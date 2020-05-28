package pl.paw.cinema.controller.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.paw.cinema.entity.User;
import pl.paw.cinema.service.UserService;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;
    private Logger logger = Logger.getLogger(getClass().getName());

    @GetMapping("/loginForm")
    public ModelAndView showLoginForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signIn");
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView showRegisterForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("signUp");
        return modelAndView;
    }

    @PostMapping("/processRegistrationForm")
    public ModelAndView registerAccount(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        logger.info("Processing registration form for: " + user.getUserName());

        if (!((user.getPassword().equals(user.getConfirmPassword())))) {
            bindingResult.rejectValue("confirmPassword", "error.user", "Hasła muszą być identyczne");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("signUp");
            return modelAndView;
        }

        if (userService.isUsernameExists(user.getUserName())) {
            modelAndView.addObject("user", new User());
            modelAndView.addObject("registrationError", "Nazwa użytkownika już istnieje");
            logger.warning("Nazwa użytkownika już istnieje");
            return modelAndView;
        }
        userService.saveUser(user);
        logger.info("Succesfuly created user");
        modelAndView.addObject("successfullyRegistered", true);
        modelAndView.setViewName("home");
        System.out.println(modelAndView);
        return modelAndView;
    }
}