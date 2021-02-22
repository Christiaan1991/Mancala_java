package mancala.domain;
import java.util.Scanner;

// Make your own mancala implementation using your design.
// You can take this stub as an example how to make a 
// class inside a package and how to test it.

public class Player {

	private int player_id;
	private Player new_player;
	private Bowl first_bowl;

	//default constructor
	public Player(int player_id){
		this.player_id = player_id;

		first_bowl = new Bowl(player_id, 0, 4); //create first bowl with player_id, bowl_id 0 and 4 stones, and more bowls from there

		if(player_id < 2){
			new_player = new Player(player_id + 1); //create new player if player if < 2
		}

	}

	public int getPlayerID(){return player_id;}

	//public int getOtherPlayerID(){return new_player.getPlayerID();}

	//public int getBowlIDThroughPlayer(){return bowl.getBowlID();}

	//public int getNextBowlIDThroughPlayer(){return bowl.goNextBowl().getBowlID();}

	// public int bowlsTest(int num){
	// 	return bowl.getBowlID();
	// 	// while(num != bowl.getBowlID()){
	// 	// 	bowl = bowl.goNextBowl();
	// 	// }
	// 	// return bowl.getStones();
	// 	//return bowl.getBowlID();
	// }

	public int turn(int bowlNo){
		int returnedStones;
		
		returnedStones = first_bowl.move(bowlNo);
		return returnedStones;
	}

	

}