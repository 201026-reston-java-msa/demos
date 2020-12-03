package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.SuperVillain;
import com.example.repository.VillainDao;

// This is a stereotype annotation which primes this class to be injected into another
// Stereotype components are crucial when we are using @Annoation-based configuration
@Component("villServ")
public class VillainServiceImpl implements VillainService{
// in the old way, without DI
	// private VillainDao villainDao = new VillainDaoImpl();
	
	
	// with DI....
	//@Autowired  // using autowired above a property tells spring to attempt byName or byType
	private VillainDao villainDao;
	
	public static int counter = 0;
	
	public VillainServiceImpl() {
		System.out.println("In Service Layer: no args to construct");
		counter++;
	}
	
	@Autowired // using autowired above a constructor tells spring to attempt autowiring using this constructor
	public VillainServiceImpl(VillainDao villainDao) {
		System.out.println("In Service Layer: DI constructor");
		counter++;
		this.villainDao = villainDao;
	}
	
	// for the sake of demonstrating the difference between XML configuration and annotations
	public VillainServiceImpl(VillainDao villainDao, int num) {
		System.out.println("In the Service Layer: DI constructor with int argument " + num);
		counter ++;
		this.villainDao = villainDao;
	}
	
	@Override
	public List<SuperVillain> getAllVills() {
		return villainDao.selectAll();
	}
	
}
