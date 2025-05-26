package org.example.ep1;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuAlunos{


    private ArrayList<Aluno> alunosL = new ArrayList<>();

    public MenuAlunos() {
        // Initialize with some sample students
        alunosL.add(new Aluno("João Silva", "Filosofia", "123"));
        alunosL.add(new Aluno("Maria Santos", "Engenharia", "2350"));
        alunosL.add(new Aluno("Pedro Costa", "Nyan", "567"));
    }
    public ListView<String> getListaAlunos(){
        ListView<String> helper = new ListView<>();
        for(Aluno aluno : alunosL){
            helper.getItems().add(aluno.getName());
        }
        return helper;
    }

    public ArrayList<Aluno> getLista(){
        return alunosL;
    }
    public void addAluno(Aluno aluno){
        for(Aluno a : alunosL){
            if(a.getMatricula() == aluno.getMatricula()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.showAndWait();
                return;
            }
        }
        alunosL.add(aluno);
    }
    public void removeAluno(int index){
        alunosL.remove(index);
    }
    public void showAlunos(ListView<String> list){
        list.getItems().clear();
        for(Aluno aluno : alunosL){
            String nome = aluno.getName();
            list.getItems().add(nome);
        }


    }

}
