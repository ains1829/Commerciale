package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerciale.models.BonsortieMi;
import com.example.commerciale.repository.BonsortieMiRepository;

import java.util.List;
import java.util.Optional;
@Service
public class BonsortieMiService {

    @Autowired
    private BonsortieMiRepository bonsortieRepository;

    // Méthode pour enregistrer un bonsortie
    public BonsortieMi savebonsortie(BonsortieMi bonsortie) {
        return bonsortieRepository.save(bonsortie);
    }

    // Méthode pour récupérer tous les bonsorties
    public List<BonsortieMi> getAllbonsorties() {
        return bonsortieRepository.findAll();
    }
    public BonsortieMi getLastBonsortieMi(int magasin,int id_article){
        List<BonsortieMi> lstA=bonsortieRepository.getLastBonSortie(magasin, id_article);
        if(lstA.isEmpty()==true){ return null; }
        BonsortieMi bonsorties=lstA.get(0);
        return bonsorties;
    }
    public BonsortieMi[] getTabAllbonsorties(){
        List<BonsortieMi> lstA=getAllbonsorties();
        if(lstA==null){ return null; }
        if(lstA.isEmpty()){ return null; }
        BonsortieMi[] bonsorties=new BonsortieMi[lstA.size()];
        for(int i=0;i<lstA.size();i++){
            bonsorties[i]=lstA.get(i);
        }
        return bonsorties;
    }
    // Méthode pour récupérer un bonsortie par son ID
    public Optional<BonsortieMi> getById(int id) {
        return bonsortieRepository.findById(id);
    }

    // Méthode pour supprimer un bonsortie par son ID
    public void deletebonsortie(int id) {
        bonsortieRepository.deleteById(id);
    }
}
