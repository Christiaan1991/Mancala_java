package mancala.domain;

// Your test class should be in the same
// package as the class you're testing.
// Usually the test directory mirrors the
// main directory 1:1. So for each class in src/main,
// there is a class in src/test.

// Import our test dependencies. We import the Test-attribute
// and a set of assertions.

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDemo {


    /* Create player, which will create the mancala board */
    Player player = new Player(0);

    @Nested
    @DisplayName("Initialization of mancala")
    class Mancala_intialize{

        @Test
        @DisplayName("Setup of the Players")
        void Player_setup() {
            assertAll("Board setup by checking Bowl ID's",
                    () -> assertTrue(player.getFirstBowl().getBowlID()),
                    () -> assertTrue(player.getFirstBowl().goNextBowl().getBowlID()));
        }

        @Test
        @DisplayName("Setup of the playing Board")
        void Board_setup() {
            assertAll("Board setup by checking Bowl ID's",
                    () -> assertEquals(0,player.getFirstBowl().getBowlID()),
                    () -> assertEquals(1, player.getFirstBowl().goNextBowl().getBowlID()),
                    () -> assertEquals(2, player.getFirstBowl().findBowl(2).getBowlID()),
                    () -> assertEquals(3, player.getFirstBowl().findBowl(3).getBowlID()),
                    () -> assertEquals(4, player.getFirstBowl().findBowl(4).getBowlID()),
                    () -> assertEquals(5, player.getFirstBowl().findBowl(5).getBowlID()),
                    () -> assertTrue(player.getFirstBowl().findBowl(5).isKalaha()));
        }
    }


    @Test
    public void TestIncludingOwnKalahaAndExcludingOtherKalahaAndDoublePlayerSwitch() {

        /* Create player, which will create the mancala board */
        Player player = new Player(0);

        /* set stones for test */
        player.getFirstBowl().findBowl(0).setStones(6);
        player.getFirstBowl().findBowl(1).setStones(0);
        player.getFirstBowl().findBowl(2).setStones(0);
        player.getFirstBowl().findBowl(3).setStones(0);
        player.getFirstBowl().findBowl(4).setStones(0);
        player.getFirstBowl().findBowl(5).setStones(0);

        player.getFirstBowlOpponent().findBowl(0).setStones(0);
        player.getFirstBowlOpponent().findBowl(1).setStones(0);
        player.getFirstBowlOpponent().findBowl(2).setStones(0);
        player.getFirstBowlOpponent().findBowl(3).setStones(0);
        player.getFirstBowlOpponent().findBowl(4).setStones(0);
        player.getFirstBowlOpponent().findBowl(5).setStones(0);


        /* Player takes turn and picks bowl 0 */
        player.turn(0);

    }

}