import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Testing {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mariadb://localhost:3306/testing_java";
		String username = "root";
		String password = "";
		
		//1. create connection
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("got connection");
		
		//2. create statement
		Statement st = con.createStatement();
		System.out.println("create statement");
		
		//3. define query
		String query = """
				INSERT INTO employees(emp_no,emp_name,city,salary,bonus,birthday)
				VALUES(1004, 'cherry', 'Mandalay', 4000000, 0.0)
				""";
		//4. execute query
		int numbers = st.executeUpdate(query);
		if(numbers > 0 ) {
			System.out.println("success");
		}
		else
			System.out.println("something is wrong");
		
		// 5. close connection
		con.close();
		
		
	}
}
