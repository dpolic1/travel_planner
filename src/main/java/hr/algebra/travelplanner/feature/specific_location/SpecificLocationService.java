package hr.algebra.travelplanner.feature.specific_location;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecificLocationService {

  private final SpecificLocationRepository specificLocationRepository;

  public List<SpecificLocation> getAllSpecificLocations() {
    return specificLocationRepository.findAll();
  }
}
