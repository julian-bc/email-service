package com.github.julianbc.emailservice.application.in;

import com.github.julianbc.emailservice.application.out.EmailSenderPort;
import com.github.julianbc.emailservice.domain.EmailStrategy;
import com.github.julianbc.emailservice.domain.EmailType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SendEmailService {
    private final List<EmailStrategy> strategies;
    private final EmailSenderPort emailSenderPort;

    public SendEmailService(List<EmailStrategy> strategies, EmailSenderPort emailSenderPort) {
        this.strategies = strategies;
        this.emailSenderPort = emailSenderPort;
    }

    public void execute(String to, EmailType type, Map<String, String> data) {
        EmailStrategy strategy = strategies.stream()
                .filter(s -> s.getEmailType().equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo de email no soportado"));

        String subject = strategy.getSubject();
        String html = strategy.buildHtml(data);

        emailSenderPort.send(to, subject, html);
    }
}
