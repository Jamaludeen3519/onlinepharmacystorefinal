package com.cg.onlinepharmacystore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.cg.onlinepharmacystore.entity.DiscussionBoard;
import com.cg.onlinepharmacystore.entity.User;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;

@Repository
public interface DiscussionBoardRepository extends JpaRepository<DiscussionBoard, Long>{

	public Optional<DiscussionBoard> findByUserEmail(String email);
	

}
