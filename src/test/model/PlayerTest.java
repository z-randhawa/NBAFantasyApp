package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Player p0;
    Player p1;
    Player p2;
    Player p3;
    Player p4;

    @BeforeEach
    void runBefore() {
        p0 = new Player("");
        p0.setPoints(0);
        p0.setRebounds(0);
        p0.setAssists(0);
        p0.setSteals(0);
        p0.setBlocks(0);
        p0.setThrees(0);
        p0.setTurnovers(0);

        p1 = new Player("Player 1");
        p1.setPoints(25);
        p1.setRebounds(2);
        p1.setAssists(4.5);
        p1.setSteals(0.8);
        p1.setBlocks(0.7);
        p1.setThrees(1.3);
        p1.setTurnovers(0);
        p1.setValue();

        p2 = new Player("Player 2");
        p2.setPoints(12.6);
        p2.setRebounds(0);
        p2.setAssists(0);
        p2.setSteals(1.2);
        p2.setBlocks(2.1);
        p2.setThrees(4);
        p2.setTurnovers(5);
        p2.setValue();

        p3 = new Player("Player 3");
        p3.setPoints(7.0);
        p3.setRebounds(2.5);
        p3.setAssists(3);
        p3.setSteals(3);
        p3.setBlocks(0);
        p3.setThrees(5);
        p3.setTurnovers(2.5);
        p3.setValue();

        p4 = new Player("Player 4");
        p4.setPoints(0);
        p4.setRebounds(0);
        p4.setAssists(0);
        p4.setSteals(0);
        p4.setBlocks(0);
        p4.setThrees(0);
        p4.setTurnovers(11.3);
        p4.setValue();
    }

    @Test
    void testGetName() {
        assertEquals("", p0.getName());
        assertEquals("Player 1", p1.getName());
    }

    @Test
    void testGetPoints() {
        assertEquals(0, p0.getPoints());
        assertEquals(25, p1.getPoints());
    }

    @Test
    void testGetRebounds() {
        assertEquals(0, p0.getRebounds());
        assertEquals(2.5, p3.getRebounds());
    }

    @Test
    void testGetAssists() {
        assertEquals(0, p0.getAssists());
        assertEquals(3, p3.getAssists());
    }

    @Test
    void testGetSteals() {
        assertEquals(0, p0.getSteals());
        assertEquals(1.2, p2.getSteals());
    }

    @Test
    void testGetBlocks() {
        assertEquals(0, p0.getBlocks());
        assertEquals(2.1, p2.getBlocks());
    }

    @Test
    void testGetThrees() {
        assertEquals(0, p0.getThrees());
        assertEquals(1.3, p1.getThrees());
    }

    @Test
    void testGetTurnovers() {
        assertEquals(0, p0.getTurnovers());
        assertEquals(2.5, p3.getTurnovers());
    }

    @Test
    void testGetValue() {
        assertEquals(0, p0.getValue());
        assertEquals(62.5, p3.getValue());
        assertEquals(-56.5, p4.getValue());
    }
}
