package com.Day12ALogin.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Day12ALogin.model.User;
import com.Day12ALogin.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "*" }, maxAge = 4800, allowCredentials = "false")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{userId}")
	public ResponseEntity<Object> getUser(@PathVariable("userId") int userId) {

		User user = userService.getUser(userId);
		return new org.springframework.http.ResponseEntity<>(user, HttpStatus.OK);

	}

	@PostMapping("/create")
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

}
