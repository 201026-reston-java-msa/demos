package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Jedi;
import com.revature.service.JediService;

public class Main {
	
	public static void main(String[] args) {
		// instantiate the AppContext
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get a JediService Bean
		JediService jediService = appContext.getBean("jediService", JediService.class);
		
		// Register some Jedis
		System.out.println("Registering Jedis");
		jediService.register(new Jedi(0, "Obi Wan", "Blue"));
		jediService.register(new Jedi(0, "Yoda", "Green"));
		jediService.register(new Jedi(0, "Mace Windu", "Purple"));
	
		
		//Return all
		System.out.println("All Jedis: " + jediService.getAllJedis());
//		
//		//Return Yoda
		System.out.println("Getting Yoda: " + jediService.getJedi(new Jedi("Yoda")));
		
		// Get %c%
		System.out.println("Get %c% Jedis: " + jediService.getJedisByPattern("c"));
		
		System.out.println("Getting current Time: " + jediService.getCurrentJediTime());

		
	}
	
}
