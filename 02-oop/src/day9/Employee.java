package day9;

public class Employee {

	static int noOfEmplyee = 3;
	static int nextId = 1;
	String name;
	int salary;
	
	final int empId;
	
	public Employee() throws AppException {
		if(nextId > noOfEmplyee) { //  4 > 3
			throw new AppException("Sorry! Limited number has been reached");
		}
		empId = nextId;
		nextId++;
	}
	
	//name = "Hla Hla", salary = 500000
	public void init(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	//newName = "Cherry", newSalary = 500000
	public void changeData(String newName, int newSalary) {
		if(!this.name.equalsIgnoreCase(newName)) // abc Abc => true
			this.name = newName;
		if(this.salary != newSalary)
			this.salary = newSalary;
	}
	
	public void showData() {
		//System.out.println(this.empId + "\t" + this.name + "\t" + this.salary + " ks.");
		System.out.format("%d \t %s \t %d\n", this.empId, this.name, this.salary);
	}
	
	public static void changeNoOfEmployee(int count) {// count = 5
		//this.name = "aung"
		//super()
		noOfEmplyee = count;
		///salary = 1000;
	}
	
	public void viewInfo() {
		System.out.println("Total emp: " + noOfEmplyee);// access static data
		System.out.println("---- Current Employee----");
		this.showData();
		System.out.println("Next emp's Id: " + nextId);
	}
}
