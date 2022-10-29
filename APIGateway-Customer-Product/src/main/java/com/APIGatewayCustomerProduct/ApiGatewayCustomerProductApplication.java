package com.APIGatewayCustomerProduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayCustomerProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayCustomerProductApplication.class, args);
	}

}
