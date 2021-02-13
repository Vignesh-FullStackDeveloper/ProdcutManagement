package com.launchpod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.launchpod.entity.Customer;
import com.launchpod.entity.Distributor;
import com.launchpod.entity.Sales;
import com.launchpod.repository.CustomerRepository;
import com.launchpod.repository.DistributorRepository;
import com.launchpod.repository.SalesRepository;

@Service
public class SalesService {
	@Autowired
	private SalesRepository repo;
	
	public List<Sales> listAll() {		
		return repo.findAll();
	}
	
	public void save(Sales sales) {
		repo.save(sales);
	}
	
	public Sales get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public void getAllSalesOrder() {
		
	}
}
