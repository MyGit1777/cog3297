package com.CustomerService.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private Long productId;
	private String productName;
	private Long price;
	private String category;
}
