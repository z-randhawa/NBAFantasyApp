package persistence;

import model.FantasyTeam;
import model.Player;
import model.ListOfFantasyTeam;
import org.json.JSONArray;
import org.json.JSONObject;
import ui.FantasyTeamApp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

//JsonReader class framework from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads list of fantasy teams from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ListOfFantasyTeam read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseListOfFantasyTeam(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses list of fantasy teams from JSON object and returns it
    private ListOfFantasyTeam parseListOfFantasyTeam(JSONObject jsonObject) {
        JSONArray allTeams = jsonObject.getJSONArray("allTeams");
        ListOfFantasyTeam fantasyTeams = new ListOfFantasyTeam("allTeams");
        for (Object teamObject : allTeams) {
            FantasyTeam team = parseFantasyTeam((JSONObject) teamObject);
            fantasyTeams.addTeam(team);
        }
        return fantasyTeams;
    }

    //EFFECTS: parses a fantasy team from JSON object
    private FantasyTeam parseFantasyTeam(JSONObject jo) {
        String teamName = jo.getString("teamName");
        JSONArray allPlayers = jo.getJSONArray("players");
        FantasyTeam fantasyTeam = new FantasyTeam(teamName);
        for (Object player : allPlayers) {
            JSONObject p = (JSONObject) player;
            String name = p.getString("name");
            double value = p.getDouble("value");
            Player pl = new Player(name);
            pl.setValue(value);
            fantasyTeam.addPlayerToTeam(pl);
            FantasyTeamApp.getMasterListOfPlayers().addPlayerToTeam(pl);
        }
        return fantasyTeam;
    }

}
