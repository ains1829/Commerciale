package com.example.commerciale.controller;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.commerciale.models.Fournisseur;
import com.example.commerciale.models.Membre;
import com.example.commerciale.service.BandeDetail;
import com.example.commerciale.service.MemberService;
import com.example.commerciale.service.ServiceFournisseur;
import com.example.commerciale.service.ServiceLivraison;
@Controller
@RequestMapping("/logincontroller")
public class LoginContoller {
    @Autowired
    private MemberService serviceMember ;
    @Autowired
    private BandeDetail detailBande;
    @Autowired
    private ServiceFournisseur fournisseur ;
    @Autowired 
    private ServiceLivraison servicelivraison;
    @PostMapping("/login")
    public String login(@RequestParam("email") String email , @RequestParam("password") String password, HttpSession session , Model model){
        Membre membre = serviceMember.MembreExist(email, password) ;
        if(membre == null){
            return "Page" ;
        }
        session.setAttribute("aboutmember", membre);
        model.addAttribute("bande", detailBande) ;
        model.addAttribute("fournisseur", fournisseur) ;
        return "Profil" ;
    }
    @PostMapping("/fournisseur_login")
    public String login_fournisseur(@RequestParam("email") String email , @RequestParam("password") String password, HttpSession session , Model model){
        Fournisseur fournisseur_exist= fournisseur.isFournisseur(email, password) ;
        if(fournisseur_exist == null){
            return "PageFournisseur" ;
        }
        session.setAttribute("aboutfournisseur", fournisseur_exist);
        model.addAttribute("livraison", servicelivraison) ;
        model.addAttribute("bande", detailBande) ;
        model.addAttribute("fournisseur", fournisseur) ;
        return "AfficheF" ;
    }
}
