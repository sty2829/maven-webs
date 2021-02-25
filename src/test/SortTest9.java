package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
	
	private String name;
	private int age;
	private int grade;
	
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "student [name=" + name + ", age=" + age + ", grade=" + grade + "]";
	}
	
}

public class SortTest9 {

	public static void main(String[] args) {
		List<Student> sList = new ArrayList<>();
		Student s = new Student();
		s.setName("꺽정");
		s.setAge(10);
		s.setGrade(4);
		sList.add(s);
		
		s = new Student();
		s.setName("길동");
		s.setAge(5);
		s.setGrade(1);
		sList.add(s);
		
		s = new Student();
		s.setName("청이");
		s.setAge(9);
		s.setGrade(2);
		sList.add(s);
		
		s = new Student();
		s.setName("콩쥐");
		s.setAge(10);
		s.setGrade(2);
		sList.add(s);
		
		s = new Student();
		s.setName("팥쥐");
		s.setAge(4);
		s.setGrade(1);
		sList.add(s);
		
//		Collections.sort(sList, new Comparator<Student>() {
//
//			@Override
//			public int compare(Student o1, Student o2) {
//				int s1 = o1.getAge() + o1.getGrade();
//				int s2 = o2.getAge() + o2.getGrade();
//				if(s1 > s2) {
//					return -1;
//				}
//				if(s1 < s2) {
//					return 1;
//				}
//				return 0;
//			}
//		});
		
		Collections.sort(sList, new Comparator<Student>(){

			@Override
			public int compare(Student o1, Student o2) {
				
				if(o1.getGrade() > o2.getGrade()) {
					return -1;
				}
				if(o1.getGrade() < o2.getGrade()) {
					return 1;
				}
				if(o1.getAge() > o2.getAge()) {
					return 1;
				}
				if(o1.getAge() < o2.getAge()) {
					return -1;
				}
				return 0;
			}
			
		});
		
		for(Student student : sList) {
			System.out.println(student);
		}
	}
}
