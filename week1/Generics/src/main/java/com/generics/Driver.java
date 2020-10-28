package com.generics;

public class Driver {

	public static void main(String[] args) {
		FootballPlayer tom = new FootballPlayer("Tom");
		BaseballPlayer bob = new BaseballPlayer("Bob");
		SoccerPlayer beckham = new SoccerPlayer("Beckham");

		Team<FootballPlayer> patriots = new Team<FootballPlayer>("Patriots");
		patriots.addPlayer(tom);

//		patriots.addPlayer(bob);
		
//		Team patriots = new Team("Patriots");
//		patriots.addPlayer(tom);
//		patriots.addPlayer(bob);
//		patriots.addPlayer(beckham);

		
		System.out.println(patriots.numPlayers());

	}

}
