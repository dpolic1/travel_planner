package hr.algebra.travelplanner.feature.country;

import hr.algebra.travelplanner.feature.country.Country;
import hr.algebra.travelplanner.feature.country.CountryRepository;
import hr.algebra.travelplanner.feature.country.mapper.CountryMapper;
import hr.algebra.travelplanner.feature.country.request.CountryRequest;
import hr.algebra.travelplanner.feature.country.response.CountrySimple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
  private final CountryRepository countryRepository;
  private final CountryMapper countryMapper;

  public List<Country> getAllCountries() {
    return countryRepository.findAll();
  }

  public List<CountrySimple> getAllCountriesSimple() {
    return countryMapper.mapToCountrySimpleList(countryRepository.findAll());
  }

  public Country findById(Integer id) {
    return countryRepository.findById(id).orElse(null);
  }
}
