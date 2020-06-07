package pl.paw.cinema.repository;

import org.springframework.stereotype.Repository;
import pl.paw.cinema.entity.Role;
import pl.paw.cinema.utils.serialization.DataTablesJpaRepository;

@Repository
public interface RoleRepository extends DataTablesJpaRepository<Role, Integer> {
    Role findByRole(String role);
}
