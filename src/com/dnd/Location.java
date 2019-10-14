package com.dnd;

public class Location {
    String name;
    String description;
    String[] pointsOfInterest;
    String[] connectsTo;
    int reputationInArea; //separate from party reputation
    int alertLevel;

    //to help build commoners in an area
    String[] mostCommonRaces;
    String[] commonRaces;
    String[] uncommonRaces;
    String[] leastCommonRaces;

    int travelerChance; //traveler is someone who does not live in the area.
    int beggarChance;
    int poorChance;
    int middleClassChance;
    int wealthyChance;
    int toleranceModifier;
    int aggressionModifier;
    int chanceToCallGuardsModifier;
    int pickpocketDcModifier;
    int platinumLow;
    int platinumHigh;
    int goldLow;
    int goldHigh;
    int silverLow;
    int silverHigh;
    int copperLow;
    int copperHigh;
    int lockDCLow;
    int lockDCHigh;
    int itemsCarriedLow;
    int itemsCarriedHigh;

    int chanceOfGuardsInArea; //how likely it is that a guard is close enough to report trouble
    int guardGroupLowSize; // these determine how many guards would be around
    int guardGroupHighSize;
    int fastestCallTime; //how long it takes for reinforcements to be called
    int slowestCallTime;
    int chanceOfCommonersInArea; //how likely it is that someone is out on the street.
    int commonerGroupLowSize;
    int commonerHighLowSize;





}
