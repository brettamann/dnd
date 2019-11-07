package com.dnd.DataObjects.Items;

import com.dnd.DataObjects.Location;
import com.dnd.DataObjects.EconomicClasses;
import com.dnd.Utilities.RandomCollectionWeighted;
import com.dnd.Utilities.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Pack {
    //the pack holds all items
    public String nameOfOwner;
    public List<Weapon> weaponsCarried = new ArrayList<>();
    public List<Armor> armorCarried = new ArrayList<>();
    public List<Loot> lootCarried = new ArrayList<>();

    public void fillPackRandomly(String economicClass, RandomGenerator randGen, Location location) {
        double itemsCarriedTotal = RandomGenerator.randomIntInRange(location.itemsCarriedLow, location.itemsCarriedHigh);
        switch (economicClass) {
            //this takes the max range from the area and modifies it depending on the class. Wealthy are the full range defined.
            case EconomicClasses.beggar:
                itemsCarriedTotal -= randGen.randomDoubleInRange(2, 4);
                break;
            case EconomicClasses.poor:
                itemsCarriedTotal -= randGen.randomDoubleInRange(1, 3);
                break;
            case EconomicClasses.middleClass:
                itemsCarriedTotal -= randGen.randomDoubleInRange(0, 2);
                break;
            case EconomicClasses.elite:
                itemsCarriedTotal += randGen.randomDoubleInRange(1, 4);
                break;
        }
        if (itemsCarriedTotal < 1) {
            //make sure we don't get a negative
            itemsCarriedTotal = 0;
        }
        int weaponsCarried = 0;
        int armorCarried = 0;
        int lootCarried = 0;
        RandomCollectionWeighted<String> rc = new RandomCollectionWeighted<String>().add(15, "weapon").add(5, "armor").add(80, "loot"); //the worn weapons and armor are part of the "loot" but are not in the pack. As it'd be really rare to carry spare armor, it's reflected here. Spare weapons would be uncommon but not as rare as spare armor.
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
            switch (economicClass) {
                case EconomicClasses.beggar:
                    weaponsCarried.add(randGen.getWeaponByEconomyAndTier(EconomicClasses.beggar, RandomGenerator.randomIntInRange(1, 3)));
                    break;
                case EconomicClasses.poor:
                    weaponsCarried.add(randGen.getWeaponByEconomyAndTier(EconomicClasses.poor, RandomGenerator.randomIntInRange(1, 3)));
                    break;
                case EconomicClasses.middleClass:
                    weaponsCarried.add(randGen.getWeaponByEconomyAndTier(EconomicClasses.middleClass, RandomGenerator.randomIntInRange(1, 4)));
                    break;
                case EconomicClasses.wealthy:
                    weaponsCarried.add(randGen.getWeaponByEconomyAndTier(EconomicClasses.wealthy, RandomGenerator.randomIntInRange(1, 5)));
                    break;
                case EconomicClasses.elite:
                    weaponsCarried.add(randGen.getWeaponByEconomyAndTier(EconomicClasses.wealthy, RandomGenerator.randomIntInRange(4, 5)));
                    break;
            }
        }
    }

    private void getArmorInPack(int amount, String economicClass, RandomGenerator randGen) {
        for (int i = 0; i < amount; i++) {
            switch (economicClass) {
                case EconomicClasses.beggar:
                    armorCarried.add(randGen.getArmorByEconomyAndTier(EconomicClasses.beggar, RandomGenerator.randomIntInRange(1, 3)));
                    break;
                case EconomicClasses.poor:
                    armorCarried.add(randGen.getArmorByEconomyAndTier(EconomicClasses.poor, RandomGenerator.randomIntInRange(1, 3)));
                    break;
                case EconomicClasses.middleClass:
                    armorCarried.add(randGen.getArmorByEconomyAndTier(EconomicClasses.middleClass, RandomGenerator.randomIntInRange(1, 4)));
                    break;
                case EconomicClasses.wealthy:
                    armorCarried.add(randGen.getArmorByEconomyAndTier(EconomicClasses.wealthy, RandomGenerator.randomIntInRange(1, 5)));
                    break;
                case EconomicClasses.elite:
                    armorCarried.add(randGen.getArmorByEconomyAndTier(EconomicClasses.wealthy, RandomGenerator.randomIntInRange(4, 5)));
                    break;
            }
        }
    }

    private void getLootInPack(int amount, String economicClass, RandomGenerator randGen) {
        for (int i = 0; i < amount; i++) {
            switch (economicClass) {
                case EconomicClasses.beggar:
                    lootCarried.add(randGen.getLootByEconomyAndTier(EconomicClasses.beggar, RandomGenerator.randomIntInRange(1, 3)));
                    break;
                case EconomicClasses.poor:
                    lootCarried.add(randGen.getLootByEconomyAndTier(EconomicClasses.poor, RandomGenerator.randomIntInRange(1, 3)));
                    break;
                case EconomicClasses.middleClass:
                    lootCarried.add(randGen.getLootByEconomyAndTier(EconomicClasses.middleClass, RandomGenerator.randomIntInRange(1, 4)));
                    break;
                case EconomicClasses.wealthy:
                    lootCarried.add(randGen.getLootByEconomyAndTier(EconomicClasses.wealthy, RandomGenerator.randomIntInRange(1, 5)));
                    break;
                case EconomicClasses.elite:
                    lootCarried.add(randGen.getLootByEconomyAndTier(EconomicClasses.wealthy, RandomGenerator.randomIntInRange(4, 5)));
                    break;
            }
        }
    }
}
