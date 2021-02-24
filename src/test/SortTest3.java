package test;

import java.util.ArrayList;
import java.util.List;

public class SortTest3 {

	public static void main(String[] args) {
		
		List<Integer> numList = new ArrayList<>();
		numList.add(10);
		numList.add(1);
		numList.add(7);
		numList.add(3);
		numList.add(5);
		
		for(int i=0; i<numList.size()-1; i++) {
			for(int j=i+1; j<numList.size(); j++) {
				if(numList.get(i) > numList.get(j)) {
					int tmp = numList.get(i);
					numList.remove(i);
					numList.add(i, numList.get(j));
					numList.remove(j);
					numList.add(j, tmp);
				}
			}
		}
		
		System.out.println(numList);
	}
}
