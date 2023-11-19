package com.example.commerciale.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.commerciale.models.Fournisseur;
import com.example.commerciale.repository.FournisseurResp;
@Service
public class ServiceFournisseur {
    @Autowired
    FournisseurResp myfournisseur ;
    public List<Fournisseur> getAllFournisseur(){
        return myfournisseur.findAll() ;
    }
    public Fournisseur getFournisseur(Integer id){
        return myfournisseur.getById(id) ;
    }
}
