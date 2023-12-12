package hr.algebra.travelplanner.feature.city;

import hr.algebra.travelplanner.feature.city.response.CitySimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
  @Autowired private CityService cityService;

  @GetMapping()
  public List<City> getAllCities() {
    return cityService.getAllCities();
  }

  @GetMapping("/country/{countryId}")
  public List<CitySimple> getAllCitiesByCountryId(@PathVariable Integer countryId) {
    return cityService.getAllCitiesByCountryId(countryId);
  }
}
