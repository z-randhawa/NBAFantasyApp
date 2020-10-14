package model;

import java.util.LinkedList;
import java.util.List;

class FantasyTeam {

    private String teamName;
    private List<Player> playerList;
    private double teamValue;

    public FantasyTeam(String tn) {
        this.teamName = tn;
        this.playerList = new LinkedList<>();
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
            teamValue = teamValue + p.getValue();
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

    // EFFECTS: return player if list contains given player
    public Player viewPlayer(Player p) {
        if (playerList.contains(p)) {
            return p;
        } else {
            return null;
        }
    }
}