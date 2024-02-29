package com.dojo.belt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.belt.model.Job;
import com.dojo.belt.model.User;
import com.dojo.belt.services.JobService;
import com.dojo.belt.services.UserService;
@RestController 
@RequestMapping("/job")
@CrossOrigin
public class JobController {

	private UserService userService;
	
	private JobService jobService;
	
	public JobController(UserService userService, JobService jobService) {
		this.userService = userService;
		this.jobService = jobService;
	}
	
	@PostMapping("/add")
	public User saveUserWithJob(@RequestBody User user) {
		return userService.createUser(user);
		
	}
	
	@GetMapping("/getAll")
	public List<Job> getAllJob() {
		return jobService.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Job findJob (@PathVariable Long id) {
		
		return jobService.findJobById(id);
		
	}
	/*@PutMapping("/{id}/process")
	public Job editJob (@PathVariable Long id,@RequestBody Job jobDetails) {
		Job updateJob = userService.findUserById(id);
		updateJob.setAddress(userDetails.getAddress());
		updateUser.setPhone(userDetails.getPhone());
		updateUser.setEmail(userDetails.getEmail());
		updateUser.setName(userDetails.getName());
		updateUser.setJobs(userDetails.getJobs());
		
		return userService.updateUser(updateUser);
		
	}*/
	
	@GetMapping("/find/{fee}")
	public List <Job> findUsersContainingByName (@PathVariable double fee) {
		return  jobService.findJobfeeLessThan(fee);
		
	
	}
}
