package pl.paw.cinema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.paw.cinema.entity.Movie;
import pl.paw.cinema.service.MovieService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MovieService movieService;

    @GetMapping(value = {"/", "welcome"})
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        List<Movie> movies = movieService.findAll();
        modelAndView.addObject("movieList", movies);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
