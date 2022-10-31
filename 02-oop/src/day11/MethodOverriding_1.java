package day11;

public class MethodOverriding_1 {

	public static void main(String[] args) {
		
		Teacher teacher = new Teacher("U Kyaw Kyaw", "Tutor");
		teacher.showInfo();
		
		Person person = new Person("U Aung Aung");
		person.showInfo();
		
		Person person2 = new Teacher("Jeon", "Lecturer");
		
		person2.showInfo();
		
		
	}
}
