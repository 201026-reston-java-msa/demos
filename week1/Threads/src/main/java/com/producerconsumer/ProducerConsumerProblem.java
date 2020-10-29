package com.producerconsumer;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerProblem {
	
	public static final int NUM_OF_PRODS = 2;
	public static final int NUM_OF_CONS = 8;

	public static void main(String[] args) throws InterruptedException{

		System.out.println(Thread.currentThread().getName());
		
		// This is the only queue object in memory
		// ALL threads will share this queue
		// PLEASE NOTE that the size of this queue is limited to 10 integers
		// the producers will have to first wait for the consumers
		// before they continue producing.
		Queue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
		
		// We create a ton of producer threads here now
		Set<Producer> producers = new HashSet<Producer>();
		
		for (int i=0; i< NUM_OF_PRODS; i++) {
			Producer p = new Producer();
			p.setQueue(queue);
			producers.add(p);
		}
		
		// AND add a bunch of consumer threads
		Set<Consumer> consumers = new HashSet<Consumer>();
		 for (int i=0; i< NUM_OF_CONS; i++) {
			 Consumer c = new Consumer();
			 c.setQueue(queue);
			 consumers.add(c);
		 }
		
		 // We start the producers first...
		 for(Producer p : producers) {
			 p.start();
		 }
		 
		 // Wait a second....
		 Thread.sleep(200);
		 
		 for(Consumer c : consumers) {
			 c.start();
		 }
	}
	
	// by this point the only thread that will continue is OUR threads becasue the main thread will have ended.

}
