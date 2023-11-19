package com.example.commerciale.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.commerciale.models.Membre;
public interface MemberRepository extends JpaRepository<Membre  , Integer>{}
