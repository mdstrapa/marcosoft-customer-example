package com.marcosoft.marcosoftcustomerexample.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerDatabase {

    public Connection createConnection(){
        final String dbUrl = "jdbc:mysql://localhost:3306/customerDatabase";
        final String dbUser = "root";
        final String dbPassword = "mysql";
        try {
            return DriverManager.getConnection(dbUrl,dbUser,dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
