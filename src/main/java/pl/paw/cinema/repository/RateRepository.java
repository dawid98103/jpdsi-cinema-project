package pl.paw.cinema.repository;

import org.springframework.stereotype.Repository;
import pl.paw.cinema.entity.Rate;
import pl.paw.cinema.utils.serialization.DataTablesJpaRepository;

import java.util.Optional;

@Repository
public interface RateRepository extends DataTablesJpaRepository<Rate, Integer> {

    Optional<Rate> findByUserIdAndMovieId(int userId, int movieId);
}
