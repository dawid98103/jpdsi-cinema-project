package pl.paw.cinema.repository;

import org.springframework.stereotype.Repository;
import pl.paw.cinema.entity.Showing;
import pl.paw.cinema.utils.serialization.DataTablesJpaRepository;

import java.util.List;

@Repository
public interface ShowingRepository extends DataTablesJpaRepository<Showing, Integer> {

    List<Showing> findAll();

    Showing findByShowingId(int showingId);
}
