package com.masters_of_destiny.DataObjects.Items;

import com.masters_of_destiny.Utilities.Colors;
import com.masters_of_destiny.DataObjects.EconomicClasses;

public class Rarities {
    public static final String common = "common";
    public static final String commonColor = Colors.RESET;
    public static final int commonCostModlow = 50;
    public static final int commonCostModHigh = 100;

    public static final String uncommon = "uncommon";
    public static final String uncommonColor = Colors.CYAN;
    public static final int uncommonCostModlow = 101;
    public static final int uncommonCostModHigh = 500;

    public static final String rare = "rare";
    public static final String rareColor = Colors.PURPLE;
    public static final int rareCostModlow = 501;//+1 bonuses are here
    public static final int rareCostModHigh = 5000;

    public static final String veryRare = "very rare";
    public static final String veryRareColor = Colors.YELLOW;
    public static final int veryRareCostModlow = 5001; //+2 bonuses
    public static final int veryRareCostModHigh = 30000;

    public static final String legendary = "legendary";
    public static final String legendaryColor = Colors.RED;
    public static final int legendaryCostModlow = 30001; //+3 bonuses
    public static final int legendaryCostModhigh = 100000;

    public static String getColorByRarityOrEconomy(String colorPicker) {
        if (colorPicker.equals(common) || colorPicker.equals(uncommon) || colorPicker.equals(rare) || colorPicker.equals(veryRare) || colorPicker.equals(legendary)) {
            switch (colorPicker) {
                case common:
                    return commonColor;
                case uncommon:
                    return uncommonColor;
                case rare:
                    return rareColor;
                case veryRare:
                    return veryRareColor;
                case legendary:
                    return legendaryColor;
                default:
                    return "null";
            }
        } else {
            switch (colorPicker) {
                case EconomicClasses.beggar:
                    return commonColor;
                case EconomicClasses.poor:
                    return uncommonColor;
                case EconomicClasses.middleClass:
                    return rareColor;
                case EconomicClasses.wealthy:
                    return veryRareColor;
                case EconomicClasses.elite:
                    return legendaryColor;
                default:
                    return "null";
            }
        }
    }
}
