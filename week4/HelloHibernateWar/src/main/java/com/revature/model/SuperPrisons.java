package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Super_Prison")
public class SuperPrisons {
	
	@Id
	@Column(name="spId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int spId;
	
	@Column(name="sp_name")
	private String spName;
	
	@Column(name="sp_location")
	private String location;
	
	// here we will signal to hibernate that this is the key for the relationship
	// that we are fetching in our SuperVillain table
	@OneToMany(mappedBy="superPrisonHolder", fetch=FetchType.LAZY)
	private List<SuperVillain> villList = new ArrayList<>();
	
	public SuperPrisons() {
		
	}

	public SuperPrisons(int spId, String spName, String location, List<SuperVillain> villList) {
		super();
		this.spId = spId;
		this.spName = spName;
		this.location = location;
		this.villList = villList;
	}

	public SuperPrisons(String spName, String location, List<SuperVillain> villList) {
		super();
		this.spName = spName;
		this.location = location;
		this.villList = villList;
	}
	
	public SuperPrisons(String spName, String location) {
		super();
		this.spName = spName;
		this.location = location;
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<SuperVillain> getVillList() {
		return villList;
	}

	public void setVillList(List<SuperVillain> villList) {
		this.villList = villList;
	}

	@Override
	public String toString() {
		return "SuperPrisons [spId=" + spId + ", spName=" + spName + ", location=" + location + ", villList=" + villList
				+ "]";
	}


}
