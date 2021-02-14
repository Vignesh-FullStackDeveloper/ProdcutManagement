package com.launchpod.model;

import lombok.Data;

@Data
public class SalesOrder {
	
	private Long id;
	private String customerName;
	private Long customerContact;
	private String customerEmail;
	private String product;
	private String manufacturer;
	private Long discount;
	private Float price;
}