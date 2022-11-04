package day14.assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {

	private static List<String> categoryList = new ArrayList<>();
	private static List<Author> authorList = new ArrayList<>();
	private static List<Book> bookList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		try(
				Scanner sc = new Scanner(System.in);
			) {
			
			init();
			String confirm = null;
			do {
				String data = """
						1. view author
						2. view category
						3. view book
						4. add book
						Choose (1, 2, 3 or 4):""";
				System.out.print(data);
				
				var input = Integer.parseInt(sc.nextLine());
				
				switch(input) {
				case 1:
					view_author();
					break;
				case 2:
					view_category();
					break;
				case 3:
					view_book(sc);
					break;
				case 4:
					add_book(sc);
					break;
				default:
					System.err.println("Invalid input");
				}
				System.out.println("If you want to continue?, Press 'y': ");
				confirm = sc.nextLine();
			} while (confirm.equals("y"));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void add_book(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	private static void view_book(Scanner sc) {
		
		String data = """
				1. view all
				2. view by category
				3. view by author
				Please Choose(1, 2 or 3): """;
		System.out.print(data);
		var input = Integer.parseInt(sc.nextLine());
		if(input == 1)
			view_all_book();
		else if(input == 2)
			view_by_category(sc);
		else if(input == 3)
			view_by_author(sc);
		else
			System.err.println("Invalid input");
		
	}

	private static void view_by_author(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	private static void view_by_category(Scanner sc) {
		System.out.print("Enter category name: ");
		var input_category = sc.nextLine();
		var result = findByCategory(input_category);
		
		if(result == null) {// not found
			System.err.println("This category does not exist");
		}
		else { // category exist
			
			List<Book> resultList = new ArrayList<>();
			bookList.forEach( book -> {
				if(book.getCategory().equals(result)) {
					resultList.add(book);
				}
			});
			
			if(resultList.size() > 0) { 
				System.out.println("Code \t Title \t PublishDate \t Author");
				System.out.println("------------------------------------------");
				resultList.forEach(obj -> {
					System.out.print(obj.getCode() + " \t ");
					System.out.print(obj.getTitle() + " \t ");
					System.out.print(obj.getPublishDate() + " \t ");
					System.out.print(obj.getAuthor().getName()+ " \n ");
					
				});
			}
			else { // no book
				System.err.println("Thers is no book in this category");
			}
		}
		
	}

	private static String findByCategory(String input) {
		String category = null;
		
		for(var cat: categoryList) {
			if(cat.equals(input)) {
				category = input;
				break;
			}
		}
		
		return category;
	}
	private static void view_all_book() {
		// TODO Auto-generated method stub
		
	}

	private static void view_category() {
		System.out.println("ID \t Name");
		System.out.println("---------------");
		for(var i = 0; i < categoryList.size(); i++) {
			System.out.println((i + 1) + " \t " + categoryList.get(i));
		}
		
	}

	private static void view_author() {
		// TODO Auto-generated method stub
		
	}

	private static void init() {
		
		// add category
		String[] categories = {"category 1", "category 2", "category 3", "category 4"};
		categoryList.addAll(Arrays.asList(categories));
		
		// add author
		List<Author> authors = List.of(
				new Author("aung aung", "myanmar"),
				new Author("kyaw kyaw", "India")
				);
		authorList.addAll(authors);
		
		// add book
		
		var book1 = new Book();
		book1.setCode(1001);
		book1.setTitle("Title 1");
		book1.setPublishDate(LocalDate.now());
		book1.setCategory(categoryList.get(0));
		book1.setAuthor(authorList.get(1));
		
		var book2 = new Book();
		book2.setCode(1002);
		book2.setTitle("Title 2");
		book2.setPublishDate(LocalDate.now());
		book2.setCategory(categoryList.get(1));
		book2.setAuthor(authorList.get(1));
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(new Book(1003, "Title 3", LocalDate.now(), categoryList.get(0), authorList.get(1)));
		
		
		
	}
}
