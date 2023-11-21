package com.example.commerciale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commerciale.Models.FournisseurMi;

public interface FournisseurMiRepository extends JpaRepository<FournisseurMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}