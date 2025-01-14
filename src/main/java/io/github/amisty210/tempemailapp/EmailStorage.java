package io.github.amisty210.tempemailapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class EmailStorage {

    private static final String EMAIL_FILE = "emails.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    // Save emails to a file
    public void saveEmails(List<Email> emails) throws IOException {
        objectMapper.writeValue(new File(EMAIL_FILE), emails);
    }

    // Load emails from a file
    public List<Email> loadEmails() throws IOException {
        return objectMapper.readValue(new File(EMAIL_FILE),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Email.class));
    }
}
