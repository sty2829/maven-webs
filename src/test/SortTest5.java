package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person{
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
public class SortTest5 {

	public static void main(String[] args) {
		List<Person> pList = new ArrayList<>();
		Person p = new Person();
		p.setName("동동");
		p.setAge(6);
		pList.add(p);
		p = new Person();
		p.setName("꺾정");
		p.setAge(5);
		pList.add(p);
		p.setName("호우");
		p.setAge(3);
		pList.add(p);
		p = new Person();
		p.setName("카이");
		p.setAge(8);
		pList.add(p);

		Collections.sort(pList, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if(o1.getAge() > o2.getAge()) {
					return 1;
				}
				if(o1.getAge() < o2.getAge()) {
					return -1;
				}
				return 0;
			}
		});
		
		for(Person person : pList) {
			System.out.println(person);
		}
	}
}
