package day10.pkg2;

import day10.pkg1.A;

public class D {

	void test() {
		A obj = new A();
		//obj.a = 20; // error (private)
		//obj.b = 20; // error => default (different pkg)
		//obj.c = 20; // error => protected (different pkg & non-subclass)
		obj.d = 20; // ok => public
	}
}
