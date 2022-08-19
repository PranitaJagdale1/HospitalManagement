package com.hospital.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HospitalBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalBackendApplication.class, args);
	}

}
