package com.lvg.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customers {
	@Id
	@Column(name="c_id")
	private int customerId;
	@Column(name="c_name")
	private String customerName;
	@Column(name="c_email")
	private String customerEmail;
	@Column(name="c_details")
	private String customerDetails;
	public Customers() {
		
	}
	public Customers(int customerId, String customerName, String customerEmail, String customerDetails) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerDetails = customerDetails;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(String customerDetails) {
		this.customerDetails = customerDetails;
	}
}