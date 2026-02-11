package com.esprit.microservice.jobservice.service;

import com.esprit.microservice.jobservice.entity.Job;
import com.esprit.microservice.jobservice.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Ajouter un job
    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    // Récupérer tous les jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Récupérer un job par ID
    public Job getJobById(Integer id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job introuvable avec l'ID: " + id));
    }

    // Modifier un job
    public Job updateJob(Integer id, Job job) {
        Job existingJob = getJobById(id);
        existingJob.setTitre(job.getTitre());
        existingJob.setDescription(job.getDescription());
        existingJob.setEntreprise(job.getEntreprise());
        existingJob.setLocalisation(job.getLocalisation());
        existingJob.setSalaire(job.getSalaire());
        return jobRepository.save(existingJob);
    }

    // Supprimer un job
    public void deleteJob(Integer id) {
        jobRepository.deleteById(id);
    }
}
