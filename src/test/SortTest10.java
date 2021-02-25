package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Rabbit implements Comparable<Rabbit>{
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Rabbit [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int compareTo(Rabbit o) {
		if(age>o.getAge()) {
			return -1;
		}
		if(age<o.getAge()) {
			return 1;
		}
		return 0;
	}
	
	
}

public class SortTest10 {

	public static void main(String[] args) {
		List<Rabbit> rList = new ArrayList<>();
		Rabbit r = new Rabbit();
		r.setName("깜둥이");
		r.setAge(5);
		rList.add(r);
		
		r = new Rabbit();
		r.setName("흰둥이");
		r.setAge(1);
		rList.add(r);
		
		r = new Rabbit();
		r.setName("재둥이");
		r.setAge(3);
		rList.add(r);
		
		Collections.sort(rList);
		
		for(Rabbit ra : rList) {
			System.out.println(ra);
		}
		
	}
	
}
