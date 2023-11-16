package com.example.commerciale.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.commerciale.models.Proformatmain;
public interface MyProformatRepository extends JpaRepository <Proformatmain , Integer >{}
