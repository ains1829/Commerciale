package com.example.commerciale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commerciale.Models.Proformat;

public interface ProformatRepository extends JpaRepository<Proformat, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    
}