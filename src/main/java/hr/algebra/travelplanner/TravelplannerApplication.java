package hr.algebra.travelplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class TravelplannerApplication {
  public static void main(String[] args) {
    SpringApplication.run(TravelplannerApplication.class, args);
  }
}
