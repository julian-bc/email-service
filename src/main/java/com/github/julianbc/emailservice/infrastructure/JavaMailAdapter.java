package com.github.julianbc.emailservice.infrastructure;

import com.github.julianbc.emailservice.application.out.EmailSenderPort;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
        try {
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true);

            mailSender.send(message);
        } catch (MessagingException ex) {
            throw new RuntimeException("Error al formatear el correo para Gmail", ex);
        }
    }
}
