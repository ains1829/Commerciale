package com.example.commerciale.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.commerciale.models.Membre;
public interface MemberRepository extends JpaRepository<Membre  , Integer>{
    @Query(value = "select id_departement from membre where id_membre = :id_membre" , nativeQuery = true)
    int getIddepartement(@Param("id_membre") int idmembre) ;
}
