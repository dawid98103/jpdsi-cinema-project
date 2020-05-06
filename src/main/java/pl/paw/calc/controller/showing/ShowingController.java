package pl.paw.calc.controller.showing;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.paw.calc.model.request.AddReservationRequest;
import pl.paw.calc.model.response.MovieShowingResponseModel;
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

    @GetMapping("/myReservation")
    public ModelAndView myReservation(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("reservations", reservationService.findAllReservationsByCurrentUser());
        modelAndView.setViewName("myReservationPage");
        return modelAndView;
    }

    @PostMapping("/reservation")
    private ResponseEntity<?> saveReservation(@RequestBody AddReservationRequest addReservationRequest){
        reservationService.saveReservation(addReservationRequest);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/reservationPage")
    public ModelAndView showReservationPage() {
        return new ModelAndView("myReservationPage");
    }
}
