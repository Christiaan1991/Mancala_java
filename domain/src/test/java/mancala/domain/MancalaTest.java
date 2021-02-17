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
    public void aNormalBorlStartsWith4Stones() {
        Player player_1 = new Player();
        Player player_2 = new Player();

        assertEquals(4, player_1.getScore());
    }
}