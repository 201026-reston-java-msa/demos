package com.threadsdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class FileIONotes {
	
	public static void main(String[] args) {
		
		// this is an example of try with resources
		try {
			FileReader file = new FileReader("C:\\users\\downloads\\x.txt");
			BufferedReader fileInput = new BufferedReader(file);
			
			for (int i =0; i < 3; i++) {
				System.out.println(fileInput.readLine());
			}
			fileInput.close();
		} catch (IOException e) {
			// here's how we would recover
			System.out.println("File not found");
		} finally {
			System.out.println("This finally block will always run");

		}
		// IO is a Java API targeted for reading data from external sources

		
		// Print the first 3 lines of the file found at C:\\users\\downloads\\x.txt...
		
	}
	
	/*
	 * Java has 2 types of classes for input and output (IO)
	 * STREAMS
	 * READERS/WRITERS
	 * 
	 * Streams(InputStream, OutputStream are for reading binary data from files or a network
	 * 
	 * Readers are for reading and writing text in the form of characters
	 * 
	 * ** Readers act as a layer ONTO of Streams that convert byte code into characters
	 * a BUFFER will store A LOT of data in memory 
	 *
	 * 
	 */
	
	BufferedReader br = new BufferedReader(new InputStream(System.in)); 
	
	
	// System.in IS an input stream - BufferedReader is what we wrap AROUND the stream
	// in order to convert that data
	// a BufferedReader reads from an InputStream that reads from System.in...
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}


