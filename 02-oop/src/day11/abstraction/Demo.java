package day11.abstraction;

public class Demo {

	public static void main(String[] args) {
		//DatabaseUtil util = new DatabaseUtil(); // can't create object
		
		DatabaseUtil util = new ProductService();
		util.connect_database();
		util.insert();
		util.update();
		util.delete(1001);
		util.findById( 1002 );
		util.findAll();
		
		System.out.println("-----------");
		util = new CategoryService();
		util.insert();
	}
}
