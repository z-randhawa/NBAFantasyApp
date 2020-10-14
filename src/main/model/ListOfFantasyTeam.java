package model;

import java.util.ArrayList;

public class ListOfFantasyTeam {

    private ArrayList<FantasyTeam> teamList;

    //setter
    public ListOfFantasyTeam() {
        this.teamList = new ArrayList<>();
    }

    //getter
    public boolean containsTeam(String tn) {
        for (FantasyTeam ft : teamList) {
            if (ft.getTeamName().equals(tn)) {
                return true;
            }
        }
        return false;
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
        FantasyTeam rt = new FantasyTeam(tn);
        return rt;
    }
}
