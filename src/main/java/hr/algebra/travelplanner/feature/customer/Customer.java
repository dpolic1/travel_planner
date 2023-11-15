package hr.algebra.travelplanner.feature.customer;

import hr.algebra.travelplanner.feature.trip.Trip;
import jakarta.persistence.*;
import lombok.Data;

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

  //  @ManyToMany(fetch = FetchType.EAGER)
  //  @JsonIgnore
  //  @JoinTable(
  //      name = "customers_roles",
  //      joinColumns = {@JoinColumn(name = "customer_id")},
  //      inverseJoinColumns = {@JoinColumn(name = "role_id")})
  //  private Set<Role> roles = new HashSet<>();

  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "customers_roles", joinColumns = @JoinColumn(name = "customer_id"))
  @Column(name = "role", nullable = false)
  @Enumerated(EnumType.STRING)
  private Set<Role> roles = new HashSet<>();
}
