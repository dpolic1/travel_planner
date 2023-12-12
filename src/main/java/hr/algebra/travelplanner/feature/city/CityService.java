package hr.algebra.travelplanner.feature.city;

import hr.algebra.travelplanner.feature.city.City;
import hr.algebra.travelplanner.feature.city.CityRepository;
import hr.algebra.travelplanner.feature.city.mapper.CityMapper;
import hr.algebra.travelplanner.feature.city.response.CitySimple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
  private final CityRepository cityRepository;
  private final CityMapper cityMapper;

  public List<City> getAllCities() {
    return cityRepository.findAll();
  }

  public List<CitySimple> getAllCitiesByCountryId(Integer countryId) {
    return cityMapper.mapToCitySimpleList(cityRepository.findAllByCountryId(countryId));
  }
}
