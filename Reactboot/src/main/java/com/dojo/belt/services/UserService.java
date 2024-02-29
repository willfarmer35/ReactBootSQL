package com.dojo.belt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.belt.model.User;
import com.dojo.belt.repos.UserRepo;

import jakarta.validation.Valid;
@Service
public class UserService {
private final UserRepo userRepo;
	
	public UserService(UserRepo userRepo) {
		this.userRepo=userRepo;
	}

	public User createUser(@Valid User newuser) {
		return userRepo.save(newuser);
		
	}
	public User updateUser(@Valid User newuser) {
		return userRepo.save(newuser);
		
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findUserById(Long id) {
		Optional<User> user = userRepo.findById(id);
		
		if(user.isPresent()) {
			return user.get();
		}else {
			return null;
		}
	}

	public List<User> findUserbyName(String name) {
		return userRepo.findByNameContaining(name);
	}

	public void deleteUser(Long id) {
		userRepo.deleteById(id);
		
	}

	


}
