package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerciale.Models.Article;
import com.example.commerciale.repository.ArticleRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    // Méthode pour enregistrer un Article
    public Article saveArticle(Article Article) {
        return articleRepository.save(Article);
    }

    // Méthode pour récupérer tous les Articles
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
    public Article[] getTabAllArticles(){
        List<Article> lstA=getAllArticles();
        if(lstA==null){ return null; }
        Article[] articles=new Article[lstA.size()];
        for(int i=0;i<lstA.size();i++){
            articles[i]=lstA.get(i);
        }
        return articles;
    }
    // Méthode pour récupérer un Article par son ID
    public Optional<Article> getArticleById(int id) {
        return articleRepository.findById(id);
    }

    // Méthode pour supprimer un Article par son ID
    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }
}
