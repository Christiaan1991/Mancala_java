package mancala.domain;

// Make your own mancala implementation using your design.
// You can take this stub as an example how to make a 
// class inside a package and how to test it.

public class Kalaha {
	public int num_stones;
	private int player_id;
	private Player new_player;
	private Player first_player;

	public Kalaha(Player first_player, int player_id){
		this.player_id = player_id;
		this.num_stones = 0; //Always set number of stones in Kalaha to 0

		if(player_id < 1){
			new_player = new Player(first_player, player_id + 1); //create new player with constructor
		}

		if(player_id == 1){ //only then we need the first_player
			this.first_player = first_player;
		}
	}

	public Player getOtherPlayer(){return new_player;}

	public Player getFirstPlayer(){return first_player;}

	public void addStones(int num){num_stones = num_stones + num;}

	public int getStones(){return num_stones;}

	public int getPlayerID(){return player_id;}

}