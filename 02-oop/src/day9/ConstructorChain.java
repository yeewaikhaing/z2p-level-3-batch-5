package day9;

public class ConstructorChain {

	public ConstructorChain() {
		this(100);
		System.out.println("This is default constructor");
		//this(100);
		
	}
	
	public ConstructorChain(int i) {// i = 100
		this(i, 200); // (100,200)
		System.out.println("This is 2 args constructor");
	}
	
	public ConstructorChain(int i, int j) { // i = 100, j = 200
		
		System.out.println("i = " + i + ",j = " + j);
	}
	
	public static void main(String[] args) {
		ConstructorChain obj = new ConstructorChain();
		
		//Teacher techer = new Teacher("Aung", "tutor");
	}
	
}

class Person {
	 String name;
	
	public Person() {
		
	}

	public Person(String name) {
		this.name = name;
	}
}

class Teacher extends Person {
	
	String position;
	
	private Teacher(String name, String pos) {
		super(name);
		this.position = pos;
		
	}
}

//class Tutor extends Teacher {
//	
//}
