package org.example.ep1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Misc {

    private String[] modos = {
            "Aluno",
            "Diciplina/Turma",
            "Avaliação/Frequência"
    };


    public void mainMenu(ListView<Label> lv){
        for (String modo : modos) {
            Label label = new Label(modo);

            label.setOnMouseClicked(event -> {
                try {
                    changeScene(modo, event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            lv.getItems().add(label);



        }
    }

    public void changeScene(String sceneName, MouseEvent event) throws IOException {
        String fxmlFile = "";
        String sceneTitle = "";

        // Map each label to its corresponding FXML file
        switch (sceneName) {
            case "Aluno":
                fxmlFile = "aluno-view.fxml";
                sceneTitle = "Gestão de Alunos";
                break;
            case "Diciplina/Turma":
                fxmlFile = "diciplina.fxml";
                sceneTitle = "Gestão de Disciplinas/Turmas";
                break;
            case "Avaliação/Frequência":
                fxmlFile = "avaliacao-view.fxml";
                sceneTitle = "Gestão de Avaliações/Frequência";
                break;
            default:
                System.out.println("Unknown scene: " + sceneName);
                return;
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));

            Stage currentStage = (Stage) ((Label) event.getSource()).getScene().getWindow();
            Scene newScene = new Scene(root);
            currentStage.setTitle(sceneTitle);
            currentStage.setScene(newScene);
            currentStage.show();

        } catch (IOException e) {
            System.err.println("Error loading FXML file: " + fxmlFile);
            e.printStackTrace();
        }
    }
}
