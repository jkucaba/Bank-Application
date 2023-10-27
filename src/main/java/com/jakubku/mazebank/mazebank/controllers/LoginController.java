package com.jakubku.mazebank.mazebank.controllers;

import com.jakubku.mazebank.mazebank.models.Model;
import com.jakubku.mazebank.mazebank.views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> acc_selector;
    public Label payee_address_label;
    public TextField payee_address_fld;
    public TextField password_fld;
    public Button login_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN)); //Dodajemy iopcje wyboru client/admin
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType()); // usttawiamy początkową wartość na client
        acc_selector.valueProperty().
                addListener(observable ->
                        Model.getInstance()
                                .getViewFactory()
                                .setLoginAccountType(acc_selector.getValue())); // sprawdzamy co wybrał użytkownik i zmieniamy wartość selected Acc type
        login_btn.setOnAction(event -> onLogin());
    }
    private void onLogin(){
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        if(Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT){ //jeśli client to wybieramy klienta
            Model.getInstance().getViewFactory().showClientWindow();
        } else { //jak admin to dajemy widok admina
            Model.getInstance().getViewFactory().showAdminWindow();
        }
    }
}
