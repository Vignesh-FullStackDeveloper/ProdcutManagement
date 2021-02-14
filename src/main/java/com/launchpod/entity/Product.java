package com.launchpod.entity;

import java.util.Date;
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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String productName;
	private String manufacturer;
	private float MRP;
	private Long inStock;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lastPurchaseOn;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<Stock> stocks;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<Sales> sales;

}
