package hr.algebra.travelplanner.feature.customer;

import hr.algebra.travelplanner.feature.customer.request.LoginRequest;
import hr.algebra.travelplanner.feature.customer.request.RegisterRequest;
import hr.algebra.travelplanner.feature.customer.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
  @Autowired private CustomerService customerService;

  @GetMapping()
  public List<Customer> getAllUsers() {
    return customerService.getAllUsers();
  }

  @GetMapping("/{id}")
  public Customer getUserById(@PathVariable Integer id) {
    return customerService.getUserById(id);
  }

  @GetMapping("/currentuserid")
  public Integer getCurrentUserId(@RequestHeader("Authorization") String token) {
    return customerService.getCustomerIdFromToken(token);
  }

  @GetMapping("/currentuser")
  public Customer getCurrentUser(@RequestHeader("Authorization") String token) {
    return customerService.getCustomerDataFromToken(token);
  }

  @GetMapping("/currentuserroles")
  public List<String> getCurrentUserRoles(@RequestHeader("Authorization") String token) {
    return customerService.getCustomerRolesFromToken(token);
  }
}
