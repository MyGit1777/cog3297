package com.dmartapp.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "DemartProduct")
public class Product {

	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	private String productName;
	private String productCategory;
	private String productDescription;
	private Long quantity;
	private Long price;

}