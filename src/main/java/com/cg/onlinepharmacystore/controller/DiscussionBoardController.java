package com.cg.onlinepharmacystore.controller;

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

import com.cg.onlinepharmacystore.entity.DiscussionBoard;
import com.cg.onlinepharmacystore.entity.User;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;
import com.cg.onlinepharmacystore.service.IDiscussionBoardService;


@RestController 
@RequestMapping("/api/v1")
public class DiscussionBoardController {
	
	@Autowired
	private IDiscussionBoardService discsussionBoardService;

	// Add Message to discussion board
	@PostMapping("/discussion")
	public DiscussionBoard addMessage(@Valid @RequestBody DiscussionBoard DB){
		return discsussionBoardService.addMessage(DB);
	}
	
	//Get discussionBoard by id
	@GetMapping("/discussion/{id}")
    public ResponseEntity<DiscussionBoard> getDiscussionBoardById(@PathVariable(value = "id") Long discussionId)
        throws ResourceNotFoundException {
		return discsussionBoardService.getDiscussionBoardById(discussionId);
	}
	
	//Get discussionboard by username and email
	@GetMapping("/user/{email}")
	public ResponseEntity<DiscussionBoard> getDiscussionBoardByEmail(@PathVariable(value = "email") String userEmail) throws ResourceNotFoundException {
		return discsussionBoardService.getDiscussionBoardByUserEmail( userEmail);
		}
	
	//update disscuion board 
	@PutMapping("/user/{id}")
    public ResponseEntity<DiscussionBoard> updateDiscussionBoard(@PathVariable(value = "id") Long discussionId,
         @Valid @RequestBody DiscussionBoard discussionboardDetails) throws ResourceNotFoundException {
		return discsussionBoardService.updateDiscussionBoard(discussionId, discussionboardDetails);
    }
	
}
