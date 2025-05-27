package org.example.ep1;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
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
        /*
        for (String modo : modos) {
            list.getItems().add(new Label(modo));
         */
        setupContextMenu();
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
        alunos.setCellFactory(lv -> new ListCell<Aluno>() {
            @Override
            protected void updateItem(Aluno aluno, boolean empty) {
                super.updateItem(aluno, empty);
                setText(empty || aluno == null ? "" : aluno.toString());
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

    private void setupContextMenu() {
        alunos.setCellFactory(lv -> {
            ListCell<Aluno> cell = new ListCell<>() {
                @Override
                protected void updateItem(Aluno aluno, boolean empty) {
                    super.updateItem(aluno, empty);
                    if (empty || aluno == null) {
                        setText(null);
                        setGraphic(null);
                        setContextMenu(null);
                    } else {
                        setText(aluno.toString());
                        setupCellContextMenu(this, aluno);
                    }
                }
            };
            return cell;
        });
    }

    private void setupCellContextMenu(ListCell<Aluno> cell, Aluno aluno) {
        ContextMenu contextMenu = new ContextMenu();

        MenuItem deleteItem = new MenuItem("Delete");
        deleteItem.setOnAction(e -> {
            menuAlunos.removeAluno(aluno.getId());
            alunos.getItems().remove(aluno);
        });

        contextMenu.getItems().addAll(deleteItem);
        cell.setContextMenu(contextMenu);


        cell.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                contextMenu.show(cell, event.getScreenX(), event.getScreenY());
            }
        });

    }



        //menuAlunos.showAlunos(alunos);

        // Add mouse click listener to the list

    }
