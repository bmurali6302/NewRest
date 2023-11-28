package com.lvg.demo.dto;
public class Customer {
	private int customerId;
	private String customerName;
	private String customerEmail;
	private String customerDetails;
	
	public Customer() {
		
	}

	public Customer(int customerId, String customerName, String customerEmail, String customerDetails) {
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