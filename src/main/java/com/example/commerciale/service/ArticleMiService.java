package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerciale.Models.ArticleMi;
import com.example.commerciale.repository.ArticleMiRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ArticleMiService {

    @Autowired
    private ArticleMiRepository articleRepository;

    // Méthode pour enregistrer un Article
    public ArticleMi saveArticle(ArticleMi Article) {
        return articleRepository.save(Article);
    }

    // Méthode pour récupérer tous les Articles
    public List<ArticleMi> getAllArticles() {
        return articleRepository.findAll();
    }
    public ArticleMi[] getTabAllArticles(){
        List<ArticleMi> lstA=getAllArticles();
        if(lstA==null){ return null; }
        ArticleMi[] articles=new ArticleMi[lstA.size()];
        for(int i=0;i<lstA.size();i++){
            articles[i]=lstA.get(i);
        }
        return articles;
    }
    // Méthode pour récupérer un Article par son ID
    public Optional<ArticleMi> getArticleById(int id) {
        return articleRepository.findById(id);
    }

    // Méthode pour supprimer un Article par son ID
    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }
}
