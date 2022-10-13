package day2;

public class Testing_1 {
	
	// global place(outside all method) - fields
	private int num2; // instance field/variable
	boolean flag; // instance field/variable
	private static int num3; // static field/variable
	//var name = "Su Su";
	
	public void display() { // instance method
		//static int num1 = 0;
		//private int num1 = 0;
		//int num1;
		int num1 = 10;
		System.out.println("Num1 = " + num1);
		System.out.println("Num2 = " + num2); //0
		System.out.println("Num3 = " + num3);
		System.out.println("flag = " + flag); // false
		
		var num2 = 100;
		var num3 = 3.5;
		var num4 = "Kyaw kyaw";
		var num5 = true;
		
		//int a, b, c;
		//var a = 10, b = 30;
		//var num5;
		//var num5 = null;
		
		//return num2;
		show();
		init();
	}
	// object = instance
	public void show() {
		
	}
	
	public static void init() {
		// just call only static data(variable or method)
		//show();
		add();
		//System.out.println("Num2 = " + num2);
		System.out.println("Num3 = " + num3);
	}
	
	public static void add() {
		
	}
	public static void main(String[] args) { // static method
		//display();
		Testing_1 obj = new Testing_1(); // create obj
		obj.display();
		System.out.println("Num2 = " + obj.num2);
		System.out.println("Num3 = " + num3);
		//int num1;
		//System.out.println("Num1 = " + num1);
	}
}
