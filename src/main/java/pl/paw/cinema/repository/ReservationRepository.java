package pl.paw.cinema.repository;

import org.springframework.stereotype.Repository;
import pl.paw.cinema.entity.Reservation;
import pl.paw.cinema.entity.User;
import pl.paw.cinema.utils.serialization.DataTablesJpaRepository;

import java.util.List;

@Repository
public interface ReservationRepository extends DataTablesJpaRepository<Reservation, Integer> {

    List<Reservation> findAllByUser(User user);
}
