package com.masters_of_destiny.DataObjects.Items;

import com.masters_of_destiny.Utilities.RandomGenerator;
import com.masters_of_destiny.Utilities.Screen;

import java.util.ArrayList;
import java.util.List;

public class Armor {
    public String name;
    public String description;
    public List<String> abilities = new ArrayList<>();
    public int strRequirement; //some armor requires certain strength levels
    public int ac;
    public int dexBonusMax; //some armor allows dexterity to add onto the AC of armor, up to a point. just use a huge number like 100 if it's unlimited
    public String material; //sometimes the armor makeup matters, like with shocking grasp

    public int valuePlatinum;
    public int valueGold;
    public int valueSilver;
    public int valueCopper;
    public String rarity;
    public boolean hasCallGlyph;

    public Armor(String name, String description, List<String> abilities, int strRequirement, int ac, int dexBonusMax, String material, int valuePlatinum, int valueGold, int valueSilver, int valueCopper, String rarity) {
        this.name = name;
        this.description = description;
        this.abilities = abilities;
        this.strRequirement = strRequirement;
        this.ac = ac;
        this.dexBonusMax = dexBonusMax;
        this.material = material;
        this.valuePlatinum = valuePlatinum;
        this.valueGold = valueGold;
        this.valueSilver = valueSilver;
        this.valueCopper = valueCopper;
        this.rarity = rarity;
    }

    public Armor(Armor other) {
        this.name = other.name;
        this.description = other.description;
        this.abilities = new ArrayList<>(other.abilities);
        this.strRequirement = other.strRequirement;
        this.ac = other.ac;
        this.dexBonusMax = other.dexBonusMax;
        this.material = other.material;
        this.valuePlatinum = other.valuePlatinum;
        this.valueGold = other.valueGold;
        this.valueSilver = other.valueSilver;
        this.valueCopper = other.valueCopper;
        this.rarity = other.rarity;
        this.hasCallGlyph = other.hasCallGlyph;
    }

    public void setPlusEnchantmentByLevel(int plusEnchantmentLevel) {
        name = name + " +" + plusEnchantmentLevel;
        ac += plusEnchantmentLevel;
    }

    public void addRandomAbilityByTier(int tier) {
        RandomGenerator randgen = new RandomGenerator();
        abilities.add(randgen.getRandomArmorAbilityByTier(tier));
    }

    public void displayArmorStats() {
        Screen.print("Armor: " + name + ", AC: " + ac + " + " + dexBonusMax + " max DEX bonus ");
        for (int i = 0; i < abilities.size() - 1; i++){
            Screen.print(abilities.get(i));
        }
    }

    public String getArmorStatsStringForDisplay() {
        String stringToReturn = "Armor: " + name + ", AC: " + ac + " + " + dexBonusMax + " max DEX bonus ";
        for (int i = 0; i < abilities.size() - 1; i++) {
            if (!abilities.get(i).equals(""))
            stringToReturn = stringToReturn + "\n\t" + abilities.get(i);
        }
        return stringToReturn;
    }
}
