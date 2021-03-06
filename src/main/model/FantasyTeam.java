package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class FantasyTeam implements Writable {

    private String teamName;
    private ArrayList<Player> playerList;
    private double teamValue;

    //setter
    public FantasyTeam(String tn) {
        this.teamName = tn;
        this.playerList = new ArrayList<>();
        this.teamValue = 0;
    }

    //getters
    public String getTeamName() {
        return teamName;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public double getTeamValue() {
        return teamValue;
    }

    // MODIFIES: this
    // EFFECTS: adds the given player to the list
    public void addPlayerToTeam(Player p) {
        if (!playerList.contains(p)) {
            playerList.add(p);
            teamValue = teamValue + p.getVal();
        }
    }

    // REQUIRES: a non-empty list of players
    // EFFECTS: returns the average value of a team per player
    public double getAverageValueOfTeam() {
        if (playerList.size() == 0) {
            return 0;
        } else {
            double a;
            a = teamValue / playerList.size();
            return a;
        }
    }

    // MODIFIES: this
    // EFFECTS: returns true if the given player is able to be removed from list, false otherwise
    public boolean removePlayerFromTeam(Player p) {
        if (playerList.contains(p)) {
            playerList.remove(p);
            return true;
        } else {
            return false;
        }
    }

    // EFFECTS: return true if list contains given player
    public boolean containsPlayer(String pn) {
        for (Player p : playerList) {
            if (p.getNm().equals(pn)) {
                return true;
            }
        }
        return false;
    }

    // REQUIRES: list that contains the player
    // EFFECTS: return player if list contains given player
    public Player getPlayer(String pn) {
        for (Player p : playerList) {
            if (p.getNm().equals(pn)) {
                return p;
            }
        }
        return new Player(pn);
    }

    //EFFECTS: Prints the names of all players in the team
    public void printFantasyTeam() {
        if (playerList.isEmpty()) {
            System.out.println("There are no players on this team");
        } else {
            for (Player p : playerList) {
                System.out.println(p.getNm());
            }
            System.out.println("That's your whole squad");
        }
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("teamName", teamName);
        json.put("players", playersToJson());
        return json;
    }

    // EFFECTS: returns players in this fantasy team as a JSON array
    private JSONArray playersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Player p : playerList) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }
}
