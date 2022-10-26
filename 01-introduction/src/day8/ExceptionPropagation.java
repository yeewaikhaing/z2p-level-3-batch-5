package day8;

public class ExceptionPropagation {

	public static void main(String[] args) {
		test3(); // exception
	}

	private static void test3() {
		test2(); // exception
		
	}

	private static void test2() {
		test1();// exception
		
	}

	private static void test1() {
		System.out.println("100/0 = " + 100/0); // exception
		
	}
}

class Testing {
	int[] numbers = new int[5];
	
	public Testing(String data[]) {// {}
		
	}
}
