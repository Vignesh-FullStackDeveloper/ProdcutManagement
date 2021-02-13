package com.launchpod.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerdetails")
public class Customer {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcustomer;
	@Column(name = "id")
	private String name;
	@Column(name = "contact_number")
	private Long contactNumber;
	@Column(name = "email")
	private String email;
	@Column(name = "last_bill_date")
	private String lastBillDate;
	@Column(name = "last_bill_amount")
	private Long lastBillAmount;

	public Customer() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdcustomer() {
		return idcustomer;
	}

	public void setIdcustomer(Long idcustomer) {
		this.idcustomer = idcustomer;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLastBillDate() {
		return lastBillDate;
	}

	public void setLastBillDate(String lastBillDate) {
		this.lastBillDate = lastBillDate;
	}
	
	public Long getLastBillAmount() {
		return lastBillAmount;
	}

	public void setLastBillAmount(Long lastBillAmount) {
		this.lastBillAmount = lastBillAmount;
	}

}
