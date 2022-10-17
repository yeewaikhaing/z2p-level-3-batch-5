package day4;

public class LoopingStatement {

	public static void main(String[] args) {
		String languages[] = {
				"Python", "Java", "Javascript"
		};
		
		// for loop
		System.out.println("------- For Loop -------");
		for(var i = 0; i < languages.length;i++) {
			System.out.println("language: " + languages[i]);
		}
		
		// while loop
		System.out.println("------ while loop ------");
		int j = 0;
		while (j < languages.length) {
			String lang = languages[j];
			System.out.println("language: " + lang);
			j++;
		}
		
		// do while loop
		System.out.println("------- do while --------");
		int k = 0;
		do {
			String lang = languages[k];
			System.out.println("language: " + lang);
			k++;
		} while (k < languages.length);
		
		// foreach loop
		System.out.println("------ for each -------");
		for(String lang : languages) {
			System.out.println("language: " + lang);
		}
	}
}
