package hr.algebra.travelplanner.feature.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hr.algebra.travelplanner.feature.role.Role;
import hr.algebra.travelplanner.feature.trip.Trip;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")
@Data
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String surname;

  private String username;

  private String email;

  private String password;

  @OneToMany(mappedBy = "customer")
  private List<Trip> trips;

  @ManyToMany(fetch = FetchType.EAGER)
  @JsonIgnore
  @JoinTable(
      name = "customers_roles",
      joinColumns = {@JoinColumn(name = "customer_id")},
      inverseJoinColumns = {@JoinColumn(name = "role_id")})
  private Set<Role> roles = new HashSet<>();
}
