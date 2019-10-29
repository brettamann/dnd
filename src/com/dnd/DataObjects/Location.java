package com.dnd.DataObjects;

import java.util.List;

public class Location {
    public String name;
    public String description;
    public List<String> pointsOfInterest;
    public List<String> connectsTo;
    public int reputationInArea; //separate from party reputation
    public int alertLevel;

    //to help build commoners in an area
    public double aarakocraChance;
    public double aasimarChance;
    public double animalHybridChance;
    public double bugbearChance;
    public double centaurChance;
    public double dragonbornChance;
    public double dwarfChance;
    public double elephantineChance;
    public double elfChance;
    public double firbolgChance;
    public double genasiChance;
    public double githChance;
    public double gnomeChance;
    public double goblinChance;
    public double goliathChance;
    public double halfElfChance;
    public double halfOrcChance;
    public double halflingChance;
    public double hobgoblinChance;
    public double humanChance;
    public double kenkuChance;
    public double koboldChance;
    public double lizardfolkChance;
    public double minotaurChance;
    public double orcChance;
    public double yuanTiChance;
    public double tabaxiChance;
    public double tieflingChance;
    public double tritonChance;
    public double tortleChance;
    public double vedalkenChance;

    public double travelerChance; //traveler is someone who does not live in the area.
    public double beggarChance;
    public double poorChance;
    public double middleClassChance;
    public double wealthyChance;
    public double eliteChance;
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
    public int commonerGroupHighSize;

    public Location(String name, String description, List<String> pointsOfInterest, List<String> connectsTo, int reputationInArea, int alertLevel, double aarakocraChance, double aasimarChance, double animalHybridChance, double bugbearChance, double centaurChance, double dragonbornChance, double dwarfChance, double elephantineChance, double elfChance, double firbolgChance, double genasiChance, double githChance, double gnomeChance, double goblinChance, double goliathChance, double halfElfChance, double halfOrcChance, double halflingChance, double hobgoblinChance, double humanChance, double kenkuChance, double koboldChance, double lizardfolkChance, double minotaurChance, double orcChance, double yuanTiChance, double tabaxiChance, double tieflingChance, double tritonChance, double tortleChance, double vedalkenChance, double travelerChance, double beggarChance, double poorChance, double middleClassChance, double wealthyChance, double eliteChance, int toleranceModifier, int aggressionModifier, int chanceToCallGuardsModifier, int pickpocketDcModifier, int platinumLow, int platinumHigh, int goldLow, int goldHigh, int silverLow, int silverHigh, int copperLow, int copperHigh, int lockDCLow, int lockDCHigh, int itemsCarriedLow, int itemsCarriedHigh, int chanceOfGuardsInArea, int guardGroupLowSize, int guardGroupHighSize, int fastestCallTime, int slowestCallTime, int chanceOfCommonersInArea, int commonerGroupLowSize, int commonerGroupHighSize) {
        this.name = name;
        this.description = description;
        this.pointsOfInterest = pointsOfInterest;
        this.connectsTo = connectsTo;
        this.reputationInArea = reputationInArea;
        this.alertLevel = alertLevel;
        this.aarakocraChance = aarakocraChance;
        this.aasimarChance = aasimarChance;
        this.animalHybridChance = animalHybridChance;
        this.bugbearChance = bugbearChance;
        this.centaurChance = centaurChance;
        this.dragonbornChance = dragonbornChance;
        this.dwarfChance = dwarfChance;
        this.elephantineChance = elephantineChance;
        this.elfChance = elfChance;
        this.firbolgChance = firbolgChance;
        this.genasiChance = genasiChance;
        this.githChance = githChance;
        this.gnomeChance = gnomeChance;
        this.goblinChance = goblinChance;
        this.goliathChance = goliathChance;
        this.halfElfChance = halfElfChance;
        this.halfOrcChance = halfOrcChance;
        this.halflingChance = halflingChance;
        this.hobgoblinChance = hobgoblinChance;
        this.humanChance = humanChance;
        this.kenkuChance = kenkuChance;
        this.koboldChance = koboldChance;
        this.lizardfolkChance = lizardfolkChance;
        this.minotaurChance = minotaurChance;
        this.orcChance = orcChance;
        this.yuanTiChance = yuanTiChance;
        this.tabaxiChance = tabaxiChance;
        this.tieflingChance = tieflingChance;
        this.tritonChance = tritonChance;
        this.tortleChance = tortleChance;
        this.vedalkenChance = vedalkenChance;
        this.travelerChance = travelerChance;
        this.beggarChance = beggarChance;
        this.poorChance = poorChance;
        this.middleClassChance = middleClassChance;
        this.wealthyChance = wealthyChance;
        this.eliteChance = eliteChance;
        this.toleranceModifier = toleranceModifier;
        this.aggressionModifier = aggressionModifier;
        this.chanceToCallGuardsModifier = chanceToCallGuardsModifier;
        this.pickpocketDcModifier = pickpocketDcModifier;
        this.platinumLow = platinumLow;
        this.platinumHigh = platinumHigh;
        this.goldLow = goldLow;
        this.goldHigh = goldHigh;
        this.silverLow = silverLow;
        this.silverHigh = silverHigh;
        this.copperLow = copperLow;
        this.copperHigh = copperHigh;
        this.lockDCLow = lockDCLow;
        this.lockDCHigh = lockDCHigh;
        this.itemsCarriedLow = itemsCarriedLow;
        this.itemsCarriedHigh = itemsCarriedHigh;
        this.chanceOfGuardsInArea = chanceOfGuardsInArea;
        this.guardGroupLowSize = guardGroupLowSize;
        this.guardGroupHighSize = guardGroupHighSize;
        this.fastestCallTime = fastestCallTime;
        this.slowestCallTime = slowestCallTime;
        this.chanceOfCommonersInArea = chanceOfCommonersInArea;
        this.commonerGroupLowSize = commonerGroupLowSize;
        this.commonerGroupHighSize = commonerGroupHighSize;
    }
}
