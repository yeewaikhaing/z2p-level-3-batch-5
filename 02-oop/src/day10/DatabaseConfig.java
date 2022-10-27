package day10;

public class DatabaseConfig {

	 String db_name = "employeedb";
	// static field
	private static DatabaseConfig obj = null;
	// private constructor
	private DatabaseConfig() {
		
	}
	// static method
	public static DatabaseConfig getInstance() {
		if(obj == null) {
			obj = new DatabaseConfig();
		}
		
		return obj;
	}
	class Teacher { // inner class
		
	}
}

 class Student {
	
}
