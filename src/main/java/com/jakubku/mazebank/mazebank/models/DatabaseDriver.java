package com.jakubku.mazebank.mazebank.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
* Connects to the database
* */
public class DatabaseDriver {
    private Connection conn;

    public DatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:mazebank.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
    * Client Section
    * */

    /*
    * Admin Section
    * */

    /*
    * Utility Methods
    * */
}
