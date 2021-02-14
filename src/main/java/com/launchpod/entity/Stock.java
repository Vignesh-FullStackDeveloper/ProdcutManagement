package com.launchpod.entity;

import java.util.Date;
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
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long idProduct;
	private Long idDistributor;
	private Long unitsreceived;
	private Long distributorPrice;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  recievedDate;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduct", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product; 
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDistributor", referencedColumnName = "id", insertable = false, updatable = false)
    private Distributor distributor; 

}
