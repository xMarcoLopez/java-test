package com.accenture.test.model;

import java.util.List;

public class ShoppingCartDTO {
	
	private Integer id;
	private CustomerDTO customer;
	private List<ProductDTO> products;
			
	public ShoppingCartDTO() {}
	
	public ShoppingCartDTO(List<ProductDTO> products) {
		this.products = products;
	}
	
	public ShoppingCartDTO(Integer id, List<ProductDTO> products, CustomerDTO customer) {
		this.id = id;
		this.products = products;
		this.customer = customer;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<ProductDTO> getProducts() {
		return products;
	}
	
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
}
