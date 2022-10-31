package day11;

public class MethodOverriding_2 {

	public static void main(String[] args) {
		
		Developer dev = new Developer();
		dev.work(); // developer's work
		
		dev = new FronendDeveloper();
		dev.work(); // frontend developer's work
		
		dev = new BackendDeveloper();
		dev.work(); // backend developer's work
		
	}
}

class Developer {
	void work() {
		System.out.println("Some work");
	}
}
class FronendDeveloper extends Developer {
	
	@Override
	void work() {
		System.out.println("Working with frontend tech");
	}
}

class BackendDeveloper extends Developer {
	@Override
	void work() {
		System.out.println("Working with backend tech");
	}
}
