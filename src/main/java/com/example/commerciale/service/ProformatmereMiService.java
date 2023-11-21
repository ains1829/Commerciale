package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.commerciale.Models.ProformatmereMi;
import com.example.commerciale.repository.ProformatmereMiRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProformatmereMiService {

    @Autowired
    private ProformatmereMiRepository proformatmereRepository;

    // Méthode pour enregistrer un Proformat
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public ProformatmereMi saveProformatmere(ProformatmereMi proformatmere) {
        return proformatmereRepository.save(proformatmere);
    }

    // Méthode pour récupérer tous les Proformatmeres
    public List<ProformatmereMi> getAllProformatmeres() {
        return proformatmereRepository.findAll();
    }
    public List<ProformatmereMi> findProformatmereByDateproformat( Date dateproformat) {
        return proformatmereRepository.findByDateproformat(dateproformat);
    }
    // Méthode pour récupérer un Proformatmere par son ID
    public Optional<ProformatmereMi> getProformatmereById(int id) {
        return proformatmereRepository.findById(id);
    }

    // Méthode pour supprimer un Proformatmere par son ID
    public void deleteProformatmere(int id) {
        proformatmereRepository.deleteById(id);
    }
}
