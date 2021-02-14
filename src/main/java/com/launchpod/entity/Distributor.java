package com.launchpod.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Distributor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Code;
	private String name;
	private String address;
	private String contactNumber;
	private String contactPerson;

	@OneToMany(mappedBy = "distributor", fetch = FetchType.LAZY)
	private List<Stock> stocks;

}