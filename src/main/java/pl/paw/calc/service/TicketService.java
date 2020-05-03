package pl.paw.calc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.paw.calc.entity.Ticket;
import pl.paw.calc.exception.TicketNotFoundException;
import pl.paw.calc.repository.TicketRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public List<Ticket> getAvailableTickets(){
        return ticketRepository.findAllByActive(true);
    }

    public Ticket findTicketById(int ticketId){
        return ticketRepository.findByTicketId(ticketId).orElseThrow(() -> new TicketNotFoundException(String.format("Nie znaleziono filmu o id: %d", ticketId)));
    }
}
