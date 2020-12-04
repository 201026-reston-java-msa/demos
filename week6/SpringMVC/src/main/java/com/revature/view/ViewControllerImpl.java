package com.revature.view;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("viewController") // the @Controller this marks the class as a ewb request handler
public class ViewControllerImpl implements ViewController{

	private static Logger logger = Logger.getLogger(ViewControllerImpl.class);
	
	// We are mapping requests to this particular controller 
	// This annotation specifies what types of requests this class handles
	@RequestMapping(value = { "/", "/index"}, method = RequestMethod.GET)
	public String index() {
		logger.info("Getting index HTML from View Controller");
		return null;
	}

	
}
