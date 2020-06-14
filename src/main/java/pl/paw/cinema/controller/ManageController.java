package pl.paw.cinema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ManageController {

    @GetMapping("/adminDashboard")
    public ModelAndView showAdminPage() {
        return new ModelAndView("adminDashboard");
    }

    @GetMapping("/manage/users")
    public ModelAndView showUsersManagePage() {
        return new ModelAndView("manageUsers");
    }

    @GetMapping("/manage/movies")
    public ModelAndView showMoviesManagePage() {
        return new ModelAndView("manageMovies");
    }

    @GetMapping("/manage/showings")
    public ModelAndView showShowingsManagePage() {
        return new ModelAndView("manageShowings");
    }
}
