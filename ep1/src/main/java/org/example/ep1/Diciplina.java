package org.example.ep1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class Diciplina implements Initializable {
    Misc m = new Misc();

    @FXML
    ListView<Label> list;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        m.mainMenu(list);
    }
}
