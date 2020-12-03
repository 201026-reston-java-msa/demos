package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.services.MotdServiceBean;

// This is a bean that will be configured to inject an instance of the 
//com.example.services.MotdServiceBean into THIS bean using constructor injection.

public class Main {
	
	private MotdServiceBean motdServiceBean;
	
	public Main() {}
	
	public Main(MotdServiceBean motdServiceBean) {
		this.motdServiceBean = motdServiceBean;
	}
	
	public static void main(String[] args) {
		// Here, we're going to run this example manually
		
		// create the application context by loading it from our classpath
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
		// the above object is our configured application context...
		
		
		//Let's get a reference to our MainBean
		Main mainBean = ac.getBean("MainBean", Main.class);
		
		// Now we should be able to invoke a method (getMotd) from the ref to 
		//  motdServiceBean
		System.out.println(mainBean.motdServiceBean.getMotd(4));
		
		// then close the application context
		ac.close();
		
		
		
	}

}
