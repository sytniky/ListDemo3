package edu.hillel.listdemo;

/**
 * Created by yuriy on 13.07.16.
 */
public class Goods {
    private int iconId;
    private String title;
    private String desc;
    private double cost;

    public Goods(int iconId, String title, String desc, double cost) {
        this.iconId = iconId;
        this.title = title;
        this.desc = desc;
        this.cost = cost;
    }

    public int getIconId() {
        return iconId;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public double getCost() {
        return cost;
    }
}
