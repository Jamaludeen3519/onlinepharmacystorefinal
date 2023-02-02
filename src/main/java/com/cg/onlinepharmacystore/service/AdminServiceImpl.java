package com.cg.onlinepharmacystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlinepharmacystore.entity.Admin;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;
import com.cg.onlinepharmacystore.repository.AdminRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	AdminRepository admininRepo;

	@Override
	public ResponseEntity<Admin> getAdminById(Long adminId) throws ResourceNotFoundException {
		Admin admin = admininRepo.findById(adminId)
		          .orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));
		        return ResponseEntity.ok().body(admin);
	}

	@Override
	public ResponseEntity<Admin> getAdminByEmail( String email)throws ResourceNotFoundException {
		Admin admin = admininRepo.findByEmail(email)
		          .orElseThrow(() -> new ResourceNotFoundException("Admin not found " ));
		        return ResponseEntity.ok().body(admin);
	}

	@Override
	public ResponseEntity<Admin> updateAdmin(Long adminId, Admin adminDetails) throws ResourceNotFoundException {
		Admin admin = admininRepo.findById(adminId)
			        .orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));

					admin.setEmail(adminDetails.getEmail());
					admin.setAdminName(adminDetails.getAdminName());
					admin.setPassword(adminDetails.getPassword());
			        
			        final Admin updatedAdmin = admininRepo.save(admin);
			        return ResponseEntity.ok(updatedAdmin);
	}
}
