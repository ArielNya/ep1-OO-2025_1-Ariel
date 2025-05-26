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

public class HelloController implements Initializable {
    Misc m = new Misc();
    MenuAlunos menuAlunos = new MenuAlunos();
    @FXML
    private ListView<String> alunos;

    @FXML
    private ListView<Label> list;

//    String[] modos = {
//            "Aluno",
//            "Diciplina/Turma",
//            "Avaliação/Frequência"
//    };





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        m.mainMenu(list);
//        for (String modo : modos) {
//            Label label = new Label(modo);
//
//            label.setOnMouseClicked(event -> {
//                try {
//                    m.changeScene(modo, event);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//
//            list.getItems().add(label);
//
//
//
//        }
        menuAlunos.showAlunos(alunos);
    }
}