package com.CustomerService.service;

import java.util.List;

import com.CustomerService.model.Customer;
import com.CustomerService.model.OrderVO;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	public Customer getCustomer(Long cutomerId);
	public Customer saveCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(Long cutomerId);
	public OrderVO getAllCustomerAndProductDetails(Long cutomerId);

}
