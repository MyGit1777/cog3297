package com.ProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProductService.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	public Product getProductByproductId(Long productId);
}
