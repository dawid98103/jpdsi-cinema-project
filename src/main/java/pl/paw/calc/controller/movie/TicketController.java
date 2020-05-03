package pl.paw.calc.controller.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.paw.calc.entity.Ticket;
import pl.paw.calc.service.TicketService;

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
