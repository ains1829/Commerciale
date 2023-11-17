package com.example.commerciale.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.commerciale.bodyrequest.Proformatsbody;

@Controller // Utiliser @Controller au lieu de @RestController
public class Micontrolleur {
    @GetMapping("/")
    public String root(HttpServletRequest request) {
        request.setAttribute("content", "index.jsp");
        return "template"; 
    }
    @PostMapping("/saveproformats")
    public String savedataproformat(@RequestBody Proformatsbody proformatsbody){
        System.out.println("Tooooooongaaaaaaaaaa");
        if(proformatsbody.getProformatmerebody()!=null ){
            System.out.println("date:"+proformatsbody.getProformatmerebody().getDateproformat()+" fournisseur:"+proformatsbody.getProformatmerebody().getId_fournisseur()+" nom:"+proformatsbody.getProformatmerebody().getNomproformat());
        }
        if(proformatsbody.getProformatbodies()!=null ){
            for(int i=0;i<proformatsbody.getProformatbodies().size();i++){
                System.out.println("article:"+proformatsbody.getProformatbodies().get(i).getId_article()+" prix:"+proformatsbody.getProformatbodies().get(i).getPrixunitaire()+" quantite:"+proformatsbody.getProformatbodies().get(i).getQuantite()+" tva:"+proformatsbody.getProformatbodies().get(i).getTva());
            }
        }
        return "template";
    }

}

