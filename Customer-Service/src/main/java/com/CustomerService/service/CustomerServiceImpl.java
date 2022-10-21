package com.CustomerService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CustomerService.model.Customer;
import com.CustomerService.model.OrderVO;
import com.CustomerService.model.Product;
import com.CustomerService.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{


	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public OrderVO getAllCustomerAndProductDetails(Long cutomerId) {
		Customer customer =  customerRepo.findBycustomerId(cutomerId);
		Product product = restTemplate.getForObject("http://localhost:8992/product/" + customer.getCustomerId(), Product.class);
		
		OrderVO order  = new OrderVO();
		order.setCustomer(customer);
		order.setProduct(product);
		return order;
	}

	@Override
	public List<Customer> getAllCustomers() {
	
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomer(Long customerId) {
		
		return customerRepo.findBycustomerId(customerId);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		return customerRepo.save(customer);
	}

	@Override
	public void deleteCustomer(Long customerId) {
		customerRepo.deleteById(customerId);
		
	}

}
