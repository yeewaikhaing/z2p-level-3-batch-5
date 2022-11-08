package day15;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class LinkHashMap_testing {

	public static void main(String[] args) {
		
		//linkHashMap();
		Tree_Map();
		
	}

	private static void Tree_Map() {
		TreeMap<Integer, String> students = new TreeMap<>();
		
		students.put(1, "Aung Aung");
		students.put(11, "Naung Naung");
		students.put(2, "Kyaw Kyaw");
		
		System.out.println("students: " + students);
		
		students.replace(2, "Honey");
		System.out.println("2 => " + students.get(2));
		
	}

	private static void linkHashMap() {
LinkedHashMap<Integer, String> students = new LinkedHashMap<>();
		
		students.put(1, "Aung Aung");
		students.put(11, "Naung Naung");
		students.put(2, "Kyaw Kyaw");
		
		System.out.println("students: " + students);
		
		students.replace(2, "Honey");
		System.out.println("2 => " + students.get(2));
		
	}
}
