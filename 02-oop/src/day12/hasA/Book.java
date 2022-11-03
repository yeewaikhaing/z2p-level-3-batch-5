package day12.hasA;

public class Book {

	String name;
	int price;
	Author author; // Has-A relationship
	
	
	//name = "War and Peace", price = 15000, author = auth("Mya Than Tint", "Myaing")
	public Book(String name, int price, Author author) {
		super();
		this.name = name;
		this.price = price;
		this.author = author;
	}
	
	
	
}
