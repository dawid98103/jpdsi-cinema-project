package pl.paw.calc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.paw.calc.entity.*;
import pl.paw.calc.model.request.AddReservationRequest;
import pl.paw.calc.repository.ReservationRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final MyUserDetailsService userDetailsService;
    private final MovieService movieService;
    private final ShowingService showingService;
    private final TicketService ticketService;

    public List<Reservation> findAllReservationsByCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User retrievedUser = userDetailsService.getCurrentUserId(auth.getName());
        return reservationRepository.findAllByUser(retrievedUser);
    }

    //TODO Dodać wpisywanie po ID zamiast obiektów
    public void saveReservation(AddReservationRequest reservationToAdd) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User retrievedUser = userDetailsService.getCurrentUserId(auth.getName());
        Movie retrievedMovie = movieService.findMovieById(reservationToAdd.getMovieId());
        Showing retrievedShowing = showingService.findShowingById(reservationToAdd.getShowingId());
        Ticket retrievedTicket = ticketService.findTicketById(reservationToAdd.getTicketId());

        reservationRepository.save(
                Reservation.builder()
                        .movie(retrievedMovie)
                        .user(retrievedUser)
                        .ticket(ticketService.findTicketById(reservationToAdd.getTicketId()))
                        .reservationDateStart(retrievedShowing.getShowingDate())
                        .reservationDateEnd(retrievedShowing.getShowingDate().plusMinutes(retrievedMovie.getMovieDuration()))
                        .amountToPay(retrievedTicket.getPrice().multiply(BigDecimal.valueOf(reservationToAdd.getTicketQuantity())))
                        .build()
        );
    }
}
