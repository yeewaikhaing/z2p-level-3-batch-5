package day8.oop;

public class Phone {

	//fields
	String brand = new String(); // instance field
	String color;
	int price;
	
	
	// constructor
	public Phone(String brand, String color) {
		this.brand = brand;
		this.color = color;
		System.out.println("This is arg constructor");
	}
	
	public Phone() {
		System.out.println("This is default constructor");
	}
	// method
	public void call() {
		System.out.println("Calling Processing at here!");
	}
	
	public void takeCamera() {
		System.out.println("Taking photo at here");
	}
	
	{
		System.out.println("This is instance block");
		if(brand.equals("mi"))
			price = 100;
		else if(brand.equals("samsung"))
			price = 200;
	}
	
	static {
		System.out.println("This is static block");
	}
	
}
