package hr.algebra.travelplanner.scheduler;

import hr.algebra.travelplanner.feature.customer.Customer;
import hr.algebra.travelplanner.feature.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GlobalScheduler {
  private final CustomerRepository customerRepository;

  @Scheduled(fixedRate = 300000) // 5 minutes = 300,000 milliseconds
  public void showCustomerTripCount() {
    List<Customer> customers = customerRepository.findAllCustomersWithTrips();

    customers.forEach(
        customer ->
            System.out.println(
                customer.getUsername() + " has " + customer.getTrips().size() + " trips."));
  }
}
