package com.accenture.test.model;

import java.util.Date;

public class InvoiceDTO {

	private Integer id;
	private Date createdDate;
	private String id_customer;
	private String shipAddress;
	private double subtotal;
	private double iva;
	private double shipPrice;
	private double total;
	private String status;
	private ShoppingCartDTO shoppingCart;

	public InvoiceDTO() {
	}
	
	public InvoiceDTO(Integer id) {
		this.id = id;
	}

	public InvoiceDTO(String id_customer, String shipAddress, double subtotal, double iva, Date createdDate,
			String status, ShoppingCartDTO shoppingCart) {
		this.id_customer = id_customer;
		this.shipAddress = shipAddress;
		this.subtotal = subtotal;
		this.iva = iva;
		this.createdDate = createdDate;
		this.status = status;
		this.shoppingCart = shoppingCart;
	}
	
	public InvoiceDTO(Integer id, Date createdDate, String id_customer, String shipAddress, double subtotal,
			double iva, double shipPrice, ShoppingCartDTO shoppingCart) {
		this.id = id;
		this.createdDate = createdDate;
		this.id_customer = id_customer;
		this.shipAddress = shipAddress;
		this.subtotal = subtotal;
		this.iva = iva;
		this.shipPrice = shipPrice;
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

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
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
	
	public void calculateTotal() {
		this.total = this.subtotal + this.iva + this.shipPrice;
	}

	public double getShipPrice() {
		return shipPrice;
	}

	public void setShipPrice(double shipPrice) {
		this.shipPrice = shipPrice;
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
