package day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Browsing_DirectoryContents {

	public static void main(String[] args) throws IOException {
		
		Path path = Path.of(".");
		
		// using list()
		System.out.println("------ Using Files.list()---------");
		Files.list(path)
				.forEach(p -> System.out.println(p));
		
		// using walk()
		System.out.println("------ Using Files.walk()---------");
		Files.walk(path)
			.forEach(p -> System.out.println(p));
		
		System.out.println("------- only folder ----------");
		Files.walk(path)
				.filter(p -> Files.isDirectory(p))
				.forEach(System.out::println);
		
		System.out.println("------- only java file ---------");
		Files.walk(path)
				.filter(p -> p.toString().contains(".java"))
				.forEach(System.out::println);
		
		
	}
}
