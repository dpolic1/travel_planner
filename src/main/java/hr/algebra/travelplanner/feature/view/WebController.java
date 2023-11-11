package hr.algebra.travelplanner.feature.view;

import hr.algebra.travelplanner.feature.country.Country;
import hr.algebra.travelplanner.feature.country.CountryService;
import hr.algebra.travelplanner.feature.country.request.CountryRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web")
@AllArgsConstructor
public class WebController {

  private CountryService countryService;

  @GetMapping
  public String showWelcomePage(Model model) {
    List<Country> countriesList = countryService.getAllCountries();
    model.addAttribute("countries", countriesList);
    model.addAttribute("countryRequest", new CountryRequest());

    return "welcome";
  }

  @PostMapping("/addCountry")
  public String addCountry(@ModelAttribute("countryRequest") CountryRequest countryRequest) {
    // Convert CountryRequest to Country in your service
    countryService.addCountry(countryRequest);
    return "redirect:/web";
  }
}
