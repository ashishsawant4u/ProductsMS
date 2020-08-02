package com.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsMsApplication.class, args);
	}

}
