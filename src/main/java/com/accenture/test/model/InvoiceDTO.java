package com.accenture.test.model;

import java.util.Date;

public class InvoiceDTO {

	private Integer id;
	private Date createdDate;
	private float totalProducts;
	private float iva;
	private float deliveryPrice;
	private ShoppingCartDTO shoppingCart;

	public InvoiceDTO() {
	}

	public InvoiceDTO(Integer id, Date createdDate, float totalProducts, float iva, float deliveryPrice,
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

	public float getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(float totalProducts) {
		this.totalProducts = totalProducts;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public float getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(float deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public ShoppingCartDTO getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCartDTO shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}
