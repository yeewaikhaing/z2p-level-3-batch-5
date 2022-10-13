package day2;

public class Testing_2 {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.rno = 1; // accessing instance data via obj(obj.data)
		Student.univeristy_name = "UCSM"; // accessing static/class data via className( classname.data)
		
		s1.show();
		
		Student s2 = new Student();
		s2.rno = 2;
		s2.univeristy_name = "UCSY";
		
		s2.show();
		
		System.out.println("----------");
		s1.show();
		
	}

}
