package hr.algebra.travelplanner.feature.city;

import hr.algebra.travelplanner.feature.city.City;
import hr.algebra.travelplanner.feature.city.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
  private final CityRepository cityRepository;

  public List<City> getAllCities() {
    return cityRepository.findAll();
  }

  public List<City> getAllCitiesByCountryId(Integer countryId) {
    return cityRepository.findAllByCountryId(countryId);
  }
}
