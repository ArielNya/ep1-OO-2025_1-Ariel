package org.example.ep1;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuAlunos {

    private final ArrayList<Aluno> alunos = new ArrayList<>();

    public ArrayList<Aluno> getListaAlunos(){
        return alunos;
    }
    public void addAluno(Aluno aluno){
        alunos.add(aluno);
    }
    public void removeAluno(int index){
        alunos.remove(index);
    }
    public void showAlunos(ListView<Aluno> list){
        list.getItems().setAll(alunos);
    }
}