package com.example.commerciale.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Date ;
import java.util.List;
import com.example.commerciale.models.Livraison;
public interface LivraisonRepository extends JpaRepository<Livraison , Integer> {
    @Query(value = "select count(*) as n  from livraison where id_fournisseur = :idfournisseur and datebandecommande = :date group by id_fournisseur , datebandecommande " , nativeQuery = true)
    Integer numberExist (@Param("idfournisseur") int idfournisseur , @Param("date") Date datebandecommande) ;
    @Query(value = "select datelivraison from livraison group by datelivraison " , nativeQuery = true)
    List<Date> Datelivraison();
}
