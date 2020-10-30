package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

public class ListOfFantasyTeam implements Writable {

    private String listName;
    private ArrayList<FantasyTeam> teamList;

    //setter
    public ListOfFantasyTeam(String ln) {
        this.listName = ln;
        this.teamList = new ArrayList<>();
    }

    //getter
    public String getListName() {
        return listName;
    }

    public boolean containsTeam(String tn) {
        for (FantasyTeam ft : teamList) {
            if (ft.getTeamName().equals(tn)) {
                return true;
            }
        }
        return false;
    }

    //getter
    public int getNumOfTeams() {
        return teamList.size();
    }

    //getter
    public  ArrayList<FantasyTeam> getTeamList() {
        return teamList;
    }

    // MODIFIES: this
    // EFFECTS: adds the given team to the list
    public void addTeam(FantasyTeam ft) {
        if (!teamList.contains(ft)) {
            teamList.add(ft);
        }
    }

    // getter
    // REQUIRES: list that contains the player
    // EFFECTS: return player if list contains given player
    public FantasyTeam getTeam(String tn) {
        for (FantasyTeam ft : teamList) {
            if (ft.getTeamName().equals(tn)) {
                return ft;
            }
        }
        return new FantasyTeam(tn);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("allTeams", teamsToJson());
        return json;
    }

    // EFFECTS: returns teams in this list of fantasy teams as a JSON array
    private JSONArray teamsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (FantasyTeam ft : teamList) {
            jsonArray.put(ft.toJson());
        }

        return jsonArray;
    }
}
