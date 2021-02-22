package mancala.domain;
import java.util.Scanner;

// Make your own mancala implementation using your design.
// You can take this stub as an example how to make a 
// class inside a package and how to test it.

public class Kalaha {
	public int num_stones;
	public int player_id;

	public Kalaha(int player_id){
		this.player_id = player_id;
		this.num_stones = 0; //Always set number of stones in Kalaha to 0
	}

	public void addStones(int num){
		num_stones = num_stones + num;
	}

	public int getStones(){return num_stones;}

	public int getPlayerID(){return player_id;}

	
}