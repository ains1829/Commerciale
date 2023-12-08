package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerciale.models.BonentreMi;
import com.example.commerciale.repository.BonentreMiRepository;

import java.util.List;
import java.util.Optional;
@Service
public class BonentreMiService {

    @Autowired
    private BonentreMiRepository bonentreMiRepository;

    // Méthode pour enregistrer un Article
    public BonentreMi saveBonentre(BonentreMi bonentreMi) {
        return bonentreMiRepository.save(bonentreMi);
    }
    // Méthode pour récupérer tous les Articles
    public List<BonentreMi> getAllArticles() {
        return bonentreMiRepository.findAll();
    }
    public BonentreMi[] getTabAllArticles(){
        List<BonentreMi> lstB=getAllArticles();
        if(lstB==null){ return null; }
        if(lstB.isEmpty()==true){ return null; }
        BonentreMi[] bonentreMis=new BonentreMi[lstB.size()];
        for(int i=0;i<lstB.size();i++){
            bonentreMis[i]=lstB.get(i);
        }
        return bonentreMis;
    }
    // Méthode pour récupérer un Article par son ID
    public Optional<BonentreMi> getArticleById(int id) {
        return bonentreMiRepository.findById(id);
    }

    // Méthode pour supprimer un Article par son ID
    public void deleteArticle(int id) {
        bonentreMiRepository.deleteById(id);
    }
}
