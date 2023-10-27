package com.jakubku.mazebank.mazebank.views;

import com.jakubku.mazebank.mazebank.controllers.admin.AdminController;
import com.jakubku.mazebank.mazebank.controllers.client.ClientController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    private AccountType loginAccountType; //Opcja którą wybieramy Client/Admin
    //Client Views
    private final ObjectProperty<ClientMenuOptions> clientSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane transactionsView;
    private AnchorPane accountsView;

    //Admin Views
    private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;
    private AnchorPane createClientView;
    private AnchorPane clientsView;
    private AnchorPane depositView;

    public ViewFactory(){
        this.loginAccountType = AccountType.CLIENT; //Ustawiamy domyślną formę logowania na klienta
        this.clientSelectedMenuItem = new SimpleObjectProperty<>();
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    /*
    * Client Views Section
    * */
    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem(){
        return adminSelectedMenuItem;
    }
    public ObjectProperty<ClientMenuOptions> getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }

    public AnchorPane getDashboardView(){
        if(dashboardView == null){
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/fxml/client/dashboard.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

    public void showClientWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/client/client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }
    public AnchorPane getTransactionsView() {
        if(transactionsView == null){
            try {
                transactionsView = new FXMLLoader(getClass().getResource("/fxml/client/transactions.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return  transactionsView;
    }

    public AnchorPane getAccountsView() {
        if(accountsView == null){
            try {
                accountsView = new FXMLLoader(getClass().getResource("/fxml/client/accounts.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return accountsView;
    }
    /*
    * Admin Views Section
    * */

    public AnchorPane getCreateClientView() {
        if(createClientView == null){
            try {
                createClientView = new FXMLLoader(getClass().getResource("/fxml/admin/createClient.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return createClientView;
    }

    public AnchorPane getClientsView() {
        if(clientsView == null){
            try {
                clientsView = new FXMLLoader(getClass().getResource("/fxml/admin/clients.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return clientsView;
    }
    public AnchorPane getDepositView(){
        if(depositView == null){
            try {
                depositView = new FXMLLoader(getClass().getResource("/fxml/admin/deposit.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return depositView;
    }

    public void showAdminWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/admin/admin.fxml"));
        AdminController adminController = new AdminController();
        loader.setController(adminController);
        createStage(loader);
    }
    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        createStage(loader);
    }
    private void createStage(FXMLLoader loader){
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Maze Bank");
        stage.show();
    }

    public void closeStage(Stage stage){
        stage.close();
    }
}
