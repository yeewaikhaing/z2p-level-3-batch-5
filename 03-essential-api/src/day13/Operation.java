package day13;

@FunctionalInterface
public interface Operation {

	public int calculate(int num1, int num2);
	//public void display();
	
}

class Addition implements Operation {

	@Override
	public int calculate(int num1, int num2) {
		
		return num1 + num2;
	}

	
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
}

class Division implements Operation {

	@Override
	public int calculate(int num1, int num2) {
		
		return num1 / num2;
	}

	
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
}
