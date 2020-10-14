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

    public Player(String nm, double pts, double rebs, double asts, double stls, double blks, double thr, double to) {
        this.name = nm;
        this.points = pts;
        this.rebounds = rebs;
        this.assists = asts;
        this.steals = stls;
        this.blocks = blks;
        this.threes = thr;
        this.turnovers = to;
        this.value = ((pts * PF) + (rebs * RF) + (asts * AF) + (blks * BF) + (stls * SF) + (thr * THF) + (to * TOF));
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
}
