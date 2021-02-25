package com.accenture.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.service.CustomerService;

@RestController
@RequestMapping("/v1/customer")
public class CustomerRestController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping
	public List<CustomerDTO> getProducts(){
		return customerService.getCustomers();
	}

}
