package com.accenture.test.model;

import java.util.List;

public class ShoppingCartDTO {
	
	private Integer id;
	private List<ProductDTO> products;
		
	public ShoppingCartDTO() {}
	
	public ShoppingCartDTO(Integer id, List<ProductDTO> products) {
		this.id = id;
		this.products = products;
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
}
