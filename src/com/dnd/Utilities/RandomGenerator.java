package com.dnd.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.dnd.DataObjects.Items.*;
import com.dnd.DataObjects.Location;
import com.dnd.DataObjects.Races.Languages;
import com.dnd.DataObjects.Races.Races;
import com.dnd.DataObjects.Races.*;

import java.util.List;

public class RandomGenerator {
    public int randomIntInRange(int min, int max) {
        //https://www.mkyong.com/java/java-generate-random-integers-in-a-range/
        //this function includes both the max and the min in the range. entering min=3 and max=22 can be any number 3-22
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public double randomDouble() {
        Random r = new Random();
        return r.nextDouble();
    }

    public double randomPercent(double min, double max) {
        return Math.random() * 100;
    }

    public double randomDoubleInRange(double min, double max) {
        double random = new Random().nextDouble();
        return min + (random * (max - min));

    }

    public Location getRandomLocation(List<Location> locationlist) {
        return locationlist.get(randomIntInRange(0, locationlist.size() - 1));
    }

    public String getRandomFromStringList(List<String> stringList) {
        return stringList.get(randomIntInRange(0, stringList.size() - 1));
    }

    public String getRandomRace() {
        List<String> allRaces = new ArrayList<>(Arrays.asList(
                Races.aarakocra,
                Races.aasimar,
                Races.animalHybrid,
                Races.bugbear,
                Races.centaur,
                Races.dragonborn,
                Races.dwarf,
                Races.elephantine,
                Races.elf,
                Races.firbolg,
                Races.genasi,
                Races.gith,
                Races.gnome,
                Races.goliath,
                Races.goblin,
                Races.halfElf,
                Races.halfOrc,
                Races.halfling,
                Races.hobgoblin,
                Races.human,
                Races.kenku,
                Races.kobold,
                Races.lizardfolk,
                Races.minotaur,
                Races.orc,
                Races.tabaxi,
                Races.tiefling,
                Races.triton,
                Races.tortle,
                Races.vedalken,
                Races.yuanTi
        ));
        return getRandomFromStringList(allRaces);
    }

    public String getRandomLanguage() {
        List<String> allLanguages = new ArrayList<>(Arrays.asList(
            Languages.abyssal,
            Languages.aquan,
            Languages.auran,
            Languages.celestial,
            Languages.common,
            Languages.deepSpeech,
            Languages.draconic,
            Languages.druidic,
            Languages.dwarvish,
            Languages.elvish,
            Languages.giant,
            Languages.gnomish,
            Languages.goblin,
            Languages.gnoll,
            Languages.halfling,
            Languages.ignan,
            Languages.infernal,
            Languages.orc,
            Languages.primordial,
            Languages.sylvan,
            Languages.terran,
            Languages.undercommon
        ));
        return getRandomFromStringList(allLanguages);
    }

    public Armor getArmorByEconomyAndTier(String economicClass, int tier) {
        if (tier > 3 || tier <= 0) {
            tier = randomIntInRange(0, 3);
        }
        switch (economicClass) {
            case EconomicClasses.beggar:
                if (tier > 3 || tier <= 0) {
                    tier = randomIntInRange(0, 3);
                }
                switch (tier) {
                    case 1:
                        return getBeggarArmorTier1();
                    case 2:
                        return getBeggarArmorTier2();
                    case 3:
                        return getBeggarArmorTier3();
                    default:
                        return null;
                }
            case EconomicClasses.poor:
                if (tier > 3 || tier <= 0) {
                    tier = randomIntInRange(1, 3);
                }
                switch (tier) {
                    case 1:
                        return getPoorArmorTier1();
                    case 2:
                        return getPoorArmorTier2();
                    case 3:
                        return getPoorArmorTier3();
                    default:
                        return null;
                }
            case EconomicClasses.middleClass:
                if (tier > 4 || tier <= 0) {
                    tier = randomIntInRange(1, 4);
                }
                switch (tier) {
                    case 1:
                        return getMiddleClassArmorTier1();
                    case 2:
                        return getMiddleClassArmorTier2();
                    case 3:
                        return getMiddleClassArmorTier3();
                    case 4:
                        return getMiddleClassArmorTier4();
                    default:
                        return null;
                }
            case EconomicClasses.wealthy:
                if (tier > 5 || tier <= 0) {
                    tier = randomIntInRange(1, 5);
                }
                switch (tier) {
                    case 1:
                        return getWealthyArmorTier1();
                    case 2:
                        return getWealthyArmorTier2();
                    case 3:
                        return getWealthyArmorTier3();
                    case 4:
                        return getWealthyArmorTier4();
                    case 5:
                        return getWealthyArmorTier5();
                    default:
                        return null;
                }
            default:
                return null;
        }
    }

    private Armor getBeggarArmorTier1() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
            .add(100, StandardArmor.natural);
        return rc.next();
    }

