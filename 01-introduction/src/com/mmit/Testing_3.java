package com.mmit;

import day2.Student;
import day2.Testing_1;

// syntax -> import pkg.data;

public class Testing_3 {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.rno = 12;
		System.out.println("rno = " + s1.rno);
		s1.rno = 100;
		System.out.println("rno = " + s1.rno);
	}
}
