package com.cg.onlinepharmacystore.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.*;

import com.cg.onlinepharmacystore.entity.Admin;
import com.cg.onlinepharmacystore.entity.Order;
import com.cg.onlinepharmacystore.entity.Products;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;
import com.cg.onlinepharmacystore.service.IProductService;
import com.cg.onlinepharmacystore.service.IUserService;
import com.cg.onlinepharmacystore.service.IAdminService;
import com.cg.onlinepharmacystore.service.IDiscussionBoardService;
import com.cg.onlinepharmacystore.service.IOrderDetailsService;
import com.cg.onlinepharmacystore.service.IOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class AdminControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IAdminService adminService;
	

	@MockBean
	private IProductService productService;
	
	
	@MockBean
	private IDiscussionBoardService DBService;
	
	@MockBean
	private IOrderService orderService;
	
	@MockBean
	private IOrderDetailsService orderDetailService;
	
	@MockBean
	private IUserService userService;

	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Admin admin;

	@BeforeEach
	public void init() {
		admin = new Admin(1L, "Admin",  "admin@gmail.com","admin123");
	
	}
			
	@Test
	public void testgetAdminById() throws ResourceNotFoundException {	
		when(adminService.getAdminById(anyLong())).thenReturn(ResponseEntity.ok().body(admin));
	}
	
	@Test
	public void testgetAdminByEmail() throws ResourceNotFoundException {	
		when(adminService.getAdminByEmail((String) any(String.class))).thenReturn(ResponseEntity.ok().body(admin));
	}
	

}