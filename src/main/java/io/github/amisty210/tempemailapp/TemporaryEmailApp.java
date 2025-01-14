package io.github.amisty210.tempemailapp;

import java.util.ArrayList;
import java.util.List;

public class TemporaryEmailApp {
    private List<Email> inbox;

    public TemporaryEmailApp() {
        inbox = new ArrayList<>();
    }

    public void refreshApp() {
        inbox.clear();
        inbox.add(new Email());
    }

    public List<Email> getInbox() {
        return inbox;
    }

    public Email getEmail(int index) {
        return inbox.get(index);
    }
}
