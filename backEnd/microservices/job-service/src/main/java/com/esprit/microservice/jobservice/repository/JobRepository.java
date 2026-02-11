package com.esprit.microservice.jobservice.repository;

import com.esprit.microservice.jobservice.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
}
