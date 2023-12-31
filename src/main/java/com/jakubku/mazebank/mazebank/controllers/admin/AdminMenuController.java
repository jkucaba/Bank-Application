package com.jakubku.mazebank.mazebank.controllers.admin;

import com.jakubku.mazebank.mazebank.models.Model;
import com.jakubku.mazebank.mazebank.views.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button create_client_btn;
    public Button clients_btn;
    public Button deposit_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    private void addListeners(){
        create_client_btn.setOnAction(e -> onCreateClient());
        clients_btn.setOnAction(e -> onCLients());
        deposit_btn.setOnAction(e -> onDeposit());
        logout_btn.setOnAction(e -> onLogout());
    }
    private void onCreateClient(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CREATE_CLIENT);
    }
    private void onCLients(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CLIENTS);
    }
    private void onDeposit(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.DEPOSIT);
    }
    private void onLogout(){
        // Get Stage
        Stage stage = (Stage) clients_btn.getScene().getWindow();
        // Close the Admin Window
        Model.getInstance().getViewFactory().closeStage(stage);
        // Show Login Window
        Model.getInstance().getViewFactory().showLoginWindow();
        // Set Client Login Success Flag to false
        Model.getInstance().setAdminLoginSuccessFlag(false);
    }
}
