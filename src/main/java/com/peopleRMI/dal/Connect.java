package com.peopleRMI.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	public static Connection connectToDb() {
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