package com.accenture.test.model;

public class Product {

	private Integer id;
	private String name;
	private float price;
	private int amount;
	
	public Product() {}
	
	public Product(Integer id, String name, float price, int amount) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
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
	
}
