package com.cg.onlinepharmacystore.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.onlinepharmacystore.entity.User;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;
import com.cg.onlinepharmacystore.service.IUserService;

import com.cg.onlinepharmacystore.service.IProductService;
import com.cg.onlinepharmacystore.service.IAdminService;
import com.cg.onlinepharmacystore.service.IOrderService;
import com.cg.onlinepharmacystore.service.IOrderDetailsService;
import com.cg.onlinepharmacystore.service.IDiscussionBoardService;

import com.fasterxml.jackson.databind.ObjectMapper;
@WebMvcTest
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IUserService userService;
	@MockBean
	private IProductService productService;
	@MockBean
	private IAdminService adminService;
	
	@MockBean
	private IOrderService orderService;
	@MockBean
	private IOrderDetailsService orderDetailsService;
	@MockBean
	private IDiscussionBoardService discussionService;
	
	//@MockBean
	//private ICategoryService categoryService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private User us;
	private User us1;
	
	@BeforeEach
	public void init() {
		us = new User("dayawati","daya","dya321",22,"female","bikaner","for headache","6565453434", "dya@gmail.com");
		us1 = new User("rohan","rock","rock321",25,"male","patna","for allergy","6565453834", "rock@gmail.com");
		
	
	}
	
	
	
	@Test
	public void testgetUserById() throws ResourceNotFoundException {	
		when(userService.getUserById(anyLong())).thenReturn(ResponseEntity.ok().body(us));
	}
	@Test
	public void testgetUserByUsername() throws ResourceNotFoundException {	
		when(userService.getUserByUsernameAndEmail(anyString(),anyString())).thenReturn(ResponseEntity.ok().body(us));
	}
	
	@Test
	public void testgetAllUsers() {
		List<User> userList = new ArrayList<User>();
		userList.add(us);
		userList.add(us1);
		when(userService.getUserList()).thenReturn(userList);
	}

}


