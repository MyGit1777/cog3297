package com.dataloaderportal.controller;

import java.util.Random;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dataloaderportal.email.EmailService;
import com.dataloaderportal.model.AuthenticationRequest;
import com.dataloaderportal.model.AuthenticationResponse;

import com.dataloaderportal.model.User;
import com.dataloaderportal.repository.UserRepository;
import com.dataloaderportal.security.JWTUtil;
import com.dataloaderportal.security.UserDetailsServiceImpl;
import com.dataloaderportal.service.UserService;

@RestController
@RequestMapping("/dataloader")
@CrossOrigin("*")
public class DataLoaderController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EmailService emailService;

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	Random otpGenrator = new Random(1200);

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

	// Forgot password
	@PostMapping("/forgotPassword")
	public boolean sendOTPOnMail(@RequestParam("email") String email, HttpSession session) {

		User user = userRepo.findByUserName(email);

		if (user != null) {
			int otp = otpGenrator.nextInt(9999);

			String subject = "OTP to change your password";
			String message = "Please find below OTP: " + otp;
			session.setAttribute("otp", otp);
			return emailService.sendOTPMail(subject, message, email);
		}
		return false;
	}

	@PostMapping("/verifyOTP")
	public boolean verifyOTP(@RequestParam("otp") Integer otp, HttpSession session) {
		boolean flag = false;
		if (otp == (int) session.getAttribute("otp")) {
			flag = true;
		}

		return flag;
	}

	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createJWTToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException ex) {
			throw new Exception("Username or Password is invalid", ex);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUserName());

		final String jwt = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}