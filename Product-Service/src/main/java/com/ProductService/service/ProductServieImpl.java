package com.ProductService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProductService.model.Product;
import com.ProductService.repository.ProductRepository;

@Service
public class ProductServieImpl implements ProductService {

	@Autowired
	ProductRepository productRepol;

	@Override
	public List<Product> getAllProducts() {

		return productRepol.findAll();
	}

	@Override
	public Product getProduct(Long productId) {
		return productRepol.getProductByproductId(productId);
	}

	@Override
	public Product saveProduct(Product customer) {
		return productRepol.save(customer);
	}

	@Override
	public Product updateProduct(Product customer) {
		return productRepol.save(customer);
	}

	@Override
	public void deleteProduct(Long cutomerId) {
		productRepol.deleteById(cutomerId);
		;
	}

}
