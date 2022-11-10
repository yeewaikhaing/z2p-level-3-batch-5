package day16;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_Testing {

	public static void main(String[] args) {
		//without_stream();
		with_stream();
	}

	private static void with_stream() {
		int[] prices = {1000, 700, 1600, 500, 2100, 1000, 3100, 4200, 900, 3000};
		
		// create stream
		IntStream streams = Arrays.stream(prices);
		
		streams.filter( pri -> pri > 1500) // inter-operation
				.sorted() // inter-operation
				.forEach( pri -> System.out.println(pri)); // terminal operation
		
	}

	private static void without_stream() {
		
		int[] prices = {1000, 700, 1600, 500, 2100, 1000, 3100, 4200, 900, 3000};
		
		// filter
		List<Integer> resultList = new ArrayList<>();
		
		resultList.forEach( pri -> {
		
		});
		
		for(var price: prices) {
			if(price > 1500)
				resultList.add(price);
		}
		
		// sort
		Collections.sort(resultList);
		
		// display
		for(var price: resultList) {
			System.out.println(price);
		}
		
	}
}
