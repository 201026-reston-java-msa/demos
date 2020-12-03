package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.SuperVillain;

@Repository()
public class VillainDaoImpl implements VillainDao {

	/**
	 * This is a MOCK Dao Implementation.
	 * Instead of going to a db, it has a hardcoded list of villains
	 */
	@Override
	public List<SuperVillain> selectAll() {
		List<SuperVillain> vills = new ArrayList<>();
		
		vills.add(new SuperVillain("Penguin", "SuperFreeze", 280_000));
		vills.add(new SuperVillain("RoboCop", "Technopath", 100_000));
		vills.add(new SuperVillain("Dave", "Transformation", 220_000));
		vills.add(new SuperVillain("LavaDude", "FireBursts", 110_000));
		
		return vills;
	}
	

}
