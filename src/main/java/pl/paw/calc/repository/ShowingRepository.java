package pl.paw.calc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paw.calc.entity.Showing;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface ShowingRepository extends JpaRepository<Showing, Integer> {

    List<Showing> findAllByShowingDateAfter(Date currentDateTime);

    List<Showing> findAllByShowingDateBetween(Date startDate, Date endDate);
}
