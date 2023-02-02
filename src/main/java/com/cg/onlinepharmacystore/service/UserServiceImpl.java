package com.cg.onlinepharmacystore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlinepharmacystore.repository.UserRepository;
import com.cg.onlinepharmacystore.entity.User;
import com.cg.onlinepharmacystore.entity.User;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User createUser(User user){
		return userRepo.save(user);
	}
	
	@Override
	public List<User> getUserList() {
		return userRepo.findAll();
	}
	
	@Override
    public ResponseEntity<User> getUserById(Long userId) throws ResourceNotFoundException{
    	User us = userRepo.findByUserId(userId)
		          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		        return ResponseEntity.ok().body(us);
    }
    @Override
	public ResponseEntity<User> getUserByUsernameAndEmail(String userName, String email) throws ResourceNotFoundException{
		User us = userRepo.findByUserNameOrEmail(userName, email)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this Username:: " + userName));
		        return ResponseEntity.ok().body(us);
	}
	@Override
    public ResponseEntity<User> updateUser(User userDetails,Long UserId) throws ResourceNotFoundException{
    
  		  User user = userRepo.findById(UserId)
  			        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + UserId));

		        
  		user.setName(userDetails.getName());
  		user.setAge(userDetails.getAge());
  		user.setGender(userDetails.getGender());
  		user.setAddress(userDetails.getAddress());
  		user.setUserName(userDetails.getUserName());
  		user.setPassword(userDetails.getPassword());
  		user.setmNumber(userDetails.getmNumber());
  		user.setPrescription(userDetails.getPrescription());
  		user.setEmail(userDetails.getEmail());
		        
		        User updatedUser = userRepo.save(user);
		        return ResponseEntity.ok(updatedUser);
    }

	
}


