package hr.algebra.travelplanner.feature.customer.request;

import lombok.Data;

@Data
public class LoginRequest {

  private String username;

  private String password;
}
