package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}
	//1 message bean generated
	@Bean // no dependency bean
	public String message() {
		System.out.println("Creating message bean"); // system log output
		return "Hello, Spring!";
	}
	//3 UpperCaseMessage bean generated
	@Bean //2 MessageService bean generated
	public String uppercaseMessage(MessageService messageService) {
		System.out.println("Creating uppercaseMessage bean");
		return messageService.toString().toUpperCase();
	}
	//4 LowerCaseMessage bean generated
	@Bean
	public String lowercaseMessage(MessageService messageService) {
		System.out.println("Creating lowercaseMessage bean");
		return messageService.toString().toLowerCase();
	}

}
