package com.revature.rest;

import java.util.List;

import com.revature.model.Hero;

public interface HeroController {
	public boolean registerHero(Hero hero);
	public List<Hero> getAllHeroes();
	public Hero gethero(String name);
}
