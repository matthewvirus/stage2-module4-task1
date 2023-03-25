package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {

    @Override
    public Connection createConnection() {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            properties.load(H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties"));

            String driver = properties.getProperty("jdbc_driver");
            String databaseUrl = properties.getProperty("db_url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            Class.forName(driver);
            connection = DriverManager.getConnection(databaseUrl, user, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}