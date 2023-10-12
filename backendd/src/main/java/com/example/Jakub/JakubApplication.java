package com.example.Jakub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.Jakub.Entity")
public class JakubApplication {

	public static void main(String[] args) {
		SpringApplication.run(JakubApplication.class, args);
	}
}

