package day8.oop;

public class PhoneDemo {

	public static void main(String[] args) {
		
		Phone phone1 = new Phone("mi", "black"); // default constructor
		//phone1.brand = "mi";
		
		Phone phone2 = new Phone("samsung", "white");
		//phone2.brand = "samsung";
		
		System.out.println("phone1's price: " + phone1.price);
		System.out.println("phone2's price: " + phone2.price);
	}
}
