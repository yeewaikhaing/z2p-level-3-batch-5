package day4;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		
		//enum 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter language name: ");
		var language = sc.nextLine(); // java
		
		if(language.equals("java")) { // !=, ==
			System.out.println("Java is a compiled Language");
		}
		else if(language.equals("php")) {
			System.out.println("Php is an interpretting language");
		}
		else {
			System.out.println("Other language model");
		}
		
		sc.close();
	}
}
