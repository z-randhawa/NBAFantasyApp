package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FantasyTeamTest {
    FantasyTeam testFantasyTeam0;
    FantasyTeam testFantasyTeam1;
    Player testPlayer1;
    Player testPlayer2;
    Player testPlayer3;

    @BeforeEach
    void setUp() {
        testFantasyTeam0 = new FantasyTeam("Test Team");
        testFantasyTeam1 = new FantasyTeam("My Team");
        testPlayer1 = new Player("Lebron James", 29.2, 8.6, 11, 1.4, 1.2, 2.2, 4);
        testPlayer2 = new Player("Anthony Davis", 25, 8.1, 3.3, 1.5, 2.3, 3, 2.1);
        testPlayer3 = new Player("Jimmy Butler", 27.1, 7.5, 8, 2.7, 0.8, 0.5, 3);

        testFantasyTeam1.addPlayerToTeam(testPlayer1);
        testFantasyTeam1.addPlayerToTeam(testPlayer2);
        testFantasyTeam1.addPlayerToTeam(testPlayer3);
    }

    @Test
    void testAddPlayerToTeam() {
        testFantasyTeam1.addPlayerToTeam(testPlayer1);
        assertEquals(3, testFantasyTeam1.getPlayerList().size());
        Player testPlayer4 = new Player("Kyle Kuzma", 27.1, 7.5, 0, 0, 0, 1.5, 4);
        testFantasyTeam1.addPlayerToTeam(testPlayer4);
        assertEquals(4, testFantasyTeam1.getPlayerList().size());
    }

    @Test
    void testGetName() {
        assertEquals("My Team", testFantasyTeam1.getTeamName());
    }

    @Test
    void testGetPlayerList() {
        assertEquals(3, testFantasyTeam1.getPlayerList().size());
        assertTrue(testFantasyTeam1.getPlayerList().contains(testPlayer1));
        assertTrue(testFantasyTeam1.getPlayerList().contains(testPlayer2));
        assertTrue(testFantasyTeam1.getPlayerList().contains(testPlayer3));
    }

    @Test
    void testGetTeamValue() {
        assertEquals(0, testFantasyTeam0.getTeamValue());
        double testValue = (testPlayer1.getValue() + testPlayer2.getValue() + testPlayer3.getValue());
        assertEquals(testValue ,testFantasyTeam1.getTeamValue());
    }

    @Test
    void testGetAverageValueOfTeam() {
        assertEquals(0, testFantasyTeam0.getAverageValueOfTeam());
        double testAverageValue = (testPlayer1.getValue() + testPlayer2.getValue() + testPlayer3.getValue()) / 3;
        assertEquals(testAverageValue, testFantasyTeam1.getAverageValueOfTeam());
    }

    @Test
    void testRemovePlayerFromTeam() {
        assertFalse(testFantasyTeam0.removePlayerFromTeam(testPlayer1));

        assertTrue(testFantasyTeam1.removePlayerFromTeam(testPlayer1));
        assertEquals(2, testFantasyTeam1.getPlayerList().size());
        assertFalse(testFantasyTeam1.removePlayerFromTeam(testPlayer1));

        assertTrue(testFantasyTeam1.removePlayerFromTeam(testPlayer2));
        assertEquals(1, testFantasyTeam1.getPlayerList().size());
        assertFalse(testFantasyTeam1.removePlayerFromTeam(testPlayer2));
    }

    @Test
    void testViewPlayer() {
        assertNull(testFantasyTeam0.viewPlayer(testPlayer1));
        assertSame(testPlayer2, testFantasyTeam1.viewPlayer(testPlayer2));
    }
}
