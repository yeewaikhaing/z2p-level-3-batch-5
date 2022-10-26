package day9;

import java.time.LocalDate;

public class Book {

	String title;
	LocalDate publishDate;
	int price;
	
	//title = "Detective U San Shar", pDate = 1961/10/16, price = 6500
	public Book(String title, LocalDate pDate, int price) {
		this.title = title;
		this.publishDate = pDate;
		this.price = price;
	}
	// existing = book1
	public Book(Book existing) { // copy constructor
		this.title = existing.title;
		this.publishDate = existing.publishDate;
		this.price = existing.price;
	}
	
	@Override
	public String toString() {
		
		return "Title = " + this.title +
				"\nDate = " + this.publishDate +
				"\nPrice = " + this.price + " ks.";
	}
}
