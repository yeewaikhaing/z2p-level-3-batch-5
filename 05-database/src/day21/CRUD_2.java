package day21;

import java.util.List;
import java.util.Scanner;

public class CRUD_2 {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)){
			String data = """
					1. Add
					2. Update
					3. Delete according to Id
					4. Delete All
					5. Select
					Choose (1, 2, 3, 4, 5):""";
			
			System.out.print(data);
			int input = Integer.parseInt(sc.nextLine());
			switch (input) {
			case 1:
				add(sc);
				break;
			case 2:
				upate(sc);
				break;
			case 3:
				DatabaseService.deleteAll();
				break;	
			case 4:
				System.out.print("Enter product Id to delete: ");
				int pId = Integer.parseInt(sc.nextLine());
				DatabaseService.deleteById(pId);
				System.out.println("success...");
			case 5:
				select(sc);
				break;
			default:
				break;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void select(Scanner sc) {
		
		String data = """
				1. All product
				2. Single Product
				3. Search with Name
				4. Filter by Price
				5. New Arrival
				Choose number: """;
		System.out.print(data);
		var input = Integer.parseInt(sc.nextLine());
		if(input == 1) {
			List<Product> list = DatabaseService.findAll();
			if(list.size() == 0)
				System.err.println("There is no data");
			else {
				System.out.println("ID \t Name \t Price");
				System.out.println("----------------------------");
				list.forEach(obj -> {
					System.out.println(obj.getId() + " \t " + obj.getName() + " \t " + obj.getPrice() + "ks.");
				});
			}
		}// all prdouct
		else if(input == 2) {
			System.out.print("Enter proudct id: ");
			int productId = Integer.parseInt(sc.nextLine());
			Product prod = DatabaseService.findById(productId);
			if(prod == null) {
				System.err.print("Product with this id is not found");
			}
			else {
				System.out.println("ID: " + prod.getId());
				System.out.println("Name: " + prod.getName());
				System.out.println("Prie: " + prod.getPrice());
			}
		}// single product
		else if(input == 5) {
			List<Product> list = DatabaseService.getNewArrivals();
			displayProducts(list);
		}// new arrival
		else if(input == 4) {
			System.out.print("Enter min price: ");
			float min = Float.parseFloat(sc.nextLine());
			System.out.print("Enter max price: ");
			float max = Float.parseFloat(sc.nextLine());
			
			List<Product> list = DatabaseService.filterByPrice(min, max);
			displayProducts(list);
		}// end of filter by price
		else if(input == 3) {
			System.out.print("Enter product name: ");
			String product_name = sc.nextLine();
			
			List<Product> list = DatabaseService.filterByName(product_name);
			displayProducts(list);
		}
		
	}

	private static void displayProducts(List<Product> list) {
		System.out.println("No \t Name \t Price");
		System.out.println("----------------------");
		for(var i = 0; i < list.size();i++) {
			var obj = list.get(i);
			System.out.print((i + 1) + " \t " + obj.getName() + " \t " + obj.getPrice() + " ks.");
			System.out.println();
		}
		
	}

	private static void upate(Scanner sc) {
		try {
			System.out.print("Enter product Id to update:");
			var id = Integer.parseInt(sc.nextLine());
			System.out.println("Enter new data");
			System.out.print("Name: ");
			var name = sc.nextLine();
			System.out.print("Price: ");
			var price = Float.parseFloat(sc.nextLine());
			
			DatabaseService.update(name, price, id);
			System.out.println("Update success....");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void add(Scanner sc) {
		
		try {
			System.out.println("Enter data for new product");
			System.out.print("Name: ");
			var name = sc.nextLine();
			System.out.print("Price: ");
			var price = Float.parseFloat(sc.nextLine());
			
			DatabaseService.save(name, price);
			System.out.println("Insert success....");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
