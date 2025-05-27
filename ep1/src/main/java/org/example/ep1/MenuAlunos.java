package org.example.ep1;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuAlunos {

    private String[] temp = {
            "Aluno1",
            "Aluno2",
            "Aluno3"
    };
    private ArrayList<String> alunosL = new ArrayList<String>(List.of(temp));

    public ArrayList<String> getListaAlunos(){
        return alunosL;
    }
    public void addAluno(String aluno){
        alunosL.add(aluno);
    }
    public void removeAluno(int index){
        alunosL.remove(index);
    }
    public void showAlunos(ListView<String> list){
        list.getItems().addAll(alunosL);
    }
}