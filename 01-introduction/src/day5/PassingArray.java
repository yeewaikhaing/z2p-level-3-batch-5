package day5;

import java.util.Arrays;

public class PassingArray {

	public static void main(String[] args) {
		int[] arr1 = {
				100, 200, 300
		};
		
//		System.out.println("Before, " + Arrays.toString(arr1));
//		changeValue(arr1);
//		System.out.println("After, " + Arrays.toString(arr1));
		
//		int num = 100;
//		
//		System.out.println("Before, num = " + num);
//		changeValue(num);
//		System.out.println("After, num = " + num);
		
		Student s = new Student();
		s.rno = 1;
		System.out.println("Before, Rno: " + s.rno);
		changeRno(s);
		System.out.println("After, Rno: " + s.rno);
	}

	private static void changeRno(Student input) {
		input.rno = 5;
		
	}

	private static void changeValue(int input) {
		input = 500;
		System.out.println("Inside, input " + 500);
		
	}

	private static void changeValue(int[] input) {
		
		input[1] = 400;
		
	}
}
class Student {
	int rno;
}
