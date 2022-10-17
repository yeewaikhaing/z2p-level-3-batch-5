package day4;

import java.util.Scanner;

public class JavaSwtich {

	public static void main(String[] args) {
		
		//switch_statement();
		//multipleValuePerCase();
		//swtichExpression();
		switchExpressWithMultipleStatements() ;
	}

	private static void switchExpressWithMultipleStatements() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter food name: ");
		String name = sc.nextLine();
		String category = switch(name) {
			case "burger", "pizza", "sandwish" -> {
				if(name.equalsIgnoreCase("Pizza"))
					System.out.println(name + " is an italian food.");
				yield "Fast Food";
			}
			case "yogurt", "milk tea" -> {yield "Dessert";}
			case "monhinga" -> "Burmese Food";
			case "sushi" -> "Japanese Food";
			default -> "unknown";
		};
		
		System.out.println(name + " is " + category);
		sc.close();
		
	}

	private static void swtichExpression() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter food name: ");
		String name = sc.nextLine();
		String category = switch(name) {
			case "burger", "pizza", "sandwish" -> "Fast Food";
			case "yogurt", "milk tea" -> "Dessert";
			case "monhinga" -> "Burmese Food";
			case "sushi" -> "Japanese Food";
			default -> "unknown";
		};
		
		System.out.println(name + " is " + category);
		sc.close();
		
	}

	private static void multipleValuePerCase() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter food name: ");
		String name = sc.nextLine();
		String category; // 3 == 4
		switch(name) {
			case "burger", "pizza", "sandwish":
				category = "Fast Food";
				break;
			case "yogurt", "milk tea":
				category = "Dessert";
				break;
			case "monhinga":
				category = "Burmese Food";
				break;
			case "sushi":
				category = "Japanese Food";
				break;
			default:
				category = "unknown";
		}
		
		System.out.println(name + " is " + category);
		sc.close();
		
	}

	private static void switch_statement() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter food name: ");
		String name = sc.nextLine();
		String category;
		switch(name) {
			case "burger":
				category = "Fast Food";
				break;
			case "pizza":
				category = "Fast Food";
				break;
			case "sandwish":
				category = "Fast Food";
				break;
			case "yogurt":
				category = "Dessert";
				break;
			case "milk tea":
				category = "Dessert";
				break;
			case "monhinga":
				category = "Burmese Food";
				break;
			case "sushi":
				category = "Japanese Food";
				break;
			default:
				category = "unknown";
		}
		
		System.out.println(name + " is " + category);
		sc.close();
		
	}
	
	
}
