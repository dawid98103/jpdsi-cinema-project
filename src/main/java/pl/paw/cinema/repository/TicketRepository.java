package pl.paw.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paw.cinema.entity.Ticket;
import pl.paw.cinema.utils.serialization.DataTablesJpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends DataTablesJpaRepository<Ticket, Integer> {

    Optional<Ticket> findByTicketId(int ticketId);

    List<Ticket> findAllByActive(boolean active);

}
