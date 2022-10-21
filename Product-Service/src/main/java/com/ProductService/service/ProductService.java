package com.ProductService.service;

import java.util.List;

import com.ProductService.model.Product;

public interface ProductService {
	

	public List<Product> getAllProducts();
	public Product getProduct(Long productId);
	public Product saveProduct(Product customer);
	public Product updateProduct(Product customer);
	public void deleteProduct(Long cutomerId);

}
