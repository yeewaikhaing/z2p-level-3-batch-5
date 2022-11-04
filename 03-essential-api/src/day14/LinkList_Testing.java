package day14;

import java.util.LinkedList;

public class LinkList_Testing {

	public static void main(String[] args) {
		
		LinkedList<String> linkList = new LinkedList<>();
		
		linkList.add("Nilar");
		linkList.add(0, "Aung Aung");
		linkList.add("Kyaw Kyaw");
		
		System.out.println(linkList);
		
		linkList.addFirst("Honey");
		linkList.addLast("Hla Hla");
		
		System.out.println(linkList);
		
		System.out.println("[0]: " + linkList.get(0));
		System.out.println("last: " + linkList.getLast());
	}
}
