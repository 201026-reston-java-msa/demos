package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repository.JediRepository;

@Service("jediService")
public class JediServiceForce implements JediService{

	@Autowired
	private JediRepository jediRepository;
	
	// then we'll override some methods 
}
