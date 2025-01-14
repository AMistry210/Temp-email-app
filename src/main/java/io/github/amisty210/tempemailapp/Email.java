package io.github.amisty210.tempemailapp;

import java.util.UUID;

public class Email {
    private String from;
    private String subject;
    private String body;

    // Constructor to generate a random email
    public Email() {
        this.from = generateRandomEmail();
        this.subject = "Subject " + UUID.randomUUID().toString();
        this.body = "Body content of the email: " + UUID.randomUUID().toString();
    }

    private String generateRandomEmail() {
        return UUID.randomUUID().toString() + "@tempmail.com";
    }

    public String getFrom() {
        return from;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
