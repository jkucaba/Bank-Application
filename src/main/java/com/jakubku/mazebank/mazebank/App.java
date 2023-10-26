package com.jakubku.mazebank.mazebank;

import com.jakubku.mazebank.mazebank.models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
