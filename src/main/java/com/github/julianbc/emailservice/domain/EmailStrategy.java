package com.github.julianbc.emailservice.domain;

import java.util.Map;

public interface EmailStrategy {
    EmailType getEmailType();
    String getSubject();
    String buildHtml(Map<String, String> data);
}
