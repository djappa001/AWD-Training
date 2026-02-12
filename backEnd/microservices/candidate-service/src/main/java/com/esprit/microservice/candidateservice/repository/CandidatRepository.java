package com.esprit.microservice.candidateservice.repository;

import com.esprit.microservice.candidateservice.entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Integer> {
}
