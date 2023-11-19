package com.example.commerciale.controller;

import javax.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;
import com.example.commerciale.models.Groupementnotif;
import com.example.commerciale.models.Membre;
import com.example.commerciale.service.BandeDetail;
import com.example.commerciale.service.GroupementnotifService;
import com.example.commerciale.service.ServiceFournisseur;
import com.ibm.icu.text.Normalizer.Mode;
@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    private GroupementnotifService notifi ;
    @Autowired
    private BandeDetail detailBande;
    @Autowired
    private ServiceFournisseur fournisseur ;
    @GetMapping("/maPage")
    public String afficherMaPage(Model model) {
        model.addAttribute("message", "Bienvenue sur ma page!");
        return "Page";
    }
    
    @GetMapping("/notification")
    public String NotifPage(HttpSession session , Model model){
        Membre membrelogin = (Membre) session.getAttribute("aboutmember") ;
        List<Groupementnotif> notif = notifi.getNotif(membrelogin.getProfil(), membrelogin.getDepartement()) ;
        model.addAttribute("notification", notif) ;
        model.addAttribute("bande", detailBande) ;
        return "Notification";
    }
    @GetMapping("/commande")
    public String Commande(HttpSession session , Model model){
        Membre membrelogin = (Membre) session.getAttribute("aboutmember") ;
        System.out.println(membrelogin.getNom() + " passd = " + membrelogin.getMdp());
        System.out.println("now = " +  detailBande);
        model.addAttribute("bande", detailBande) ;
        model.addAttribute("fournisseur", fournisseur) ;
        return "Bandecommande";
    }
    @GetMapping("/updateetat")
    public String EtatBesoin(@RequestParam("idgroupenet") Integer id){
        notifi.updateGroupement(id) ;
        return "redirect:/main/notification" ;
    }
    @GetMapping("/updateetatdg")
    public String EtatBesoinDG(@RequestParam("idgroupenet") Integer id){
        notifi.updateGroupementdg(id) ;
        Groupementnotif notifgroupement = notifi.notifigroupement(id) ;
        Date date = notifgroupement.getDatebesoin() ;
        detailBande.ajouterBandeDetails(date) ;
        return "redirect:/main/commande" ;
    }
}
