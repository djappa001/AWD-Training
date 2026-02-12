package com.esprit.microservice.candidateservice.service;

import com.esprit.microservice.candidateservice.entity.Candidat;
import com.esprit.microservice.candidateservice.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    // Ajouter un candidat
    public Candidat addCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    // Récupérer tous les candidats
    public List<Candidat> getAllCandidats() {
        return candidatRepository.findAll();
    }

    // Récupérer un candidat par ID
    public Candidat getCandidatById(Integer id) {
        return candidatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidat introuvable avec l'ID: " + id));
    }

    // Modifier un candidat
    public Candidat updateCandidat(Integer id, Candidat candidat) {
        Candidat existingCandidat = getCandidatById(id);
        existingCandidat.setNom(candidat.getNom());
        existingCandidat.setPrenom(candidat.getPrenom());
        existingCandidat.setEmail(candidat.getEmail());
        return candidatRepository.save(existingCandidat);
    }

    // Supprimer un candidat
    public void deleteCandidat(Integer id) {
        candidatRepository.deleteById(id);
    }
}
