package com.launchpod.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.launchpod.entity.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {

}
