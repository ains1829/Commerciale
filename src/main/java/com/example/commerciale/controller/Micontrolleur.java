package com.example.commerciale.controller;
import com.example.commerciale.Models.*;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.Connection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Utiliser @Controller au lieu de @RestController
public class Micontrolleur {

    @GetMapping("/")
    public String root(HttpServletRequest request) {
        request.setAttribute("content", "index.jsp");
        return "template"; 
    }
    @GetMapping("/tostockout")
    public String tostockout(HttpServletRequest request,@RequestParam(name = "erreur", defaultValue = "") String erreur,Model model) {
        return "template";
    }
}

