package com.dnd.DataObjects.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Weapon {
    //non-combat
    public String name;
    public String description;
    public int range;
    public int shortRange; //for throwing/missiles
    public int longRange; //for throwing/missiles
    public List<String> type;
    public List<String> abilities;
    public int valuePlatinum;
    public int valueGold;
    public int valueSilver;
    public int valueCopper;
    public String rarity;



    public int toHitBonus;

    //physical
    public int slashingDamageMin;
    public int slashingDamageMax;

    public int bludgeoningDamageMin;
    public int bludgeoningDamageMax;

    public int piercingDamageMin;
    public int piercingDamageMax;

    public int alternateDamageMin;
    public int alternateDamageMax;
    public String alternateDamageType;

    //elemental
    public int acidDamageMin;
    public int acidDamageMax;

    public int coldDamageMin;
    public int coldDamageMax;

    public int fireDamageMin;
    public int fireDamageMax;

    public int forceDamageMin;
    public int forceDamageMax;

    public int lightningDamageMin;
    public int lightningDamageMax;

    public int necroticDamageMin;
    public int necroticDamageMax;

    public int poisonDamageMin;
    public int poisonDamageMax;

    public int psychicDamageMin;
    public int psychicDamageMax;

    public int radiantDamageMin;
    public int radiantDamageMax;

    public int thunderDamageMin;
    public int thunderDamageMax;

    public int toHitFromStats; //this comes from the wielder, not from the weapon but is attached to the weapon for ease of use
    public boolean userIsProficient;
    public int combinedToHitBonus;

    public Weapon(String name, String description, int range, int shortRange, int longRange, List<String> type, List<String> abilities, int valuePlatinum, int valueGold, int valueSilver, int valueCopper, String rarity, int toHitBonus, int slashingDamageMin, int slashingDamageMax, int bludgeoningDamageMin, int bludgeoningDamageMax, int piercingDamageMin, int piercingDamageMax, int alternateDamageMin, int alternateDamageMax, String alternateDamageType, int acidDamageMin, int acidDamageMax, int coldDamageMin, int coldDamageMax, int fireDamageMin, int fireDamageMax, int forceDamageMin, int forceDamageMax, int lightningDamageMin, int lightningDamageMax, int necroticDamageMin, int necroticDamageMax, int poisonDamageMin, int poisonDamageMax, int psychicDamageMin, int psychicDamageMax, int radiantDamageMin, int radiantDamageMax, int thunderDamageMin, int thunderDamageMax, int toHitFromStats, boolean userIsProficient, int combinedToHitBonus) {
        this.name = name;
        this.description = description;
        this.range = range;
        this.shortRange = shortRange;
        this.longRange = longRange;
        this.type = type;
        this.abilities = abilities;
        this.valuePlatinum = valuePlatinum;
        this.valueGold = valueGold;
        this.valueSilver = valueSilver;
        this.valueCopper = valueCopper;
        this.rarity = rarity;
        this.toHitBonus = toHitBonus;
        this.slashingDamageMin = slashingDamageMin;
        this.slashingDamageMax = slashingDamageMax;
        this.bludgeoningDamageMin = bludgeoningDamageMin;
        this.bludgeoningDamageMax = bludgeoningDamageMax;
        this.piercingDamageMin = piercingDamageMin;
        this.piercingDamageMax = piercingDamageMax;
        this.alternateDamageMin = alternateDamageMin;
        this.alternateDamageMax = alternateDamageMax;
        this.alternateDamageType = alternateDamageType;
        this.acidDamageMin = acidDamageMin;
        this.acidDamageMax = acidDamageMax;
        this.coldDamageMin = coldDamageMin;
        this.coldDamageMax = coldDamageMax;
        this.fireDamageMin = fireDamageMin;
        this.fireDamageMax = fireDamageMax;
        this.forceDamageMin = forceDamageMin;
        this.forceDamageMax = forceDamageMax;
        this.lightningDamageMin = lightningDamageMin;
        this.lightningDamageMax = lightningDamageMax;
        this.necroticDamageMin = necroticDamageMin;
        this.necroticDamageMax = necroticDamageMax;
        this.poisonDamageMin = poisonDamageMin;
        this.poisonDamageMax = poisonDamageMax;
        this.psychicDamageMin = psychicDamageMin;
        this.psychicDamageMax = psychicDamageMax;
        this.radiantDamageMin = radiantDamageMin;
        this.radiantDamageMax = radiantDamageMax;
        this.thunderDamageMin = thunderDamageMin;
        this.thunderDamageMax = thunderDamageMax;
        this.toHitFromStats = toHitFromStats;
        this.userIsProficient = userIsProficient;
        this.combinedToHitBonus = combinedToHitBonus;
    }

    public int getTotalUntypedDamageMin() {
        return slashingDamageMin
            + bludgeoningDamageMin
            + piercingDamageMin
            + fireDamageMin
            + coldDamageMin
            + poisonDamageMin
            + psychicDamageMin
            + necroticDamageMin
            + radiantDamageMin
            + lightningDamageMin
            + thunderDamageMin
            + forceDamageMin;
    }

    public int getTotalUntypedDamageMax() {
        return slashingDamageMin + slashingDamageMax
            + bludgeoningDamageMax
            + piercingDamageMax
            + fireDamageMax
            + coldDamageMax
            + poisonDamageMax
            + psychicDamageMax
            + necroticDamageMax
            + radiantDamageMax
            + lightningDamageMax
            + thunderDamageMax
            + forceDamageMax;
    }
}
