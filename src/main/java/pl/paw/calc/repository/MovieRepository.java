package pl.paw.calc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paw.calc.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