    private Armor getBeggarArmorTier2() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
            .add(50, StandardArmor.padded)
            .add(30, StandardArmor.leather)
            .add(20, StandardArmor.hide);
        return rc.next();
    }

    private Armor getBeggarArmorTier3() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
            .add(50, StandardArmor.studdedLeather)
            .add(50, StandardArmor.scaleMail);
        return rc.next();
    }

    //TODO: add in weapon and armor data to these classes
    private Armor getPoorArmorTier1() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(100, StandardArmor.natural);
        return rc.next();
    }

    private Armor getPoorArmorTier2() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(50, StandardArmor.padded)
                .add(30, StandardArmor.leather)
                .add(20, StandardArmor.hide);
        return rc.next();
    }

    private Armor getPoorArmorTier3() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(50, StandardArmor.studdedLeather)
                .add(50, StandardArmor.scaleMail);
        return rc.next();
    }

    private Armor getMiddleClassArmorTier1() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(100, StandardArmor.natural);
        return rc.next();
    }

    private Armor getMiddleClassArmorTier2() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(50, StandardArmor.padded)
                .add(30, StandardArmor.leather)
                .add(20, StandardArmor.hide);
        return rc.next();
    }

    private Armor getMiddleClassArmorTier3() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(50, StandardArmor.studdedLeather)
                .add(50, StandardArmor.scaleMail);
        return rc.next();
    }

    private Armor getMiddleClassArmorTier4() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(50, StandardArmor.studdedLeather)
                .add(50, StandardArmor.scaleMail);
        return rc.next();
    }

    private Armor getWealthyArmorTier1() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(100, StandardArmor.natural);
        return rc.next();
    }

    private Armor getWealthyArmorTier2() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(50, StandardArmor.padded)
                .add(30, StandardArmor.leather)
                .add(20, StandardArmor.hide);
        return rc.next();
    }

    private Armor getWealthyArmorTier3() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(50, StandardArmor.studdedLeather)
                .add(50, StandardArmor.scaleMail);
        return rc.next();
    }

    private Armor getWealthyArmorTier4() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(50, StandardArmor.studdedLeather)
                .add(50, StandardArmor.scaleMail);
        return rc.next();
    }

    private Armor getWealthyArmorTier5() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(50, StandardArmor.studdedLeather)
                .add(50, StandardArmor.scaleMail);
        return rc.next();
    }

    public Weapon getWeaponByEconomyAndTier(String economicClass, int tier) {
        if (tier > 3 || tier <= 0) {
            tier = randomIntInRange(0, 3);
        }
        switch (economicClass) {
            case EconomicClasses.beggar:
                if (tier > 3 || tier <= 0) {
                    tier = randomIntInRange(0, 3);
                }
                switch (tier) {
                    case 1:
                        return getBeggarWeaponTier1();
                    case 2:
                        return getBeggarWeaponTier2();
                    case 3:
                        return getBeggarWeaponTier3();
                    default:
                        return null;
                }
            case EconomicClasses.poor:
                if (tier > 3 || tier <= 0) {
                    tier = randomIntInRange(1, 3);
                }
                switch (tier) {
                    case 1:
                        return getPoorWeaponTier1();
                    case 2:
                        return getPoorWeaponTier2();
                    case 3:
                        return getPoorWeaponTier3();
                    default:
                        return null;
                }
            case EconomicClasses.middleClass:
                if (tier > 4 || tier <= 0) {
                    tier = randomIntInRange(1, 4);
                }
                switch (tier) {
                    case 1:
                        return getMiddleClassWeaponTier1();
                    case 2:
                        return getMiddleClassWeaponTier2();
                    case 3:
                        return getMiddleClassWeaponTier3();
                    case 4:
                        return getMiddleClassWeaponTier4();
                    default:
                        return null;
                }
            case EconomicClasses.wealthy:
                if (tier > 5 || tier <= 0) {
                    tier = randomIntInRange(1, 5);
                }
                switch (tier) {
                    case 1:
                        return getWealthyWeaponTier1();
                    case 2:
                        return getWealthyWeaponTier2();
                    case 3:
                        return getWealthyWeaponTier3();
                    case 4:
                        return getWealthyWeaponTier4();
                    case 5:
                        return getWealthyWeaponTier5();
                    default:
                        return null;
                }
            default:
                return null;
        }
    }

    private Weapon getBeggarWeaponTier1() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    private Weapon getBeggarWeaponTier2() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    private Weapon getBeggarWeaponTier3() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    private Weapon getPoorWeaponTier1() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    private Weapon getPoorWeaponTier2() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    private Weapon getPoorWeaponTier3() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    private Weapon getMiddleClassWeaponTier1() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    private Weapon getMiddleClassWeaponTier2() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    private Weapon getMiddleClassWeaponTier3() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    private Weapon getMiddleClassWeaponTier4() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    private Weapon getWealthyWeaponTier1() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    private Weapon getWealthyWeaponTier2() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    private Weapon getWealthyWeaponTier3() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    private Weapon getWealthyWeaponTier4() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    private Weapon getWealthyWeaponTier5() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, StandardWeapons.club);
        return rc.next();
    }

    public Loot getLootByEconomyAndTier(String economicClass, int tier) {
        if (tier > 3 || tier <= 0) {
            tier = randomIntInRange(0, 3);
        }
        switch (economicClass) {
            case EconomicClasses.beggar:
                if (tier > 3 || tier <= 0) {
                    tier = randomIntInRange(0, 3);
                }
                switch (tier) {
                    case 1:
                        return getBeggarLootTier1();
                    case 2:
                        return getBeggarLootTier2();
                    case 3:
                        return getBeggarLootTier3();
                    default:
                        return null;
                }
            case EconomicClasses.poor:
                if (tier > 3 || tier <= 0) {
                    tier = randomIntInRange(1, 3);
                }
                switch (tier) {
                    case 1:
                        return getPoorLootTier1();
                    case 2:
                        return getPoorLootTier2();
                    case 3:
                        return getPoorLootTier3();
                    default:
                        return null;
                }
            case EconomicClasses.middleClass:
                if (tier > 4 || tier <= 0) {
                    tier = randomIntInRange(1, 4);
                }
                switch (tier) {
                    case 1:
                        return getMiddleClassLootTier1();
                    case 2:
                        return getMiddleClassLootTier2();
                    case 3:
                        return getMiddleClassLootTier3();
                    case 4:
                        return getMiddleClassLootTier4();
                    default:
                        return null;
                }
            case EconomicClasses.wealthy:
                if (tier > 5 || tier <= 0) {
                    tier = randomIntInRange(1, 5);
                }
                switch (tier) {
                    case 1:
                        return getWealthyLootTier1();
                    case 2:
                        return getWealthyLootTier2();
                    case 3:
                        return getWealthyLootTier3();
                    case 4:
                        return getWealthyLootTier4();
                    case 5:
                        return getWealthyLootTier5();
                    default:
                        return null;
                }
            default:
                return null;
        }
    }

    private Loot getBeggarLootTier1() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }

    private Loot getBeggarLootTier2() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }

    private Loot getBeggarLootTier3() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }

    private Loot getPoorLootTier1() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }

    private Loot getPoorLootTier2() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }

    private Loot getPoorLootTier3() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }

    private Loot getMiddleClassLootTier1() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }

    private Loot getMiddleClassLootTier2() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }

    private Loot getMiddleClassLootTier3() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }

    private Loot getMiddleClassLootTier4() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }

    private Loot getWealthyLootTier1() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }

    private Loot getWealthyLootTier2() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }

    private Loot getWealthyLootTier3() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }

    private Loot getWealthyLootTier4() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }

    private Loot getWealthyLootTier5() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(100, StandardLoot.barrel);
        return rc.next();
    }
}
