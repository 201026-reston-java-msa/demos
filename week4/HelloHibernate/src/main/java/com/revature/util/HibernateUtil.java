package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static Session ses;
	// We will use the SessionFactory interface to create a Configuration()
	//Object which will call the .configure method on on our "hibernate.cfg.xml"
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	// We will create a getSession() method which is called in our DAO layer
	// This method obtains a JDBC connection which we use to perform a 
	// transaction against our DB
	public static Session getSession() {
		if(ses==null) {
			ses=sf.openSession();
		}
		return ses;
	}
	
	// This closes an active connection 
	public static void closeSes() {
		ses.close();
		sf.close();
		// By closing our session, you free up the connections from the connection
		// pool to be used by a new session.
	}
	
	
}








