package com.revature;

import com.revature.dao.BankDaoImpl;
import com.revature.dao.Dao;
import com.revature.model.BankAccount;
import com.revature.model.BankUser;

public class MainClass {
	
	/*
	 * 	Hibernate: 
	 * 	this example is to access the database through hibernate
	 * 		Hibernate is built on top of JDBC
	 * 
	 * 	Hibernate has 3 states:
	 * 		-transient
	 * 		-persistent
	 * 		-detached
	 * 
	 * 	Automatic Dirty Checking (dirty means the java object doesn't match the table record)
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		
//		hibernateReadExample();
//		hibernateReadAccount();
		getVsLoad();
	}
	
	
	public static void hibernateReadExample(){
		System.out.println("hello world");
		
		//Instantiate a Hibernate Dao
		Dao dao = new BankDaoImpl();
		
		//Instantiate a BankUser Mapped to a Table, provide the primary key
		BankUser user = new BankUser(1, null, null, null, null);
		
		//Use the pojo to pull the record from the table
		user = dao.getBankUserById(user);
		
		//Sysout the returned record
		System.out.println(user);
	}
	public static void hibernateReadAccount(){
		System.out.println("hello world");
		
		//Instantiate a Hibernate Dao
		Dao dao = new BankDaoImpl();
		
		//Instantiate a BankUser Mapped to a Table, provide the primary key
		BankAccount account = new BankAccount();
		account.setBaNumber(1);
		
		//Use the pojo to pull the record from the table
		account = dao.getBankAccountById(account);
		
		//Sysout the returned record
		System.out.println(account);
	}
	
	
	
	public static void hiberateCreateExample(){
		//Instantiate a Hibernate Dao
		Dao dao = new BankDaoImpl();
						
		//Instantiate a BankUser Mapped to a Table, provide the primary key
		BankUser user = new BankUser("jen","123", "generator", "values");
				
		dao.createUser(user);
		System.out.println("done saving user to db");
	}
	
	public static void getVsLoad(){
		/*
		 *  2 similar methods for the Read operation of CRUD
		 *  		get(class to instantiate, the record's primary key)
		 *  		load( 
		 */
		BankUser user = new BankDaoImpl().getBankUserByGetOrLoad();
		System.out.println(user.getUsername());
		System.out.println(user.getClass());
	}

}
