package pl.paw.calc.controller.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.paw.calc.entity.Movie;
import pl.paw.calc.service.MovieService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    private Logger logger = Logger.getLogger(getClass().getName());

    @GetMapping("/info/movies")
    public ModelAndView getAllMovies() {
        ModelAndView modelAndView = new ModelAndView();
        logger.info("Pobieram listę filmów z bazy danych");
        List<Movie> allMovies = movieService.findAll();
        logger.info(String.format("Pobrano %d filmów", allMovies.size()));
        modelAndView.addObject("movies", allMovies);
        modelAndView.setViewName("movieBase");
        return modelAndView;
    }

    @GetMapping("/info/{movieId}")
    public ModelAndView showMovieInfo(@PathVariable int movieId) {
        logger.info("Pokazuję informacje o filmie id:" + movieId);
        ModelAndView modelAndView = new ModelAndView();
        Movie retrievedMovie = movieService.findMovieById(movieId);
        modelAndView.addObject("movie", retrievedMovie);
        modelAndView.setViewName("movieInfo");
        return modelAndView;
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
