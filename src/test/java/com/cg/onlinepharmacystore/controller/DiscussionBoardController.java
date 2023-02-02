package com.cg.onlinepharmacystore.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.onlinepharmacystore.entity.DiscussionBoard;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;
import com.cg.onlinepharmacystore.service.IAdminService;
import com.cg.onlinepharmacystore.service.IDiscussionBoardService;
import com.cg.onlinepharmacystore.service.IOrderDetailsService;
import com.cg.onlinepharmacystore.service.IOrderService;
import com.cg.onlinepharmacystore.service.IProductService;
import com.cg.onlinepharmacystore.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DiscussionBoardController {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IProductService productService;
	
	@MockBean
	private IAdminService adminService;
	
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
	
	
	private DiscussionBoard discussionboard;
	private DiscussionBoard discussionboard1;
	@BeforeEach
	public void init() {
		discussionboard = new DiscussionBoard(1L, "santhi", "santhi@gmail.com", "hi");
		discussionboard1 = new DiscussionBoard(2L, "siri", "siri@gmail.com", "hello");
	
	}
	
	@Test
	public void testAddMessage() throws Exception{
		when(DBService.addMessage((DiscussionBoard) any(DiscussionBoard.class))).thenReturn(discussionboard1);
	}
	
	@Test
	public void testgetDiscussionBoardById() throws ResourceNotFoundException {	
		when(DBService.getDiscussionBoardById(anyLong())).thenReturn(ResponseEntity.ok().body(discussionboard1));
	}
	@Test
	public void testgetDiscussionBoardByEmail() throws ResourceNotFoundException {	
		when(DBService.getDiscussionBoardByUserEmail(anyString())).thenReturn(ResponseEntity.ok().body(discussionboard1));
	}


}
