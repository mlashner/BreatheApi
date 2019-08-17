package com.breathe.breatheApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BreatheApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreatheApiApplication.class, args);
	}
}
