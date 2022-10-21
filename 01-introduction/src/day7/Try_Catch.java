package day7;

import java.util.Scanner;

public class Try_Catch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter number1: ");
			var num1 = sc.nextInt();
			System.out.print("Enter number2: ");
			var num2 = sc.nextInt();
			
			if(num2 == 0) {
				return;
			}
			var result = num1/num2; 
			// create exception obj
			//ArithmeticException obj = new ArithmeticException();
			// throw
			//throw obj;
			System.out.println("Result: " + result);
			
			
		}
		catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
			
		}
		catch(ArithmeticException obj) {
			System.err.println("Invalid input. Divided by Zero");
		}
		catch(Exception e) {
			System.out.println("Other case");
		}
		finally {
			sc.close();
			System.out.println("It is always executed");
		}
		
		System.out.println("outside the try catch block");
	}
}
