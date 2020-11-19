package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.SuperPrisons;
import com.revature.util.HibernateUtil;

public class SuperPrisonDao {

	
	public void insert(SuperPrisons prison) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(prison);
		tx.commit();
	}
	
	public void update (SuperPrisons p) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(p);
		tx.commit();
	}
	
	public SuperPrisons selectById(int id) {
		Session ses = HibernateUtil.getSession();
		SuperPrisons prisons = ses.get(SuperPrisons.class, id);
		
		return prisons;
	}
	
	public List<SuperPrisons> selectAll() {
		Session ses = HibernateUtil.getSession();
		
		// Use HQL 
		List<SuperPrisons> prisons = ses.createQuery("from SuperPrisons", SuperPrisons.class).list();
		
		return prisons;
		
	}
	
	
	
	
}
