package org.example.ep1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        launch();
    }
}