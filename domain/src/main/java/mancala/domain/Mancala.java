package mancala.domain;
import java.util.Scanner;

// Make your own mancala implementation using your design.
// You can take this stub as an example how to make a 
// class inside a package and how to test it.

class Kalaha{
	private int num_stones;
	
	public Kalaha(int num_stones){
        this.num_stones = num_stones;
  	}	
  	// public int getStones(){return num_stones;}

  	public void addStones(int number){
  		num_stones = num_stones + number;
  	}

  	public int getStones(){return num_stones;}

  	

}

class Bowl{
	private int num_stones;

	public Bowl(int num_stones){
        this.num_stones = num_stones;
  	}	

  	public void removeAll(){
  		num_stones = 0;
  	}	

  	public int getStones(){return num_stones;}

}

class Player{
	
	Bowl bowl = new Bowl(4);

	public int getScore(){
		return bowl.getStones();
	}

}

public class Mancala{

    // public int theAnswerToLifeTheUniverseAndEverything() {
    //     return 41;
    // }
}