package hr.algebra.travelplanner.feature.country;

import hr.algebra.travelplanner.feature.city.City;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "countries")
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<City> cities;
}
