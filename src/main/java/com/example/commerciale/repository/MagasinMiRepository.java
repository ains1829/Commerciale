package com.example.commerciale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commerciale.models.MagasinMi;

public interface MagasinMiRepository extends JpaRepository<MagasinMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}