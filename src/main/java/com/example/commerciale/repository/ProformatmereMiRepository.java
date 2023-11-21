package com.example.commerciale.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commerciale.Models.ProformatmereMi;

public interface ProformatmereMiRepository extends JpaRepository<ProformatmereMi, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    List<ProformatmereMi> findByDateproformat( Date dateproformat);
    

}