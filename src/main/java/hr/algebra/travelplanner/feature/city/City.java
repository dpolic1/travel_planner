package hr.algebra.travelplanner.feature.city;

import hr.algebra.travelplanner.feature.accommodation.Accommodation;
import hr.algebra.travelplanner.feature.country.Country;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "cities")
@Data
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "country_id", referencedColumnName = "id")
  private Country country;

  @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
  private List<Accommodation> accommodations;
}
