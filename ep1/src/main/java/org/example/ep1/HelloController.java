package org.example.ep1;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private Button add;

    @FXML
    private ListView<Label> alunos;

    @FXML
    private ListView<Label> list;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add.setOnAction(e->System.out.println("uwu"));
        m.mainMenu(list);

        menuAlunos.showAlunos(alunos);
    }
}