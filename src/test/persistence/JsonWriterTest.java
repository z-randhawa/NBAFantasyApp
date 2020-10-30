package persistence;

import model.FantasyTeam;
import model.ListOfFantasyTeam;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {
    @Test
    void testWriterInvalidFile() {
        try {
            ListOfFantasyTeam lft = new ListOfFantasyTeam("allTeams");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyListOfFantasyTeams() {
        try {
            ListOfFantasyTeam lft = new ListOfFantasyTeam("allTeams");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyListOfFantasyTeams.json");
            writer.open();
            writer.write(lft);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyListOfFantasyTeams.json");
            lft = reader.read();
            assertEquals("allTeams", lft.getListName());
            assertEquals(0, lft.getNumOfTeams());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralListOfFantasyTeams() {
        try {
            ListOfFantasyTeam lft = new ListOfFantasyTeam("allTeams");
            lft.addTeam(new FantasyTeam("ft1"));
            lft.addTeam(new FantasyTeam("ft2"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralListOfFantasyTeams.json");
            writer.open();
            writer.write(lft);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralListOfFantasyTeams.json");
            lft = reader.read();
            assertEquals("allTeams", lft.getListName());
            ArrayList<FantasyTeam> teamList = lft.getTeamList();
            assertEquals(2, teamList.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
