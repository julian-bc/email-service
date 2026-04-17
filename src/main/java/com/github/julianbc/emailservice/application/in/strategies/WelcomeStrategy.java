package com.github.julianbc.emailservice.application.in.strategies;

import com.github.julianbc.emailservice.domain.EmailStrategy;
import com.github.julianbc.emailservice.domain.EmailType;
import com.github.julianbc.emailservice.utils.HtmlTemplateResolver;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WelcomeStrategy implements EmailStrategy {
    private final HtmlTemplateResolver templateResolver;

    public WelcomeStrategy(HtmlTemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
    }

    @Override
    public EmailType getEmailType() { return EmailType.WELCOME; }

    @Override
    public String getSubject() { return "Welcome!"; }

    @Override
    public String buildHtml(Map<String, String> data) {
        return templateResolver.resolve("/emails/welcome.html", data);
    }
}
