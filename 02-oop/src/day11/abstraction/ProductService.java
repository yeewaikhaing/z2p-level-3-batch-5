package day11.abstraction;

import java.util.List;

public  class ProductService extends DatabaseUtil{

	@Override
	public void insert() {
		System.out.println("INSERT INTO proudct");
		
	}

	@Override
	public void update() {
		System.out.println("UPDATE proudct SET");
		
	}

	@Override
	public boolean delete(int id) {
		System.out.println("DELETE FROM product WHERE id = " + id);
		return false;
	}

	@Override
	public Object findById(int id) {
		System.out.println("SELECT * FROM proudct id = " + id);
		return null;
	}

	@Override
	public List<Object> findAll() {
		System.out.println("SELECT * FROM product");
		return null;
	}

	
}
