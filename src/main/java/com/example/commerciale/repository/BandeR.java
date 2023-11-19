package com.example.commerciale.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.commerciale.models.Bandecommandedetail;
import java.util.List ;
import java.sql.Date; 
public interface BandeR  extends JpaRepository<Bandecommandedetail , Integer> {
    @Query(value = "select id_fournisseur from bandecommandedetail group by id_fournisseur " , nativeQuery = true )
    List <Integer> getMereFournisseur() ;
    @Query(value = "select datebandecommade from bandecommandedetail group by datebandecommade order by datebandecommade desc" , nativeQuery = true)
    List<Date> getDateMere();
    @Query(value = "select nom from article where id_article = :idarticle" , nativeQuery = true)
    String Namearticle(@Param("idarticle") int idarticle); 
}
