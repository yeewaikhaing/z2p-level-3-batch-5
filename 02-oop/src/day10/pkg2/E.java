package day10.pkg2;

import day10.pkg1.A;

public class E extends A{

	//int b; // default -> different pkg(not inherited)
	// protected int c = 10; // protected ( inherited)
	// public int d = 10;
	void test1() {
		//b = 20;
		this.c = 20;
		this.d = 20;
		A obj = new A();
		//obj.c = 20; // error=> protected
		obj.d = 20 ;// ok => public
		
	}
	
}
