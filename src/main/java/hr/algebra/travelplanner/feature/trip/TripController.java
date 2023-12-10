package hr.algebra.travelplanner.feature.trip;

import hr.algebra.travelplanner.authentication.jwt.JwtService;
import hr.algebra.travelplanner.feature.customer.Customer;
import hr.algebra.travelplanner.feature.trip.request.TripRequest;
import hr.algebra.travelplanner.feature.trip.response.TripDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {
  @Autowired private TripService tripService;
  @Autowired private JwtService jwtService;

  @GetMapping()
  public List<Trip> getAllTrips() {
    return tripService.getAllTrips();
  }

  @PostMapping()
  public TripDetails create(
      @RequestBody TripRequest tripRequest, @RequestHeader("Authorization") String bearerToken) {
    Customer customer = jwtService.getCustomerFromJwt(bearerToken);
    return tripService.create(customer, tripRequest);
  }
}
