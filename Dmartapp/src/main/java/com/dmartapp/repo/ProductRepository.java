package com.dmartapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmartapp.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findProductByProductId(Long productId);

}
