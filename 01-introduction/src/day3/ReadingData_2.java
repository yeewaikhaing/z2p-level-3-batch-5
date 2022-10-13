package day3;

import java.util.Scanner;

public class ReadingData_2 {

	public static void main(String[] args) {
		
		// create stream
		Scanner sc = new Scanner(System.in);
		// operate
		System.out.print("Enter name");
		String name = sc.nextLine();
		System.out.print("Enter salary: ");
		double sal = sc.nextDouble();
		System.out.print("Enter age: ");
		int age = sc.nextInt();
		sc.nextLine();// need it after nextType() is used.
		System.out.print("Ener bonus: ");
		int bonus = Integer.parseInt(sc.nextLine());
		//int bonus = sc.nextInt();
		
		System.out.println("------ Profile --------");
		System.out.println("Name: " + name);
		System.out.println("Salary: " + sal);
		System.out.println("Age: " + age);
		System.out.println("Bonus: " + bonus);
		//close
		sc.close();
	}
}
