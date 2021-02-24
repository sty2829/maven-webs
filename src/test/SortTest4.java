package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest4 {

	public static void main(String[] args) {
		
		List<Integer> numList = new ArrayList<>();
		numList.add(30);
		numList.add(10);
		numList.add(20);
		numList.add(5);
		
		Collections.sort(numList, Collections.reverseOrder());
		for(int num : numList) {
			System.out.println(num);
		}
	}
}
