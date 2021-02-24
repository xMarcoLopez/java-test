package com.accenture.test.model;

public class ProductDTO {

	private String id;
	private String name;
	private double price;
	private int amount;
	private double totalPriceProduct;
	
	public ProductDTO() {}
	
	public ProductDTO(String id) {
		this.id = id;
	}
	
	public ProductDTO(String id, double price, int amount) {
		this.id = id;
		this.price = price;
		this.amount = amount;
	}
	
	public ProductDTO(String id, String name, double price, int amount) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getTotalPriceProduct() {
		return this.price*this.amount;
	}

	public void setTotalPriceProduct(double totalPriceProduct) {
		this.totalPriceProduct = totalPriceProduct;
	}
	
}
