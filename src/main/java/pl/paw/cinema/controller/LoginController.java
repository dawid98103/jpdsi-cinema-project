package pl.paw.cinema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.paw.cinema.entity.User;
import pl.paw.cinema.service.SecurityService;
import pl.paw.cinema.service.UserService;
import pl.paw.cinema.utils.helper.UserValidator;

import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    private final SecurityService securityService;
    private final UserValidator userValidator;
    private Logger logger = Logger.getLogger(getClass().getName());

    @GetMapping("/loginForm")
    public String showLoginForm() {
        return "signIn";
    }

    @GetMapping("/registrationForm")
    public ModelAndView showRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("signUp");
        return modelAndView;
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Nazwa użytkownika jest nieprawidłowa");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "signIn";
    }

    @PostMapping("/processRegistrationForm")
    public String registerAccount(@ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors())
            return "signUp";

        userService.saveUser(user);
        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());
        logger.info("Succesfuly created user");
        return "redirect:/welcome";
    }
}