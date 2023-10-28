package com.jakubku.mazebank.mazebank.controllers;

import com.jakubku.mazebank.mazebank.models.Model;
import com.jakubku.mazebank.mazebank.views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> acc_selector;
    public Label payee_address_label;
    public TextField payee_address_fld;
    public PasswordField password_fld;
    public Button login_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN)); //Dodajemy iopcje wyboru client/admin
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType()); // usttawiamy początkową wartość na client
        acc_selector.valueProperty().
                addListener(observable -> setAcc_selector()); // sprawdzamy co wybrał użytkownik i zmieniamy wartość selected Acc type
        login_btn.setOnAction(event -> onLogin());
    }
    private void onLogin(){
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        if(Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT){ //jeśli client to wybieramy klienta
            // Evaluate Client Login Credentials
            Model.getInstance().evaluateClientCred(payee_address_fld.getText(), password_fld.getText());
            if(Model.getInstance().getClientLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showClientWindow();
                // Close the Login Stage
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                payee_address_fld.setText("");
                password_fld.setText("");
                error_lbl.setText("No Such Login Credentials");
            }

        } else { //jak admin to dajemy widok admina
            // Evaluate Admin Credentials
            Model.getInstance().evaluateAdminCredentials(payee_address_fld.getText(), password_fld.getText());
            if(Model.getInstance().getAdminLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showAdminWindow();
                //Close the Login Stage
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                payee_address_fld.setText("");
                password_fld.setText("");
                error_lbl.setText("No Such Login Credentials");
            }
        }
    }
    private void setAcc_selector(){
        Model.getInstance().getViewFactory().setLoginAccountType(acc_selector.getValue());
        if(acc_selector.getValue() == AccountType.ADMIN){
            payee_address_label.setText("Username:");
        } else {
            payee_address_label.setText("Payee Address:");
        }
    }
}
