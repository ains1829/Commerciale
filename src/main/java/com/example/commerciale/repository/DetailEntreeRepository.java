package com.example.commerciale.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.commerciale.models.DetailEntree;

public interface DetailEntreeRepository extends JpaRepository<DetailEntree, Integer> {
    // idbonentre | id_article | idmagasin | quantiteentre | totalsortie | dateentre | ladate | prixht | tva | prixttc
    @Query(value = " select * from etatquantiteentre_f( :date ) where id_article= :id_article and idmagasin= :idmagasin ", nativeQuery = true)
    List<DetailEntree> findById_articleByIdmagasinBeforeDate(int id_article,int idmagasin,Date date);
    @Query(value = " select * from etatquantiteentre_f( :date ) where id_article= :id_article and idmagasin= :idmagasin order by dateentre ASC,prixttc ASC ", nativeQuery = true)
    List<DetailEntree> findById_articleByIdmagasinBeforeDateFifo(int id_article, int idmagasin,Date date);
    @Query(value = " select * from etatquantiteentre_f( :date ) where id_article= :id_article and idmagasin= :idmagasin order by dateentre DESC,prixttc ASC", nativeQuery = true)
    List<DetailEntree> findById_articleByIdmagasinBeforeDateLifo(int id_article, int idmagasin,Date date);
}