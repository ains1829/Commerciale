package com.example.commerciale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commerciale.Models.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}