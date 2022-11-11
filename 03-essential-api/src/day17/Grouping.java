package day17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import day16.Emplyee;

public class Grouping {

	public static void main(String[] args) {
		
		List<Emplyee> empList = Arrays.asList(
				new Emplyee("kyaw kyaw", 9800, "yangon"),
				new Emplyee("aung aung", 6000, "mandalay"),
				new Emplyee("maung maung", 10000, "mandalay"),
				new Emplyee("yuri", 6000, "yangon"),
				new Emplyee("jeon", 6000, "monywa")
		);
		
		// count by city
		Map<String, Long> counting = empList.stream()
										.collect(Collectors.groupingBy( 
												emp -> emp.getCity(), // key
												Collectors.counting() // value
											)
										);
		// total salary by each city
		Map<String, Integer> sum = empList.stream()
										.collect(Collectors.groupingBy(
												emp -> emp.getCity(),
												Collectors.summingInt(emp -> emp.getSalary())
											)
										);
		// avg salary in each city
		Map<String, Double> avg = empList.stream()
										.collect(Collectors.groupingBy(
												emp -> emp.getCity(),
												Collectors.averagingDouble(emp -> emp.getSalary())
											)
										);
		
		System.out.println("no of employee in each city: " + counting);
		System.out.println("total salary in each city: " + sum);
		System.out.println("avg salary in each city: " + avg);
		
		// employees in each salary
		Map<Integer, List<Emplyee>> salary = empList.stream()
												.collect(Collectors.groupingBy(emp -> emp.getSalary()));
		
		System.out.println("------ Employee in each salary --------");
		salary.forEach( (k, v) -> {
			System.out.println(k + " ks.");
			v.forEach( emp -> {
				System.out.printf("\t %s(%s)\n", emp.getName(), emp.getCity());
			});
		});
		
		// employee names in each city
		Map<String, List<String>> names = empList.stream()
											.collect(Collectors.groupingBy(
													emp -> emp.getCity(), // key
													Collectors.mapping(
															emp -> emp.getName(), // obj -> string
															Collectors.toList()) 
					
												)
											);
	
		System.out.println("------ emplyee names in each city------");
		names.forEach((k, v) -> {
			System.out.println(k);
			System.out.println("\t " + v);
			System.out.println("-------------");
		});
		
		// employees who stay in the same city
		Map<String, List<Emplyee>> employees = empList.stream()
													.collect(
														Collectors.collectingAndThen(Collectors.groupingBy(emp -> emp.getCity()), 
																
															map -> map.entrySet() // Map<City, List<Employee>
																	.stream()
																	.filter(value -> value.getValue().size() > 1)
																	.collect(Collectors.toMap(
																			value -> value.getKey(), // city(key)
																			value -> value.getValue() // List<emp> (value)
																			)
																		)
														)
															
												);
		System.out.println("------ employee who staty in the same city ------");
		employees.forEach((k, v) -> {
			System.out.println(k);
			v.forEach(obj -> {
				System.out.println("\t" + obj.getName());
			});
		});
	}
}
