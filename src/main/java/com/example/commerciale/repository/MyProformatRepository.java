package com.example.commerciale.repository;
import java.util.List;
import java.sql.Date;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.commerciale.models.Proformatmain;
import org.springframework.data.jpa.repository.Query;
public interface MyProformatRepository extends JpaRepository <Proformatmain , Integer >{
    @Query(value = "select * from _notcoast" , nativeQuery = true)
    List<Proformatmain> getProformatById_mere();

    @Query(value = "select max(dateproformat) from _notcoast" , nativeQuery = true)
    Date getDatemax();
}