package com.cts.capstrone.FeedbackManagementSystem.mail.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class EmailConfig 
{
    @Bean
    public SimpleMailMessage emailTemplate()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("krishnamanohar.bca@gmail.com");
        message.setTo("hkreddy10143@gmail.com");
        message.setSubject("Feedback Management System Report");
        message.setText("Hi,PFA outreach FMS report");
        return message;
    }
}