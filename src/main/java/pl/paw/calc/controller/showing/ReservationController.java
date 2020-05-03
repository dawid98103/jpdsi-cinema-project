package pl.paw.calc.controller.showing;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.paw.calc.model.request.AddReservationRequest;
import pl.paw.calc.service.ReservationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("")
    private ResponseEntity<?> saveReservation(@RequestBody AddReservationRequest addReservationRequest){
        reservationService.saveReservation(addReservationRequest);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
