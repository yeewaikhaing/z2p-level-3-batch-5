package day10;

public class SingletonDemo {

	public static void main(String[] args) {
		DatabaseConfig config1 = DatabaseConfig.getInstance();
		System.out.println("db_name: " + config1.db_name);
		
		DatabaseConfig config2 = DatabaseConfig.getInstance();
		System.out.println("db_name: " + config2.db_name);
		
		config2.db_name = "studentdb";
		
		System.out.println("config1's db_name: " + config1.db_name);
	}
}
