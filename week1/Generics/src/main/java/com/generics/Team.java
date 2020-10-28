package com.generics;

import java.util.ArrayList;

public class Team<T extends Player> { // what we're doing here is restricting the type of object that can be added to a team

	private String name;
	int played = 0;
	int won = 0;
	int lost = 0;
	int tied = 0;
	
	private ArrayList<Player> members = new ArrayList<Player>();

	public Team(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// we will add methods such as adding a players
	// make it boolean to determine whether it's successful or not.
	public boolean addPlayer(T player) {
		if (members.contains(player)) {
			System.out.println(player.getName() + " is already on the team.");
			return false;
			
		} else {
			members.add(player);
			System.out.println(player.getName() + " picked for team " + this.name);
			return true;
		}
	}
	
	// we will return the number of players on a team
	public int numPlayers() {
		return this.members.size();
	}
	
	// we will create a Match result method 
	public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
		
		String message;
		
		if (ourScore > theirScore) {
			won++;
			message = " beat ";
		} else if (ourScore == theirScore) {
			tied++;
			message = " tied with ";
		} else {
			lost++;
			message = " lost to ";
		}
		played++;
		
		// we're adding this bit of code so that we can save our score 
		// and also update records for the opponents team
		if(opponent != null) {
			System.out.println(this.getName() + message + opponent.getName());
			opponent.matchResult(null, theirScore, ourScore);
		}
		
	}
	
	public int ranking() {
		return (won * 2) + tied;
	}
	
		
}
