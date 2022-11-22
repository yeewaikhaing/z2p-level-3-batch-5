package day21;

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
		// TODO Auto-generated method stub
		
	}

	private static void upate(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	private static void add(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
}
