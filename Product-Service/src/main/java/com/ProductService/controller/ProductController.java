package com.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProductService.model.Product;
import com.ProductService.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		log.info("Inside save product");

		return productService.saveProduct(product);
	}

	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable("productId") Long productId) {
		log.info("Inside get product");

		return productService.getProduct(productId);
	}

}