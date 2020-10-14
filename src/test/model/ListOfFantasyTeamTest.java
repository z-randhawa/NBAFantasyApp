package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListOfFantasyTeamTest {
    ListOfFantasyTeam testListOfFantasyTeam0;
    ListOfFantasyTeam testListOfFantasyTeam1;
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

        testListOfFantasyTeam0 = new ListOfFantasyTeam();
        testListOfFantasyTeam1 = new ListOfFantasyTeam();
        testListOfFantasyTeam1.addTeam(testFantasyTeam1);
    }

    @Test
    void testContainsTeam() {
        assertFalse(testListOfFantasyTeam0.containsTeam(testFantasyTeam1.getTeamName()));
        assertTrue(testListOfFantasyTeam1.containsTeam(testFantasyTeam1.getTeamName()));
    }

    @Test
    void testAddTeam() {
        testListOfFantasyTeam1.addTeam(testFantasyTeam0);;
        assertTrue(testListOfFantasyTeam1.containsTeam(testFantasyTeam0.getTeamName()));
    }

}
