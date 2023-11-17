package com.example.commerciale.controller;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.commerciale.Models.EmailService;
// import com.example.commerciale.service.ProformatmereService;
// import com.example.commerciale.repository.*;

@Controller // Utiliser @Controller au lieu de @RestController
public class Micontrolleur {
    @Autowired
    private EmailService emailService;
    // @Autowired
    // private ProformatService proformatService;
    //@Autowired
    //ProformatmereService proformatmereService;
    @GetMapping("/")
    public String root(HttpServletRequest request) {
        request.setAttribute("content", "index.jsp");
        return "template"; 
    }
    @PostMapping("/sendmail")
    public String sendmail(HttpServletRequest request, @RequestParam(name = "erreur", defaultValue = "") String erreur, Model model) {
        emailService.sendEmail("miradoregit@gmail.com", "teste mail", "test test");
        request.setAttribute("content", "index.jsp");
        return "template";
    }
    // @PostMapping("/submitForm")
    // public String submitForm(@RequestBody FormData formData) {
    //     // Implémentez la logique de traitement des données ici
    //     // Vous pouvez accéder aux données via formData.getDateproformat(), formData.getDynamicFields(), etc.
    //     return "success"; // Remplacez "success" par la vue de succès que vous souhaitez afficher
    // }

    // @PostMapping("/ajouterPersonne")
    // public String ajouterPersonne(@RequestParam(name = "nom") String nom,
    //                               @RequestParam(name = "prenom") String prenom) {
    //     Personne personne = new Personne();
    //     personne.setNom(nom);
    //     personne.setPrenom(prenom);
    //     personneService.savePersonne(personne);
    //     return "redirect:/";
    // }

}

