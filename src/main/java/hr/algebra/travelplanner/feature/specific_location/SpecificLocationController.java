package hr.algebra.travelplanner.feature.specific_location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/specific-locations")
public class SpecificLocationController {
  @Autowired private SpecificLocationService specificLocationService;

  @GetMapping
  public List<SpecificLocation> getAllSpecificLocations() {
    return specificLocationService.getAllSpecificLocations();
  }
}
