package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CrimeDao;
import com.revature.dao.SuperPrisonDao;
import com.revature.dao.SuperVillainDao;
import com.revature.model.Crime;
import com.revature.model.SuperPrisons;
import com.revature.model.SuperVillain;
import com.revature.util.HibernateUtil;

public class Driver {

	
	public static void main(String[] args) {
		initialValues();
		// run a selectAll statment from one of our Daos...like SuperPrisonDao
		SuperPrisonDao spd = new SuperPrisonDao();
		System.out.println(spd.selectAll());
		// close the Hibernate session here...
		HibernateUtil.closeSes();
		
	}
	
	public static void initialValues() {
		// Create new Crimes
		Crime c1 = new Crime("Arson", "setting something ablaze");
		Crime c2 = new Crime("Freeze", "covering a whole city in ice");
		Crime c3 = new Crime("Time Manipulation", "freeze time and rob banks");
		
		// Creaete a a new CrimeDao
		CrimeDao cd = new CrimeDao();
		
		
		// use the CrimeDao to insert the crimes
		cd.insert(c1);
		cd.insert(c2);
		cd.insert(c3);
		
		List<Crime> cList = new ArrayList<>();
		cList.add(c1);
		cList.add(c2);
		cList.add(c3);
		
		
		// Create Super Prisons,
		SuperPrisons sp1 = new SuperPrisons("Azkaban", "England");
				
		// Create SuperVillains
		SuperVillain sv1 = new SuperVillain("Joker", "Evilness", 1000000, cList, sp1);
		
		// Create a SuperPrisonDao
		SuperPrisonDao spd = new SuperPrisonDao();
		
		
		SuperVillainDao svd = new SuperVillainDao();
		svd.insert(sv1);
		
//		List<SuperVillain> svList = new ArrayList<>();
//		svList.add(sv1);
//		sp1.setVillList(svList);

//		// insert the list of super villains into super prison, then add to DB
//		spd.insert(sp1);		
//		
		
		
		
	}
	
	
	
}
