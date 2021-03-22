package mancala.domain;

// Make your own mancala implementation using your design.
// You can take this stub as an example how to make a 
// class inside a package and how to test it.

public class Bowl extends Kalaha{
	private final int bowl_id;
	private static final int num_bowls = 6;
	private Bowl next_bowl;
	public Kalaha kalaha;

	public Bowl(Player first_player, int player_id, int bowl_id, int num_stones){
		super(first_player, player_id);
		this.bowl_id = bowl_id;
		this.num_stones = num_stones;
		
		if(bowl_id < num_bowls-1){
			next_bowl = new Bowl(first_player, player_id, bowl_id + 1, num_stones); //create next bowls with bowl_id = bowl_id+1 and num_stones = num_stones
		}

		else if(bowl_id == num_bowls-1) {
			kalaha = new Kalaha(first_player, player_id); //create Kalaha from Bowl class
		}
	}

	public boolean hasStones(){
		if(this.getStones()!=0){
			return true;
		}
		else{
			return false;
		}
	}

	public void removeAll(){num_stones = 0;}

	public void setStones(int num){num_stones = num;}

	public int getBowlID(){return bowl_id;}

	public Bowl goNextBowl(){return next_bowl;}

	public Kalaha getKalaha(){return kalaha;}

	public boolean isKalaha(){
		if(getKalaha() == null){
			return false;
		}
		else{
			return true;
		}
	}

	public Bowl findBowl(int num){
		if(this.getBowlID() != num) {
			return this.goNextBowl().findBowl(num);
			}
		return this;
	}

	public Bowl getOppositeBowl(){
		return this.findBowl(5).getKalaha().getOtherPlayer().getFirstBowl().findBowl(5 % this.getBowlID());
	}

	public void distribute(int num){
		Bowl bowl = this;
		if(num != 0){//if number of hand_stones is not zero, we go to next bowl and add one
			if(bowl.getBowlID() != 5){ //not in the last bowl
				Bowl next_bowl = bowl.goNextBowl();
				if(next_bowl.getStones() == 0 && next_bowl.getPlayerID() == 0 && num == 1){//if next bowl is empty, own players bowl and 1 stone in hand remaining
					int opposite_stones = next_bowl.getOppositeBowl().getStones();
					next_bowl.getOppositeBowl().removeAll();
					next_bowl.findBowl(5).getKalaha().addStones(opposite_stones + 1);
					num--;
				}
				else{
					next_bowl.addStones(1);
					num--;
					next_bowl.distribute(num);
				}
			}

			else{//we are in bowl 5, so then we link with kalaha
				kalaha = bowl.getKalaha();

				if(kalaha.getPlayerID() == 0) {//if we are in own kalaha

					kalaha.addStones(1); //we add stone to kalaha
					num--;

					if(num == 0){
						//Player move ends in own kalaha, play again!
						System.out.println("You can go take another turn");
					}
					else{
						//we need to manually add first stone to first bowl, since distribute will move on to next
						kalaha.getOtherPlayer().getFirstBowl().addStones(1);
						num--;
						kalaha.getOtherPlayer().getFirstBowl();
						//and we continue
						kalaha.getOtherPlayer().getFirstBowl().distribute(num);
					}
				}

				else if(kalaha.getPlayerID() == 1){//if we are in opposite kalaha, add stone to next bowl
					//and continue distributing
					kalaha.getFirstPlayer().getFirstBowl().addStones(1);
					num--;
					kalaha.getFirstPlayer().getFirstBowl().distribute(num);
				}

			}
		}
	}

	public int move() {

		int hand_stones = getStones();    //take stones in hand
		removeAll();                    //remove all stones from bowl

		this.distribute(hand_stones);	//distribute stones to next bowls

		return 0;
	}
}