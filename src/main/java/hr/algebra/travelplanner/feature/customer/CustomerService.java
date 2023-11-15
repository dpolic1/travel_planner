package hr.algebra.travelplanner.feature.customer;

import hr.algebra.travelplanner.feature.authentication.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final JwtService jwtService;

  public List<Customer> getAllUsers() {
    return customerRepository.findAll();
  }

  public Customer getUserById(Integer id) {
    return customerRepository
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
  }

  public Integer getUserIdFromToken(String token) {
    return jwtService.getUserIdFromJwt(token);
  }

  public Customer getUserDataFromToken(String token) {
    Integer customerId = jwtService.getUserIdFromJwt(token);
    return customerRepository
        .findById(customerId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
  }

  public List<String> getUserRolesFromToken(String token) {
    return jwtService.getUserRolesFromJwt(token);
  }
}
