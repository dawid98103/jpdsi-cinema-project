package pl.paw.cinema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.paw.cinema.entity.Showing;
import pl.paw.cinema.model.request.AddReservationRequest;
import pl.paw.cinema.service.ReservationService;
import pl.paw.cinema.service.ShowingService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/showing")
public class ShowingController {

    private final ShowingService showingService;
    private final ReservationService reservationService;

    @PostMapping("/repertoire")
    public ResponseEntity<?> processReservation(@RequestBody AddReservationRequest addReservationRequest) {
        reservationService.saveReservation(addReservationRequest);
        return new ResponseEntity<>("Operacja wykonana pomyślnie!", HttpStatus.OK);
    }

    @GetMapping("/repertoireOverview")
    public ModelAndView showRepertoire() {
        return new ModelAndView("showing");
    }

    @GetMapping("/myReservation")
    public ModelAndView myReservation() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reservation");
        modelAndView.addObject("reservations", reservationService.findAllReservationsByCurrentUser());
        return modelAndView;
    }

    @GetMapping("")
    public DataTablesOutput<Showing> getAllShowings(@Valid DataTablesInput input) {
        return showingService.getAllShowings(input);
    }

    @PostMapping("/reservation")
    private ResponseEntity<?> saveReservation(@RequestBody AddReservationRequest addReservationRequest) {
        reservationService.saveReservation(addReservationRequest);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @DeleteMapping("/reservation/{id}")
    private ResponseEntity<?> deleteReservation(@PathVariable int id) {
        reservationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
