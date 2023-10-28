package com.jakubku.mazebank.mazebank.controllers.client;

import com.jakubku.mazebank.mazebank.models.Model;
import com.jakubku.mazebank.mazebank.views.ClientMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    public Button dashboard_btn;
    public Button transaction_btn;
    public Button accounts_btn;
    public Button profile_btn;
    public Button logout_btn;
    public Button report_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    private void addListeners(){
        dashboard_btn.setOnAction(e -> onDashboard());
        transaction_btn.setOnAction(e -> onTransactions());
        accounts_btn.setOnAction(e -> onAccounts());
        logout_btn.setOnAction(e -> onLogout());
    }
    private void onDashboard(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.DASHBOARD);
    }
    private void onTransactions(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.TRANSACTIONS);
    }
    private void onAccounts(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.ACCOUNTS);
    }
    private void onLogout(){
        // Get Stage
        Stage stage = (Stage) dashboard_btn.getScene().getWindow();
        // Close the Client Window
        Model.getInstance().getViewFactory().closeStage(stage);
        // Show Login Window
        Model.getInstance().getViewFactory().showLoginWindow();
        // Set Client Login Success Flag to false
        Model.getInstance().setClientLoginSuccessFlag(false);
    }
}
