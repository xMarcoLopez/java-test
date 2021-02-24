package com.accenture.test.utils;

import java.util.ArrayList;
import java.util.List;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.ProductDTO;


public class Utils {

	public static final List<CustomerDTO> customers = generateCustomers();
	public static final List<ProductDTO> products = generateProducts();

	public static List<CustomerDTO> generateCustomers(){
		List <CustomerDTO> customers = new ArrayList<CustomerDTO>();
		customers.add(new CustomerDTO("1245789654", "Tony Stark", "New York"));
		customers.add(new CustomerDTO("7894578601", "Peter Parker", "New York"));
		customers.add(new CustomerDTO("4569871095", "Bruce Banner", "Australia"));
		customers.add(new CustomerDTO("0472847315", "Steve Rogers", "Manhattan"));
		return customers;
	}
	
	public static List<ProductDTO> generateProducts(){
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		return products;
	}
}
