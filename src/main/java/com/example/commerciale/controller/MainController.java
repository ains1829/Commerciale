package com.example.commerciale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {
    @GetMapping("/maPage")
    public String afficherMaPage() {
        return "Page";
    }
}
