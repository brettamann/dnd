package com.dnd.DataObjects.Items;

import com.dnd.Utilities.Screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loot {
    //loot is inherintly not a weapon.
    public String name;
    public String description;
    public String itemType;
    public List<String> abilities;

    public int quantity; //set the value of the item to be what ONE is worth.
    public String rarity;
    public int platinumValuePer;
    public int goldValuePer;
    public int silverValuePer;
    public int copperValuePer;

    public Loot(String name, String description, String itemType, List<String> abilities, int quantity, String rarity, int platinumValuePer, int goldValuePer, int silverValuePer, int copperValuePer) {
        this.name = name;
        this.description = description;
        this.itemType = itemType;
        this.abilities = abilities;
        this.quantity = quantity;
        this.rarity = rarity;
        this.platinumValuePer = platinumValuePer;
        this.goldValuePer = goldValuePer;
        this.silverValuePer = silverValuePer;
        this.copperValuePer = copperValuePer;
    }

    public String getDescriptionStringForDisplay(Screen screen) {
        String stringToReturn = name + " (x" + quantity + ", " + rarity + ", " + itemType;
        if (platinumValuePer > 0) {
            stringToReturn = stringToReturn + ", " + platinumValuePer + "pp";
        }
        if (goldValuePer > 0) {
            stringToReturn = stringToReturn + ", " + goldValuePer + "gp";
        }
        if (silverValuePer > 0) {
            stringToReturn = stringToReturn + ", " + silverValuePer + "sp";
        }
        if (copperValuePer > 0) {
            stringToReturn = stringToReturn + ", " + copperValuePer + "cp";
        }
        stringToReturn = stringToReturn + "): " + description;
        for (int i = 0; i < abilities.size() - 1; i++) {
            if (!abilities.get(i).equals("")) {
                stringToReturn = stringToReturn + "\n\t" + abilities.get(i);
            }
        }
        return stringToReturn;
    }
}
