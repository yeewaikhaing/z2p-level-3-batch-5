import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Testing {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mariadb://localhost:3306/testing_java";
		String username = "root";
		String password = "";
		
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("got connection");
	}
}
