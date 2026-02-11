package com.esprit.microservice.jobservice.controller;

import com.esprit.microservice.jobservice.entity.Job;
import com.esprit.microservice.jobservice.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobRestAPI {

    @Autowired
    private JobService jobService;

    // POST - Créer un job
    @PostMapping
    public ResponseEntity<Job> create(@RequestBody Job job) {
        Job savedJob = jobService.addJob(job);
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    // GET - Récupérer tous les jobs
    @GetMapping
    public ResponseEntity<List<Job>> getAll() {
        List<Job> jobs = jobService.getAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    // GET - Récupérer un job par ID
    @GetMapping("/{id}")
    public ResponseEntity<Job> getById(@PathVariable Integer id) {
        Job job = jobService.getJobById(id);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    // PUT - Modifier un job
    @PutMapping("/{id}")
    public ResponseEntity<Job> update(@PathVariable Integer id, @RequestBody Job job) {
        Job updatedJob = jobService.updateJob(id, job);
        return new ResponseEntity<>(updatedJob, HttpStatus.OK);
    }

    // DELETE - Supprimer un job
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        jobService.deleteJob(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
