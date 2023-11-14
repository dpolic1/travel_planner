package hr.algebra.travelplanner.feature.customer;

import hr.algebra.travelplanner.authentication.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final JwtService jwtService;

  public List<Customer> getAllUsers() {
    return customerRepository.findAll();
  }

  public Integer getUserIDWithToken(String token) {
    return jwtService.getUserIdFromJwt(token);
  }
}
