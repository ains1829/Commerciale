package com.example.commerciale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commerciale.Models.Proformatmere;

public interface ProformatmereRepository extends JpaRepository<Proformatmere, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}