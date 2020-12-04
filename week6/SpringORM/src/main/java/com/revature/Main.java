package com.revature;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Hero;
import com.revature.service.HeroService;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		HeroService heroService = appContext.getBean("heroService", HeroService.class);

		// Let's register some heroes and persist them into the DB
		logger.trace((heroService.registerHero(new Hero("Dr. Strange", "knowledge", true)))
				? "Dr.Strange registered successfully"
				: "Couldn't register hero.");

		// Let's register some heroes and persist them into the DB
		logger.trace((heroService.registerHero(new Hero("Flash", "superspeed", false)))
				? "flash success"
				: "Couldn't register hero.");

		// Let's register some heroes and persist them into the DB
		logger.trace((heroService.registerHero(new Hero("Batman", "money", false)))
				? "batman success"
				: "Couldn't register hero.");

		// Let's register some heroes and persist them into the DBsuperman 
		logger.trace((heroService.registerHero(new Hero("Superman", "literally everything", true)))
				? "superman success"
				: "Couldn't register hero.");
		
		
		//Select Heroes 
		logger.trace("Getting all heroes: " + heroService.getAllHeroes()) ;

		
//		// Find by Name
		logger.trace("Selecting Flash: " + heroService.getHero("Flash")) ;

	}

}
