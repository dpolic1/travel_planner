package hr.algebra.travelplanner.feature.city;

import hr.algebra.travelplanner.feature.city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findAllByCountryId(Integer countryId);
}
