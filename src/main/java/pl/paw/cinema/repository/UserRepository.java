package pl.paw.cinema.repository;

import org.springframework.stereotype.Repository;
import pl.paw.cinema.entity.User;
import pl.paw.cinema.utils.serialization.DataTablesJpaRepository;

@Repository
public interface UserRepository extends DataTablesJpaRepository<User, Integer> {
    User findByUsername(String userName);

    boolean existsByUsername(String username);
}
