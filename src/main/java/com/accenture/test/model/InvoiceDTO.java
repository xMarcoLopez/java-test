package com.accenture.test.model;

import java.util.Date;

public class InvoiceDTO {

	private Integer id;
	private Date createdDate;
	private String id_customer;
	private String deliveryAddress;
	private double subtotal;
	private double iva;
	private double deliveryPrice;
	private double total;
	private String status;
	private ShoppingCartDTO shoppingCart;

	public InvoiceDTO() {
	}
	
	public InvoiceDTO(Integer id) {
		this.id = id;
	}	

	public InvoiceDTO(Integer id, Date createdDate, String id_customer, String deliveryAddress, double subtotal,
			double iva, double deliveryPrice, ShoppingCartDTO shoppingCart) {
		this.id = id;
		this.createdDate = createdDate;
		this.id_customer = id_customer;
		this.deliveryAddress = deliveryAddress;
		this.subtotal = subtotal;
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

	public String getId_customer() {
		return id_customer;
	}

	public void setId_customer(String id_customer) {
		this.id_customer = id_customer;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ShoppingCartDTO getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCartDTO shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}
