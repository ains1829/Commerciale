package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.commerciale.Models.Proformat;
import com.example.commerciale.repository.ProformatRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ProformatService {

    @Autowired
    private ProformatRepository proformatRepository;

    // Méthode pour enregistrer un Proformat
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Proformat saveProformat(Proformat proformat) {
        return proformatRepository.save(proformat);
    }

    // Méthode pour récupérer tous les Proformats
    public List<Proformat> getAllProformats() {
        return proformatRepository.findAll();
    }
    public List<Proformat> getAllProformatsById_proformatmere(int id_proformatmere){
        return proformatRepository.findByProformatMereId(id_proformatmere);
    }

    // Méthode pour récupérer un Proformat par son ID
    public Optional<Proformat> getProformatById(int id) {
        return proformatRepository.findById(id);
    }

    // Méthode pour supprimer un Proformat par son ID
    public void deleteProformat(int id) {
        proformatRepository.deleteById(id);
    }
}
