package com.example.commerciale.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.commerciale.models.DetailArticleRecu;

public interface DetailArticleRecuRepository extends JpaRepository<DetailArticleRecu, Integer> {
     //idbandereception | id_fournisseur | id_article | nomarticle | datereception | quantiterecu
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    @Query(value = "SELECT * FROM detailarticlerecu_view WHERE datereception = :datereception", nativeQuery = true)
    List<DetailArticleRecu> findByDatereception(Date datereception);
    @Query(value = "SELECT * FROM detailarticlerecu_view WHERE datereception = :datereception and id_fournisseur= :id_fournisseur", nativeQuery = true)
    List<DetailArticleRecu> findByDatereceptionById_fournisseur(Date datereception,int id_fournisseur);
}