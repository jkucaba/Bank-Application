package com.jakubku.mazebank.mazebank.controllers.admin;

import com.jakubku.mazebank.mazebank.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public BorderPane admin_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, newVal, oldVal) -> {
            //TODO Add switch statement

        });
    }
}
