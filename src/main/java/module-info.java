module com.jakubku.mazebank.mazebank {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.jakubku.mazebank.mazebank to javafx.fxml;
    exports com.jakubku.mazebank.mazebank;
    exports com.jakubku.mazebank.mazebank.controllers;
    exports com.jakubku.mazebank.mazebank.controllers.admin;
    exports com.jakubku.mazebank.mazebank.controllers.client;
    exports com.jakubku.mazebank.mazebank.models;
    exports com.jakubku.mazebank.mazebank.views;

}