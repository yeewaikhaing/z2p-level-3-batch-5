package day3;

public class JavaMethods {

	int num1 = 100; // instance field
	static int num2 = 200; //static field
	
	static void staticMethod1() {//static method
		//num1 = 300; // can't use (num1 is instance data)
		num2 = 300; // ok (num2 is static data)
		staticMethod2(); // ok (num2 is static data)
		//this.num1 = 300;
	}
	void instanceMethod1() { //instance method
		System.out.println("This is instance method");
		num1 = 300;
		num2 = 400;
		staticMethod2();
	}
	static void staticMethod2() {
		System.out.println("This is static method 2");
	}
	
}
