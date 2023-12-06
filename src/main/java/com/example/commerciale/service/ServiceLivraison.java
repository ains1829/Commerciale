package com.example.commerciale.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerciale.models.Livraison;
import com.example.commerciale.repository.LivraisonRepository;

@Service
public class ServiceLivraison {
    @Autowired
    private LivraisonRepository livraisonRepository;
    public Livraison Saving(Livraison livraison){
        return livraisonRepository.save(livraison) ;
    }
    public int getNumberLivraison(int idfournisseur , Date date){
        if(livraisonRepository.numberExist(idfournisseur, date) == null){
            return 0 ;
        }
        return livraisonRepository.numberExist(idfournisseur, date); 
    }
    public List<Date> Datelivraison(){
        return livraisonRepository.Datelivraison() ;
    }
    public List<Livraison> AllLivraison(){
        return livraisonRepository.findAll() ;
    }
    public List<Livraison> MyLivraison(int idfournisseur , Date bandecommande){
        List<Livraison> list = AllLivraison() ;
        List<Livraison> result = new ArrayList<Livraison>() ;
        for (int i = 0; i < list.size(); i++) {
            if((list.get(i).getId_fournisseur() == idfournisseur) && (list.get(i).getDatebandecommande().equals(bandecommande) == true)){
                result.add(list.get(i)) ;
            }
        }
        return result ;
    }
}
