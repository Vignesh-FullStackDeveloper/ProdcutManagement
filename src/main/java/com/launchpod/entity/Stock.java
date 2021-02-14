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

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idStock;
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

	
	public Long getIdStock() {
		return idStock;
	}

	public void setIdStock(Long idstock) {
		this.idStock = idstock;
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

	public Long getIdDistributor() {
		return idDistributor;
	}

	public void setIdDistributor(Long idDistributor) {
		this.idDistributor = idDistributor;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Distributor getDistributor() {
		return distributor;
	}

	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}
	

}
