package hr.algebra.travelplanner.feature.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {
  @Autowired private TripService tripService;

  @GetMapping
  public List<Trip> getAllTrips() {
    return tripService.getAllTrips();
  }
}
