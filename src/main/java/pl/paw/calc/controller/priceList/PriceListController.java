package pl.paw.calc.controller.priceList;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.paw.calc.entity.Ticket;
import pl.paw.calc.service.TicketService;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/priceList")
public class PriceListController {

    private final TicketService ticketService;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    PriceListController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/showPriceList")
    public ModelAndView showPriceList() {
        ModelAndView modelAndView = new ModelAndView();
        logger.info("Pobieram listę dostępnych biletów");
        List<Ticket> availableTickets = ticketService.getAvailableTickets();
        logger.info(String.format("Pobrano %d biletów", availableTickets.size()));
        modelAndView.addObject("tickets", availableTickets);
        modelAndView.setViewName("priceList");
        return modelAndView;
    }
}
