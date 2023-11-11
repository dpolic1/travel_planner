package hr.algebra.travelplanner.feature.role;

import hr.algebra.travelplanner.feature.role.Role;
import hr.algebra.travelplanner.feature.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
  private final RoleRepository roleRepository;

  public List<Role> getAllRoles() {
    return roleRepository.findAll();
  }
}
