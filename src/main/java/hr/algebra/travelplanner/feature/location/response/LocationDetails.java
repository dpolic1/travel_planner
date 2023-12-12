package hr.algebra.travelplanner.feature.location.response;

import hr.algebra.travelplanner.feature.accommodation.response.AccommodationDetails;
import lombok.Data;

@Data
public class LocationDetails {

  private Integer id;
  private String name;
  private String cityName; // todo: add custom mapping method
  private String specificLocationName; // todo: add custom mapping method
  private boolean paidAccommodation;
  private AccommodationDetails accommodation; // todo: add custom mapping method
}
