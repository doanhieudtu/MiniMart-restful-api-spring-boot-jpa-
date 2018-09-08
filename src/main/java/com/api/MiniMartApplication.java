package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages="com.api.model")
@SpringBootApplication
public class MiniMartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniMartApplication.class, args);
	}
}
