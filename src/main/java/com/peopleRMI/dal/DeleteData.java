package com.peopleRMI.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
	public static void deletePeopleByName(String name) {
		String sql = "delete from people" +
				" where name like ?";
		
		Connection conn = Connect.getInstance().getConnection();
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, "%" + name + "%");
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
