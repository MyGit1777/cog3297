package com.dmartapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmartapp.model.Product;
import com.dmartapp.model.User;
import com.dmartapp.service.ProductService;
import com.dmartapp.service.UserService;

@RestController
@RequestMapping("/dmart")
@CrossOrigin(origins = { "*" })
public class DmartController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;

	@GetMapping("/{userId}")
	public ResponseEntity<Object> getUser(@PathVariable("userId") Long userId) {

		User user = userService.getUser(userId);
		return new org.springframework.http.ResponseEntity<>(user, HttpStatus.OK);

	}

	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		System.out.println(user.getUserName());
		return ResponseEntity.status(HttpStatus.CREATED).body((userService.createUser(user)));

	}

	// Login for user

	@PostMapping("/login")
	public ResponseEntity<Object> getUserByNameAndPassword(@RequestBody User loginUser) {

		User user = userService.getUserByUserNameAndPassword(loginUser.getUserName(), loginUser.getPassword());
		if (user != null) {
			return new org.springframework.http.ResponseEntity<>(user, HttpStatus.OK);

		} else {
			return new org.springframework.http.ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}

	}
	
	@PostMapping("/createProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body((productService.createProduct(product)));

	}

	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		
		List<Product> products = productService.getAllProducts();
		return products;
	}

	
	@GetMapping("/getProduct/{productId}")
	public Product getProduct(@PathVariable Long productId) {
		
		Product product = productService.findProductByProductId(productId);
		return product;
	}
	
	 @DeleteMapping(value = "/delete/{productId}")
	    public ResponseEntity<Long> deleteProduct(@PathVariable Long productId) {

	       productService.deleteProduct(productId);
	        return new ResponseEntity<>(productId, HttpStatus.OK);
	    }
}