module org.example.ep1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens org.example.ep1 to javafx.fxml;
    exports org.example.ep1;
}