package hr.algebra.travelplanner.feature.accommodation.mapper;

import hr.algebra.travelplanner.feature.accommodation.Accommodation;
import hr.algebra.travelplanner.feature.accommodation.response.AccommodationDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccommodationMapper {
    AccommodationDetails toDetails(Accommodation accommodation);
}