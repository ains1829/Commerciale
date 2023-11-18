package com.example.commerciale.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commerciale.Models.Proformatmere;

public interface ProformatmereRepository extends JpaRepository<Proformatmere, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    List<Proformatmere> findByDateproformat( Date dateproformat);
    

}