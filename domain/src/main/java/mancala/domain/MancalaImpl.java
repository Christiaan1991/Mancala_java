package mancala.domain;

public class MancalaImpl implements Mancala {
    private Player player;
    private int hasTurn;

    public MancalaImpl() {
        player = new Player(0); //creates player 0, which creates the whole Mancala board and the other player 1
        hasTurn = PLAYER_ONE; //we start that player one has the turn
    }

    @Override
    public boolean isPlayersTurn(int player) {
        if(player == hasTurn){
            return true;
        }
        else {
            return false;
        }
    }

    public void switchTurn(){
        int newTurn = 0;
        if(hasTurn == PLAYER_ONE){
            newTurn = PLAYER_TWO;
        }
        else if(hasTurn == PLAYER_TWO){
            newTurn = PLAYER_ONE;
        }
        hasTurn = newTurn;
    }

    @Override
	public void playPit(int index) throws MancalaException {
        // Implement playing a pit from player 1
        if(index <= 6 && hasTurn == PLAYER_ONE){
            player.turn(index, hasTurn);
            switchTurn();
        }
        //implement playing a pit from player 2.
        else if (index >= 7 && index <= 13 && hasTurn == PLAYER_TWO){
            player.getOpponent().turn((index % 7), hasTurn);
            switchTurn();
        }
    }
	
	@Override
	public int getStonesForPit(int index) {
        if(index >= 0 && index <= 5){
            return player.getFirstBowl().findBowl(index).getStones();
        }
        else if(index == 6){
            return player.getKalahaFirst().getStones();
        }
        else if(index >= 7 && index <= 12){
            return player.getFirstBowlOpponent().findBowl(index % 7).getStones();
        }
        else{ //index is 13
            return player.getOpponent().getKalahaFirst().getStones();
        }

    }

	@Override
	public boolean isEndOfGame() {
        return false;
    }

	@Override
	public int getWinner() {
        return Mancala.NO_PLAYERS;
    }
}