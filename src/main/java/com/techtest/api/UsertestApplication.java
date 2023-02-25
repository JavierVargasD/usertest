package com.techtest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.techtest.api.domain"})
public class UsertestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsertestApplication.class, args);
	}

}
