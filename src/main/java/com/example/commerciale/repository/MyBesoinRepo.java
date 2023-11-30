package com.example.commerciale.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.commerciale.models.Besoin;
public interface MyBesoinRepo extends JpaRepository<Besoin , Integer> {
    @Query(value = "select nom from departement where id_departement = :iddepartement" , nativeQuery = true )
    String Namedepartement(@Param("iddepartement") int iddepartement) ;
}
