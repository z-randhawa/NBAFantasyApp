package model;

import org.json.JSONObject;
import persistence.Writable;

public class Player implements Writable {

    // The following are factors that are multiplied by each player statistic to get their numerical contribution
    // to the overall value of a player
    public static int PF = 1;
    public static int RF = 2;
    public static int AF = 3;
    public static int SF = 8;
    public static int BF = 10;
    public static int THF = 6;
    public static int TOF = -5;

    private String nm;
    private double pts;
    private double rbs;
    private double ast;
    private double stl;
    private double blk;
    private double thr;
    private double tos;
    private double val;

    public Player(String nm) {
        this.nm = nm;
        this.pts = 0;
        this.rbs = 0;
        this.ast = 0;
        this.stl = 0;
        this.blk = 0;
        this.thr = 0;
        this.tos = 0;
        this.val = 0;
    }

    //getters
    public String getNm() {
        return nm;
    }

    public double getPts() {
        return pts;
    }

    public double getRbs() {
        return rbs;
    }

    public double getAst() {
        return ast;
    }

    public double getStl() {
        return stl;
    }

    public double getBlk() {
        return blk;
    }

    public double getThr() {
        return thr;
    }

    public double getTos() {
        return tos;
    }

    public double getVal() {
        return val;
    }

    //setters
    public void setPts(double pts) {
        this.pts = pts;
    }

    public void setRbs(double rbs) {
        this.rbs = rbs;
    }

    public void setAst(double ast) {
        this.ast = ast;
    }

    public void setStl(double stl) {
        this.stl = stl;
    }

    public void setBlk(double blk) {
        this.blk = blk;
    }

    public void setThr(double thr) {
        this.thr = thr;
    }

    public void setTos(double tos) {
        this.tos = tos;
    }

    public void setValue() {
        this.val = ((pts * PF) + (rbs * RF) + (ast * AF) + (blk * BF) + (stl * SF) + (thr * THF) + (tos * TOF));
    }

    public void setValue(double v) {
        this.val = v;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", nm);
        json.put("value", val);
        return json;
    }
}
