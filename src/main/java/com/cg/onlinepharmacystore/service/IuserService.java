package com.cg.onlinepharmacystore.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlinepharmacystore.entity.User;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;

public interface IUserService {

	public User createUser(User user);
	public List<User> getUserList();
    public ResponseEntity<User> getUserById(Long userId) throws ResourceNotFoundException;
	public ResponseEntity<User> getUserByUsernameAndEmail(String username, String email) throws ResourceNotFoundException;
    public ResponseEntity<User> updateUser(User userDetails,Long userId) throws ResourceNotFoundException;

}
