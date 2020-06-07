package pl.paw.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paw.cinema.entity.TicketQuantity;
import pl.paw.cinema.utils.serialization.DataTablesJpaRepository;

@Repository
public interface TicketQuantityRepository extends DataTablesJpaRepository<TicketQuantity, Integer> {
}
