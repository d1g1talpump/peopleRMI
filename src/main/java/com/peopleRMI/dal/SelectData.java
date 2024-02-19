package com.peopleRMI.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.peopleRMI.bo.Person;

public class SelectData {
	
	public static List<Person> selectAll() {	
		
		List<Person> people = new ArrayList<Person>();
		
		String sql = "select * from people;";
		
		ResultSet rs = null;
		
		Connection conn = Connect.connectToDb();
		
		try (Statement stmt = conn.createStatement();) {
			
			rs = stmt.executeQuery(sql);
			
			resultsetToListPeople(people, rs);
			
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
		
		return people;
	}
	
	public static List<Person> selectbyName(String name) {

		List<Person> people = new ArrayList<Person>();
		
		String sql = "select * from person where name = ?;";
		
		ResultSet rs = null;
		new Connect();
		Connection conn = Connect.connectToDb();
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			resultsetToListPeople(people, rs);
			
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
		
		return people;				
	}	


	private static void resultsetToListPeople(List<Person> people, ResultSet rs) throws SQLException {
		while(rs.next()) {
			Person person = new Person(rs.getInt("id"), rs.getString("name"));
			
			if (person != null) {
				people.add(person);
			}
		}
	}
}
