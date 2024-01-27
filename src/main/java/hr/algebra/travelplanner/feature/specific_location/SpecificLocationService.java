package hr.algebra.travelplanner.feature.specific_location;

import hr.algebra.travelplanner.feature.specific_location.mapper.SpecificLocationMapper;
import hr.algebra.travelplanner.feature.specific_location.response.SpecificLocationSimple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecificLocationService {

  private final SpecificLocationRepository specificLocationRepository;
  private final SpecificLocationMapper specificLocationMapper;

  public List<SpecificLocation> getAllSpecificLocations() {
    return specificLocationRepository.findAll();
  }

  public List<SpecificLocationSimple> getAllSpecificLocationsByCountryId(Integer countryId) {
    return specificLocationMapper.mapToSpecificLocationSimpleList(
        specificLocationRepository.findAllByCountryId(countryId));
  }

  public SpecificLocation findById(Integer id) {
    return specificLocationRepository.findById(id).orElse(null);
  }
}
