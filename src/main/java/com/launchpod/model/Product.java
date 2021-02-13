package com.launchpod.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	private Long id;
	//private Long idDistributor;
	private String product;
	private String manufacturer;
	private float MRP;

	public Product() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
//	public Long getIdDistributor() {
//		return idDistributor;
//	}
//
//	public void setIdDistributor(Long idDistributor) {
//		this.idDistributor = idDistributor;
//	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public float getMRP() {
		return MRP;
	}

	public void setMRP(float MRP) {
		this.MRP = MRP;
	}

}
