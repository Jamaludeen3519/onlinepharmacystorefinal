package com.cg.onlinepharmacystore.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlinepharmacystore.entity.Admin;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;

public interface IAdminService {


    public ResponseEntity<Admin> getAdminById(Long adminId) throws ResourceNotFoundException;
	public ResponseEntity<Admin> getAdminByEmail(String email) throws ResourceNotFoundException;
    public ResponseEntity<Admin> updateAdmin(Long adminId,Admin adminDetails) throws ResourceNotFoundException;
    
	
}
