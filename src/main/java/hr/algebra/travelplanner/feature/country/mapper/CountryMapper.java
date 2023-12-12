package hr.algebra.travelplanner.feature.country.mapper;

import hr.algebra.travelplanner.feature.country.Country;
import hr.algebra.travelplanner.feature.country.response.CountrySimple;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    List<CountrySimple> mapToCountrySimpleList(List<Country> countries);
}
