package hr.algebra.travelplanner.authentication.config;

import hr.algebra.travelplanner.authentication.jwt.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  public static final List<String> UNAUTHENTICATED_ENDPOINTS =
      List.of("/auth/register", "/auth/login");

  private final JwtFilter jwtFilter;

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(
            auth -> {
              //              auth.requestMatchers("/auth/login").permitAll();
              //              auth.requestMatchers("/auth/register").permitAll();
              UNAUTHENTICATED_ENDPOINTS.forEach(
                  endpoint -> auth.requestMatchers(endpoint).permitAll());

              auth.requestMatchers("/countries")
                  .hasRole("ADMIN"); // TODO: remove later, this is for testing

              auth.anyRequest().authenticated();
            })
        .csrf(csrf -> csrf.disable())
        .formLogin(
            login ->
                login
                    .defaultSuccessUrl("/web", true)
                    .failureUrl("/login.html?error=true")) // TODO: change later
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
        .exceptionHandling(
            httpSecurityExceptionHandlingConfigurer ->
                httpSecurityExceptionHandlingConfigurer.authenticationEntryPoint(
                    (request, response, authException) ->
                        response.setStatus(HttpStatus.UNAUTHORIZED.value())))
        .build();
  }
}
