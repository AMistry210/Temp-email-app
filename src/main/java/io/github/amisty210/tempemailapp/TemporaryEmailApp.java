package io.github.amisty210.tempemailapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TemporaryEmailApp {
    private List<Email> inbox;
    private EmailStorage emailStorage;

    public TemporaryEmailApp() {
        inbox = new ArrayList<>();
        emailStorage = new EmailStorage();
    }

    public void refreshApp() {
        inbox.clear();
        inbox.add(new Email());
    }

    public void loadEmails() {
        try {
            inbox = emailStorage.loadEmails();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveEmails() {
        try {
            emailStorage.saveEmails(inbox);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendEmail(String subject, String body) {
        Email newEmail = new Email();
        inbox.add(newEmail);
        saveEmails();
    }

    public List<Email> getInbox() {
        return inbox;
    }

    public Email getEmail(int index) {
        return inbox.get(index);
    }
}
