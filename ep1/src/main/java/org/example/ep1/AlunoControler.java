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
import java.util.Objects;
import java.util.ResourceBundle;

public class AlunoControler implements Initializable {
    MenuAlunos menuAlunos = new MenuAlunos();
    @FXML
    private ListView<String> alunoNome;

    private ListView<Aluno> alunos = new ListView<>();

    @FXML
    private ListView<Label> list;

    @FXML
    private Button add;

    String[] modos = {
            "Aluno",
            "Diciplina/Turma",
            "Avaliação/Frequência"
    };
    private final ContextMenuFactory<DisplayableEntity> contextMenuFactory = new ContextMenuFactory<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
        for (String modo : modos) {
            list.getItems().add(new Label(modo));
         */
        setupContextMenuFactory();
        setupListView();
        add.setOnAction(e->{
            handleAddButton();
        });

        }

    private void setupListView() {
        list.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Label item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item.getText());
            }
        });


        // Add your existing modes
        for(String modo : modos) {
            list.getItems().add(new Label(modo));
        }
    }

    @FXML
    private void handleAddButton() {
        add.setOnAction(event -> showStudentForm());
    }

    private void showStudentForm() {
        FormDialog dialog = new FormDialog.Builder()
                .title("Add New Student")
                .fields("matricula", "Name", "Curso")
                .build();


        dialog.showAndWait().ifPresent(results -> {
            String id  = results.get("matricula");
            String name = results.get("Name");
            String curso = results.get("Curso");
            //String email = results.get("Email");

            for(Aluno aluno : alunos.getItems()){
                if(Objects.equals(aluno.getId(), id)){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Duplicata nas matriculas registradas");
                    alert.showAndWait();
                    return;
                }
            }


            Aluno newAluno = new Aluno(id, name, curso);

            menuAlunos.addAluno(newAluno);
            alunos.getItems().add(newAluno);
            alunoNome.getItems().add(newAluno.getNome() + " - " + newAluno.getId());
        });
    }

    private void setupContextMenuFactory() {
        contextMenuFactory.addAction("Delete", entity -> {
            if(entity instanceof Aluno) {
                int index = alunos.getItems().indexOf(entity);
                if(index >= 0) {
                    menuAlunos.removeAluno(index);
                    alunos.getItems().remove(index);
                }
            }
            // Add other entity types here
        });



        //menuAlunos.showAlunos(alunos);

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