package day10.inheritance;

public class MethodOverriding {

	public static void main(String[] args) {
		Cat obj = new Cat();
		obj.sound();
		obj.show();
		
		System.out.println("----------");
		Animal obj2 = new Animal();
		obj2.sound(); //
		
		obj2 = obj; // obj2 => cat
		obj2.sound(); //
	}
}

class Animal {
	void show() {
		System.out.println("This is show method");
	}
	void sound() {
		System.out.println("Speck with some sound");
	}
}

class Cat extends Animal {
	
	@Override
	void sound() { // overriding 
		System.out.println("Myaung");
	}
}
