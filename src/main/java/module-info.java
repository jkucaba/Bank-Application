module com.jakubku.mazebank.mazebank {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jakubku.mazebank.mazebank to javafx.fxml;
    exports com.jakubku.mazebank.mazebank;
}