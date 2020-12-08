package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Jedi;
import com.revature.repository.JediRepository;

@Service("jediService")
public class JediServiceForce implements JediService {

	@Autowired
	private JediRepository jediRepository;

	public JediServiceForce() {
		System.out.println("Instantiating Jedi Service Force Bean.");
	}

	// constructor injection!
	public JediServiceForce(JediRepository jediRepository) {
		System.out.println("Instantiating Jedi Service Force Bean from constructor with parameters.");
		System.out.println("Constructor Injection Happening!");
		this.jediRepository = jediRepository;
	}
	
	// Setter Injection
	public void setJediRepository(JediRepository jediRepository) {
		System.out.println("Setter Injection Happening!");
		this.jediRepository = jediRepository;
	}
	

	@Override
	public void register(Jedi jedi) {
		jediRepository.save(jedi);
	}

	@Override
	public void registerSecure(Jedi jedi) {
		jediRepository.save(jedi.getId(), jedi.getName(), jedi.getSaberColor());

	}

	@Override
	public Jedi getJedi(Jedi jedi) {
		return jediRepository.findTopByName(jedi.getName());
	}

	@Override
	public Jedi getJediNative(Jedi jedi) {
		return jediRepository.findJediNative(jedi.getName());
	}

	@Override
	public String getCurrentJediTime() {
		return jediRepository.currentJediTime();
		
	}

	@Override
	public List<Jedi> getJedisByPattern(String pattern) {
		return jediRepository.findByNameContaining(pattern);
	}

	@Override
	public List<Jedi> getAllJedis() {
		// TODO Auto-generated method stub
		return 	jediRepository.findAll();
	}

	// then we'll override some methods
}
