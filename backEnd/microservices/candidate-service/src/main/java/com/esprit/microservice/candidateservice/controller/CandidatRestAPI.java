package com.esprit.microservice.candidateservice.controller;

import com.esprit.microservice.candidateservice.entity.Candidat;
import com.esprit.microservice.candidateservice.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidats")
public class CandidatRestAPI {

    @Autowired
    private CandidatService candidatService;

    // POST - Créer un candidat
    @PostMapping
    public ResponseEntity<Candidat> create(@RequestBody Candidat candidat) {
        Candidat savedCandidat = candidatService.addCandidat(candidat);
        return new ResponseEntity<>(savedCandidat, HttpStatus.CREATED);
    }

    // GET - Récupérer tous les candidats
    @GetMapping
    public ResponseEntity<List<Candidat>> getAll() {
        List<Candidat> candidats = candidatService.getAllCandidats();
        return new ResponseEntity<>(candidats, HttpStatus.OK);
    }

    // GET - Récupérer un candidat par ID
    @GetMapping("/{id}")
    public ResponseEntity<Candidat> getById(@PathVariable Integer id) {
        Candidat candidat = candidatService.getCandidatById(id);
        return new ResponseEntity<>(candidat, HttpStatus.OK);
    }

    // PUT - Modifier un candidat
    @PutMapping("/{id}")
    public ResponseEntity<Candidat> update(@PathVariable Integer id, @RequestBody Candidat candidat) {
        Candidat updatedCandidat = candidatService.updateCandidat(id, candidat);
        return new ResponseEntity<>(updatedCandidat, HttpStatus.OK);
    }

    // DELETE - Supprimer un candidat
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        candidatService.deleteCandidat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
