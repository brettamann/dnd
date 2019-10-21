package com.dnd.DataObjects.Items;

public class Rarities {
    public static final String common = "common";
    public static int commonCostModlow = 50;
    public static int commonCostModHigh = 100;

    public static final String uncommon = "uncommon";
    public static int uncommonCostModlow = 101;
    public static int uncommonCostModHigh = 500;

    public static final String rare = "rare";
    public static int rareCostModlow = 501;//+1 bonuses are here
    public static int rareCostModHigh = 5000;

    public static final String veryRare = "very rare";
    public static int veryRareCostModlow = 5001; //+2 bonuses
    public static int veryRareCostModHigh = 50000;

    public static final String legendary = "legendary";
    public static int legendaryCostModlow = 50001; //+3 bonuses
    public static int legendaryCostModhigh = 500000;
}
