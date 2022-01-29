module com.example.sk2chessjava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.chess.app to javafx.fxml;
    exports com.chess.app;
}