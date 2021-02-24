package com.accenture.test.model;

public class CustomerDTO {

	private String id;
	private String fullName;
	private String address;
	private ShoppingCartDTO shoppingCart;
	
	public CustomerDTO() {}
	
	public CustomerDTO(String id, String address, ShoppingCartDTO shoppingCart) {
		this.id = id;
		this.address = address;
		this.shoppingCart = shoppingCart;
	}
	
	public CustomerDTO(String id, String fullName, String address) {
		this.id = id;
		this.fullName = fullName;
		this.address = address;
	}
	
	public CustomerDTO(String id, String fullName, String address, ShoppingCartDTO shoppingCart) {
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.shoppingCart = shoppingCart;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public ShoppingCartDTO getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCartDTO shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
		
}
