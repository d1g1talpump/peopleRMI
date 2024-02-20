package com.peopleRMI.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
    // Private static instance variable
    private static Connect instance;   
    // Private connection variable
    private Connection conn;
    
	// Public static method to get the instance
    public static Connect getInstance() {
        if (instance == null) {
            instance = new Connect();
        }
        return instance;
    }

    // Public method to get the connection
    public Connection getConnection() {
        if (conn == null) {
            conn = connectToDb();
        }
        return conn;
    }

	private static Connection connectToDb() {
		String url = "jdbc:sqlite:C:peopleDb.db";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Connection to SQLite has been established.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}
}