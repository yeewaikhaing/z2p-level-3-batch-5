package day17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import day16.Emplyee;

public class Reduction {

	public static void main(String[] args) {
		
		List<Emplyee> empList = Arrays.asList(
				new Emplyee("kyaw kyaw", 9800, "yangon"),
				new Emplyee("aung aung", 6000, "mandalay"),
				new Emplyee("maung maung", 10000, "mandalay"),
				new Emplyee("yuri", 6000, "yangon"),
				new Emplyee("jeon", 6000, "monywa")
		);
		
		//bulit-in reduction
		int totalSalary = empList.stream()
								.mapToInt(emp -> emp.getSalary())
								.sum();
		double avgSalary = empList.stream()
								.mapToDouble(emp -> emp.getSalary())
								.average()
								.getAsDouble();
		
		int maxSalary = empList.stream()
							.mapToInt(emp -> emp.getSalary())
							.max()
							.getAsInt();
		long count = empList.stream()
						.filter(emp -> emp.getSalary() > 6000)
						.count();
		Emplyee maxEmp = empList.stream()
							.max(Comparator.comparingInt(emp -> emp.getSalary()))
							.get();
		Emplyee minEmp = empList.stream()
							.min((e1,e2) -> e1.getSalary() - e2.getSalary() )
							.get();
				
		System.out.println("Total Salary: " + totalSalary);
		System.out.println("Average salary: " + avgSalary);
		System.out.println("Maximum salary: " + maxSalary);
		System.out.println("No of employee: " + count);
		System.out.println("Employee who got max salary: " + maxEmp);
		System.out.println("Emplyee who got min salary: " + minEmp);
		System.out.println("--------------------");
		
		// custom reduction
		totalSalary = empList.stream()
							.map(emp -> emp.getSalary())
							.reduce(0, (sal1, sal2) -> sal1 + sal2);
		
		int minSalary = empList.stream()
							.map(emp -> emp.getSalary())
							.reduce(Integer::min)
							.get();
		minEmp = empList.stream()
					.reduce((e1, e2) -> e1.getSalary() < e2.getSalary() ? e1 : e2)
					.get();
		
		System.out.println("Total Salary: " + totalSalary);
		System.out.println("Minimum Salary: " + minSalary);
		System.out.println("Employee who got min salary: " + minEmp);
		//System.out.println("min value: " + Integer.min(100, 200));
	}
}
