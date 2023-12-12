package hr.algebra.travelplanner.feature.accommodation.response;

import lombok.Data;

@Data
public class AccommodationDetails {
    private Integer id;
    private String name;
    private String address;
    private String type;
    private Double price;
    private Double rating;
}
