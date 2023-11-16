package com.example.commerciale.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
@RequestMapping("/main")
public class MainController {
    @GetMapping("/maPage")
    public String afficherMaPage(Model model) {
        model.addAttribute("message", "Bienvenue sur ma page!");
        return "Page";
    }
}
