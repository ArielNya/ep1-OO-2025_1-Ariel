package org.example.ep1;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class AlunoControler implements Initializable {
    MenuAlunos menuAlunos = new MenuAlunos();
    @FXML
    private ListView<String> alunos;

    @FXML
    private ListView<Label> list;

    String[] modos = {
            "Aluno",
            "Diciplina/Turma",
            "Avaliação/Frequência"
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (String modo : modos) {
            list.getItems().add(new Label(modo));
        }

        menuAlunos.showAlunos(alunos);

        // Add mouse click listener to the list
        list.setOnMouseClicked(event -> {
            Label selectedLabel = list.getSelectionModel().getSelectedItem();
            if (selectedLabel != null) {
                String fxmlFile = "";
                switch (selectedLabel.getText()) {
                    case "Aluno":
                        fxmlFile = "aluno.fxml";
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
    }
}