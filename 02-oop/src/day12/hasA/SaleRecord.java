package day12.hasA;

import java.time.LocalDate;

public class SaleRecord {

	int id;
	LocalDate saleDate;
	Product product;
	int saleQty;
	public SaleRecord(int id, LocalDate saleDate, Product product, int saleQty) {
		super();
		this.id = id;
		this.saleDate = saleDate;
		this.product = product;
		this.saleQty = saleQty;
	}
	
	void showData() {
		System.out.print(id + "\t");
		System.out.print(saleDate + "\t");
		System.out.print(product.name + "\t");
		System.out.print(product.price + " ks.\t");
		System.out.print(saleQty + "\t");
		System.out.print((saleQty * product.price) + " ks.\n");
	}
	
	
}
