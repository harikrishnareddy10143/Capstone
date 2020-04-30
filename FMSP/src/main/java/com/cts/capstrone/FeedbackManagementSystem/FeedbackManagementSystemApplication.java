package com.cts.capstrone.FeedbackManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cts.capstrone.FeedbackManagementSystem.mail.service.EmailService;

@SpringBootApplication
@ComponentScan(basePackages="com.cts.capstrone.FeedbackManagementSystem.*")
public class FeedbackManagementSystemApplication  {
	
	
	public static void main(String[] args) {
		SpringApplication.run(FeedbackManagementSystemApplication.class, args);
	}
	
	

}
