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
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Sales {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idProduct;
	private Long idCustomer;
	private Long discount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date purchaseDate;
	private float price;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduct", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product; 
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCustomer", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer customer; 
	
}
