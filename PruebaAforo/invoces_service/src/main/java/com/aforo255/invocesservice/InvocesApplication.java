package com.aforo255.invocesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class InvocesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvocesApplication.class, args);
	}

}
