package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
// JPA (Java Persistence API) is the specification and Hibernate is the implementation


// We communicate with the Schema through hibernate by using Annotations
// to define our tables, columns, and relationships (think cardinality i.e
// one-to-one, one-to-many, etc...

// This is a JPA specification that is implemented by Hibernate
@Entity
@Table(name="Super_Villain")
public class SuperVillain {
	
	@Id
	@Column(name="svill_id")
	@GeneratedValue(strategy=GenerationType.AUTO) // this acts like the SERIAL datatype in SQL
	private int svillId;
	
	@Column(name="name", unique=true, nullable=false)
	private String name;
	
	@Column(name="superpower")
	private String superPower;
	
	@Column(name="bounty")
	private double bounty;
	
	// We can specify relationships between entities (tables) using an annotation
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	// Fetching is related to querying amongst related tables
	private List<Crime> crimes;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="Prison_FK")
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


	public int getSvillId() {
		return svillId;
	}


	public void setSvillId(int svillId) {
		this.svillId = svillId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSuperPower() {
		return superPower;
	}


	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}


	public double getBounty() {
		return bounty;
	}


	public void setBounty(double bounty) {
		this.bounty = bounty;
	}


	public List<Crime> getCrimes() {
		return crimes;
	}


	public void setCrimes(List<Crime> crimes) {
		this.crimes = crimes;
	}


	public SuperPrisons getSuperPrisonHolder() {
		return superPrisonHolder;
	}


	public void setSuperPrisonHolder(SuperPrisons superPrisonHolder) {
		this.superPrisonHolder = superPrisonHolder;
	}


	@Override
	public String toString() {
		return "SuperVillain [svillId=" + svillId + ", name=" + name + ", superPower=" + superPower + ", bounty="
				+ bounty + ", crimes=" + crimes + ", superPrisonHolder=" + superPrisonHolder + "]";
	}
	
}







