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
        p0 = new Player("", 0, 0, 0, 0, 0, 0, 0);
        p1 = new Player("Player 1", 25, 2, 4.5, 0.8, 0.7, 1.3, 0);
        p2 = new Player("Player 2", 12.6, 0, 0, 1.2, 2.1, 4, 5);
        p3 = new Player("Player 3", 7.0, 2.5,3,3, 0, 5, 2.5);
        p4 = new Player("Player 4", 0, 0, 0,0,0,0, 11.3);
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
