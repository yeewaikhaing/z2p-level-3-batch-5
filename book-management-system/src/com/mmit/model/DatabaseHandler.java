package com.mmit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHandler {
	
	private static Connection createConnection() throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_5", "root", "");
		
		return con;
	}

	public static User login(String user_name, String password) {
		 
		User user = null;
		
		try (Connection con = createConnection()){
			
			var query = "SELECT * FROM users WHERE user_name = ? AND password = ?";
			
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, user_name);
			pstm.setString(2, password);
			
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
//	public static void main(String[] args) throws SQLException {
//		createConnection();
//		System.out.println("ok...");
//	}

}
