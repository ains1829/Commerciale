package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerciale.models.MagasinMi;
import com.example.commerciale.repository.MagasinMiRepository;

import java.util.List;
import java.util.Optional;
@Service
public class MagasinMiService {

    @Autowired
    private MagasinMiRepository magasinRepository;

    // Méthode pour enregistrer un magasin
    public MagasinMi savemagasin(MagasinMi magasin) {
        return magasinRepository.save(magasin);
    }

    // Méthode pour récupérer tous les magasins
    public List<MagasinMi> getAllmagasins() {
        return magasinRepository.findAll();
    }
    public MagasinMi[] getTabAllmagasins(){
        List<MagasinMi> lstA=getAllmagasins();
        if(lstA==null){ return null; }
        if(lstA.isEmpty()==true){ return null; }
        MagasinMi[] magasins=new MagasinMi[lstA.size()];
        for(int i=0;i<lstA.size();i++){
            magasins[i]=lstA.get(i);
        }
        return magasins;
    }
    // Méthode pour récupérer un magasin par son ID
    public Optional<MagasinMi> getById(int id) {
        return magasinRepository.findById(id);
    }

    // Méthode pour supprimer un magasin par son ID
    public void deletemagasin(int id) {
        magasinRepository.deleteById(id);
    }
}
