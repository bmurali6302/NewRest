package com.lvg.demo.entity;

import com.lvg.demo.dto.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Orders {
    @Id
    @Column(name="or_id")
    private int orderId;
    @Column(name="c_id")
    private int customerId;
    @Column(name="or_name")
    private String OrderName;
    @Column(name="or_cost")
    private String OrderCost;
    
    @Transient
    Customer customers;
    
    public Orders() {
    	
    }

	public Orders(int orderId, int customerId, String orderName, String orderCost, Customer customers) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		OrderName = orderName;
		OrderCost = orderCost;
		this.customers = customers;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getOrderName() {
		return OrderName;
	}

	public void setOrderName(String orderName) {
		OrderName = orderName;
	}

	public String getOrderCost() {
		return OrderCost;
	}

	public void setOrderCost(String orderCost) {
		OrderCost = orderCost;
	}

	public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}
    
    

}
