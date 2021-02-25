package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortTest7 {

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
		
		List<Map<String,Integer>> iMapList = new ArrayList<>();
		
		for(Map<String,String> map : list) {
			Map<String, Integer> iMap = new HashMap<>();
			iMap.put("age", Integer.parseInt(map.get("age")));
			iMapList.add(iMap);
		}
		
		
		Collections.sort(iMapList, new Comparator<Map<String,Integer>>() {

			@Override
			public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
				return (o1.get("age") > o2.get("age") ? 1 : (o1.get("age") < o2.get("age") ? -1 : 0));

			}
		});
		
		list = new ArrayList<>();
		for(Map<String,Integer> iMap : iMapList) {
			Map<String,String> sMap = new HashMap<>();
			sMap.put("age", Integer.toString(iMap.get("age")));
			list.add(sMap);
		}
		
		for(Map<String,String> map : list) {
			System.out.println(map);
		}
		
	}
}
