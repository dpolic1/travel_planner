package hr.algebra.travelplanner.feature.customer;

import hr.algebra.travelplanner.feature.authentication.jwt.JwtService;
import lombok.RequiredArgsConstructor;
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

  public Integer getUserIdFromToken(String token) {
    return jwtService.getUserIdFromJwt(token);
  }

  public Customer getUserDataFromToken(String token) {
    Integer customerId = jwtService.getUserIdFromJwt(token);
    return customerRepository
        .findById(customerId)
        .orElseThrow(() -> new RuntimeException("User not found"));
  }

  public List<String> getUserRolesFromToken(String token) {
    return jwtService.getUserRolesFromJwt(token);
  }
}
