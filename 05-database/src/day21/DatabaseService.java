package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

	public static Connection createConnection() throws SQLException {
		var url = "jdbc:mariadb://localhost:3306/testing_java";
		var user_name = "root";
		var password = "";
		
		Connection con = DriverManager.getConnection(url, user_name, password);
		
		return con;
	}
	
	public static void closeConnection(Connection conn) throws SQLException {
		if(conn != null)
			conn.close();
	}
	public static void save(String item_name, float price) throws SQLException {
		
		Connection con = createConnection();
		
		var query = "INSERT INTO products(name, price)VALUES(?, ?)";
		
		// create prepare st
		PreparedStatement pst = con.prepareStatement(query);
		
		//define param value (pst.setXXX(postion, value);)
		pst.setString(1, item_name);
		pst.setFloat(2, price);
		
		// execute
		pst.executeUpdate();
		
		closeConnection(con);
		
	}
	
	public static void update(String item_name, float price, int proudct_id) throws SQLException {
		
		Connection con = createConnection();
		
		var query = "UPDATE products SET price = ?, name = ? WHERE id = ?";
		
		// create prepare st
		PreparedStatement pst = con.prepareStatement(query);
		
		//define param value (pst.setXXX(postion, value);)
		pst.setFloat(1, price);
		pst.setString(2, item_name);
		pst.setInt(3, proudct_id);
		
		// execute
		pst.executeUpdate();
		
		closeConnection(con);
		
	}
	
	public static void deleteById(int id) throws SQLException {
		
		Connection conn = createConnection();
		
		var query = "DELETE FROM products WHERE id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(query);
		
		pstm.setInt(1, id);
		
		pstm.executeUpdate();
		
		closeConnection(conn);
	}
	
	public static void deleteAll() throws SQLException {
		
		Connection conn = createConnection();
		
		var query = "DELETE FROM products";
		
		PreparedStatement pstm = conn.prepareStatement(query);
		
		pstm.executeUpdate();
		
		closeConnection(conn);
	}

	public static List<Product> findAll() {
		List<Product> data = new ArrayList<>();
		
		try(Connection con = createConnection()) {
			
			var query = "SELECT * FROM products";
			// SELECT id,name,price from products;
			
			PreparedStatement pstm = con.prepareStatement(query);
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				// create new product object
				Product prod = new Product();
				
				// retrieve from resultset
				int productId = rs.getInt(1);
				String productName = rs.getString("name");
				float price = rs.getFloat("price");
				
				//convert column to field
				prod.setId(productId);
				prod.setName(productName);
				prod.setPrice(price);
				
				// add to list
				data.add(prod);
				
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}

	public static Product findById(int productId) {
		Product product = null;
		try(Connection con = createConnection()) {
			
			var query = "SELECT * FROM products WHERE id = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, productId);
			
			var rs = pst.executeQuery();
			if(rs.next()) {
				product = new Product();
				product.setId(productId);
				product.setName(rs.getString("name"));
				product.setPrice(rs.getFloat("price"));
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}
}
