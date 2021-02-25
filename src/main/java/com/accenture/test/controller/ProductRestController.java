package com.accenture.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.test.model.ProductDTO;
import com.accenture.test.service.ProductService;

@RestController
@RequestMapping("/v1/product")
public class ProductRestController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<ProductDTO> getProducts(){
		return productService.getProducts();
	}
}
