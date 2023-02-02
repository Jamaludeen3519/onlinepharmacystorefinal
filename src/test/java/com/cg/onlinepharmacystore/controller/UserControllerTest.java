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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinepharmacystore.entity.Admin;
import com.cg.onlinepharmacystore.entity.Order;
import com.cg.onlinepharmacystore.entity.Products;
import com.cg.onlinepharmacystore.entity.User;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;
import com.cg.onlinepharmacystore.service.IProductService;
import com.cg.onlinepharmacystore.service.IUserService;
import com.cg.onlinepharmacystore.service.UserServiceImpl;
import com.cg.onlinepharmacystore.service.IAdminService;
import com.cg.onlinepharmacystore.service.IDiscussionBoardService;
import com.cg.onlinepharmacystore.service.IOrderDetailsService;
import com.cg.onlinepharmacystore.service.IOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class UserControllerTest {
	
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
	
//	@MockBean
//	private UserServiceImpl userServiceImpl;

	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private User user;

	@BeforeEach
	public void init() {
		user = new User(" name", "userName", " password", 20, "gender", "address",
				"prescription", "mNumber","email");
	
	}
	@Test
	public void testgetAllUsers() {
		List<User> orderList = new ArrayList<User>();
		orderList.add(user);
		when(userService.getUserList()).thenReturn(orderList);
	}
	@Test
	public void testgetUserById() throws ResourceNotFoundException {	
		when(userService.getUserById(anyLong())).thenReturn(ResponseEntity.ok().body(us));
	}
	@Test
	public void testgetUserByUsername() throws ResourceNotFoundException {	
		when(userService.getUserByUsernameAndEmail(anyString(),anyString())).thenReturn(ResponseEntity.ok().body(us));
	}

	

}