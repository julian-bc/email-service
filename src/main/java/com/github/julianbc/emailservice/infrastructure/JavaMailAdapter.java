package com.github.julianbc.emailservice.infrastructure;

import com.github.julianbc.emailservice.application.out.EmailSenderPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class JavaMailAdapter implements EmailSenderPort {
    private final JavaMailSender mailSender;
    private final String fromEmail;

    public JavaMailAdapter(JavaMailSender mailSender, @Value("MAIL_USERNAME") String fromEmail) {
        this.mailSender = mailSender;
        this.fromEmail = fromEmail;
    }

    @Override
    public void send(String to, String subject, String html) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(html);
        mailSender.send(message);
    }
}
