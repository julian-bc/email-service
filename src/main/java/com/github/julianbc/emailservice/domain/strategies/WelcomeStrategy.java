package com.github.julianbc.emailservice.domain.strategies;

import com.github.julianbc.emailservice.domain.EmailStrategy;
import com.github.julianbc.emailservice.domain.EmailType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WelcomeStrategy implements EmailStrategy {
    @Override
    public EmailType getEmailType() { return EmailType.WELCOME; }

    @Override
    public String getSubject() { return "Welcome!"; }

    @Override
    public String buildHtml(Map<String, String> data) {
        return "Welcome dear " + data.get("name") + "!";
    }
}
