package hr.algebra.travelplanner.feature.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;

  public List<Customer> getAllUsers() {
    return customerRepository.findAll();
  }
}
