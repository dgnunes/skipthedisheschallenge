/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.model;

import java.util.Date;

/**
 *
 * @author douglas
 */
public class Customer {
    
    private int customerId;
	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private Date customerCreation;
	private String customerPassword;
	
	public Customer() {
	}
	
	public Customer (int customerId) {
		this.customerId = customerId;
	}
	
	public Customer (String customerEmail) {
		this.customerEmail = customerEmail;
	}

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerCreation() {
        return customerCreation;
    }

    public void setCustomerCreation(Date customerCreation) {
        this.customerCreation = customerCreation;
    }
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Date getCutomerCreation() {
		return customerCreation;
	}
	public void setCutomerCreation(Date cutomerCreation) {
		this.customerCreation = cutomerCreation;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
        
}
