package com.launchpod.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.launchpod.model.CustomerDetails;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {

}
