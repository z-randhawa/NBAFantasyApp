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
        testPlayer1 = new Player("Lebron James");
        testPlayer1.setPoints(29.2);
        testPlayer1.setRebounds(8.6);
        testPlayer1.setAssists(11);
        testPlayer1.setSteals(1.4);
        testPlayer1.setBlocks(1.2);
        testPlayer1.setThrees(2.2);
        testPlayer1.setTurnovers(4);

        testPlayer2 = new Player("Anthony Davis");
        testPlayer2.setPoints(25);
        testPlayer2.setRebounds(8.1);
        testPlayer2.setAssists(3.3);
        testPlayer2.setSteals(1.5);
        testPlayer2.setBlocks(2.3);
        testPlayer2.setThrees(3);
        testPlayer2.setTurnovers(2.1);

        testPlayer3 = new Player("Jimmy Butler");
        testPlayer3.setPoints(27.1);
        testPlayer3.setRebounds(7.5);
        testPlayer3.setAssists(8);
        testPlayer3.setSteals(2.7);
        testPlayer3.setBlocks(0.8);
        testPlayer3.setThrees(0.5);
        testPlayer3.setTurnovers(3);

        testFantasyTeam1.addPlayerToTeam(testPlayer1);
        testFantasyTeam1.addPlayerToTeam(testPlayer2);
        testFantasyTeam1.addPlayerToTeam(testPlayer3);
    }

    @Test
    void testAddPlayerToTeam() {
        testFantasyTeam1.addPlayerToTeam(testPlayer1);
        assertEquals(3, testFantasyTeam1.getPlayerList().size());
        Player testPlayer4 = new Player("Kyle Kuzma");
        testPlayer4.setPoints(27.1);
        testPlayer4.setRebounds(7.5);
        testPlayer4.setAssists(0);
        testPlayer4.setSteals(0);
        testPlayer4.setBlocks(0);
        testPlayer4.setThrees(1.4);
        testPlayer4.setTurnovers(4);

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
    void testContainsPlayer() {
        assertFalse(testFantasyTeam0.containsPlayer(testPlayer1.getName()));
        assertTrue(testFantasyTeam1.containsPlayer(testPlayer2.getName()));
    }

    @Test
    void testGetPlayer() {
        assertSame(testPlayer2, testFantasyTeam1.getPlayer(testPlayer2.getName()));
    }

}
