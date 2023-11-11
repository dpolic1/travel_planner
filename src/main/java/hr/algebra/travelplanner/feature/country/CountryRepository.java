package hr.algebra.travelplanner.feature.country;

import hr.algebra.travelplanner.feature.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {}
