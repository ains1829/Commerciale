package com.example.commerciale.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.commerciale.models.ArticleMi;
import com.example.commerciale.models.ProformatMi;
import com.example.commerciale.models.ProformatDetail;
import com.example.commerciale.models.ProformatmereMi;
import com.example.commerciale.models.ProformatmereDetail;
import com.example.commerciale.bodyrequest.Proformatsbody;
import com.example.commerciale.service.ArticleMiService;
import com.example.commerciale.service.FournisseurMiService;
import com.example.commerciale.service.ProformatMiService ;
import com.example.commerciale.service.ProformatmereMiService;

@Controller // Utiliser @Controller au lieu de @RestController
@RequestMapping("/mi")
public class Micontrolleur {

    @Autowired
    private ArticleMiService articleService;
    @Autowired
    private FournisseurMiService fournisseurService;
    @Autowired
    private ProformatMiService proformatService;
    @Autowired
    private ProformatmereMiService proformatmereService;
    @GetMapping("/")
    public String root(HttpServletRequest request,@RequestParam(name = "erreur", defaultValue = "") String erreur) {       
        request.setAttribute("articles",articleService.getTabAllArticles());
        request.setAttribute("fournisseurs",fournisseurService.getTabAllFournisseurs());
        request.setAttribute("erreur", erreur);
        System.out.println("--------------->>>>"+erreur);
        request.setAttribute("content", "proformatform.jsp");
        return "template"; 
    }
    @PostMapping("/saveproformats")
    public String savedataproformat(@RequestBody Proformatsbody proformatsbody,HttpServletRequest request){
        System.out.println("Tooooooongaaaaaaaaaa");
        String erreur="";
        try{
            int nbchecked=0;
            if(proformatsbody.getProformatmerebody()!=null ){   nbchecked++;    }
            if(proformatsbody.getProformatbodies()!=null ){ nbchecked++;    }
            if(nbchecked==2){
                System.out.println("date:"+proformatsbody.getProformatmerebody().getDateproformat()+" fournisseur:"+proformatsbody.getProformatmerebody().getId_fournisseur()+" nom:"+proformatsbody.getProformatmerebody().getNomproformat());
                ProformatmereMi proformatmere=new ProformatmereMi("0", proformatsbody.getProformatmerebody().getDateproformat(), proformatsbody.getProformatmerebody().getNomproformat(), proformatsbody.getProformatmerebody().getId_fournisseur());
                ProformatMi[] proformats=new ProformatMi[proformatsbody.getProformatbodies().size()];
                for(int i=0;i<proformatsbody.getProformatbodies().size();i++){
                    System.out.println("article:"+proformatsbody.getProformatbodies().get(i).getId_article()+" prix:"+proformatsbody.getProformatbodies().get(i).getPrixunitaire()+" quantite:"+proformatsbody.getProformatbodies().get(i).getQuantite()+" tva:"+proformatsbody.getProformatbodies().get(i).getTva());
                    proformats[i]=new ProformatMi("0","0",proformatsbody.getProformatbodies().get(i).getQuantite(),proformatsbody.getProformatbodies().get(i).getPrixunitaire(),proformatsbody.getProformatbodies().get(i).getTva(),proformatsbody.getProformatbodies().get(i).getId_article());
                }
                proformatmere.insererProformatmereAndAllProformat(proformatService, proformatmereService, proformats);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            erreur=ex.getMessage();
            System.out.println("----------->"+erreur);
        }
        //request.setAttribute("", null);
        return "redirect:/?erreur="+erreur;
    }
    @PostMapping("/getArticles")
    public ResponseEntity<?> getArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }
    @GetMapping("/voirproformatmeres")
    public String voirproformatmere(HttpServletRequest request){
        ProformatmereDetail[] proformatmereDetails=new ProformatmereDetail().getAllProformatDetail(proformatmereService, fournisseurService);
        if(proformatmereDetails!=null){
            System.out.println(proformatmereDetails.length);
        }
        request.setAttribute("proformatmereDetails", proformatmereDetails);
        request.setAttribute("content", "proformatmeres.jsp");
        return "template";
    }
    @GetMapping("/voidetailByIdproformatmere")
    public String voidetailByIdproformatmere(@RequestParam(name = "Id_proformatmere",defaultValue = "0") String Id_proformatmere ,HttpServletRequest request){
        ProformatDetail[] proformatDetails=new ProformatDetail().getProformatDetailsById_proformatmere(proformatService, articleService, Integer.valueOf(Id_proformatmere));
        request.setAttribute("proformatDetails", proformatDetails);
        request.setAttribute("content", "proformatdetails.jsp");
        return "template";
    }

}

