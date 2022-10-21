package com.EurekaServerCustomerProduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerCustomerProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerCustomerProductApplication.class, args);
	}

}
