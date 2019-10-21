package com.dnd.DataObjects;

public class Location {
    public String name;
    public String description;
    public String[] pointsOfInterest;
    public String[] connectsTo;
    public int reputationInArea; //separate from party reputation
    public int alertLevel;

    //to help build commoners in an area
    public int aarakocraChance;
    public int aasimarChance;
    public int animalHybridChance;
    public int bugbearChance;
    public int centaurChance;
    public int dragonbornChance;
    public int dwarfChance;
    public int elephantineChance;
    public int elfChance;
    public int firbolgChance;
    public int genasiChance;
    public int githChance;
    public int gnomeChance;
    public int goblinChance;
    public int goliathChance;
    public int halfElfChance;
    public int halfOrcChance;
    public int halflingChance;
    public int hobgoblinChance;
    public int humanChance;
    public int kenkuChance;
    public int koboldChance;
    public int lizardfolkChance;
    public int minotaurChance;
    public int orcChance;
    public int yuanTiChance;
    public int tabaxiChance;
    public int tieflingChance;
    public int tritonChance;
    public int tortleChance;
    public int vedalkenChance;

    public int travelerChance; //traveler is someone who does not live in the area.
    public int beggarChance;
    public int poorChance;
    public int middleClassChance;
    public int wealthyChance;
    public int toleranceModifier;
    public int aggressionModifier;
    public int chanceToCallGuardsModifier;
    public int pickpocketDcModifier;
    public int platinumLow;
    public int platinumHigh;
    public int goldLow;
    public int goldHigh;
    public int silverLow;
    public int silverHigh;
    public int copperLow;
    public int copperHigh;
    public int lockDCLow;
    public int lockDCHigh;
    public int itemsCarriedLow;
    public int itemsCarriedHigh;

    public int chanceOfGuardsInArea; //how likely it is that a guard is close enough to report trouble
    public int guardGroupLowSize; // these determine how many guards would be around
    public int guardGroupHighSize;
    public int fastestCallTime; //how long it takes for reinforcements to be called
    public int slowestCallTime;
    public int chanceOfCommonersInArea; //how likely it is that someone is out on the street.
    public int commonerGroupLowSize;
    public int commonerHighLowSize;
}
