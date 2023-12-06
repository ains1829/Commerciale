package com.example.commerciale.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.commerciale.models.Stock;
public interface StockRepository extends JpaRepository<Stock , Integer> {}
