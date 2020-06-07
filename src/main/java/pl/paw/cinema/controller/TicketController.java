package pl.paw.cinema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.paw.cinema.entity.Ticket;
import pl.paw.cinema.service.TicketService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("")
    public List<Ticket> getAllTickets(){
        return ticketService.findAvailableTickets();
    }
}
