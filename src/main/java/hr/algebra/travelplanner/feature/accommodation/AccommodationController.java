package hr.algebra.travelplanner.feature.accommodation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accomodations")
public class AccommodationController {
  @Autowired private AccommodationService accommodationService;

  @GetMapping()
  public List<Accommodation> getAllAccomodations() {
    return accommodationService.getAllAccomodations();
  }
}
