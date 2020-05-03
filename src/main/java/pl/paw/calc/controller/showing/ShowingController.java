package pl.paw.calc.controller.showing;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pl.paw.calc.model.request.AddReservationRequest;
import pl.paw.calc.model.response.MovieShowingResponseModel;
import pl.paw.calc.service.MovieService;
import pl.paw.calc.service.ReservationService;
import pl.paw.calc.service.ShowingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/showing")
public class ShowingController {

    private final ShowingService showingService;
    private final ReservationService reservationService;

    @GetMapping("/repertoire/{dateFrom}/{dateTo}")
    public List<MovieShowingResponseModel> getShowingsByDate(@PathVariable long dateFrom, @PathVariable long dateTo) {
        return showingService.getShowingsByDates(dateFrom, dateTo);
    }

    @PostMapping("/repertoire")
    public ResponseEntity<?> processReservation(@RequestBody AddReservationRequest addReservationRequest){
        reservationService.saveReservation(addReservationRequest);
        return new ResponseEntity<>("Operacja wykonana pomyślnie!", HttpStatus.OK);
    }

    @GetMapping("/repertoireOverview")
    public ModelAndView showRepertoire() {
        return new ModelAndView("repertoire");
    }

    @PostMapping("/reservationPage")
    public ModelAndView showReservationPage() {
        return new ModelAndView("reservationPage");
    }
}
