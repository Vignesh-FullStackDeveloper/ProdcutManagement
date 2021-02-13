package com.launchpod.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.launchpod.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
