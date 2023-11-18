package com.example.commerciale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.commerciale.Models.Proformat;

public interface ProformatRepository extends JpaRepository<Proformat, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    @Query(value = "SELECT * FROM proformat WHERE Id_proformatmere = :id_proformatmere", nativeQuery = true)
    List<Proformat> findByProformatMereId(int id_proformatmere);

    
}