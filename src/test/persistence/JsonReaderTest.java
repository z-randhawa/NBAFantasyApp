package persistence;

import model.FantasyTeam;
import model.ListOfFantasyTeam;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ListOfFantasyTeam lft = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyListOfFantasyTeams() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyListOfFantasyTeams.json");
        try {
            ListOfFantasyTeam lft = reader.read();
            assertEquals("allTeams", lft.getListName());
            assertEquals(0, lft.getNumOfTeams());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralListOfFantasyTeams() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralListOfFantasyTeams.json");
        try {
            ListOfFantasyTeam lft = reader.read();
            assertEquals("allTeams", lft.getListName());
            ArrayList<FantasyTeam> teamList = lft.getTeamList();
            assertEquals(2, teamList.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}

