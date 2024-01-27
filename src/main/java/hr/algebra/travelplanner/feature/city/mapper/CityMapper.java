package hr.algebra.travelplanner.feature.city.mapper;

import hr.algebra.travelplanner.feature.city.City;
import hr.algebra.travelplanner.feature.city.CityService;
import hr.algebra.travelplanner.feature.city.response.CitySimple;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    List<CitySimple> mapToCitySimpleList(List<City> cities);
}
