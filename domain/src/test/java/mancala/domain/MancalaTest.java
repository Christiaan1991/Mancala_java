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
    // Define a test starting with @Test. The test is like
    // a small main method - you need to setup everything
    // and you can write any arbitrary Java code in it.
    @Test 
    public void CheckStonesinBowls() {
        
        Player player = new Player(0);

        player.turn(0);

        //assertEquals(0, player.bowlsTest(0));
        //assertEquals(4, player.bowlsTest(0));
        
    }

    // @Test 
    // public void CheckKalaha() {
        
    //     Kalaha kalaha = new Kalaha(4);

    //     //number of stones in bowl 1
    //     assertEquals(5, kalaha.addStones(1));
    // }

    // @Test
    // public void CheckStonesInBowls() {
        
    //     Bowl bowl = new Bowl(6,4);
    //     assertEquals(7, bowl.getNextBowlID());
    // }
}