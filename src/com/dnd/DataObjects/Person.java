package com.dnd.DataObjects;

public class Person {
    String economicClass;
    String race;
    String racialTraits;
    String name;
    String gender;
    String alignment;
    String[] quirks; //personality traits and physical descriptions
    int age;
    int agePercent;
    int xpValue;

    int level;
    int hp;
    int ac;
    String weaponText;
    int weaponToHitScore;
    int weaponToHitLowScore;
    int weaponToHitHighScore;
    String[] armor;
    boolean hasShield;
    String[] abilities;

    int passivePerception;
    int tolerance;
    int aggression;
    int violentOnRollLowerThan;
    int callsGuardsOnLowerThan;
    int chanceToRecognizePlayer;

    int strength;
    int strMod;
    int dexterity;
    int dexMod;
    int constitution;
    int conMod;
    int intelligence;
    int intMod;
    int wisdom;
    int wisMod;
    int charisma;
    int chrMod;

    int platinum;
    int gold;
    int silver;
    int copper;
    String[] items;
    int dcToPickpocket;

    Boolean hasCallGlyph;
    String callGlyphType;
    Boolean hasBodyguard;
    Boolean isBodyguard;
    String bodyguardForName;
    String[] bodyguardName;

    Boolean hasFamily;
    int familyMemberCount;
    String[] familyNames;
    String areaOfResidence;

    public void create(int partyReputation, Location location) {
        //economic traits
        getEconomicClassFromLocation();
        getQuirksFromEconomicClass();
        getLevelFromClass();
        getStatsFromEconomicClass();
        getInventoryFromClass();

        //race traits
        getRaceFromLocation(location);
        getNameFromRace();
        getAlignmentFromRace();
        getRacialTraitsFromRace();
        getGenderFromRace();
        getAgeFromRace();

        calculateXPValue();
    }

    public void getEconomicClassFromLocation() {
        if (economicClass.equals("traveler")) {

        } else {

        }
    }

    public void getLevelFromClass() {

    }

    public void getQuirksFromEconomicClass() {

    }

    public void getRaceFromLocation(Location location) {

    }

    public void getNameFromRace() {

    }

    public void getAlignmentFromRace() {

    }

    public void getRacialTraitsFromRace() {

    }

    public void getGenderFromRace() {

    }

    public void getAgeFromRace() {

    }

    public void getStatsFromEconomicClass() {
        // hp, primary skills, etc

    }

    public void getInventoryFromClass() {
        //weapons, armor, gold, items carried
    }

    public void calculateXPValue() {

    }
}


