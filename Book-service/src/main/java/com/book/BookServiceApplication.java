package com.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@EnableEurekaClient
@SpringBootApplication
public class BookServiceApplication {

	public static void main(String[] args) {
		System.out.println("Inside controller");

		SpringApplication.run(BookServiceApplication.class, args);
	}

}
