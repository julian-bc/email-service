package com.github.julianbc.emailservice;

import com.github.julianbc.emailservice.application.in.SendEmailService;
import com.github.julianbc.emailservice.domain.EmailType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class EmailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailServiceApplication.class, args);
    }

//    @Bean
//    CommandLineRunner executeWelcomeTestEmail(SendEmailService sendEmailService) {
//        return args -> {
//            String toEmail = "";
//            Map<String, String> data = new HashMap<>();
//            data.put("name", "");
//
//            sendEmailService.execute(toEmail, EmailType.WELCOME, data);
//        };
//    }
}
