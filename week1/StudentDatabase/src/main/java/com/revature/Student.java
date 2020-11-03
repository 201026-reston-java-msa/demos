package com.revature;

import java.util.Scanner;

public class Student {

	/* 
	 * Generate at least 8 private fields 
	 * hint: costOfCourse and id may be static 
	 * since they're shared across all objects of this Class
	 */
	private String firstName;
	private String lastName;
	private int gradeYear;
	private int studentID;
	private String courses = "";
	private int tuitionBalance;
	
	private static int costOfCourse = 600; // true across all objects of type Student
	private static int id = 1000;
	
	/*
	 *  Constructor: incorporate the instantiation of a Scanner 
	 *  and prompt user to enter student's name and year
	 *  
	 *  add setID() into the Constructor logic
	 */
	public Student() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the student's first name:");
		this.firstName = s.nextLine();
		
		System.out.println("Enter the student's last name:");
		this.lastName = s.nextLine();
		
		System.out.println("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\n Enter the grade year:");
		this.gradeYear = s.nextInt();
		
		setStudentID();

	}
	
	/* 
	 * setID() method that increases the static field and 
	 * incorporates the student's grade number to make it unique
	 */
	private void setStudentID() {
		// grade level & ID 
		id++;
		this.studentID = gradeYear + id;
	}
	
	// Generate an enroll() method
	public void enroll() {
		do {
			System.out.println("Enter course to enroll in. Press Q to quit:");
			Scanner s = new Scanner(System.in);
			String course = s.nextLine();
			
			if (!course.toUpperCase().equals("Q")) {
				courses = courses + " \n" + course;
				tuitionBalance += costOfCourse;
			} else {
				break;
			}
			
		} while (true);
		
		System.out.println("ENROLLED IN: " + courses);
		System.out.println("TUITION BALANCE: " + tuitionBalance);
	}
	
	// viewBalance()
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	// payTuition()
	public void payTuition() {
		viewBalance();
		System.out.println("Enter your payment:");
		Scanner s = new Scanner(System.in);
		int payment = s.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", gradeYear=" + gradeYear
				+ ", studentID=" + studentID + ", courses=" + courses + ", tuitionBalance=" + tuitionBalance + "]";
	}
	
}
















