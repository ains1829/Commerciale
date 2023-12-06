package com.example.commerciale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commerciale.models.BonentreMi;

public interface BonentreMiRepository extends JpaRepository<BonentreMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}