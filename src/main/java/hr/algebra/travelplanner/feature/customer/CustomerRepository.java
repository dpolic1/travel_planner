package hr.algebra.travelplanner.feature.customer;

import hr.algebra.travelplanner.feature.customer.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByUsername(String email);

    @Query("SELECT c FROM Customer c")
    @EntityGraph(attributePaths = "trips")
    List<Customer> findAllCustomersWithTrips();
}
