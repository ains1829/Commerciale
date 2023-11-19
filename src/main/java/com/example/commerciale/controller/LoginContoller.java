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
import com.example.commerciale.models.Membre;
import com.example.commerciale.service.BandeDetail;
import com.example.commerciale.service.MemberService;
import com.example.commerciale.service.ServiceFournisseur;
@Controller
@RequestMapping("/logincontroller")
public class LoginContoller {
    @Autowired
    private MemberService serviceMember ;
    @Autowired
    private BandeDetail detailBande;
    @Autowired
    private ServiceFournisseur fournisseur ;
    @PostMapping("/login")
    public String login(@RequestParam("email") String email , @RequestParam("password") String password, HttpSession session , Model model){
        System.out.println(email);
        System.out.println(password);
        Membre membre = serviceMember.MembreExist(email, password) ;
        if(membre == null){
            return "Page" ;
        }
        session.setAttribute("aboutmember", membre);
        model.addAttribute("bande", detailBande) ;
        model.addAttribute("fournisseur", fournisseur) ;
        return "Bandecommande" ;
    }
}
