package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  			// Marks the app as a SpringBootApplication
									// This annotation encompasses several other annotations 
									// including: @Configuration, @EnableAutoConfirguration
									// @ComponentScan -- If we need to add any additional configuration,
									// We can add it with ease
public class Application {
	

	public static void main(String[] args) {
		/*
		 * One of the main features of Spring Boot is that the application will deploy
		 * itself.  When the main method is run, we call SpringApplication.run(Application.class, args);
		 * which will deploy your app to a Tomcat Server which has been spun up by the app for exactly
		 * that purpose
		 */
		
		SpringApplication.run(Application.class, args);
	}

}
