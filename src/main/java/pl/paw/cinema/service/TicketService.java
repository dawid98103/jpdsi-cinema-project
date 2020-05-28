package pl.paw.cinema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.paw.cinema.entity.Ticket;
import pl.paw.cinema.exception.TicketNotFoundException;
import pl.paw.cinema.repository.TicketRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public List<Ticket> findAvailableTickets(){
        return ticketRepository.findAllByActive(true);
    }

    public Ticket findTicketById(int ticketId){
        return ticketRepository.findByTicketId(ticketId).orElseThrow(() -> new TicketNotFoundException(String.format("Nie znaleziono biletu o id: %d", ticketId)));
    }
}
