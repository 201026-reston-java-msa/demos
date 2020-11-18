package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.Table;

// We communicate with the Schema through hibernate by using Annotations
// to define our tables, columns, and relationships (think cardinality i.e
// one-to-one, one-to-many, etc...


@Entity
@Table(name="Super_Villain")
public class SuperVillain {
	
	private int svillId;
	
	private String name;
	
	private String superPower;
	
	private double bounty;
	
	private List<Crime> crimes;
	
	private SuperPrisons superPrisonHolder;
	
	public SuperVillain() {
		
	}


	public SuperVillain(int svillId, String name, String superPower, double bounty, List<Crime> crimes,
			SuperPrisons superPrisonHolder) {
		super();
		this.svillId = svillId;
		this.name = name;
		this.superPower = superPower;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}


	public SuperVillain(String name, String superPower, double bounty, List<Crime> crimes,
			SuperPrisons superPrisonHolder) {
		super();
		this.name = name;
		this.superPower = superPower;
		this.bounty = bounty;
		this.crimes = crimes;
		this.superPrisonHolder = superPrisonHolder;
	}
	
	
}







