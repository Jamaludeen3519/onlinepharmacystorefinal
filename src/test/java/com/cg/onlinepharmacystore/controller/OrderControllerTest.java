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
import com.cg.onlinepharmacystore.entity.Order;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;
import com.cg.onlinepharmacystore.service.IProductService;
import com.cg.onlinepharmacystore.service.IUserService;
import com.cg.onlinepharmacystore.service.IAdminService;
import com.cg.onlinepharmacystore.service.IDiscussionBoardService;
import com.cg.onlinepharmacystore.service.IOrderDetailsService;
import com.cg.onlinepharmacystore.service.IOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class OrderControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IProductService productService;
	
	@MockBean
	private IOrderService orderService;
		
	@MockBean
	private IAdminService adminService;
	
	@MockBean
	private IDiscussionBoardService DBService;
	
	@MockBean
	private IOrderDetailsService orderDetailService;
	
	@MockBean
	private IUserService userService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Order order;
	private Order order1;
	@BeforeEach
	public void init() {
		order = new Order("10", 6L, 40.00,"Delivered","20-10-2022");
		order1= new Order("20", 2L, 60.00,"Delivered", "12Jan2024");
	
	}
	
	@Test
	public void testSaveOrder() throws Exception{
		when(orderService.saveOrder((Order) any(Order.class))).thenReturn(order);
	}
	
	@Test
	public void testgetAllOrder() {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(order);
		orderList.add(order1);
		when(orderService.getAllOrders()).thenReturn(orderList);
	}
	
	@Test
	public void testgetOrderById() throws ResourceNotFoundException {	
		when(orderService.getOrderById(anyString())).thenReturn(ResponseEntity.ok().body(order));
	}
	


}