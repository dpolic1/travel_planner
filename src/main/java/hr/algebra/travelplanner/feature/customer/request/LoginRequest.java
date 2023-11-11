package hr.algebra.travelplanner.feature.customer.request;

import lombok.Data;

@Data
public class LoginRequest {

  private String email;

  private String password;
}
