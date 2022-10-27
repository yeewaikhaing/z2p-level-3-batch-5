package day10.inheritance;

public class Demo {

	public static void main(String[] args) {
		// create obj with args constructor
		Student obj = new Student(1, "Kyaw Kyaw", "091234567");
		
		System.out.println("---------------");
		// create obj with default constructor
		Student obj2 = new Student();
		
		//System.out.println("Rno - " + obj.getRno());
		//obj.display(); // call parent's method
	}
}
