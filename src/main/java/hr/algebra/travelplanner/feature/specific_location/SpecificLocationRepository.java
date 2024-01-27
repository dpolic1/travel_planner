package hr.algebra.travelplanner.feature.specific_location;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecificLocationRepository extends JpaRepository<SpecificLocation, Integer> {

    List<SpecificLocation> findAllByCountryId(Integer countryId);

}
