package hr.algebra.travelplanner.feature.accommodation;

import hr.algebra.travelplanner.feature.accommodation.Accommodation;
import hr.algebra.travelplanner.feature.accommodation.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccommodationService {
  private final AccommodationRepository accommodationRepository;

  public List<Accommodation> getAllAccomodations() {
    return accommodationRepository.findAll();
  }
}
