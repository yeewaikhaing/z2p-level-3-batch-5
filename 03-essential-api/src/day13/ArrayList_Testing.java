package day13;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_Testing {

	public static void main(String[] args) {
		
		// create
		ArrayList<Integer> list = new ArrayList<>();
		
		//add
		list.add(100);
		list.add(200);
		list.add(0, 300);
		
		//output
		System.out.println("list[0]: " + list.get(0));
		System.out.println("data: " + list);
		
		//update
		list.set(2, 500);
		System.out.println("After update, " + list);
		
		//remove
		list.remove(1);
		System.out.println("After remove, " + list);
		
		System.out.println("Max value: " + Collections.max(list));
		
		//remove all 
		list.clear();
		System.out.println("size: " + list.size());
		
		System.out.println("---- all data ---");
//		for(var i = 0; i < list.size();i++)
//			System.out.println(list.get(i));
		
//		var i = 0;
//		while(i < list.size())
//		{
//			System.out.println(list.get(i));
//			i++;
//		}
//		for(Integer data: list) {
//			System.out.println(data);
//		}
	}
}
