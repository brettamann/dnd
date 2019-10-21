package com.dnd.DataObjects.Races;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {
    public String raceName;
    public String bodySize;

    public int walkSpeed;
    public int flySpeed;
    public int swimSpeed;
    public int climbSpeed;

    public int lawfulGoodChance;
    public int chaoticGoodChance;
    public int neutralGoodChance;

    public int lawfulEvilChance;
    public int chaoticEvilChance;
    public int neutralEvilChance;

    public int lawfulNeutralChance;
    public int chaoticNeutralChance;
    public int trueNeutralChance;

    public int strMod;
    public int dexMod;
    public int conMod;
    public int wisMod;
    public int intMod;
    public int chrMod;

    public List<String> abilities;
    public List<String> languages; //if the race has "x and 1 other" language, set the language in that "1 other" slot to "other"

    public int minAge;
    public int maxAge;
    public int braveryMod;

    public int familySizeMax;

    public Race(String raceName, String bodySize, int walkSpeed, int flySpeed, int swimSpeed, int climbSpeed, int lawfulGoodChance, int chaoticGoodChance, int neutralGoodChance, int lawfulEvilChance, int chaoticEvilChance, int neutralEvilChance, int lawfulNeutralChance, int chaoticNeutralChance, int trueNeutralChance, int strMod, int dexMod, int conMod, int wisMod, int intMod, int chrMod, List<String> abilities, List<String> languages,int minAge, int maxAge, int braveryMod, int familySizeMax) {
        this.raceName = raceName;
        this.bodySize = bodySize;
        this.walkSpeed = walkSpeed;
        this.flySpeed = flySpeed;
        this.swimSpeed = swimSpeed;
        this.climbSpeed = climbSpeed;
        this.lawfulGoodChance = lawfulGoodChance;
        this.chaoticGoodChance = chaoticGoodChance;
        this.neutralGoodChance = neutralGoodChance;
        this.lawfulEvilChance = lawfulEvilChance;
        this.chaoticEvilChance = chaoticEvilChance;
        this.neutralEvilChance = neutralEvilChance;
        this.lawfulNeutralChance = lawfulNeutralChance;
        this.chaoticNeutralChance = chaoticNeutralChance;
        this.trueNeutralChance = trueNeutralChance;
        this.strMod = strMod;
        this.dexMod = dexMod;
        this.conMod = conMod;
        this.wisMod = wisMod;
        this.intMod = intMod;
        this.chrMod = chrMod;
        this.abilities = abilities;
        this.languages = languages;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.braveryMod = braveryMod;
        this.familySizeMax = familySizeMax;
    }
}
