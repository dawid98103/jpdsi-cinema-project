package pl.paw.cinema.model.request;

import lombok.Data;
import pl.paw.cinema.model.TicketModel;

import java.util.List;

@Data
public class AddReservationRequest {
    private int movieId;
    private int showingId;
    List<TicketModel> ticketList;
}
