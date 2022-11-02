package com.dmartapp.service;

import java.util.List;

import com.dmartapp.model.Product;

public interface ProductService {
	public Product findProductByProductId(Long productId);
	public List<Product> getAllProducts();
	public Product createProduct(Product product);
	public Product updateProduct(Product product);
	public void deleteProduct(Long productId);

}
