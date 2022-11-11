package day17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Collecting {

	public static void main(String[] args) {
		
		Student[] students = {
				new Student(10, "cherry", "yangon"),
				new Student(2, "cherry", "mandalay"),
				new Student(5, "khaing", "monywa"),
				new Student(1, "htet", "mandalay"),
				new Student(11, "htet yadanar", "yangon")
		};
		
		Set<String> names = Arrays.stream(students)
								.map(std -> std.getName())
								.collect(Collectors.toSet());
		
		TreeSet<Integer> rnos = Arrays.stream(students)
									.map(std -> std.getRno())
									.collect(Collectors.toCollection(TreeSet::new));
		
		List<String> cities = Arrays.stream(students)
									.map(std -> std.getCity())
									.collect(Collectors.toList());
		Map<Integer, String> map1 = Arrays.stream(students)
										.collect(Collectors.toMap(
												obj -> obj.getRno(),  // key
												obj -> obj.getName() //value
											));
		
		Map<Integer, Student> map2 = Arrays.stream(students)
										.filter(obj -> !obj.getCity().equals("yangon"))
										.collect(Collectors.toMap(
												Student::getRno, // key
												s -> s // value
											));
		System.out.println("map1: " + map1);
		map2.forEach((k,v) -> {
			System.out.println("Rno -> " + k);
			System.out.println("Name -> " + v.getName());
			System.out.println("City -> " + v.getCity());
		});
		System.out.println("--------------");
		System.out.println("names: " + names);
		System.out.println("Rnos: " + rnos);
		System.out.println("Cities: " + cities);
	}
}
