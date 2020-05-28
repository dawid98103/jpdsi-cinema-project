package pl.paw.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paw.cinema.entity.Rate;

import java.util.Optional;

@Repository
public interface RateRepository extends JpaRepository<Rate, Integer> {

    Optional<Rate> findByUserIdAndMovieId(int userId, int movieId);
}
