package com.dojo.belt.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dojo.belt.model.User;

public interface UserRepo extends JpaRepository<User,Long> {
	
	 List <User>findByNameContaining(String name);

	List<User> findAll();
	
}
