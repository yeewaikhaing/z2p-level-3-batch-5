package com.mmit.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public static void saveAuthor(Author author) throws Exception {
		try (Connection con = createConnection()){
			var query = "INSERT INTO authors(name, birthday, created_by, native_town)"
					+ "VALUES(?, ?, ?, ?)";
			
			var pstm = con.prepareStatement(query);
			pstm.setString(1, author.getName());
			pstm.setDate(2, Date.valueOf(author.getBirthday()));
			pstm.setInt(3, author.getCreated_by().getId());
			pstm.setString(4, author.getNativeTown());
			
			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	public static List<Author> findAllAuthors() {
		List<Author> list = new ArrayList<>();
		try(Connection con = createConnection()) {
			var query = """
					SELECT authors.*, users.user_name 
					FROM authors, users
					WHERE authors.created_by = users.id
					""";
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var auth
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
//	public static void main(String[] args) throws SQLException {
//		createConnection();
//		System.out.println("ok...");
//	}

}
