package com.comparatorvcomparable;

public class Student implements Comparable<Student>{
	
	String name;
	int grade;
	
	public Student() { // no args constructor/ default constructor
		
	}
	
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}


	 //compareTo method to compare grade OR compare name
	public int compareTo(Student student) {
		
		Integer x = (Integer) this.grade;
		Integer y = student.getGrade();

		// compare name
		//return this.name.compareTo(student.getName());
		return y - x;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + "]";
	}
	
	


	
	
	

}
