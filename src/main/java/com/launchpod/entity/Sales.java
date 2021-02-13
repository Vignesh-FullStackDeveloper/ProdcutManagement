package com.launchpod.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sales {
	private Long idsales;
	private Long idproduct;
	private Long idcustomer;
	private Long discount;
	private String purchaseDate;
	private float price;

	public Sales() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdsales() {
		return idsales;
	}

	public void setIdsales(Long idsales) {
		this.idsales = idsales;
	}
	
	public Long getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(Long idproduct) {
		this.idproduct = idproduct;
	}

	public Long getIdcustomer() {
		return idcustomer;
	}

	public void setIdcustomer(Long idcustomer) {
		this.idcustomer = idcustomer;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
