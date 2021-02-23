package com.accenture.test.model;

import java.util.List;

public class ShoppingCart {
	
	private Integer id;
	private List<Product> products;
	private Customer id_customer;
		
	public ShoppingCart() {}
	
	public ShoppingCart(Integer id, List<Product> products, Customer id_customer) {
		this.id = id;
		this.products = products;
		this.id_customer = id_customer;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Customer getId_customer() {
		return id_customer;
	}
	
	public void setId_customer(Customer id_customer) {
		this.id_customer = id_customer;
	}
	
	
	
}
