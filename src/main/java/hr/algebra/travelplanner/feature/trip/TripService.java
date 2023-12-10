package hr.algebra.travelplanner.feature.trip;

import hr.algebra.travelplanner.feature.customer.Customer;
import hr.algebra.travelplanner.feature.trip.mapper.TripMapper;
import hr.algebra.travelplanner.feature.trip.request.TripRequest;
import hr.algebra.travelplanner.feature.trip.response.TripDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {
  private final TripRepository tripRepository;
  private final TripMapper tripMapper;

  public List<Trip> getAllTrips() {
    return tripRepository.findAll();
  }

  public TripDetails create(Customer customer, TripRequest tripRequest){
    Trip trip = tripMapper.toEntity(tripRequest);
    trip.setCustomer(customer);
    tripRepository.save(trip);
    return tripMapper.toDetails(trip);
  }
}
