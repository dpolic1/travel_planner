package hr.algebra.travelplanner.feature.location.response;

import hr.algebra.travelplanner.feature.accommodation.response.AccommodationDetails;
import lombok.Data;

@Data
public class LocationDetails {

  private Integer id;
  private Integer cityId;
  private String cityName;
  private Integer specificLocationId;
  private String specificLocationName;
}
