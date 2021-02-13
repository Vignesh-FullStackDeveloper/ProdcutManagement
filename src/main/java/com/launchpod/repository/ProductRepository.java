package com.launchpod.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.launchpod.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
