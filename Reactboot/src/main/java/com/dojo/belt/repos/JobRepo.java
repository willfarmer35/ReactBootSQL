package com.dojo.belt.repos;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dojo.belt.model.Job;


public interface JobRepo extends JpaRepository<Job,Long> {
	
	
	List<Job>findByFeeLessThan(double fee);
}
