package pl.paw.cinema.controller.rate;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.paw.cinema.model.request.MovieRateRequest;
import pl.paw.cinema.service.RateService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rate")
public class RateController {

    private final RateService rateService;

    @PostMapping("/addRate")
    public ResponseEntity<?> addRateToMovie(@RequestBody MovieRateRequest movieRateRequest) {
        rateService.addRateToMovie(movieRateRequest);
        return new ResponseEntity<>("Dodano ocenę!", HttpStatus.OK);
    }

    @GetMapping("/getRate/{movieId}")
    public ResponseEntity<?> getRateForMovie(@PathVariable int movieId) {
        return new ResponseEntity<>(rateService.getValueForUser(movieId), HttpStatus.OK);
    }
}
