package com.dojo.belt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.belt.model.User;
import com.dojo.belt.services.JobService;
import com.dojo.belt.services.UserService;


@RestController 
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	
	private UserService userService;
	
	private JobService jobService;
	
	public UserController(UserService userService, JobService jobService) {
		this.userService = userService;
		this.jobService = jobService;
	}
	
	@PostMapping("/add")
	public User saveUserWithJob(@RequestBody User user) {
		return userService.createUser(user);
		
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUser() {
		return userService.findAll();
		
	}
	
	@GetMapping("/{id}")
	public User findUser (@PathVariable Long id) {
		
		return userService.findUserById(id);
		
	}
	@PutMapping("/{id}/process")
	public User editUser (@PathVariable Long id,@RequestBody User userDetails) {
		User updateUser = userService.findUserById(id);
		updateUser.setAddress(userDetails.getAddress());
		updateUser.setPhone(userDetails.getPhone());
		updateUser.setEmail(userDetails.getEmail());
		updateUser.setName(userDetails.getName());
		updateUser.setJobs(userDetails.getJobs());
		
		return userService.updateUser(updateUser);
		
	}
	
	@GetMapping("/find/{name}")
	public List <User> findUsersContainingByName (@PathVariable String name) {
		return  userService.findUserbyName(name);
		
	}

	
}
