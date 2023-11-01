package com.jakubku.mazebank.mazebank.models;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CheckingAccount extends Account{
    //Number of transactions a client is allowed to do per day
    private final IntegerProperty transactionLimit;
    public CheckingAccount(String owner, String accountNumber, double balance, int transLimit) {
        super(owner, accountNumber, balance);
        this.transactionLimit = new SimpleIntegerProperty(this, "TransactionLimit", transLimit);
    }
    public IntegerProperty transactionLimitProperty() {
        return transactionLimit;
    }

    @Override
    public String toString() {
        return accountNumberProperty().get();
    }
}
