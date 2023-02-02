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

import com.cg.onlinepharmacystore.entity.Order;
import com.cg.onlinepharmacystore.entity.OrderDetails;
import com.cg.onlinepharmacystore.entity.Products;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;
import com.cg.onlinepharmacystore.service.IAdminService;
import com.cg.onlinepharmacystore.service.IDiscussionBoardService;
import com.cg.onlinepharmacystore.service.IOrderDetailsService;
import com.cg.onlinepharmacystore.service.IOrderService;
import com.cg.onlinepharmacystore.service.IProductService;
import com.cg.onlinepharmacystore.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class OrderDetailsController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IOrderDetailsService orderdetailsService;
	
	@MockBean
	private IAdminService adminService;
	

	@MockBean
	private IProductService productService;
	
	
	@MockBean
	private IDiscussionBoardService DBService;
	
	@MockBean
	private IOrderService orderService;
	
	
	@MockBean
	private IUserService userService;

	
	@Autowired
	private ObjectMapper objectMapper;
	
	private OrderDetails orderdetails;
	private OrderDetails orderdetails1;
	@BeforeEach
	public void init() {
		orderdetails= new OrderDetails( 10L,"vasline", 60.00, 2L, 60.00, 1L,"Delivered");
		orderdetails1 = new OrderDetails (20L,"Crocine", 20.00, 2L, 60.00, 1L,"Delivered");
		
	
	}
	
	@Test
	public void testgetOrderDetails() throws Exception{
		when(orderdetailsService.getAllOrderDetailsByOrderId(anyString())).thenReturn(List<OrderDetails> orderdetails);
	}
	
//	@Test
//	public void testgetAllOrderDetails() {
//		List<OrderDetails> orderdetailsList = new ArrayList<OrderDetails>();
//		orderdetailsList.add(orderdetails);
//		orderdetailsList.add(orderdetails1);
//		when(orderdetailsService.orderDetails ((OrderDetails) any(OrderDetails.class))).thenReturn(orderdetailsList);
//	}
	
//	@Test
//	public void testgetOrderDetailsByAdminId() throws ResourceNotFoundException {	
//		when(orderdetailsService.getOrderDetailsByAdminId(anyLong())).thenReturn(orderdetails);
//	}

}