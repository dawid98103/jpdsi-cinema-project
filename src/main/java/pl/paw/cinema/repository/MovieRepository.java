package pl.paw.cinema.repository;

import org.springframework.stereotype.Repository;
import pl.paw.cinema.entity.Movie;
import pl.paw.cinema.utils.serialization.DataTablesJpaRepository;

@Repository
public interface MovieRepository extends DataTablesJpaRepository<Movie, Integer> {

}
