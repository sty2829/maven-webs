package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortTest8 {

	public static void main(String[] args) {
		List<Map<String,String>> list = new ArrayList<>();
		Map<String,String> m = new HashMap<>();
		m.put("age", "11");
		list.add(m);
		
		m = new HashMap<>();
		m.put("age", "5");
		list.add(m);
		
		m = new HashMap<>();
		m.put("age", "3");
		list.add(m);
		
		m = new HashMap<>();
		m.put("age", "7");
		list.add(m);
		
		
		Collections.sort(list, new Comparator<Map<String,String>>() {

			@Override
			public int compare(Map<String, String> o1, Map<String, String> o2) {
				int a1 = Integer.parseInt(o1.get("age"));
				int a2 = Integer.parseInt(o2.get("age"));
				if(a1>a2) {
					return 1;
				}
				if(a1<a2) {
					return -1;
				}
				return 0;
			}

		});
		
		
		for(Map<String,String> map : list) {
			System.out.println(map);
		}
		
	}
}
