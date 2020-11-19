package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Crime;
import com.revature.util.HibernateUtil;

public class CrimeDao {

	public void insert(Crime crime) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(crime);
		tx.commit();
	}
	
	// the rest of the methods within this DAOImplementation would be very similar to the SuperVillainDao
}
