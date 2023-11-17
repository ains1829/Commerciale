package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerciale.Models.Proformatmere;
import com.example.commerciale.repository.ProformatmereRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProformatmereService {

    @Autowired
    private ProformatmereRepository proformatmereRepository;

    // Méthode pour enregistrer un Proformat
    public Proformatmere saveProformatmere(Proformatmere proformatmere) {
        return proformatmereRepository.save(proformatmere);
    }

    // Méthode pour récupérer tous les Proformatmeres
    public List<Proformatmere> getAllProformatmeres() {
        return proformatmereRepository.findAll();
    }

    // Méthode pour récupérer un Proformatmere par son ID
    public Optional<Proformatmere> getProformatmereById(int id) {
        return proformatmereRepository.findById(id);
    }

    // Méthode pour supprimer un Proformatmere par son ID
    public void deleteProformatmere(int id) {
        proformatmereRepository.deleteById(id);
    }
}
