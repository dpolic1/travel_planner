package hr.algebra.travelplanner.feature.location.mapper;

import hr.algebra.travelplanner.feature.accommodation.Accommodation;
import hr.algebra.travelplanner.feature.accommodation.AccommodationService;
import hr.algebra.travelplanner.feature.city.City;
import hr.algebra.travelplanner.feature.city.CityService;
import hr.algebra.travelplanner.feature.specific_location.SpecificLocation;
import hr.algebra.travelplanner.feature.specific_location.SpecificLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationReferenceMapper {
  @Autowired CityService cityService;
  @Autowired SpecificLocationService specificLocationService;
  @Autowired
  AccommodationService accommodationService;

  public City mapToCity(Integer cityId) {
    if(cityId == null) return null;
    return cityService.findById(cityId);
  }

  public SpecificLocation mapToSpecificLocation(Integer specificLocationId) {
    if(specificLocationId == null) return null;
    return specificLocationService.findById(specificLocationId);
  }

  public Accommodation mapToAccommodation(Integer accommodationId) {
    if(accommodationId == null) return null;
    return accommodationService.findById(accommodationId);
  }
}
