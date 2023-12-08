package com.example.commerciale.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.commerciale.models.DetailArticleEntre;
// id_article | nomarticle | idmagasin | nommagasin | entrees | sorties | ladate
public interface DetailArticleEntreRepository extends JpaRepository<DetailArticleEntre, Integer> {
    @Query(value = " select * from etatquantitearticle_f( :date ) where id_article= :id_article and idmagasin= :idmagasin ", nativeQuery = true)
    List<DetailArticleEntre> findById_articleByIdmagasinBeforeDate(int id_article,int idmagasin,Date date);
}