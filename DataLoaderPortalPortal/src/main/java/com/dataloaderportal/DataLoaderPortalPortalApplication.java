package com.dataloaderportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("*")
public class DataLoaderPortalPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataLoaderPortalPortalApplication.class, args);
	}

	
//	@Bean 
//	public PasswordEncoder passwordEncoder() { 
//		return NoOpPasswordEncoder.getInstance();
//	}
}
