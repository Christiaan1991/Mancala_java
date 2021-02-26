package mancala.domain;

// Your test class should be in the same
// package as the class you're testing.
// Usually the test directory mirrors the
// main directory 1:1. So for each class in src/main,
// there is a class in src/test.

// Import our test dependencies. We import the Test-attribute
// and a set of assertions.
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MancalaTest{
//     Define a test starting with @Test. The test is like
//     a small main method - you need to setup everything
//     and you can write any arbitrary Java code in it.
    @Test
    public void CheckPlayerTest() {
        //Create player
        Player player = new Player(0);
    }

    @Test
    public void TestAtPositionZero() {

        //Create player
        Player player = new Player(0);

        //Player takes turn and picks bowl 0
        player.turn(0);

    }

    @Test
    public void TestIncludingKalahaAndPlayerSwitch() {

        //Create player
        Player player = new Player(0);

        //Player takes turn and picks bowl 5
        player.turn(5);
    }

    @Test
    public void TestIncludingOwnKalahaAndExcludingOtherKalahaAndDoublePlayerSwitch() {

        /* Create player, which will create the mancala board */
        Player player = new Player(0);

        /* set stones for test */
        player.getFirstBowl().findBowl(0,player.getFirstBowl()).setStones(20);
        player.getFirstBowl().findBowl(1,player.getFirstBowl()).setStones(0);
        player.getFirstBowl().findBowl(2,player.getFirstBowl()).setStones(0);
        player.getFirstBowl().findBowl(3,player.getFirstBowl()).setStones(0);
        player.getFirstBowl().findBowl(4,player.getFirstBowl()).setStones(0);
        player.getFirstBowl().findBowl(5,player.getFirstBowl()).setStones(0);

        player.getFirstBowlOpponent().findBowl(0,player.getFirstBowlOpponent()).setStones(0);
        player.getFirstBowlOpponent().findBowl(1,player.getFirstBowlOpponent()).setStones(0);
        player.getFirstBowlOpponent().findBowl(2,player.getFirstBowlOpponent()).setStones(0);
        player.getFirstBowlOpponent().findBowl(3,player.getFirstBowlOpponent()).setStones(0);
        player.getFirstBowlOpponent().findBowl(4,player.getFirstBowlOpponent()).setStones(0);
        player.getFirstBowlOpponent().findBowl(5,player.getFirstBowlOpponent()).setStones(0);


        /* Player takes turn and picks bowl 0 */
        player.turn(0);

    }

}