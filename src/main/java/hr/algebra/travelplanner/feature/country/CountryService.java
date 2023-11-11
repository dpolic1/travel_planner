package hr.algebra.travelplanner.feature.country;

import hr.algebra.travelplanner.feature.country.Country;
import hr.algebra.travelplanner.feature.country.CountryRepository;
import hr.algebra.travelplanner.feature.country.request.CountryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
  private final CountryRepository countryRepository;

  public List<Country> getAllCountries() {
    return countryRepository.findAll();
  }

  public void addCountry(CountryRequest countryRequest) {
    Country newCountry = new Country();
    newCountry.setName(countryRequest.getName());
    countryRepository.save(newCountry);
  }
}
