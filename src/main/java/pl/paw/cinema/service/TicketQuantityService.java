package pl.paw.cinema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.paw.cinema.entity.TicketQuantity;
import pl.paw.cinema.repository.TicketQuantityRepository;

@Service
@RequiredArgsConstructor
public class TicketQuantityService {

    private final TicketQuantityRepository ticketQuantityRepository;

    public void saveTicketQuantity(TicketQuantity ticketQuantity) {
        ticketQuantityRepository.save(ticketQuantity);
    }
}
