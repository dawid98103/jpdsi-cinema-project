package pl.paw.cinema.controller.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.paw.cinema.entity.Movie;
import pl.paw.cinema.service.MovieService;

import java.util.Comparator;
import java.util.stream.Collectors;

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

    @GetMapping("/info/{movieId}")
    public ModelAndView showMovieInfo(@PathVariable int movieId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("movie", movieService.findMovieById(movieId));
        modelAndView.setViewName("movieInfo");
        return modelAndView;
    }

    @GetMapping("/ranking")
    public ModelAndView showMovieRanking() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("movieRanking");
        modelAndView.addObject(
                "movie",
                movieService.findAll().stream()
                        .filter(movie -> movie.getAverageRate() != null)
                        .sorted(Comparator.comparingInt(Movie::getAverageRate).reversed())
                        .collect(Collectors.toList()));
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
