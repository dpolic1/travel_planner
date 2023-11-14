package hr.algebra.travelplanner.authentication.jwt;

import hr.algebra.travelplanner.feature.customer.Customer;
import hr.algebra.travelplanner.feature.customer.CustomerRepository;
import hr.algebra.travelplanner.feature.role.Role;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtService {
  private static final Logger log = LoggerFactory.getLogger(JwtService.class);

  @Value("604800")
  private Long accessTokenValiditySeconds;

  @Value("${security.authentication.jwt.base64-secret}")
  private String secretKey;

  private final CustomerRepository customerRepository;

  public boolean authenticate(String token) {
    // If JWT is invalid, user can not be authenticated
    if (isJwtInvalid(token)) {
      return false;
    }
    // If JWT is valid, store authentication in Spring security context
    Customer applicationUser = getUserDataFromJwt(token);
    saveAuthentication(applicationUser);

    return true;
  }

  public String createJwt(Customer jwtCustomer) {
    Instant expiration = Instant.now().plusSeconds(accessTokenValiditySeconds);
    String authorities =
        jwtCustomer.getRoles().stream().map(Role::getName).collect(Collectors.joining(","));

    return Jwts.builder()
        .signWith(SignatureAlgorithm.HS512, secretKey)
        .setSubject(jwtCustomer.getName())
        .claim("id", jwtCustomer.getId())
        .claim("authorities", authorities)
        .setExpiration(new Date(expiration.toEpochMilli()))
        .setIssuedAt(new Date())
        .compact();
  }

  private boolean isJwtInvalid(String jwtToken) {
    try {
      Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
      return false;
    } catch (SignatureException e) {
      log.debug("Invalid JWT signature.");
      log.trace("Invalid JWT signature trace: {}", e.getMessage());
    } catch (MalformedJwtException e) {
      log.debug("Invalid JWT token.");
      log.trace("Invalid JWT token trace: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      log.debug("Expired JWT token.");
      log.trace("Expired JWT token trace: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      log.debug("Unsupported JWT token.");
      log.trace("Unsupported JWT token trace: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      log.debug("JWT token compact of handler are invalid.");
      log.trace("JWT token compact of handler are invalid trace: {}", e.getMessage());
    }
    return true;
  }

  public Customer getUserDataFromJwt(String jwtToken) {
    Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();

    List<SimpleGrantedAuthority> authorities =
        Arrays.stream(claims.get("authorities").toString().split(","))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

    Customer customer =
        customerRepository
            .findById(Integer.valueOf(claims.get("id").toString()))
            .orElseThrow(() -> new RuntimeException("User not found from JWT"));
    customer.setTrips(null);
    customer.setAuthorities(authorities);
    return customer;
  }

  public Integer getUserIdFromJwt(String jwtToken) {
    Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();
    return Integer.valueOf(claims.get("id").toString());
  }

  private void saveAuthentication(Customer applicationUser) {
    Authentication authentication =
        new UsernamePasswordAuthenticationToken(
            applicationUser, null, applicationUser.getAuthorities());
    SecurityContextHolder.getContext().setAuthentication(authentication);
  }
}
