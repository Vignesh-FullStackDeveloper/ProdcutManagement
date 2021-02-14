package com.launchpod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.launchpod.entity.Customer;
import com.launchpod.entity.Distributor;
import com.launchpod.repository.CustomerRepository;
import com.launchpod.repository.DistributorRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repo;
	
	public List<Customer> listAll() {		
		return repo.findAll();
	}
	
	public void save(Customer customer) {
		repo.save(customer);
	}
	
	public Customer get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
