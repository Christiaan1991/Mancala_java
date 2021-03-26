package mancala.domain;

// Make your own mancala implementation using your design.
// You can take this stub as an example how to make a 
// class inside a package and how to test it.

public class Bowl extends Kalaha{
	public static final int AGAIN = 1;
	public static final int VALID = 0;

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

	public boolean hasNextBowl(){
		if(goNextBowl() != null){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean hasKalaha(){
		if(this.getKalaha() != null){
			return true;
		}
		else{
			return false;
		}
	}

	public Kalaha findKalaha(){
		if(!this.hasKalaha()){
			return this.goNextBowl().findKalaha();
		}
		else{
			return kalaha;
		}
	}

	public Kalaha getKalaha(){ return kalaha; }

	public Bowl findBowl(int num){
		if(this.getBowlID() != num) {
			return this.goNextBowl().findBowl(num);
			}
		return this;
	}

	public Bowl getOppositeBowl(){
		return this.findBowl(5).getKalaha().getNextPlayer().getFirstBowl().findBowl(5 % this.getBowlID());
	}

	public int distribute(int num, int hasTurn) {
		Bowl bowl = this;
		while (num != 0) {
			if (bowl.hasNextBowl()) { //if bowl has a next bowl
				bowl = bowl.goNextBowl();
				bowl.addStones(1);
				num--;

				if (bowl.getStones() == 1 && bowl.getPlayerID() == (hasTurn - 1) && num == 0) { //if no more stones in hand, only
					bowl.findKalaha().addStones(bowl.getOppositeBowl().getStones() + bowl.getStones());
					bowl.getOppositeBowl().removeAll();
					bowl.removeAll();
					break;

				}
			} else { //we cannot go to a next bowl, so we go to a kalaha!
				kalaha = bowl.getKalaha();

				if(kalaha.isOwnKalaha(hasTurn)){
					kalaha.addStones(1);
					num--;

					if(num == 0){
						//Player move ends in own kalaha, play again!
						System.out.println("You can take another turn");
						return AGAIN;
					}
				}

				//skipping addstones to other kalaha, so we add a stone to the next bowl
				bowl = kalaha.getNextPlayer().getFirstBowl();
				bowl.addStones(1);
				num--;
			}

		}
		//return valid move!
		return VALID;
	}


	public int distribute2(int num, int hasTurn) {

		Bowl bowl = this;
		if(num != 0){//if number of hand_stones is not zero, we go to next bowl and add one
			if(bowl.getBowlID() != 5){ //not in the last bowl
				Bowl next_bowl = bowl.goNextBowl();
				if(next_bowl.getStones() == 0 && next_bowl.getPlayerID() == (hasTurn-1) && num == 1){//if next bowl is empty, own players bowl and 1 stone in hand remaining
					int opposite_stones = next_bowl.getOppositeBowl().getStones();
					next_bowl.getOppositeBowl().removeAll();
					next_bowl.findBowl(5).getKalaha().addStones(opposite_stones + 1);
					num--;
				}
				else{
					next_bowl.addStones(1);
					num--;
					next_bowl.distribute(num, hasTurn);
				}
			}

			else{//we are in bowl 5, so then we link with kalaha
				kalaha = bowl.getKalaha();

				if(kalaha.getPlayerID() == (hasTurn-1)) {//if we are in own kalaha, which belongs to player who has the turn

					kalaha.addStones(1); //we add stone to kalaha
					num--;

					if(num == 0){
						//Player move ends in own kalaha, play again!
						System.out.println("You can take another turn");
					}
					else{
						//we need to manually add first stone to first bowl, since distribute will move on to next
						kalaha.getNextPlayer().getFirstBowl().addStones(1);
						num--;
						kalaha.getNextPlayer().getFirstBowl();
						//and we continue
						kalaha.getNextPlayer().getFirstBowl().distribute(num, hasTurn);
					}
				}

				else if(kalaha.getPlayerID() != (hasTurn-1)){//if we are in opposite kalaha, add stone to next bowl
					//and continue distributing
					kalaha.getNextPlayer().getFirstBowl().addStones(1);
					num--;
					kalaha.getNextPlayer().getFirstBowl().distribute(num, hasTurn);
				}

			}

		}

		return Bowl.VALID;

	}

	public int move(int hasTurn) {

		int hand_stones = getStones();    //take stones in hand
		removeAll();                    //remove all stones from bowl

		return distribute(hand_stones, hasTurn);	//distribute stones to next bowls
	}
}