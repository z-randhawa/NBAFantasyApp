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
