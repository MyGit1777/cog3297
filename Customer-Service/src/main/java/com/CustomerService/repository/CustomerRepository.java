package com.CustomerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CustomerService.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	public Customer findBycustomerId(Long customerId);

}
