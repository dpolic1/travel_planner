package hr.algebra.travelplanner.feature.location.response;

import hr.algebra.travelplanner.feature.accommodation.response.AccommodationDetails;
import lombok.Data;

@Data
public class LocationDetails {

  private Integer id;
  private String cityName;
  private String specificLocationName;
  private boolean paidAccommodation;
  private AccommodationDetails accommodation; // todo: add custom mapping method
}
