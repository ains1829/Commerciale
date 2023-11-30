package com.example.commerciale.controller;

import javax.servlet.http.HttpSession;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;
import com.example.commerciale.models.Groupementnotif;
import com.example.commerciale.models.Membre;
import com.example.commerciale.models.Article;
import com.example.commerciale.models.Besoin;
import com.example.commerciale.models.Besoinmain;
import com.example.commerciale.service.ArticleService;
import com.example.commerciale.service.BandeDetail;
import com.example.commerciale.service.BesoinService;
import com.example.commerciale.service.BesoinTservice;
import com.example.commerciale.service.EmailService;
import com.example.commerciale.service.GroupementnotifService;
import com.example.commerciale.service.MemberService;
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
    @Autowired
    private BesoinTservice truebesoin ;
    @Autowired
    private MemberService memberService ;
    @Autowired
    private ArticleService article ;
    @Autowired
    private BesoinService besoin_view ;
    @Autowired
    private EmailService emailService;
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
    @GetMapping("/Besoin")
    public String Besoin(Model model){
        model.addAttribute("article", article) ;
        return "Besoin" ;
    }
    @GetMapping("/insertBesoin")
    public String getMethodName(@RequestParam("article") String article , @RequestParam("quantite") String quantite , @RequestParam("date") String date , HttpSession session) {
        Membre membrelogin = (Membre) session.getAttribute("aboutmember") ;
        int id_departement = memberService.getDepartement(membrelogin.getId_membre());
        System.out.println("departement = " + id_departement);
        int id_article = Integer.valueOf(article);
        double quantite_t = Double.valueOf(quantite);
        Date dates = Date.valueOf(date) ;
        Besoin mybesoin = new Besoin(dates , quantite_t , id_departement , id_article ) ;
        truebesoin.insertBesoin(mybesoin);
        return "redirect:/main/Besoin" ;
    }
    @GetMapping("/groupement")
    public String toGroupement(Model model){
        List<Date> dateList = besoin_view.getDateG() ;
        model.addAttribute("dateG", dateList) ;
        return "Groupement" ;
    }
    @GetMapping("/detail")
    public String detailGroupement(Model model , @RequestParam("dates") Date date_choice) {
        List<Besoinmain> besoingroupe = besoin_view.getBesoinAllBydate(date_choice) ;
        model.addAttribute("about", besoingroupe) ;
        model.addAttribute("article", article) ;
        model.addAttribute("notif", notifi) ;
        return "AboutGroupement" ;
    }
    @GetMapping("/insertnotif")
    public String insert(@RequestParam("dates") Date date_choice){
        Groupementnotif notif_new = new Groupementnotif(date_choice , 0) ;
        notifi.saving(notif_new) ;
        return "redirect:/main/detail?dates="+date_choice ;
    }
    @GetMapping("/profil")
    public String getProfil(){
        return "Profil" ;
    }
    @GetMapping("/send")
    public String sendEmailToMultipleRecipients(@RequestParam("dates") Date date_choice) {
        List<Besoinmain> besoingroupes = besoin_view.getBesoinAllBydate(date_choice) ;
        List<String> recipients = Arrays.asList("balitatsiory@gmail.com", "miradoregit@gmail.com");
        String subject = "Nos commande";
        StringBuilder bodys = new StringBuilder("Liste des commandes :\n \n \n");
        bodys.append("<html><body>") ;
        bodys.append("<table border='1'> <tr><th>Article</th><th>Quantite</th></tr>") ;
        for (int u = 0; u < besoingroupes.size(); u++) {
            Article articless = article.getArticleById(besoingroupes.get(u).getId_article()) ;
            bodys.append("<tr>").append("<td>").append(articless.getNom()).append("</td>").append("<td>").append(besoingroupes.get(u).getQuantite()).append(articless.getUnite()).append("</td></tr>") ;
        }
        bodys.append("</table></body></html>") ;
        emailService.sendHtmlEmail(recipients, subject, bodys.toString());
        return "redirect:/main/profil" ;
    }
    @GetMapping("/detail_groupement")
    public String getDetails(@RequestParam("dates") Date dates , @RequestParam("idarticle") int idarticle , Model model) {
        model.addAttribute("details", truebesoin.getcomposition(dates, idarticle))  ;
        model.addAttribute("serviceBesoin", truebesoin) ;
        model.addAttribute("article", article) ;
        return "Detailsgroupement" ;
    }
}
