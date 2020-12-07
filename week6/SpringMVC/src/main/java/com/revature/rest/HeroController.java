package com.revature.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.model.Hero;

public interface HeroController {
//	public boolean registerHero(Hero hero);
//	public List<Hero> getAllHeroes();
//	public Hero gethero(String name);
	
	ClientMessage registerHero(Hero hero);
	Hero findHero(Hero hero, HttpServletRequest request);
	List<Hero> findAllHeroes();
}
