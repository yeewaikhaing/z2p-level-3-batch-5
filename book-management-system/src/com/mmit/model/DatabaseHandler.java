package com.mmit.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
				var author = new Author();
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				author.setNativeTown(rs.getString("native_town"));
				
				User created = new User();
				
				created.setId(rs.getInt("created_by"));
				created.setUserName(rs.getString("user_name"));
				
				author.setCreated_by(created);
				
				author.setBirthday(LocalDate.parse(rs.getString("birthday")));
				
				list.add(author);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static void updateAuthor(Author author) throws Exception {
		
		try (Connection con = createConnection()){
			
			var query = "UPDATE authors SET name = ?, birthday = ?, native_town = ? WHERE id = ?";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, author.getName());
			pstm.setDate(2, Date.valueOf(author.getBirthday()));
			pstm.setString(3, author.getNativeTown());
			pstm.setInt(4, author.getId());
			
			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	public static void deleteAuthorById(int id) {
		try(Connection con = createConnection()) {
			
			var query = "DELETE FROM authors WHERE id = ?";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			
			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public static List<Category> findAllCategories() {
		List<Category> list = new ArrayList<>();
		try(Connection con = createConnection()) {
			var query = """
					SELECT categories.*, users.user_name 
					FROM categories, users 
					WHERE categories.created_by = users.id
					""";
			var pstm = con.prepareStatement(query);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var cat = new Category();
				cat.setCreated_at(LocalDate.parse(rs.getString("created_at")));
				cat.setName(rs.getString("name"));
				cat.setId(rs.getInt("id"));
				
				var user = new User();
				user.setId(rs.getInt("created_by"));
				user.setUserName(rs.getString("user_name"));
				
				cat.setCreated_by(user);
				
				list.add(cat);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static void saveBook(Book book) throws Exception {
		try (var con = createConnection()){
			var query = "INSERT INTO books(code, title, price, publish_date, category_id, author_id, created_by )VALUES(?,?,?,?,?,?,?)";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, book.getCode());
			pstm.setString(2, book.getTitle());
			pstm.setFloat(3, book.getPrice());
			pstm.setDate(4, Date.valueOf(book.getPublish_date()));
			pstm.setInt(5, book.getCategory().getId());
			pstm.setInt(6, book.getAuthor().getId());
			pstm.setInt(7, book.getCreated_by().getId());
			
			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	public static List<Book> findAllBooks() {
		List<Book> list = new ArrayList<>();
		try(Connection con = createConnection()) {
			var query = """
					SELECT books.*, authors.name, categories.name, users.user_name 
					FROM authors, books, categories, users
					WHERE books.author_id = authors.id && 
					books.category_id = categories.id && 
					books.created_by = users.id;
					""";
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while(rs.next()) {
				// create book
				var book = new Book();
				// assign data
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getFloat("price"));
				book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));
				
				var cat = new Category();
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("name"));
				
				book.setCategory(cat);
				// add to list
				list.add(book);
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
