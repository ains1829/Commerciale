package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerciale.Models.FournisseurMi;
import com.example.commerciale.repository.FournisseurMiRepository;

import java.util.List;
import java.util.Optional;
@Service
public class FournisseurMiService {

    @Autowired
    private FournisseurMiRepository fournisseurRepository;

    // Méthode pour enregistrer un Fournisseur
    public FournisseurMi saveFournisseur(FournisseurMi Fournisseur) {
        return fournisseurRepository.save(Fournisseur);
    }

    // Méthode pour récupérer tous les Fournisseurs
    public List<FournisseurMi> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }
    public FournisseurMi[] getTabAllFournisseurs(){
        List<FournisseurMi> lstA=getAllFournisseurs();
        if(lstA==null){ return null; }
        FournisseurMi[] fournisseurs=new FournisseurMi[lstA.size()];
        for(int i=0;i<lstA.size();i++){
            fournisseurs[i]=lstA.get(i);
        }
        return fournisseurs;
    }

    // Méthode pour récupérer un Fournisseur par son ID
    public Optional<FournisseurMi> getFournisseurById(int id) {
        return fournisseurRepository.findById(id);
    }

    // Méthode pour supprimer un Fournisseur par son ID
    public void deleteFournisseur(int id) {
        fournisseurRepository.deleteById(id);
    }
}
