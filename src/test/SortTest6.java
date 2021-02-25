package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest6 {

	public static void main(String[] args) {
		
		List<String> strList = new ArrayList<>();
		
		strList.add("1");
		strList.add("11");
		strList.add("2");
		strList.add("13");
		List<Integer> numList = new ArrayList<>();
		for(String str : strList) {
			numList.add(Integer.parseInt(str));
		}
		
		Collections.sort(numList);
		
		strList = new ArrayList<>();
		
		for(Integer num : numList) {
			strList.add(Integer.toString(num));
		}
		
		System.out.println(strList);
	}
}
