package com.example.commerciale.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.commerciale.models.Besoinmain;
import com.example.commerciale.models.BonsortieMi;
// idbonsortie | idbonentre | quantitesortie | datesortie

// lastbonsortie_view :idbonsortie | idbonentre | idmagasin | id_article | quantitesortie | datesortie
public interface BonsortieMiRepository extends JpaRepository<BonsortieMi, Integer> {
    @Query(value = "select idbonsortie, idbonentre, quantitesortie, datesortie from lastbonsortie_view where idmagasin= : idmagasin and id_article= : id_article" , nativeQuery = true) 
    List<BonsortieMi> getLastBonSortie(int idmagasin , int id_article) ;
}