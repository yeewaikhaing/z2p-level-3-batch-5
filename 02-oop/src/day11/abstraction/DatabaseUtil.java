package day11.abstraction;

import java.util.List;

public abstract class DatabaseUtil {

	private String db_name = "shop_db";
	
	public void connect_database() {
		System.out.println("Connecting to " + db_name + "......");
	}
	
	public abstract void insert() ;
	public abstract void update();
	public abstract boolean delete(int id);
	public abstract Object findById(int id);
	public abstract List<Object> findAll();
	 boolean deleteAll() {
		return false;
	}
}
