package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerciale.Models.Fournisseur;
import com.example.commerciale.repository.FournisseurRepository;

import java.util.List;
import java.util.Optional;
@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    // Méthode pour enregistrer un Fournisseur
    public Fournisseur saveFournisseur(Fournisseur Fournisseur) {
        return fournisseurRepository.save(Fournisseur);
    }

    // Méthode pour récupérer tous les Fournisseurs
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }
    public Fournisseur[] getTabAllFournisseurs(){
        List<Fournisseur> lstA=getAllFournisseurs();
        if(lstA==null){ return null; }
        Fournisseur[] fournisseurs=new Fournisseur[lstA.size()];
        for(int i=0;i<lstA.size();i++){
            fournisseurs[i]=lstA.get(i);
        }
        return fournisseurs;
    }

    // Méthode pour récupérer un Fournisseur par son ID
    public Optional<Fournisseur> getFournisseurById(int id) {
        return fournisseurRepository.findById(id);
    }

    // Méthode pour supprimer un Fournisseur par son ID
    public void deleteFournisseur(int id) {
        fournisseurRepository.deleteById(id);
    }
}
