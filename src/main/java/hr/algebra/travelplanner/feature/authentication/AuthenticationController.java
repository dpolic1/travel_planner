package hr.algebra.travelplanner.feature.authentication;

import hr.algebra.travelplanner.feature.customer.request.LoginRequest;
import hr.algebra.travelplanner.feature.customer.request.RegisterRequest;
import hr.algebra.travelplanner.feature.customer.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  @Autowired private AuthenticationService customerService;

  @PostMapping("/login")
  public LoginResponse login(@RequestBody LoginRequest loginRequest) {
    return customerService.login(loginRequest);
  }

  @PostMapping("/register")
  public void register(@RequestBody RegisterRequest registerRequest) {
    customerService.register(registerRequest);
  }
}
