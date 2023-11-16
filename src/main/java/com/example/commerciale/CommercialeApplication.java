package com.example.commerciale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan("com.example.commerciale.models")
@SpringBootApplication
public class CommercialeApplication {
	public static void main(String[] args) {
		SpringApplication.run(CommercialeApplication.class, args);
	}
}
