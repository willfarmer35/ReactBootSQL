package com.dojo.belt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.belt.model.Job;
import com.dojo.belt.repos.JobRepo;


import jakarta.validation.Valid;

@Service
public class JobService {
private final JobRepo jobRepo;
	
	public JobService(JobRepo jobRepo) {
		this.jobRepo=jobRepo;
	}

	public Job createJob(@Valid Job newJob) {
		return jobRepo.save(newJob);
		
	}
	public Job updateJob(@Valid Job newJob) {
		return jobRepo.save(newJob);
		
		
	}

	public List<Job> findAll() {
		return jobRepo.findAll();
	}

	public Job findJobById(Long id) {
		Optional<Job> job = jobRepo.findById(id);
		
		if(job.isPresent()) {
			return job.get();
		}else {
			return null;
		}
	}

	public List<Job> findJobfeeLessThan(double fee) {
		return jobRepo.findByFeeLessThan(fee);
	}

	public void deleteJob(Long id) {
		jobRepo.deleteById(id);
		
	}
}
