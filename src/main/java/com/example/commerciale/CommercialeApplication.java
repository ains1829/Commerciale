package com.example.commerciale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@EntityScan(basePackages = "com.example.commerciale.Models")
@EnableJpaRepositories(basePackages = "com.example.commerciale.repository")
@EnableTransactionManagement
public class CommercialeApplication {
	public static void main(String[] args) {
		SpringApplication.run(CommercialeApplication.class, args);
	}
}
