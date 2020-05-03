package pl.paw.calc.model.request;

import lombok.Data;

@Data
public class AddReservationRequest {
    private int movieId;
    private int showingId;
    private int ticketId;
    private int ticketQuantity;
}
