package day16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping_1 {

	public static void main(String[] args) {
		
		List<Emplyee> empList = Arrays.asList(
				new Emplyee("kyaw kyaw", 9800, "yangon"),
				new Emplyee("aung aung", 6000, "mandalay"),
				new Emplyee("maung maung", 10000, "mandalay"),
				new Emplyee("yuri", 6000, "yangon"),
				new Emplyee("jeon", 6000, "monywa")
		);
		
		// distinct cities
		List<String> cities = empList.stream()	
									.map(obj -> obj.getCity())
									.distinct()
									.collect(Collectors.toList());
		
		System.out.println("cities: " + cities);
		
		// salaries array
		int[] salaries = empList.stream()
							.filter(obj -> obj.getSalary() > 6000)
							.mapToInt(obj -> obj.getSalary())
							.toArray();
		
		System.out.println("salaries: " + Arrays.toString(salaries));
		
		// salary list
		List<Integer> salaryList = empList.stream()
										.map(obj -> obj.getSalary())
										.filter(val -> val < 10000)
										.limit(3)
										.toList();
		System.out.println("salaries: " + salaryList);
		
		// max salary
		int max_salary = empList.stream()
							.mapToInt(emp -> emp.getSalary())
							.max()
							.getAsInt();
		System.out.println("Max salary: " + max_salary);
	}
}
