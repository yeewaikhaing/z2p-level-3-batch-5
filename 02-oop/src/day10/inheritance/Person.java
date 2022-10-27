package day10.inheritance;

public class Person {

	private String name;
	protected String phone;
	
	public Person() {
		System.out.println("Person's default constructor");
	}
	
	public Person(String name, String phone) { //"kyaw kyaw", "12345"
		System.out.println("Person's argument constructor");
		this.name = name;
		this.phone = phone;
	}
	
	void display() {
		System.out.println("Name - " + name);
		System.out.println("Phone - " + phone);
	}
	
}
