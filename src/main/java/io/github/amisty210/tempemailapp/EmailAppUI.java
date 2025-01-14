package io.github.amisty210.tempemailapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmailAppUI extends Application {
    private TemporaryEmailApp emailApp;
    private ListView<String> inboxView;
    private TextArea emailContentArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        emailApp = new TemporaryEmailApp();
        emailApp.refreshApp();

        inboxView = new ListView<>();
        updateInboxView();

        emailContentArea = new TextArea();
        emailContentArea.setEditable(false);

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(event -> refreshApp());

        inboxView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                int index = inboxView.getSelectionModel().getSelectedIndex();
                showEmailContent(index);
            }
        });

        // Layout
        VBox layout = new VBox(10, inboxView, emailContentArea, refreshButton);
        Scene scene = new Scene(layout, 400, 300);

        stage.setTitle("Temporary Email App");
        stage.setScene(scene);
        stage.show();
    }

    private void refreshApp() {
        emailApp.refreshApp();
        updateInboxView();
        emailContentArea.clear();
    }

    private void showEmailContent(int index) {
        Email email = emailApp.getEmail(index);
        emailContentArea.setText("From: " + email.getFrom() + "\n" +
                "Subject: " + email.getSubject() + "\n" +
                "Body:\n" + email.getBody());
    }

    private void updateInboxView() {
        inboxView.getItems().clear();
        for (Email email : emailApp.getInbox()) {
            inboxView.getItems().add(email.getSubject());
        }
    }
}
