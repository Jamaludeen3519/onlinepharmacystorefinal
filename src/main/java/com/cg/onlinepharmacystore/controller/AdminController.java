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

import com.cg.onlinepharmacystore.entity.Admin;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;
import com.cg.onlinepharmacystore.service.IAdminService;


@RestController 
@RequestMapping("/api/v1")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;

	
	//Get Admin by id
	@GetMapping("/admin/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable(value = "id") Long adminId)
        throws ResourceNotFoundException {
		return adminService.getAdminById(adminId);
	}
	
	//Get Admin by username and email
	@GetMapping("/getadmin/{email}")
	public ResponseEntity<Admin> getAdminByEmail(@PathVariable(value = "email") String email) throws ResourceNotFoundException {
		return adminService.getAdminByEmail( email);
		}
	
	//update Admin
	@PutMapping("/admin/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable(value = "id") Long adminId,
         @Valid @RequestBody Admin adminDetails) throws ResourceNotFoundException {
		return adminService.updateAdmin(adminId, adminDetails);
    }
	
}
