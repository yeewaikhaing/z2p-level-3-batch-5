package day8;

public class ThrowingException {

	public static void main(String[] args)throws ArrayIndexOutOfBoundsException {
		
		try {
			checkMark(200);
			int[] data = {100, 200, 300};
			int index = 10;
			
			if(index >= data.length) {
				//ArrayIndexOutOfBoundsException obj = new ArrayIndexOutOfBoundsException("Index out of range");
				//throw obj;
				throw new ArrayIndexOutOfBoundsException("Index out of range");
			}
			
			System.out.println("result: " + data[index]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.print(e.getMessage());
		}
		catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void checkMark(int mark)  {
		if(mark < 0 || mark > 100) {
			throw new ArithmeticException("Invalid mark");
		}
	}
}
