package org.example.ep1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MenuDiciplina implements Initializable {

    @FXML
    private Button add;

    @FXML
    private ListView<Label> list;

    @FXML
    private ListView<Diciplina> diciplinas;

    String[] modos = {
            "Aluno",
            "Diciplina/Turma",
            "Avaliação/Frequência"
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        list.setOnMouseClicked(event -> {
            Label selectedLabel = list.getSelectionModel().getSelectedItem();
            if (selectedLabel != null) {
                String fxmlFile = "";
                switch (selectedLabel.getText()) {
                    case "Aluno":
                        fxmlFile = "view.fxml";
                        break;
                    case "Diciplina/Turma":
                        fxmlFile = "diciplina.fxml";
                        break;
                    case "Avaliação/Frequência":
                        fxmlFile = "avaliacao_frequencia.fxml";
                        break;
                }
                try {
                    // Load the new FXML
                    Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
                    Stage stage = (Stage) list.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        /*
        for (String modo : modos) {
            list.getItems().add(new Label(modo));
         */
        add.setOnAction(e->{
            handleAddButton();
        });
        setupListView();
    }

    private void setupListView() {
        list.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Label item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item.getText());
            }
        });
        diciplinas.setCellFactory(lv -> new ListCell<Diciplina>() {
            @Override
            protected void updateItem(Diciplina aluno, boolean empty) {
                super.updateItem(aluno, empty);
                setText(empty || aluno == null ? "" : aluno.toString());
            }
        });

        // Add your existing modes
        for(String modo : modos) {
            list.getItems().add(new Label(modo));
        }
    }

    private void handleAddButton(){

    }
}
