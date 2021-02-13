package com.launchpod.model;





import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Stock {
	private Long idstock;
	private Long idProduct;
	private Long idDistributor;
	private Long unitsreceived;
	private Long distributorPrice;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  recievedDate;
	
	private Long inStock;

	public Stock() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdstock() {
		return idstock;
	}

	public void setIdstock(Long idstock) {
		this.idstock = idstock;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Long getUnitsreceived() {
		return unitsreceived;
	}

	public void setUnitsreceived(Long unitsreceived) {
		this.unitsreceived = unitsreceived;
	}

	public Long getDistributorPrice() {
		return distributorPrice;
	}

	public void setDistributorPrice(Long distributorPrice) {
		this.distributorPrice = distributorPrice;
	}
	
	public Date getRecievedDate() {
		return recievedDate;
	}

	public void setRecievedDate(Date recievedDate) {
		this.recievedDate = recievedDate;
	}

	public Long getInStock() {
		return inStock;
	}

	public void setInStock(Long inStock) {
		this.inStock = inStock;
	}

	public Long getIdDistributor() {
		return idDistributor;
	}

	public void setIdDistributor(Long idDistributor) {
		this.idDistributor = idDistributor;
	}

	
}
