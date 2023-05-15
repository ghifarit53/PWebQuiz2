package com.pweb.reddits.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String welcome(Model model) {
        String name = "Ghifari";
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/newpost")
    public String post(Model model) {
        return "newpost";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        return "signup";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    @GetMapping("/profile")
    public String profile(Model model) {
        return "profile";
    }

}
