package pl.paw.cinema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.paw.cinema.entity.*;
import pl.paw.cinema.model.request.AddReservationRequest;
import pl.paw.cinema.repository.ReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final MyUserDetailsService userDetailsService;
    private final MovieService movieService;
    private final ShowingService showingService;
    private final TicketService ticketService;
    private final TicketQuantityService ticketQuantityService;

    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }

    public List<Reservation> findAllReservationsByCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User retrievedUser = userDetailsService.getCurrentUserId(auth.getName());
        return reservationRepository.findAllByUser(retrievedUser);
    }

    public void deleteById(int reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    //TODO Dodać wpisywanie po ID zamiast obiektów
    public void saveReservation(AddReservationRequest reservationToAdd) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User retrievedUser = userDetailsService.getCurrentUserId(auth.getName());
        Movie retrievedMovie = movieService.findMovieById(reservationToAdd.getMovieId());
        Showing retrievedShowing = showingService.findShowingById(reservationToAdd.getShowingId());

        Reservation savedReservation = reservationRepository.save(
                Reservation.builder()
                        .movie(retrievedMovie)
                        .user(retrievedUser)
                        .reservationDateStart(retrievedShowing.getShowingDate())
                        .reservationDateEnd(retrievedShowing.getShowingDate().plusMinutes(retrievedMovie.getMovieDuration()))
                        .build()
        );

        reservationToAdd.getTicketList().forEach(ticketModel -> ticketQuantityService.saveTicketQuantity(TicketQuantity.builder()
                .reservation(savedReservation)
                .quantity(ticketModel.getTicketQuantity())
                .ticket(ticketService.findTicketById(ticketModel.getTicketId()))
                .build()));
    }
}
