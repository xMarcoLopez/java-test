package com.accenture.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.accenture.test.model.CustomerDTO;
//import com.accenture.test.model.ProductDTO;
import com.accenture.test.service.ShoppingCartService;

@RestController
@RequestMapping("/v1/shopping-cart")
public class ShoppingCartRestController {

	@Autowired
	ShoppingCartService shoppingCartService;

//	@GetMapping
//	public ProductDTO addProduct(ProductDTO product) {
//		return product;
//	}
//
//	@PostMapping
//	public CustomerDTO addProductsList(@RequestBody CustomerDTO customer) {
//		return customer;
//	}
//
//	@DeleteMapping
//	public ProductDTO removeProduct(ProductDTO product) {
//		return product;
//	}
}
