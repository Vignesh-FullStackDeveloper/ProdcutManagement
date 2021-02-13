package com.launchpod.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distributor")
public class Distributor {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Code;
	private String name;
	private String address;
	@Column(name = "contactname")
	private String contactname;
	private String phonenumber;

	public Distributor() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactName() {
		return contactname;
	}

	public void setContactName(String contactname) {
		this.contactname = contactname;
	}

	public String getPhoneNumber() {
		return phonenumber;
	}

	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
}