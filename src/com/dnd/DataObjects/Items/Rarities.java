package com.dnd.DataObjects.Items;

import com.dnd.Utilities.Colors;
import com.dnd.DataObjects.EconomicClasses;

public class Rarities {
    public static final String common = "common";
    public static final String commonColor = Colors.ANSI_RESET;
    public static int commonCostModlow = 50;
    public static int commonCostModHigh = 100;

    public static final String uncommon = "uncommon";
    public static final String uncommonColor = Colors.ANSI_CYAN;
    public static int uncommonCostModlow = 101;
    public static int uncommonCostModHigh = 500;

    public static final String rare = "rare";
    public static final String rareColor = Colors.ANSI_PURPLE;
    public static int rareCostModlow = 501;//+1 bonuses are here
    public static int rareCostModHigh = 5000;

    public static final String veryRare = "very rare";
    public static final String veryRareColor = Colors.ANSI_YELLOW;
    public static int veryRareCostModlow = 5001; //+2 bonuses
    public static int veryRareCostModHigh = 30000;

    public static final String legendary = "legendary";
    public static final String legendaryColor = Colors.ANSI_RED;
    public static int legendaryCostModlow = 30001; //+3 bonuses
    public static int legendaryCostModhigh = 100000;

    public String getColorByRarityOrEconomy(String colorPicker) {
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
