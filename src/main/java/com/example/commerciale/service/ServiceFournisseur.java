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
    public Fournisseur isFournisseur(String email , String password){
        List<Fournisseur> list_fournisseur = getAllFournisseur() ;
        for (int i = 0; i < list_fournisseur.size(); i++) {
            if((list_fournisseur.get(i).getEmail().compareTo(email) == 0) && (list_fournisseur.get(i).getPassword().compareTo(password) == 0)) {
                return list_fournisseur.get(i) ;
            }
        }
        return null ;
    }
}
