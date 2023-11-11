package hr.algebra.travelplanner.feature.specific_location;

import hr.algebra.travelplanner.feature.country.Country;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "specific_locations")
@Data
public class SpecificLocation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "country_id")
  private Country country;
}
