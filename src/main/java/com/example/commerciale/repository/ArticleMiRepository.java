package com.example.commerciale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commerciale.Models.ArticleMi;

public interface ArticleMiRepository extends JpaRepository<ArticleMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}