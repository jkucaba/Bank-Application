package com.jakubku.mazebank.mazebank.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SavingsAccount extends Account{
    // The withdrawal limit from the savings
    private final DoubleProperty withdrawalLimit;

    public SavingsAccount(String owner, String accountNumber, double balance, double limit) {
        super(owner, accountNumber, balance);
        this.withdrawalLimit = new SimpleDoubleProperty(this, "WithdrawalLimit", limit);
    }
    public DoubleProperty withdrawalLimitProperty() {
        return withdrawalLimit;
    }
}
