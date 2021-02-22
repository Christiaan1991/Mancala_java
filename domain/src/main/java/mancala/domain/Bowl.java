package mancala.domain;
import java.util.Scanner;

// Make your own mancala implementation using your design.
// You can take this stub as an example how to make a 
// class inside a package and how to test it.

public class Bowl extends Kalaha{
	private int bowl_id;
	private int player_id;
	private static int num_bowls = 6;
	private Bowl next_bowl;
	private Kalaha kalaha;

	public Bowl(int player_id, int bowl_id, int num_stones){
		super(player_id);
		this.bowl_id = bowl_id;
		this.num_stones = num_stones;
		
		if(bowl_id < num_bowls-1){
			next_bowl = new Bowl(player_id, bowl_id + 1, num_stones); //create next bowls with bowl_id = bowl_id+1 and num_stones = num_stones
		}

		else if(bowl_id == num_bowls){
			kalaha = new Kalaha(player_id); //create Kalaha from Bowl class
		}

		//Bowl b = (Bowl) kalaha;
		
	}

	public void removeAll(){num_stones = 0;}

	public int getBowlID(){return bowl_id;}

	public Bowl goNextBowl(){return next_bowl;}

}