package hr.algebra.travelplanner.feature.country;

import hr.algebra.travelplanner.feature.country.response.CountrySimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
  @Autowired private CountryService countryService;

  @GetMapping()
  public List<Country> getAllCountries() {
    return countryService.getAllCountries();
  }

  @GetMapping("/simple")
  public List<CountrySimple> getAllCountriesSimple() {
    return countryService.getAllCountriesSimple();
  }
}
