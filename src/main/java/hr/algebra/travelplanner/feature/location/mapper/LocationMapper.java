package hr.algebra.travelplanner.feature.location.mapper;

import hr.algebra.travelplanner.feature.location.Location;
import hr.algebra.travelplanner.feature.location.request.LocationRequest;
import hr.algebra.travelplanner.feature.location.response.LocationDetails;
import org.mapstruct.*;

@Mapper(
    componentModel = "spring",
    uses = {LocationReferenceMapper.class})
public interface LocationMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "destination", ignore = true)
  @Mapping(target = "city", source = "cityId")
  @Mapping(target = "specificLocation", source = "specificLocationId")
  @Mapping(target = "accommodation", source = "accommodationId")
  @Mapping(target = "paidAccommodation", source = "paidAccommodation", defaultValue = "false")
  Location toEntity(LocationRequest locationRequest);

  @Mapping(target = "cityName", source = "city.name")
  @Mapping(target = "specificLocationName", source = "specificLocation.name")
  LocationDetails toDetails(Location location);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @InheritConfiguration(name = "toEntity")
  void update(LocationRequest locationRequest, @MappingTarget Location target);
}
