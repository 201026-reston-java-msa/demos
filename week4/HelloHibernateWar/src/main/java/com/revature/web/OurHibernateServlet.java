package com.revature.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.CrimeDao;
import com.revature.dao.SuperPrisonDao;
import com.revature.dao.SuperVillainDao;
import com.revature.model.Crime;
import com.revature.model.SuperPrisons;
import com.revature.model.SuperVillain;


public class OurHibernateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static SuperVillainDao svdao = new SuperVillainDao();
	public static CrimeDao crdao = new CrimeDao();
	public static SuperPrisonDao prdao = new SuperPrisonDao();
       

    public OurHibernateServlet() {
        // Here we will invoke the initialValues() method
    	initialValues();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// we will select a supervillain by name
		System.out.println("In doGet");
		System.out.println("\nAbout to select by name: ");
		
		System.out.println(svdao.selectByName("Joker"));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// select all
		System.out.println("In doPost");
		System.out.println("\nAbout to select All: ");
		System.out.println(svdao.selectAll());
	}
	
	public static void initialValues() {
		// Create new Crimes
		Crime c1 = new Crime("Arson", "setting something ablaze");
		Crime c2 = new Crime("Freeze", "covering a whole city in ice");
		Crime c3 = new Crime("Time Manipulation", "freeze time and rob banks");
		
		// Create a a new CrimeDao
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
		
	}

}
