package com.example;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.VillainService;
import com.example.service.VillainServiceImpl;

public class Main {
	
	/*
	 * What is Spring?
	 * 
	 * -- It is a module based open source framework.  It provides 
	 * support for enterprise level applications.  It provides the infrastructure,
	 * so you can focus on your app's business logic.
	 * 
	 * What is a module?
	 * 
	 * -- It is a groups of libraries that work together to achieve some goal
	 * using reusable, abstracted code.
	 * 
	 * What are some Spring Modules?
	 * -- Core, context, ORM, AOP, WEB-MVC, security, test
	 * 
	 * How does Spring achieve all of these goals?
	 * -- Inversion of Control (IoC)
	 * -- Aspect Oriented Programming (AOP)
	 * -- MVC
	 * -- Abstraction API (Spring Data)
	 * 
	 * What is Bean Wiring?
	 * -- creating an association between spring's bean container and an object
	 * that you want spring to manage.
	 * 
	 * ** In Spring, this is done with the "Spring Container" which injects
	 * our registered objects (or our Spring Beans)
	 * 
	 * 
	 * ***IoC container is represented by an ApplicationContext or BeanFactory?
	 * We can manage the lifecycle of beans, and provide dependencies wehre necessary.
	 * 
	 * ** The Spring Container is at the core of the Spring Framework...
	 * it will create, wire, and configure objects (beans)
	 * 
	 * **Scopes of a Spring Bean (which we configure in our application context):
	 * - Singleton (default scope of a Spring Bean)
	 * - Prototype (multiple instances of the bean)
	 * - Request (exists within an HTTP request)
	 * - Session (exists within a HTTP session)
	 * - GlobalSession (exists within all HTTP sessions)
	 * 
	 * ** LifeCycle of a Spring Bean
	 * I - Instantiate
	 * P - Populate Properties
	 * N - setName
	 * F - setFactory
	 * C - setApplicationContext
	 * 
	 * B - BeforePostProcessing
	 * A - AfterPopulateProperties
	 * C - customInit
	 * A - AfterPostProcessing
	 * 
	 * U - Use
	 * D - Destroy
	 * D - customDestroy
	 * 
	 * What is the ApplicationContext?
	 * -- ApplicationContext is a BeanFactory.  It literally inherits from a BeanFactory Interface
	 * It adds more functionality (like event publication and eager instantiation)
	 */
	
	
	private static VillainService villServ;
	
	// This main method is demonstrating how we start up Spring's IoC container;
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		// we should increment the counter every time
		
		villServ = ac.getBean("villServ", VillainService.class);
		
		System.out.println("Counter: " + VillainServiceImpl.counter);
		cleanPrint(villServ.getAllVills());
	}
	
	public static <T> void cleanPrint(List<T> myList) {
		System.out.println("The List:");
		for (T listItem: myList) {
			System.out.println(listItem);
		}
	}

}
