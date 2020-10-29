package com.producerconsumer;

import java.util.Queue;

/*
 * LIVELOCK - is when two or more threads keep repeating a particular piece of code.
 * This is a recursive situation. 1 thread is responding to the other, and the other is doing the same
 * 
 * DEADLOCK - this is when one thread is waiting on another thread , and the other thread is doing the same
 * 
 * both of these situations prevent the threads from progressing
 * 
 * SYNCHRONIZATION - is the concurrent execution of two or more threads that share critiical 
 * resources (memory)...like a buffer.
 * 
 * PRODUCER/CONSUMER problem: 2 processes: a producer and a consumer share a fixed-size buffer
 * (like a queue set to a particular capacity)...
 * The producer's job is to generate data and store it within the buffer
 * The consumer's job is to consume data/remove it from the buffer
 * 
 * However...if neither are doing their job and removing data/adding data at the wrong times, 
 * we enter into this situation...
 */

public class Consumer extends Thread {
	// This is the buffer that will be shared with other threads
	// Remember that all threads share the same heap
	// This means that all threads will have reference to the same object
	// (There is only ONE queue in memory...
	private Queue<Integer> q;

	public void run() {
		
		try {
			while(true) {
				
				// This prevents multiple threads from accessing the same queue object at the same
				// time.  Java will block the other threads while one thread is using it.
				synchronized (q) {
					while(q.isEmpty()) {
						System.out.println("Consumer " + getName() + " falling asleep");
						
						q.wait();
						
						
					}
						int val = q.remove(); // Queue's are FIFO
					
						System.out.println("Reading value: " + val);
						
						q.notifyAll();
						
						Thread.sleep(4);
					
				}
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	public void setQueue(Queue<Integer> q) {
		this.q = q;
	}
		
}
