package com.accenture.test.model;

import java.util.Date;

public class Invoice {

	private Integer id;
	private Date createdDate;
	private float total;

	public Invoice() {}
	
	public Invoice(Integer id, Date createdDate, float total) {
		this.id = id;
		this.createdDate = createdDate;
		this.total = total;
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
	public float getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}
	
	
}
