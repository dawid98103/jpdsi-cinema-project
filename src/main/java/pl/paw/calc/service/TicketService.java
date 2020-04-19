package pl.paw.calc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.paw.calc.entity.Ticket;
import pl.paw.calc.repository.TicketRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public List<Ticket> getAvailableTickets(){
        return ticketRepository.findAllByActive(true);
    }
}
