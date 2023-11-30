package com.example.commerciale.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Date;
import com.example.commerciale.models.Besoinmain;
public interface BesoinRepository extends JpaRepository<Besoinmain , Integer> {
    @Query(value = "select * from simple_groupement where datebesoin = :date_besoin" , nativeQuery = true) 
    List<Besoinmain> getBesoinMainDate(@Param("date_besoin") Date datess) ;
    @Query(value = "select datebesoin from simple_groupement group by datebesoin " , nativeQuery = true) 
    List<Date> getDateGroupement() ;
}
