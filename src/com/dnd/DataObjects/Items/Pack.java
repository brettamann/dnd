package com.dnd.DataObjects.Items;

import com.dnd.DataObjects.Location;
import com.dnd.DataObjects.EconomicClasses;
import com.dnd.Utilities.RandomCollectionWeighted;
import com.dnd.Utilities.RandomGenerator;

import java.util.List;

public class Pack {
    //the pack holds all items
    public String nameOfOwner;
    public List<Weapon> weaponsCarried;
    public List<Armor> armorCarried;
    public List<Loot> lootCarried;

    public void fillPackRandomly(String economicClass, RandomGenerator randGen, Location location) {
        double itemTierSelector = randGen.randomIntInRange(1,100);
        double itemsCarriedTotal = randGen.randomIntInRange(location.itemsCarriedLow, location.itemsCarriedHigh);
        switch (economicClass) {
            //this takes the max range from the area and modifies it depending on the class
            case EconomicClasses.beggar:
                itemsCarriedTotal = Math.round(itemsCarriedTotal / randGen.randomDoubleInRange(4, 8));
                break;
            case EconomicClasses.poor:
                itemsCarriedTotal = Math.round(itemsCarriedTotal / randGen.randomDoubleInRange(3, 6));
                break;
            case EconomicClasses.middleClass:
                itemsCarriedTotal = Math.round(itemsCarriedTotal / randGen.randomDoubleInRange(1, 4));
                break;
        }
        int weaponsCarried = 0;
        int armorCarried = 0;
        int lootCarried = 0;
        RandomCollectionWeighted<String> rc = new RandomCollectionWeighted<String>().add(30, "weapon").add(10, "armor").add(60, "loot"); //it's a lot more realistic to carry extra weapons than extra armor and as the creature is likely to be wearing armor that will be "loot" anyway, it's not super important to have it here
        for (int i = 0; i < itemsCarriedTotal; i++) {
            switch (rc.next()) {
                case "weapon":
                    weaponsCarried++;
                    break;
                case "armor":
                    armorCarried++;
                    break;
                case "loot":
                    lootCarried++;
                    break;
            }
        }
        getWeaponsInPack(weaponsCarried, economicClass, randGen);
        getArmorInPack(armorCarried, economicClass, randGen);
        getLootInPack(lootCarried, economicClass, randGen);
    }

    private void getWeaponsInPack(int amount, String economicClass, RandomGenerator randGen) {
        for (int i = 0; i < amount; i++) {
            int tierSelector;
            switch (economicClass) {
                case EconomicClasses.beggar:
                    tierSelector = randGen.randomIntInRange(1, 3);
                    weaponsCarried.set(i, randGen.getWeaponByEconomyAndTier(EconomicClasses.beggar, tierSelector));
                    break;
                case EconomicClasses.poor:
                    tierSelector = randGen.randomIntInRange(1, 3);
                    weaponsCarried.set(i, randGen.getWeaponByEconomyAndTier(EconomicClasses.poor, tierSelector));
                    break;
                case EconomicClasses.middleClass:
                    tierSelector = randGen.randomIntInRange(1, 4);
                    weaponsCarried.set(i, randGen.getWeaponByEconomyAndTier(EconomicClasses.middleClass, tierSelector));
                    break;
                case EconomicClasses.wealthy:
                    tierSelector = randGen.randomIntInRange(1, 5);
                    weaponsCarried.set(i, randGen.getWeaponByEconomyAndTier(EconomicClasses.wealthy, tierSelector));
                    break;
            }
        }
    }

    private void getArmorInPack(int amount, String economicClass, RandomGenerator randGen) {
        for (int i = 0; i < amount; i++) {
            int tierSelector;
            switch (economicClass) {
                case EconomicClasses.beggar:
                    tierSelector = randGen.randomIntInRange(1, 3);
                    armorCarried.set(i, randGen.getArmorByEconomyAndTier(EconomicClasses.beggar, tierSelector));
                    break;
                case EconomicClasses.poor:
                    tierSelector = randGen.randomIntInRange(1, 3);
                    armorCarried.set(i, randGen.getArmorByEconomyAndTier(EconomicClasses.poor, tierSelector));
                    break;
                case EconomicClasses.middleClass:
                    tierSelector = randGen.randomIntInRange(1, 4);
                    armorCarried.set(i, randGen.getArmorByEconomyAndTier(EconomicClasses.middleClass, tierSelector));
                    break;
                case EconomicClasses.wealthy:
                    tierSelector = randGen.randomIntInRange(1, 5);
                    armorCarried.set(i, randGen.getArmorByEconomyAndTier(EconomicClasses.wealthy, tierSelector));
                    break;
            }
        }
    }

    private void getLootInPack(int amount, String economicClass, RandomGenerator randGen) {
        for (int i = 0; i < amount; i++) {
            int tierSelector;
            switch (economicClass) {
                case EconomicClasses.beggar:
                    tierSelector = randGen.randomIntInRange(1, 3);
                    lootCarried.set(i, randGen.getLootByEconomyAndTier(EconomicClasses.beggar, tierSelector));
                    break;
                case EconomicClasses.poor:
                    tierSelector = randGen.randomIntInRange(1, 3);
                    lootCarried.set(i, randGen.getLootByEconomyAndTier(EconomicClasses.poor, tierSelector));
                    break;
                case EconomicClasses.middleClass:
                    tierSelector = randGen.randomIntInRange(1, 4);
                    lootCarried.set(i, randGen.getLootByEconomyAndTier(EconomicClasses.middleClass, tierSelector));
                    break;
                case EconomicClasses.wealthy:
                    tierSelector = randGen.randomIntInRange(1, 5);
                    lootCarried.set(i, randGen.getLootByEconomyAndTier(EconomicClasses.wealthy, tierSelector));
                    break;
            }
        }
    }
}
