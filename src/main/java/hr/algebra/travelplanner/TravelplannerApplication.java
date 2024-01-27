package hr.algebra.travelplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableScheduling
public class TravelplannerApplication {
  public static void main(String[] args) {
    SpringApplication.run(TravelplannerApplication.class, args);
  }
}
