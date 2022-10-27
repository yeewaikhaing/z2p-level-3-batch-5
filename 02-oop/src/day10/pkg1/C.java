package day10.pkg1;

public class C extends A{
	//private int a; // can't inherit
	// int b = 10;
	// protected int c = 10;
	// public int d = 10;
	
	void test1() {
		//a = 20; // error, private (not inherited)
		b = 20; // ok, default (inherited)
		c = 20; // ok protected (inherited)
		d = 20; // ok, public (inherited)
	}
}
