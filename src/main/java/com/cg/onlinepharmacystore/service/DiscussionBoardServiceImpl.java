package com.cg.onlinepharmacystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlinepharmacystore.entity.DiscussionBoard;
import com.cg.onlinepharmacystore.entity.User;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;
import com.cg.onlinepharmacystore.repository.DiscussionBoardRepository;

@Service
public class DiscussionBoardServiceImpl implements IDiscussionBoardService {

	@Autowired
	DiscussionBoardRepository discussionRepo;


	@Override
	public ResponseEntity<DiscussionBoard> getDiscussionBoardById(Long discussionId) throws ResourceNotFoundException {
		DiscussionBoard discussionboard = discussionRepo.findById(discussionId)
		          .orElseThrow(() -> new ResourceNotFoundException("Discussion not found for this id :: " + discussionId));
		        return ResponseEntity.ok().body(discussionboard);
	
	}

	@Override
	public ResponseEntity<DiscussionBoard> getDiscussionBoardByUserEmail(String userEmail) throws ResourceNotFoundException {
		DiscussionBoard discussionboard = discussionRepo.findByUserEmail(userEmail)
		          .orElseThrow(() -> new ResourceNotFoundException("DiscussionBoard not found " ));
		        return ResponseEntity.ok().body(discussionboard);
	}

	@Override
	public ResponseEntity<DiscussionBoard> updateDiscussionBoard(Long discussionId,
			DiscussionBoard discussionboardDetails) throws ResourceNotFoundException {
		DiscussionBoard discussionboard = discussionRepo.findById(discussionId)
		        .orElseThrow(() -> new ResourceNotFoundException("DiscussionBoard not found for this id :: " + discussionId));

				discussionboard.setUserEmail(discussionboardDetails.getUserEmail());
				discussionboard.setUserName(discussionboardDetails.getUserName());
				discussionboard.setMessage(discussionboardDetails.getMessage());
				
		        
		        final DiscussionBoard updatedDiscussionBoard = discussionRepo.save(discussionboard);
		        return ResponseEntity.ok(updatedDiscussionBoard);
	
	}
		
	
	@Override
	public DiscussionBoard addMessage(DiscussionBoard DB){
		return discussionRepo.save(DB);
	}
}
