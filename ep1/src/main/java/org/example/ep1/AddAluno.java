package org.example.ep1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddAluno implements Initializable {
    private MenuAlunos ma;
    private Runnable alunoCreated;
    @FXML
    private TextField nome;

    @FXML
    private TextField curso;

    @FXML
    private TextField matricula;

    @FXML
    private Button addBtn;

    @FXML
    private void onClick(){
        String name = nome.getText().trim();
        String course = curso.getText().trim();
        String mat = matricula.getText().trim();

        if(name.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please set a name");
            alert.showAndWait();
            return;
        }
        if(course.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please set a course");
            alert.showAndWait();
            return;
        }
        if(mat.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor escreva a matricula");
            alert.showAndWait();
            return;
        }

        Aluno aluno = new Aluno(name, course, mat);

        try {
            ma.addAluno(aluno);

            if (alunoCreated != null) {
                alunoCreated.run();
            }

            Stage stage = (Stage) nome.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Erro ao criar aluno: " + e.getMessage());
        }

    }

    public void setMenuAlunos(MenuAlunos menu){
        this.ma = ma;
    }
    public void setAlunoCreate(Runnable callback){
        this.alunoCreated = callback;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addBtn.setOnAction(e->onClick());
    }
}
