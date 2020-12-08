package com.revature.service;

import java.util.List;

import com.revature.model.Jedi;

public interface JediService {
	// here we'll define the basic methods our service layer provides
	public void register(Jedi jedi);
	public void registerSecure(Jedi jedi);
	public Jedi getJedi(Jedi jedi);
	public Jedi getJediNative(Jedi jedi);
	public String getCurrentJediTime();
	public List<Jedi> getJedisByPattern(String pattern);
	public List<Jedi> getAllJedis();
	
}
