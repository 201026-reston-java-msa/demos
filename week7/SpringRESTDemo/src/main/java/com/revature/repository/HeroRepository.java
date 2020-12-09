package com.revature.repository;

import java.util.List;

import com.revature.model.Hero;

public interface HeroRepository {
	// This repository is ONLY FOR HEROES! >:O
	// Only Heroes allowed....no supervillains (or anything else)
	void save (Hero hero);
	List<Hero> findAll();
	Hero findByName(String name);
}
