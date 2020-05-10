package pl.paw.calc.controller.priceList;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.paw.calc.entity.Ticket;
import pl.paw.calc.service.TicketService;

import java.util.List;
import java.util.logging.Logger;

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
