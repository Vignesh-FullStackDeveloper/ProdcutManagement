package com.launchpod.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.launchpod.model.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {

}
