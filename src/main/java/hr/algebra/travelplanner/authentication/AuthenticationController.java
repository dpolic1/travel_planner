package hr.algebra.travelplanner.authentication;

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

  @Autowired private AuthenticationService authenticationService;

  @PostMapping("/login")
  public LoginResponse login(@RequestBody LoginRequest loginRequest) {
    return authenticationService.login(loginRequest);
  }

  @PostMapping("/register")
  public void register(@RequestBody RegisterRequest registerRequest) {
    authenticationService.register(registerRequest);
  }

  @PostMapping("/registeradmin")
  public void registerAdmin(@RequestBody RegisterRequest registerRequest) {
    authenticationService.registerAdmin(registerRequest);
  }
}
