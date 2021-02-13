package com.launchpod.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "manufacturer")
	private String manufacturer;
	@Column(name = "MRP")
	private float MRP;
	@Column(name = "in_stock")
	private Long inStock;
	@Column(name = "last_purchase_on")
	private Long lastPurchaseOn;

	public Product() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public Long getInStock() {
		return inStock;
	}

	public void setInStock(Long inStock) {
		this.inStock = inStock;
	}

	public Long getLastPurchaseOn() {
		return lastPurchaseOn;
	}

	public void setLastPurchaseOn(Long lastPurchaseOn) {
		this.lastPurchaseOn = lastPurchaseOn;
	}

}
