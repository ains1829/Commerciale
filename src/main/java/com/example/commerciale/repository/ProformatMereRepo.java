package com.example.commerciale.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.commerciale.models.MereProformat;
public interface ProformatMereRepo extends JpaRepository <MereProformat , Integer> {
    @Query(value = "select * from proformatmere where id_fournisseur = :id order by dateproformat desc limit 1" , nativeQuery = true)
    MereProformat getLastProformatByFournisseur(@Param("id") int id_fournisseur);
}
