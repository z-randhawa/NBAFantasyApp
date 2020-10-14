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
        p0.setPts(0);
        p0.setRbs(0);
        p0.setAst(0);
        p0.setStl(0);
        p0.setBlk(0);
        p0.setThr(0);
        p0.setTos(0);

        p1 = new Player("Player 1");
        p1.setPts(25);
        p1.setRbs(2);
        p1.setAst(4.5);
        p1.setStl(0.8);
        p1.setBlk(0.7);
        p1.setThr(1.3);
        p1.setTos(0);
        p1.setValue();

        p2 = new Player("Player 2");
        p2.setPts(12.6);
        p2.setRbs(0);
        p2.setAst(0);
        p2.setStl(1.2);
        p2.setBlk(2.1);
        p2.setThr(4);
        p2.setTos(5);
        p2.setValue();

        p3 = new Player("Player 3");
        p3.setPts(7.0);
        p3.setRbs(2.5);
        p3.setAst(3);
        p3.setStl(3);
        p3.setBlk(0);
        p3.setThr(5);
        p3.setTos(2.5);
        p3.setValue();

        p4 = new Player("Player 4");
        p4.setPts(0);
        p4.setRbs(0);
        p4.setAst(0);
        p4.setStl(0);
        p4.setBlk(0);
        p4.setThr(0);
        p4.setTos(11.3);
        p4.setValue();
    }

    @Test
    void testGetName() {
        assertEquals("", p0.getNm());
        assertEquals("Player 1", p1.getNm());
    }

    @Test
    void testGetPoints() {
        assertEquals(0, p0.getPts());
        assertEquals(25, p1.getPts());
    }

    @Test
    void testGetRebounds() {
        assertEquals(0, p0.getRbs());
        assertEquals(2.5, p3.getRbs());
    }

    @Test
    void testGetAssists() {
        assertEquals(0, p0.getAst());
        assertEquals(3, p3.getAst());
    }

    @Test
    void testGetSteals() {
        assertEquals(0, p0.getStl());
        assertEquals(1.2, p2.getStl());
    }

    @Test
    void testGetBlocks() {
        assertEquals(0, p0.getBlk());
        assertEquals(2.1, p2.getBlk());
    }

    @Test
    void testGetThrees() {
        assertEquals(0, p0.getThr());
        assertEquals(1.3, p1.getThr());
    }

    @Test
    void testGetTurnovers() {
        assertEquals(0, p0.getTos());
        assertEquals(2.5, p3.getTos());
    }

    @Test
    void testGetValue() {
        assertEquals(0, p0.getVal());
        assertEquals(62.5, p3.getVal());
        assertEquals(-56.5, p4.getVal());
    }
}
