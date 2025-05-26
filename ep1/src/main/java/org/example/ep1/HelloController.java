package org.example.ep1;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    Misc m = new Misc();
    MenuAlunos menuAlunos = new MenuAlunos();



    @FXML
    private void abrirJanelaNovoAluno() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("createAluno.fxml"));
            Parent root = loader.load();

            AddAluno controller = loader.getController();
            controller.setMenuAlunos(menuAlunos);
            controller.setAlunoCreate(this::refreshAlunoList);

            Stage newWindow = new Stage();
            newWindow.setTitle("Criar Novo Aluno");
            newWindow.setScene(new Scene(root));
            newWindow.initModality(Modality.APPLICATION_MODAL);
            newWindow.setResizable(false);


            newWindow.showAndWait();

        } catch (IOException e) {
            showAlert("Erro", "Não foi possível abrir a janela de criação de aluno.", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }


    @FXML
    private Button add;

    @FXML
    private ListView<String> alunos;

    @FXML
    private ListView<Label> list;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add.setOnAction(e->abrirJanelaNovoAluno());
        m.mainMenu(list);

        for(Aluno aluno : menuAlunos.getLista()){
            String nome = aluno.getName();
            alunos.getItems().add(nome);
        }
        menuAlunos.showAlunos(alunos);


    }

    private void refreshAlunoList() {
        menuAlunos.showAlunos(menuAlunos.getListaAlunos());
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}