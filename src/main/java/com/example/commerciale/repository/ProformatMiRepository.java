package com.example.commerciale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.commerciale.Models.ProformatMi;

public interface ProformatMiRepository extends JpaRepository<ProformatMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    @Query(value = "SELECT * FROM proformat WHERE Id_proformatmere = :id_proformatmere", nativeQuery = true)
    List<ProformatMi> findByProformatMereId(int id_proformatmere);

    
}