package com.dornezz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tcs"})
public class FirstwebapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstwebapplicationApplication.class, args);
	}

}
