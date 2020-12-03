package com.example.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This is a Spring Bean...we just have to configure the ApplicationContext to define it as such
// A Spring Bean is a Java POJO that is managed by the Spring IoC Container
public class MotdServiceBean {
	
	protected List<String> motds = new ArrayList<>();
	protected int defaultMotdIndex;
	
	// Once a spring bean has an instance, it will be able to invoke this method
	public String getMotd(int motdIndex) {
		if (motdIndex < 0 || motdIndex > motds.size()) { 
			return motds.get(defaultMotdIndex);
		}
		return motds.get(motdIndex);
	}
	
	// this will be configured using a custom init lifecycle hook
	// to invoke this method when the bean is instantiated
	// -- we do this in the application-context.xml file in our resources
	protected void initMotds() {
		motds.addAll(Arrays.asList("Good Morning",
			"The first step of the journey is always the most difficult",
			"You always pass failure on your way to success",
			"It seems impossible until it is done",
			"Positive anything is always better than negative nothing"));
	}
	
	// this is method will be configured to inject a values from the application
	// into this class property using setter injection
	public void setDefaultMotdIndex(int defaultMotdIndex) {
		this.defaultMotdIndex = defaultMotdIndex;
	}
	
	

}
