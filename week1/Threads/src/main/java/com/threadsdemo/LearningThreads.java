package com.threadsdemo;

public class LearningThreads {
	
	// A thread is an independent path of execution through program code
	// Threads are light-weight sub-processes that share common memory space
	
	/*
	 * A thread can be in 1 of the following states:
	 * 
	 * 1. NEW - a thread that hasn't started yet
	 * 2. RUNNABLE - the thread executing in the JVM
	 * 3. BLOCKED - waiting for a monitor lock
	 * 4. WAITING - waiting indeifinitely for another thread to perform a particular action
	 * 5. TIMED_WAITING - a thread that is waiting for another thread during a certain time
	 * 6. TERMINATED - a thread that has exited  
	 */
	
	public static void main(String[] args) {
		
		Task taskRunner = new Task();
		taskRunner.setName("A");
		taskRunner.start();  
		
		System.out.println("Hello there....");
		
		
		Task taskRunner2 = new Task();
		taskRunner2.setName("B");
		taskRunner2.start();
		
	}
	
	// what does the start() method do ?
	
	/*
	 * 1. it starts a new thread
	 * 2. the thread moves from NEW state to RUNNABLE state
	 * 3, when the thread gets a change to execute, its target run() method will run.
	 */

}
// Challenge: name the instances of the thread
class Task extends Thread{
	
//	String name;
//	
//	public Task(String name) {
//		this.name = name;
//	}


	public void run() {
		
		//Thread.currentThread().setName(name);
		
		for (int i=0; i<1000; i++) {
			System.out.println("number: " + i + Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}









