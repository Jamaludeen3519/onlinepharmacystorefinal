package com.cg.onlinepharmacystore.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlinepharmacystore.entity.DiscussionBoard;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;

public interface IDiscussionBoardService {


    public ResponseEntity<DiscussionBoard> getDiscussionBoardById(Long discussionId)throws ResourceNotFoundException;
	public ResponseEntity<DiscussionBoard> getDiscussionBoardByUserEmail(String userEmail)throws ResourceNotFoundException;
    public ResponseEntity<DiscussionBoard> updateDiscussionBoard(Long discussionId,DiscussionBoard discussionboardDetails)throws ResourceNotFoundException;
    public DiscussionBoard addMessage(DiscussionBoard DB);
}
