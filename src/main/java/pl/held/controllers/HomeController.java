package pl.held.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {

        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "signInForm";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}

