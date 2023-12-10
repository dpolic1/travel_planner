package hr.algebra.travelplanner.feature.customer;

import hr.algebra.travelplanner.authentication.jwt.JwtService;
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

  public Integer getCustomerIdFromToken(String token) {
    return jwtService.getCustomerIdFromJwt(token);
  }

  public Customer getCustomerDataFromToken(String token) {
    Integer customerId = jwtService.getCustomerIdFromJwt(token);
    return customerRepository
        .findById(customerId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
  }

  public List<String> getCustomerRolesFromToken(String token) {
    return jwtService.getCustomerRolesFromJwt(token);
  }
}
