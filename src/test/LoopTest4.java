package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result3{
	private List<Map<String,String>> datas = new ArrayList<>();
	private int idx = 0;
	
	public Result3() {
		for(int i=0; i<=2; i++) {
			Map<String,String> data = new HashMap<>();
			data.put("name", "이름" + i);
			data.put("age", i+"");
			datas.add(data);
		}
	}
	
	public boolean next() {
		return datas.size() > idx ++;
	}
	
	public String getString(String key) {
		Map<String,String> data = datas.get(idx-1);
		return data.get(key);
	}
}

public class LoopTest4 {

	public static void main(String[] args) {
		
		Result3 rs = new Result3();
		while(rs.next()) {
			String name = rs.getString("name");
			int age = Integer.parseInt(rs.getString("age"));
			
			System.out.println("이름은 : " + name + " 나이는 : " + age);
		}
	}
}
