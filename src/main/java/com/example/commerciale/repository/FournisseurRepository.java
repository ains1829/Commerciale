package com.example.commerciale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commerciale.Models.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}