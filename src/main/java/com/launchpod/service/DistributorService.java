package com.launchpod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.launchpod.entity.Distributor;
import com.launchpod.repository.DistributorRepository;

@Service
public class DistributorService {
	@Autowired
	private DistributorRepository repo;
	
	public List<Distributor> listAll() {		
		return repo.findAll();
	}
	
	public void save(Distributor distributor) {
		repo.save(distributor);
	}
	
	public Distributor get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
