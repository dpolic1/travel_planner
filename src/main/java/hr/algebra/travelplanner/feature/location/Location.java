package hr.algebra.travelplanner.feature.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hr.algebra.travelplanner.feature.accommodation.Accommodation;
import hr.algebra.travelplanner.feature.city.City;
import hr.algebra.travelplanner.feature.destination.Destination;
import hr.algebra.travelplanner.feature.specific_location.SpecificLocation;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "locations")
@Data
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "destination_id")
  @JsonIgnore
  private Destination destination;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "city_id")
  private City city; // can be null

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "specific_location_id")
  private SpecificLocation specificLocation; // can be null

  private Boolean paidAccommodation;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "accommodation_id")
  private Accommodation accommodation;
}
