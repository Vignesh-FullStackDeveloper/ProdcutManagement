package com.launchpod.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.launchpod.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
