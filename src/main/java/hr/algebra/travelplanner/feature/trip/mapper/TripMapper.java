package hr.algebra.travelplanner.feature.trip.mapper;

import hr.algebra.travelplanner.feature.trip.Trip;
import hr.algebra.travelplanner.feature.trip.request.TripRequest;
import hr.algebra.travelplanner.feature.trip.response.TripDetails;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TripMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "customer", ignore = true)
  Trip toEntity(TripRequest tripRequest);

  TripDetails toDetails(Trip trip);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void update (TripRequest tripRequest, @MappingTarget Trip target);
}
