package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.commerciale.Models.Proformatmere;
import com.example.commerciale.repository.ProformatmereRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProformatmereService {

    @Autowired
    private ProformatmereRepository proformatmereRepository;

    // Méthode pour enregistrer un Proformat
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Proformatmere saveProformatmere(Proformatmere proformatmere) {
        return proformatmereRepository.save(proformatmere);
    }

    // Méthode pour récupérer tous les Proformatmeres
    public List<Proformatmere> getAllProformatmeres() {
        return proformatmereRepository.findAll();
    }
    public List<Proformatmere> findProformatmereByDateproformat( Date dateproformat) {
        return proformatmereRepository.findByDateproformat(dateproformat);
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
