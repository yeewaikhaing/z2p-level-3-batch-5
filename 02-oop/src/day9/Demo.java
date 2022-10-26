package day9;

public class Demo {

	public static void main(String[] args) {
		try {
			// create obj
			Employee emp1 = new Employee();
			var emp2 = new Employee();
			var emp3 = new Employee();
			
			// init data
			emp1.init("Kyaw Kyaw", 500000);
			emp2.init("Aung Aung", 600000);
			emp3.init("Hla Hla", 500000);
			// show data
			System.out.println("ID \t Name \t Salary");
			System.out.println("-------------------------");
			emp1.showData();
			emp2.showData();
			emp3.showData();
			
			emp3.changeData("Cherry", 500000);
			System.out.println("After change emp1' data");
			emp3.showData();
			
			Employee.changeNoOfEmployee(5);
			
			emp3.viewInfo();
			
			var emp4 = new Employee(); // occur exception
			emp4.showData();
		} catch (AppException e) {
			System.err.print(e.getMessage());
		}
	}
}
