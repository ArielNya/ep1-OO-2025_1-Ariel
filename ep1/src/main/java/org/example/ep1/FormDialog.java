package org.example.ep1;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import java.util.HashMap;
import java.util.Map;

public class FormDialog extends Dialog<Map<String, String>> {
    private final GridPane grid = new GridPane();
    private final Map<String, TextField> fields = new HashMap<>();
    private static int lastId = 0;

    public FormDialog(String title, String... fieldNames) {
        setTitle(title);
        grid.setHgap(10);
        grid.setVgap(10);

        // Create form fields
        for (int i = 0; i < fieldNames.length; i++) {
            String fieldName = fieldNames[i];
            Label label = new Label(fieldName + ":");
            TextField textField = new TextField();

            // Auto-generate ID if field is "ID"
            if (fieldName.equalsIgnoreCase("ID")) {
                textField.setText(String.valueOf(++lastId));
                textField.setDisable(true);
            }

            grid.addRow(i, label, textField);
            fields.put(fieldName, textField);

            // Add validation
            textField.textProperty().addListener((obs, oldVal, newVal) ->
                    validateFields());
        }

        // Set dialog buttons
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(okButton, ButtonType.CANCEL);

        // Create container and add grid
        GridPane container = new GridPane();
        container.setMaxWidth(Double.MAX_VALUE);
        container.add(grid, 0, 0);
        GridPane.setHgrow(grid, Priority.ALWAYS);
        getDialogPane().setContent(container);

        // Result converter
        setResultConverter(button -> {
            if (button == okButton) {
                Map<String, String> results = new HashMap<>();
                fields.forEach((name, field) -> results.put(name, field.getText()));
                return results;
            }
            return null;
        });

        // Initial validation
        //validateFields();
    }

    private void validateFields() {
        boolean valid = fields.values().stream()
                .noneMatch(field -> field.getText().trim().isEmpty());

        //Button okButton = (Button) getDialogPane().lookupButton(ButtonType.OK);
        //okButton.setDisable(!valid);
    }

    public static class Builder {
        private String title;
        private String[] fields;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder fields(String... fields) {
            this.fields = fields;
            return this;
        }

        public FormDialog build() {
            return new FormDialog(title, fields);
        }
    }
}