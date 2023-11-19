package com.example.commerciale.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.commerciale.models.Groupementnotif;
public interface NotificationGroupement extends JpaRepository<Groupementnotif , Integer> {}
