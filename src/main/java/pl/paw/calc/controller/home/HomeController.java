package pl.paw.calc.controller.home;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.paw.calc.entity.Movie;
import pl.paw.calc.service.MovieService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MovieService movieService;

    @GetMapping(value = "/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        List<Movie> movies = movieService.findAll();
        modelAndView.addObject("movieList", movies);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
