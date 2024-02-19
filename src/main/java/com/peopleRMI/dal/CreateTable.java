package com.peopleRMI.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void createTablePeople() {
		
		String sql = "create table if not exists people (\n"
				+ "	id integer primary key AUTOINCREMENT,\n"
				+ "	name text not null);";
		
		Connection conn = Connect.connectToDb();		
		try (Statement stmt = conn.createStatement()){
			
			stmt.execute(sql);
			
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
