package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.commerciale.models.ProformatMi;
import com.example.commerciale.repository.ProformatMiRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ProformatMiService {

    @Autowired
    private ProformatMiRepository proformatRepository;

    // Méthode pour enregistrer un Proformat
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public ProformatMi saveProformat(ProformatMi proformat) {
        return proformatRepository.save(proformat);
    }

    // Méthode pour récupérer tous les Proformats
    public List<ProformatMi> getAllProformats() {
        return proformatRepository.findAll();
    }
    public List<ProformatMi> getAllProformatsById_proformatmere(int id_proformatmere){
        return proformatRepository.findByProformatMereId(id_proformatmere);
    }

    // Méthode pour récupérer un Proformat par son ID
    public Optional<ProformatMi> getProformatById(int id) {
        return proformatRepository.findById(id);
    }

    // Méthode pour supprimer un Proformat par son ID
    public void deleteProformat(int id) {
        proformatRepository.deleteById(id);
    }
}
