package com.launchpod.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.launchpod.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
