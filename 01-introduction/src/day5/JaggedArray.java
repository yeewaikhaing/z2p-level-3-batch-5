package day5;

public class JaggedArray {

	public static void main(String[] args) {
		int[][] data = {
				{100, 200},
				{100, 200, 300},
				{100}
		};
		
		System.out.println("----- for looping -----");
		for(var r = 0; r < data.length;r++) {
			for(var c = 0; c< data[r].length;c++) {
				System.out.print(data[r][c] + "\t");
			}
			System.out.println();
		}
	}
}
