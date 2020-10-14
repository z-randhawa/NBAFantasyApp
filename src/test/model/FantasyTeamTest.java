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
        testPlayer1.setPts(29.2);
        testPlayer1.setRbs(8.6);
        testPlayer1.setAst(11);
        testPlayer1.setStl(1.4);
        testPlayer1.setBlk(1.2);
        testPlayer1.setThr(2.2);
        testPlayer1.setTos(4);

        testPlayer2 = new Player("Anthony Davis");
        testPlayer2.setPts(25);
        testPlayer2.setRbs(8.1);
        testPlayer2.setAst(3.3);
        testPlayer2.setStl(1.5);
        testPlayer2.setBlk(2.3);
        testPlayer2.setThr(3);
        testPlayer2.setTos(2.1);

        testPlayer3 = new Player("Jimmy Butler");
        testPlayer3.setPts(27.1);
        testPlayer3.setRbs(7.5);
        testPlayer3.setAst(8);
        testPlayer3.setStl(2.7);
        testPlayer3.setBlk(0.8);
        testPlayer3.setThr(0.5);
        testPlayer3.setTos(3);

        testFantasyTeam1.addPlayerToTeam(testPlayer1);
        testFantasyTeam1.addPlayerToTeam(testPlayer2);
        testFantasyTeam1.addPlayerToTeam(testPlayer3);
    }

    @Test
    void testAddPlayerToTeam() {
        testFantasyTeam1.addPlayerToTeam(testPlayer1);
        assertEquals(3, testFantasyTeam1.getPlayerList().size());
        Player testPlayer4 = new Player("Kyle Kuzma");
        testPlayer4.setPts(27.1);
        testPlayer4.setRbs(7.5);
        testPlayer4.setAst(0);
        testPlayer4.setStl(0);
        testPlayer4.setBlk(0);
        testPlayer4.setThr(1.4);
        testPlayer4.setTos(4);

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
        double testValue = (testPlayer1.getVal() + testPlayer2.getVal() + testPlayer3.getVal());
        assertEquals(testValue ,testFantasyTeam1.getTeamValue());
    }

    @Test
    void testGetAverageValueOfTeam() {
        assertEquals(0, testFantasyTeam0.getAverageValueOfTeam());
        double testAverageValue = (testPlayer1.getVal() + testPlayer2.getVal() + testPlayer3.getVal()) / 3;
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
        assertFalse(testFantasyTeam0.containsPlayer(testPlayer1.getNm()));
        assertTrue(testFantasyTeam1.containsPlayer(testPlayer2.getNm()));
    }

    @Test
    void testGetPlayer() {
        assertSame(testPlayer2, testFantasyTeam1.getPlayer(testPlayer2.getNm()));
    }

}
