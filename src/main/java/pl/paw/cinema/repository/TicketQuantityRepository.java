package pl.paw.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paw.cinema.entity.TicketQuantity;

@Repository
public interface TicketQuantityRepository extends JpaRepository<TicketQuantity, Integer> {
}
