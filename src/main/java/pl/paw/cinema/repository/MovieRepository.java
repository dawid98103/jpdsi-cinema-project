package pl.paw.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paw.cinema.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

//    @Query("SELECT AVG () from Rate r WHERE movie")
//    Set<Integer> movieIds();
}
