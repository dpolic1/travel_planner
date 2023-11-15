package hr.algebra.travelplanner.feature.authentication;

import hr.algebra.travelplanner.feature.authentication.jwt.JwtService;
import hr.algebra.travelplanner.feature.customer.Customer;
import hr.algebra.travelplanner.feature.customer.CustomerRepository;
import hr.algebra.travelplanner.feature.customer.request.LoginRequest;
import hr.algebra.travelplanner.feature.customer.request.RegisterRequest;
import hr.algebra.travelplanner.feature.customer.response.LoginResponse;
import hr.algebra.travelplanner.feature.customer.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final CustomerRepository customerRepository;
  private final JwtService jwtService;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public LoginResponse login(LoginRequest request) {
    Customer customer =
        customerRepository
            .findByUsername(request.getUsername())
            .orElseThrow(
                () ->
                    new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Customer with the given username does not exist"));

    if (!bCryptPasswordEncoder.matches(request.getPassword(), customer.getPassword())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid password.");
    }
    return new LoginResponse(jwtService.createJwt(customer));
  }

  public void register(RegisterRequest request) {
    try {
      Customer newCustomer = new Customer();
      newCustomer.setName(request.getName());
      newCustomer.setSurname(request.getSurname());
      newCustomer.setUsername(request.getUsername());
      newCustomer.setEmail(request.getEmail());
      newCustomer.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
      newCustomer.getRoles().add(Role.ROLE_USER);
      customerRepository.save(newCustomer);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  public void registerAdmin(RegisterRequest request) {
    try {
      Customer newCustomer = new Customer();
      newCustomer.setName(request.getName());
      newCustomer.setSurname(request.getSurname());
      newCustomer.setUsername(request.getUsername());
      newCustomer.setEmail(request.getEmail());
      newCustomer.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
      newCustomer.getRoles().addAll(Set.of(Role.ROLE_USER, Role.ROLE_ADMIN));
      customerRepository.save(newCustomer);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }
}
