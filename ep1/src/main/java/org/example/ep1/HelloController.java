package org.example.ep1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ListView<String> list;

    @FXML
    private ListView<Label> alunos;


    String[] alunosL = {
            "Aluno1",
            "Aluno2",
            "Aluno3"
    };
    ArrayList<Label> listAlunos = new ArrayList<Label>();
    ArrayList<ContextMenu> cm = new ArrayList<ContextMenu>();
    MenuItem[] mi = {
            new MenuItem("1"),
            new MenuItem("2"),
            new MenuItem("3"),
    };

    String[] modos = {
            "Aluno",
            "Diciplina/Turma",
            "Avaliação/Frequência"
    };




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list.getItems().addAll(modos);
        int x = 0;
        for(MenuItem item : mi){
            item.setId(""+x);
            x++;

        }
        for (int i = 0; i < listAlunos.size(); i++) {
            System.out.println(listAlunos.get(i));
        }



        for(int i = 0; i< mi.length; i++){
            cm.add(new ContextMenu(mi));
        }




        for(int i = 0; i < alunosL.length; i++){
            ContextMenu temp = new ContextMenu(mi);
            System.out.println(temp.getItems().get(i).getId());
            listAlunos.add(new Label(alunosL[i]));
            listAlunos.forEach(l -> l.setContextMenu(temp));
            alunos.getItems().add(listAlunos.get(i));

        }
    }
}