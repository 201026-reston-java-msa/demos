package com.revature;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		go();
	}
	
	public static void go() {
		// this method will ask how many students we want to create
		System.out.println("Please enter the number of students you want to create...");
		Scanner s = new Scanner(System.in);
		
		int numOfStudents = s.nextInt();
		Student[] students = new Student[numOfStudents];
		
		for (int i=0; i<numOfStudents; i++) {
			students[i] = new Student(); // for each SLOT WE WILL INSTANTIATE
			students[i].enroll(); // then we ENROLL the student in this slot (at index i)
			students[i].payTuition();
		}
		
		for (int i=0; i<numOfStudents; i++) {
			System.out.println(students[i].toString());
		}
	}

}
