package hr.algebra.travelplanner.feature.specific_location.mapper;

import hr.algebra.travelplanner.feature.specific_location.SpecificLocation;
import hr.algebra.travelplanner.feature.specific_location.response.SpecificLocationSimple;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecificLocationMapper {

    List<SpecificLocationSimple> mapToSpecificLocationSimpleList(List<SpecificLocation> specificLocations);

}
