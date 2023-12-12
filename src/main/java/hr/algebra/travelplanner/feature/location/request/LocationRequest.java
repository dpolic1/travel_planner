package hr.algebra.travelplanner.feature.location.request;

import lombok.Data;

@Data
public class LocationRequest {

  private String name;
  private Integer cityId;
  private Integer specificLocationId;
  private Boolean paidAccommodation;
  private Integer accommodationId;
}
