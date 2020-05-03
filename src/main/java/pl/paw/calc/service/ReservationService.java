package pl.paw.calc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.paw.calc.entity.*;
import pl.paw.calc.model.request.AddReservationRequest;
import pl.paw.calc.repository.ReservationRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final MovieService movieService;
    private final ShowingService showingService;
    private final TicketService ticketService;

    public void saveReservation(AddReservationRequest reservationToAdd) {
        Movie retrievedMovie = movieService.findMovieById(reservationToAdd.getMovieId());
        Showing retrievedShowing = showingService.findShowingById(reservationToAdd.getShowingId());
        Ticket retrievedTicket = ticketService.findTicketById(reservationToAdd.getTicketId());

        reservationRepository.save(
                Reservation.builder()
                        .movie(retrievedMovie)
                        .ticket(ticketService.findTicketById(reservationToAdd.getTicketId()))
                        .reservationDateStart(retrievedShowing.getShowingDate())
                        .reservationDateEnd(retrievedShowing.getShowingDate().plusMinutes(retrievedMovie.getMovieDuration()))
                        .amountToPay(retrievedTicket.getPrice().multiply(BigDecimal.valueOf(reservationToAdd.getTicketQuantity())))
                        .build()
        );
    }
}
