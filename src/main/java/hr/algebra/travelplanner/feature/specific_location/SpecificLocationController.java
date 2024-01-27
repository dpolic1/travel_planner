package hr.algebra.travelplanner.feature.specific_location;

import hr.algebra.travelplanner.feature.specific_location.response.SpecificLocationSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/specific_locations")
public class SpecificLocationController {
  @Autowired private SpecificLocationService specificLocationService;

  @GetMapping
  public List<SpecificLocation> getAllSpecificLocations() {
    return specificLocationService.getAllSpecificLocations();
  }

  @GetMapping("/country/{countryId}")
  public List<SpecificLocationSimple> getAllSpecificLocationsByCountryId(
      @PathVariable Integer countryId) {
    return specificLocationService.getAllSpecificLocationsByCountryId(countryId);
  }
}
