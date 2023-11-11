package hr.algebra.travelplanner.feature.country;

import hr.algebra.travelplanner.feature.country.request.CountryRequest;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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

  @PostMapping()
  public void addCountry(@RequestBody CountryRequest country) {
    countryService.addCountry(country);
  }
}
