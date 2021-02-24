package com.accenture.test.model;

import java.util.Date;

public class InvoiceDTO {

	private Integer id;
	private Date createdDate;
	private double totalProducts;
	private double iva;
	private double deliveryPrice;
	private ShoppingCartDTO shoppingCart;

	public InvoiceDTO() {
	}

	public InvoiceDTO(Integer id, Date createdDate, double totalProducts, double iva, double deliveryPrice,
			ShoppingCartDTO shoppingCart) {
		this.id = id;
		this.createdDate = createdDate;
		this.totalProducts = totalProducts;
		this.iva = iva;
		this.deliveryPrice = deliveryPrice;
		this.shoppingCart = shoppingCart;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public double getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(double totalProducts) {
		this.totalProducts = totalProducts;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public ShoppingCartDTO getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCartDTO shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}
