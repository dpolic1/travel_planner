package hr.algebra.travelplanner.feature.customer.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LoginResponse {

  private final String jwtToken;

  @Override
  public String toString() {
    return "LoginResponse{" + "jwtToken='" + jwtToken + '\'' + '}';
  }
}
