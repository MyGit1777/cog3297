package com.dataloaderportal.controller;

import java.io.File;
import java.io.IOException;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.dataloaderportal.email.EmailService;
import com.dataloaderportal.model.AuthenticationRequest;
import com.dataloaderportal.model.AuthenticationResponse;
import com.dataloaderportal.model.Patient;
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

	@Autowired
	RestTemplate resTemplate;

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

	@PostMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		System.out.println(user.getUserName());
		return ResponseEntity.status(HttpStatus.CREATED).body((userService.updateUser(user)));

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
	public boolean sendOTPOnMail(@RequestParam("email") String email) {

		User user = userRepo.findByUserName(email);

		if (user != null) {
			int otp = otpGenrator.nextInt(9999);

			String subject = "OTP to change your password";
			String message = "Please find below OTP: " + otp;
			user.setOtp(otp);
			userService.createUser(user);

			return emailService.sendOTPMail(subject, message, email);
		}
		return false;
	}

	@PostMapping("/verifyOTP")
	public boolean verifyOTP(@RequestParam("otp") Integer otp, @RequestParam("email") String email) {
		boolean flag = false;
		User user = userRepo.findByUserName(email);
		if (user != null && otp == user.getOtp()) {
			flag = true;
		}
		return flag;
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createJWTToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException ex) {
			throw new Exception("Username or Password is invalid", ex);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

		final String jwt = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	// Upload patient data
	@RequestMapping(value = "/uploadData", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public HttpStatus uploadData(@RequestParam("file") MultipartFile file) {
		File tempFile = null;
		try {
			String extension = ".xlsx";
			tempFile = File.createTempFile("temp", extension);
			file.transferTo(tempFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("file", new FileSystemResource(tempFile));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);

		try {

			resTemplate.exchange("http://localhost:8082/patient/uploadData", HttpMethod.POST, requestEntity,
					String.class);
		} catch (Exception e) {
			e.getMessage();
		}
		return HttpStatus.OK;

	}
	// Get patient by name

	@GetMapping("/getPatient/{patientName}")
	public Patient getPatient(@PathVariable String patientName) {

		Patient patient = resTemplate.getForObject("http://localhost:8082/patient/getByPatientName/" + patientName,
				Patient.class);
		return patient;

	}

	// Update Patient details

	@PutMapping("/updatePatient")
	public HttpStatus updatePatientDetails(@RequestBody Patient patient) {

		resTemplate.exchange("http://localhost:8082/patient/updatePatient", HttpMethod.PUT, new HttpEntity<>(patient),
				String.class);
		return HttpStatus.OK;

	}
}