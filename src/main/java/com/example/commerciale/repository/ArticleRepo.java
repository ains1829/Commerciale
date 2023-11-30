package com.example.commerciale.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.commerciale.models.Article;
public interface ArticleRepo extends JpaRepository<Article , Integer> {}
