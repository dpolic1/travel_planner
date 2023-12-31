package hr.algebra.travelplanner.authentication;

import hr.algebra.travelplanner.feature.customer.Customer;
import hr.algebra.travelplanner.feature.customer.CustomerRepository;
import hr.algebra.travelplanner.feature.customer.request.LoginRequest;
import hr.algebra.travelplanner.feature.customer.request.RegisterRequest;
import hr.algebra.travelplanner.feature.customer.response.LoginResponse;
import hr.algebra.travelplanner.feature.role.RoleRepository;
import hr.algebra.travelplanner.authentication.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final CustomerRepository customerRepository;
  private final RoleRepository roleRepository;
  private final JwtService jwtService;

  public LoginResponse login(LoginRequest request) {
    Customer customer =
        customerRepository
            .findByUsername(request.getUsername())
            .orElseThrow(
                () ->
                    new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Customer with the given email does not exist"));

    if (!isMatchingPassword(request.getPassword(), customer.getPassword())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid password.");
    }

    return new LoginResponse(jwtService.createJwt(customer));
  }

  private boolean isMatchingPassword(String rawPassword, String encryptedPassword) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    return bCryptPasswordEncoder.matches(rawPassword, encryptedPassword);
  }

  public void register(RegisterRequest request) {
    try {
      Customer newCustomer = new Customer();
      newCustomer.setName(request.getName());
      newCustomer.setSurname(request.getSurname());
      newCustomer.setUsername(request.getUsername());
      newCustomer.setEmail(request.getEmail());
      newCustomer.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
      newCustomer.getRoles().add(roleRepository.findByName("ROLE_USER"));
      customerRepository.save(newCustomer);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }
}
