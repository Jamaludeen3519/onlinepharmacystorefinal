package com.cg.onlinepharmacystore.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.*;
import com.cg.onlinepharmacystore.entity.Products;
import com.cg.onlinepharmacystore.exception.ResourceNotFoundException;
import com.cg.onlinepharmacystore.service.IProductService;
import com.cg.onlinepharmacystore.service.IAdminService;
import com.cg.onlinepharmacystore.service.IDiscussionBoardService;
import com.cg.onlinepharmacystore.service.IOrderService;
import com.cg.onlinepharmacystore.service.IOrderDetailsService;
import com.cg.onlinepharmacystore.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class ProductControllerTest {
	
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
	
	private Products product;
	private Products product1;
	@BeforeEach
	public void init() {
		product = new Products("vasline",  60, "20feb2020",  "20feb2024");
		product1= new Products("Crocine",  20, "20Aug2020",  "12Jan2024");
	
	}
	
	@Test
	public void testAddProduct() throws Exception{
		when(productService.addProduct((Products) any(Products.class))).thenReturn(product);
	}
	
	@Test
	public void testgetListAllProducts() {
		List<Products> productList = new ArrayList<Products>();
		productList.add(product);
		productList.add(product1);
		when(productService.getListAllProducts()).thenReturn(productList);
	}
	
	@Test
	public void testgetProductById() throws ResourceNotFoundException {	
		when(productService.getProductById(anyLong())).thenReturn(product);
	}

}