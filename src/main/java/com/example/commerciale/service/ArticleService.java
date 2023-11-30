package com.example.commerciale.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.commerciale.models.Article;
import com.example.commerciale.repository.ArticleRepo;
@Service
public class ArticleService {
    @Autowired
    private ArticleRepo articlerepo ;
    public List<Article> getArticleAll(){
        return articlerepo.findAll() ;
    }
    public Article getArticleById(Integer id){
        return articlerepo.getById(id) ;
    }
}
