package hr.algebra.travelplanner.feature.accommodation;

import hr.algebra.travelplanner.feature.city.City;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "accomodations")
@Data
public class Accommodation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String address;

  @ManyToOne
  @JoinColumn(name = "city_id")
  private City city;

  @Enumerated(EnumType.STRING)
  private Type type;

  public enum Type {
    HOTEL,
    HOSTEL,
    APARTMENT,
    RESORT
  }

  private double price;

  private double rating;
}
