package com.launchpod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.launchpod.model.Stock;
import com.launchpod.repository.StockRepository;


@Service
public class ProductInventoryService {

	@Autowired
	private StockRepository stockRepository;
	
	public List<Stock> listAll() {		
		return stockRepository.findAll();
	}
	
	public void save(Stock stock) {
		stockRepository.save(stock);
	}
	
	public Stock get(Long id) {
		return stockRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		stockRepository.deleteById(id);
	}
	

}
