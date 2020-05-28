package pl.paw.cinema.controller.priceList;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.paw.cinema.entity.Ticket;
import pl.paw.cinema.service.TicketService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/priceList")
public class PriceListController {

    private final TicketService ticketService;

    @GetMapping("/showPriceList")
    public ModelAndView showPriceList() {
        ModelAndView modelAndView = new ModelAndView();
        List<Ticket> availableTickets = ticketService.findAvailableTickets();
        modelAndView.addObject("tickets", availableTickets);
        modelAndView.setViewName("priceList");
        return modelAndView;
    }
}
