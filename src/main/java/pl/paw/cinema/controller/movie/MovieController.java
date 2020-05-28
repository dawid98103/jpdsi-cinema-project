package pl.paw.cinema.controller.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.paw.cinema.entity.Movie;
import pl.paw.cinema.service.MovieService;
import pl.paw.cinema.service.RateService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;
    private final RateService rateService;

    @GetMapping("/info/movies")
    public ModelAndView getAllMovies() {
        ModelAndView modelAndView = new ModelAndView();
        List<Movie> allMovies = movieService.findAll();
        modelAndView.addObject("movies", allMovies);
        modelAndView.setViewName("movieBase");
        return modelAndView;
    }

    @GetMapping("/info/{movieId}")
    public ModelAndView showMovieInfo(@PathVariable int movieId) {
        ModelAndView modelAndView = new ModelAndView();
        Movie retrievedMovie = movieService.findMovieById(movieId);
        modelAndView.addObject("movie", retrievedMovie);
        modelAndView.setViewName("movieInfo");
        return modelAndView;
    }

    @GetMapping("/ranking")
    public ModelAndView showMovieRanking(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("movieRanking");
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
