package com.launchpod.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "customerdetails")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long contactNumber;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lastBillDate;
	private Float lastBillAmount;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Sales> sales;
}
