package com.launchpod.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Product {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String productName;
	private String manufacturer;
	private float MRP;
	private Long inStock;
	private Long lastPurchaseOn;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<Stock> stocks;
	
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

//	public List<Stock> getStocks() {
//		return stocks;
//	}
//
//	public void setStocks(List<Stock> stocks) {
//		this.stocks = stocks;
//	}


		
	

}
