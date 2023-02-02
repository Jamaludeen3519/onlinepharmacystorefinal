package com.cg.onlinepharmacystore.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepharmacystore.entity.User;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;
import com.cg.onlinepharmacystore.service.IUserService;



	@RestController 
	@RequestMapping("/api/v1")
	public class UserController {
		
		@Autowired
		private IUserService userService;
		
		//get all User
		@GetMapping("/User")
		public List<User> getUserList()
		{
			return userService.getUserList();
		}
		
		//add new User
		@PostMapping("/User")
		public User createUser(@Valid @RequestBody User user)
		{
			return userService.createUser(user);
		}

		//get a User by id
		@GetMapping("/User/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
	        throws ResourceNotFoundException {
			return userService.getUserById(userId);
	    }
		
		//get a User by username and email
		@GetMapping("/User/{username}/{email}")
		public ResponseEntity<User> getUserByUsernameAndEmail(@PathVariable(value = "username") String username,
				@PathVariable(value ="email") String email) throws ResourceNotFoundException {
			return userService.getUserByUsernameAndEmail(username,email);
		    }
		
		//update a User
		@PutMapping("/UserUpdate/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
	         @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
			return userService.updateUser(userDetails,userId);
	    }
		
	}
