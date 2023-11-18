package com.example.commerciale.controller;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.commerciale.service.BandeDetail;
import com.example.commerciale.service.BesoinService;
import com.example.commerciale.service.MyProformatService;
import com.example.commerciale.models.Bandecommandedetail;
import com.example.commerciale.models.Besoinmain;
import com.example.commerciale.models.Proformatmain;
import com.example.commerciale.repository.BandeR;
import com.example.commerciale.repository.BesoinRepository;
@RestController
@RequestMapping("/testcontroller")
public class PostmanController {
    @Autowired
    MyProformatService proformatService ;
    @Autowired
    BesoinService besoinService ;
    @Autowired
    BandeDetail bandeservice ;
    @Autowired
    BandeR bandeRere ;
    @GetMapping("/allproformat")
    public List<Proformatmain> getAllProformats() {
        return proformatService.getProformatAll() ;
    }
    @GetMapping("/besoinAll")
    public List<Besoinmain> getAllBesoinmains(){
        return besoinService.getBesoin();
    }
    @GetMapping("/montant")
    public double getMontantMontant(){
        Date date = Date.valueOf("2023-11-16");
        return bandeservice.getMontant(date);
    }
    @GetMapping("/generateBande")
    public List<Bandecommandedetail> getNewBandecommande(){
        Date date = Date.valueOf("2023-11-16") ;
        return bandeservice.ajouterBandeDetails(date) ;
    }
    @GetMapping("/bande")
    public Bandecommandedetail saving(@RequestBody Bandecommandedetail bd){
        return bandeRere.save(bd) ;
    }
}
