package com.peopleRMI.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
	
	public static void insertPerson(String name) {
				
		String sql = "insert into people (name)"
				+ " values (?)";

		Connection conn = Connect.connectToDb();
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, name);
			
			pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
		
	}

}
