package hr.algebra.travelplanner.feature.destination.mapper;

import hr.algebra.travelplanner.feature.country.Country;
import hr.algebra.travelplanner.feature.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DestinationReferenceMapper {
  @Autowired CountryService countryService;

  public Country mapToCountry(Integer countryId) {
    return countryService.findById(countryId);
  }
}
