package hr.algebra.travelplanner.feature.accommodation;

import hr.algebra.travelplanner.feature.accommodation.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Integer> {}
