package com.CustomerService.controller;

import javax.activity.InvalidActivityException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerService.exception.CustomerExceptionHandler;
import com.CustomerService.model.Customer;
import com.CustomerService.model.OrderVO;
import com.CustomerService.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService customerIdService;

	@PostMapping("/save")
	public Customer saveCustomer(@RequestBody Customer customer) throws InvalidActivityException {
		log.info("Inside save product");
		if (customer.getCustomerName().isEmpty() || StringUtils.isBlank(customer.getEmail())
				|| StringUtils.isBlank(customer.getCustomerName())) {

			throw new InvalidActivityException("Either customer name or email is not valid");
		}
		return customerIdService.saveCustomer(customer);
	}

	// PathVariable

	@GetMapping("/{customerId}")
	public OrderVO getCustomerWithProductDetails(@PathVariable("customerId") Long customerId) {
		log.info("Inside get customer");

		return customerIdService.getAllCustomerAndProductDetails(customerId);
	}

	// RequestParam
	@DeleteMapping("/delete")
	public HttpStatus deleteCustomer(@RequestParam("customerId") Long customerId) {
		log.info("Inside get customer");
		customerIdService.deleteCustomer(customerId);
		return HttpStatus.OK;
	}

}