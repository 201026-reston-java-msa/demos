package com.revature.dao;
/*
 * Session methods:
 * 
 * save() and persist() ---- result in a SQL insert
 * update() and merge() ---- result in a SQL update
 * saveOrUpdate() ---------- result in a SQL insert OR update (depends)
 * get() and load()	-------- result in a SQL select 
 * 
 * 
 * There are 3 different ways to create complex queries in Hibernate:
 * 
 * 1. HQL - Hibernate Query Language
 * 2. Criteria API
 * 3. Native SQL 
 * 
 */

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.model.SuperVillain;
import com.revature.util.HibernateUtil;

public class SuperVillainDao {

	public SuperVillainDao() {
		
	}
	
	public void insert(SuperVillain villain) {
		Session ses = HibernateUtil.getSession(); // capture the session
		Transaction tx = ses.beginTransaction();  // perform an operation on DB
		
		ses.save(villain); // use the save() session method to perform an insert operation
		tx.commit(); // commit the transaction by utilizing the methods from the Transaction interface
	}

	public void update (SuperVillain villain) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(villain);
		tx.commit();
	}
	
	public SuperVillain selectById(int id) {
		Session ses = HibernateUtil.getSession();
		SuperVillain vill = ses.get(SuperVillain.class, id);
		
		return vill;
	}
	
	public SuperVillain selectByName(String name) {
		Session ses = HibernateUtil.getSession();
		
		// HQL -- Hibernate Query Language
		// creates a complex query using a combination of Native SQL & OOP
		// HQL targets Java Objects, NOT SQL tables
		List<SuperVillain> villList = ses.createQuery("from SuperVillain where name='"+name+"'", SuperVillain.class).list();
		
		// CRITERIA API 
		// Creates complex queries programatically. It only uses OOP
		// Criteria API only target Java Objects
//		List<SuperVillain> villList2 = ses.createCriteria(SuperVillain.class).add(Restrictions.like("name", name)).list();
		
		// NATIVE SQL
		// Create complex queries using plain old SQL queries
		// Native SQL targets SQL tables, NOT java Objects
//		List<SuperVillain> villList3 = ses.createNativeQuery("SELECT * FROM Super_Villain WHERE name = '"+name+"'", SuperVillain.class).list();
//		
		
		
		if(villList.size()==0) {
			System.out.println("PANIC!");
			return null;
		}
		
		return villList.get(0);
	}
	
	public List<SuperVillain> selectAll(){
		Session ses = HibernateUtil.getSession();
		
		// This is an example of HQL --> HQL will check for the class name (of our java models)
		List<SuperVillain> villList = ses.createQuery("from SuperVillain", SuperVillain.class).list();
		// HQL is returning all instances of the SuperVillain class
		// no needfor transaction object here We are just querying Data, NOT commiting any changes to our database, hence it's not a transaction
		return villList;
	}
	
}
