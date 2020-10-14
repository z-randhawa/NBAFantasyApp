package model;

public class Player {

    // The following are factors that are multiplied by each player statistic to get their numerical contribution
    // to the overall value of a player
    public static int PF = 1;
    public static int RF = 2;
    public static int AF = 3;
    public static int SF = 8;
    public static int BF = 10;
    public static int THF = 6;
    public static int TOF = -5;

    private String name;
    private double points;
    private double rebounds;
    private double assists;
    private double steals;
    private double blocks;
    private double threes;
    private double turnovers;
    private double value;

    public Player(String nm) {
        this.name = nm;
        this.points = 0;
        this.rebounds = 0;
        this.assists = 0;
        this.steals = 0;
        this.blocks = 0;
        this.threes = 0;
        this.turnovers = 0;
        this.value = 0;
    }

    //getters
    public String getName() {
        return name;
    }

    public double getPoints() {
        return points;
    }

    public double getRebounds() {
        return rebounds;
    }

    public double getAssists() {
        return assists;
    }

    public double getSteals() {
        return steals;
    }

    public double getBlocks() {
        return blocks;
    }

    public double getThrees() {
        return threes;
    }

    public double getTurnovers() {
        return turnovers;
    }

    public double getValue() {
        return value;
    }

    //setters
    public void setPoints(double pts) {
        this.points = pts;
    }

    public void setRebounds(double rbs) {
        this.rebounds = rbs;
    }

    public void setAssists(double ast) {
        this.assists = ast;
    }

    public void setSteals(double stl) {
        this.steals = stl;
    }

    public void setBlocks(double blk) {
        this.blocks = blk;
    }

    public void setThrees(double thr) {
        this.threes = thr;
    }

    public void setTurnovers(double tos) {
        this.turnovers = tos;
    }

    public void setValue() {
        this.value = ((points * PF) + (rebounds * RF) + (assists * AF) + (blocks * BF) + (steals * SF) + (threes * THF) + (turnovers * TOF));
    }
}
