package com.example.commerciale.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.commerciale.Models.Article;
import com.example.commerciale.bodyrequest.Proformatsbody;
import com.example.commerciale.service.ArticleService;
import com.example.commerciale.service.FournisseurService;

@Controller // Utiliser @Controller au lieu de @RestController
public class Micontrolleur {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private FournisseurService fournisseurService;
    @GetMapping("/")
    public String root(HttpServletRequest request) {       
        request.setAttribute("articles",articleService.getTabAllArticles());
        request.setAttribute("fournisseurs",fournisseurService.getTabAllFournisseurs());
        request.setAttribute("content", "index.jsp");
        return "template"; 
    }
    @PostMapping("/saveproformats")
    public String savedataproformat(@RequestBody Proformatsbody proformatsbody,HttpServletRequest request){
        System.out.println("Tooooooongaaaaaaaaaa");
        if(proformatsbody.getProformatmerebody()!=null ){
            System.out.println("date:"+proformatsbody.getProformatmerebody().getDateproformat()+" fournisseur:"+proformatsbody.getProformatmerebody().getId_fournisseur()+" nom:"+proformatsbody.getProformatmerebody().getNomproformat());
            
        }
        if(proformatsbody.getProformatbodies()!=null ){
            for(int i=0;i<proformatsbody.getProformatbodies().size();i++){
                System.out.println("article:"+proformatsbody.getProformatbodies().get(i).getId_article()+" prix:"+proformatsbody.getProformatbodies().get(i).getPrixunitaire()+" quantite:"+proformatsbody.getProformatbodies().get(i).getQuantite()+" tva:"+proformatsbody.getProformatbodies().get(i).getTva());
            }
        }
        //request.setAttribute("", null);
        return "redirect:/";
    }
    @PostMapping("/getArticles")
    public ResponseEntity<?> getArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

}

