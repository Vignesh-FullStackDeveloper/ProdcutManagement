package com.launchpod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.launchpod.entity.Sales;
import com.launchpod.repository.SalesRepository;

@Service
public class SalesService {
	@Autowired
	private SalesRepository repo;
	
	public List<Sales> listAll() {		
		return repo.findAll();
	}
	
	public void save(Sales customer) {
		repo.save(customer);
	}
	
	public Sales get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
