package com.github.julianbc.emailservice.application.out;

public interface EmailSenderPort {
    void send(String to, String subject, String html);
}
