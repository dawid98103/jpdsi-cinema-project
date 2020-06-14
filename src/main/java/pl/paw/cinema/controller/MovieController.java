package pl.paw.cinema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.paw.cinema.entity.Movie;
import pl.paw.cinema.model.request.AddMovieRequest;
import pl.paw.cinema.service.MovieService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/info/movies")
    public ModelAndView getAllMovies() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("movies", movieService.findAll());
        modelAndView.setViewName("movieBase");
        return modelAndView;
    }

    @GetMapping("")
    public DataTablesOutput<Movie> getMovies(DataTablesInput input) {
        return movieService.findAll(input);
    }

    @GetMapping("/ranking")
    public ModelAndView showRankingPage() {
        return new ModelAndView("movieRanking");
    }

    @GetMapping("/info/{movieId}")
    public ModelAndView showMovieInfo(@PathVariable int movieId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("movie", movieService.findMovieById(movieId));
        modelAndView.setViewName("movieInfo");
        return modelAndView;
    }

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable int movieId){
        return movieService.findMovieById(movieId);
    }

    @PostMapping("")
    public ResponseEntity<?> addMovie(@RequestBody AddMovieRequest addMovieRequest) {
        movieService.create(addMovieRequest);
        return ResponseEntity.ok("Pomyślnie dodano film");
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable int movieId) {
        movieService.delete(movieId);
        return ResponseEntity.ok("Pomyślnie usunięto film");
    }

//    @GetMapping("/repertoire")
//    public ModelAndView showReservationPage(@ModelAttribute("date") ShowingDateModel showingDateModel) {
//        ModelAndView modelAndView = new ModelAndView();
//        System.out.println(showingDateModel);
//        logger.info("Pobieram listę dostępnych seansów");
//        List<Showing> showings = (showingDateModel.getDateFrom() == null) ? showingService.getShowingsAfterCurrentDate()
//                : showingService.getShowingsForSpecificPeriod(showingDateModel);
//        modelAndView.addObject("showingDates", showingDateModel);
//        modelAndView.addObject("showings", showings);
//        modelAndView.setViewName("repertoire");
//        return modelAndView;
//    }
}
