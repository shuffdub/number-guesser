module com.example.numbergame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.desktop;


    opens com.example.numbergame to javafx.fxml;
    exports com.example.numbergame;
}