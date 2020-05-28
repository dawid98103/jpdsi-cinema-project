package pl.paw.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paw.cinema.entity.Showing;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShowingRepository extends JpaRepository<Showing, Integer> {

    Showing findByShowingId(int showingId);

    List<Showing> findAllByShowingDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}