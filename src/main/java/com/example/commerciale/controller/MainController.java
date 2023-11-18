package com.example.commerciale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    @GetMapping("/maPage")
    public String afficherMaPage(Model model) {
        // Ajoutez des données au modèle si nécessaire
        model.addAttribute("message", "Bienvenue sur ma page!");

        // Renvoie le nom de la vue (la page)
        return "Page";
    }
}
