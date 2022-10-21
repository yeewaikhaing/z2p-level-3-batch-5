package day7;

public class JavaStringBuffer {

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer("Java Programming");
		
		buffer.append(" is a high level programming.");
		System.out.println("After append, " + buffer);
		
		buffer.insert(0, "Php");
		System.out.println("After insert, " + buffer);
		
		buffer.replace(0, 3, "");
		System.out.println("After replace, " + buffer);
		
		System.out.println("Len: " + buffer.length());
		System.out.println("index of 'level': " + buffer.indexOf("level"));
		
		System.out.println("substr: " + buffer.substring(0, 150));
		
		buffer.delete(0, 5);
		System.out.println("After delete, " + buffer);
		
		
		
		
	}
}
