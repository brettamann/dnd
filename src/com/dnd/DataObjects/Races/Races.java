package com.dnd.DataObjects.Races;

import com.dnd.DataObjects.Sizes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Races {
    public static final String aarakocra = "aaracokra";
    public static final String aasimar = "aasimar";
    public static final String animalHybrid = "animal-hybrid";
    public static final String bugbear = "bugbear";
    public static final String centaur = "centaur";
    public static final String dragonborn = "dragonborn";
    public static final String dwarf = "dwarf";
    public static final String elephantine = "elephantine";
    public static final String elf = "elf";
    public static final String firbolg = "firbolg";
    public static final String genasi = "genasi";
    public static final String gith = "gith";
    public static final String gnome = "gnome";
    public static final String goliath = "goliath";
    public static final String goblin = "goblin";
    public static final String halfElf = "half-elf";
    public static final String halfOrc = "half-orc";
    public static final String halfling = "halfling";
    public static final String hobgoblin = "hobgoblin";
    public static final String human = "human";
    public static final String kenku = "kenku";
    public static final String kobold = "kobold";
    public static final String lizardfolk = "lizardfolk";
    public static final String minotaur = "minotaur";
    public static final String orc = "orc";
    public static final String tabaxi = "tabaxi";
    public static final String tiefling = "tiefling";
    public static final String triton = "triton";
    public static final String tortle = "tortle";
    public static final String vedalken = "vedalken";
    public static final String yuanTi = "yuan-ti";

    public List<Race> generateRaceData() {
        //TODO: Fill out race data
        List<Race> raceData = new ArrayList<Race>((Arrays.asList(
            //TODO: Finish filling out race data from genasi down
            new Race(aarakocra, Sizes.medium, 25, 50, 15, 15, 12, 11, 11, 11, 11, 11, 11, 11, 11, 0, 2, 0, 1, 0, 0, new ArrayList<>(Arrays.asList("Can fly, 50 speed")), new ArrayList<>(Arrays.asList(Languages.common, Languages.auran)),3,30,-2, 4),
            new Race(aasimar, Sizes.medium, 30, 0, 15, 15, 15, 15, 15, 5, 5, 5, 10, 10, 10, 0, 0, 0, 0, 0, 2, new ArrayList<>(Arrays.asList("Darkvision to 60 ft", "Resistances: necrotic, radiant","As an action can touch another creature and cause it to regain [level] hp", "Knows the Light cantrip (cause an object to glow)")), new ArrayList<>(Arrays.asList(Languages.common, Languages.celestial)),18,160,5, 4),
            new Race(animalHybrid, Sizes.medium, 30, 0, 15, 15, 12, 11, 11, 11, 11, 11, 11, 11, 11, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("Combines 2 races")), new ArrayList<>(Arrays.asList(Languages.common, "other","other")),18,60,0, 6),
            new Race(bugbear, Sizes.medium, 30, 0, 15, 15, 1, 1, 3, 25, 30, 25, 5, 5, 5, 1, 1, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("Darkvision to 60 ft", "Extra 5 ft reach with melee weapons","Deals an extra 2d6 on surprise rounds")), new ArrayList<>(Arrays.asList(Languages.common, Languages.goblin)),18,80,1, 6),
            new Race(centaur, Sizes.medium, 50, 0, 15, 15, 20, 50, 20, 2, 1, 1, 2, 2, 2, 2, 0, 1, 0, 0, 0, new ArrayList<>(Arrays.asList("Large size", "50 run speed unless wearing armor heavier than hide, or with a rider", "Hoof attack: 2d6+STR Modifier and push target back 5 ft unless they succeed in DC 10 STR save", "Doesn't provoke attacks of opportunity when moving","Charge: Can charge 30 ft and hit target, dealing 1d8-3d8 damage depending on level", "Disadvantage on stealth when walking on hard surfaces")), new ArrayList<>(Arrays.asList(Languages.common, "other")),18,60,0, 5),
            new Race(dragonborn, Sizes.medium, 30, 0, 15, 15, 15, 15, 15, 5, 5, 5, 10, 10, 10, 2, 0, 0, 0, 0, 1, new ArrayList<>(Arrays.asList("Breath Weapon: Once per long rest, 2d6-4d6 elemental damage depending on type of dragonborn, 15 ft cone or 30 ft line, 8+CON modifier save for half")), new ArrayList<>(Arrays.asList(Languages.common, Languages.draconic)),18,80,3, 7),
            new Race(dwarf, Sizes.medium, 25, 0, 15, 15, 20, 20, 20, 4, 3, 3, 10, 10, 10, 0, 0, 2, 0, 0, 0, new ArrayList<>(Arrays.asList("Darkvision to 60 ft", "Resistant to poison, advantage on poison saves")), new ArrayList<>(Arrays.asList(Languages.common, Languages.dwarvish)),14,350,2, 5),
            new Race(elephantine, Sizes.medium, 30, 0, 15, 15, 20, 20, 20, 4, 3, 3, 10, 10, 10, 2, 0, 0, 1, 0, 0, new ArrayList<>(Arrays.asList("Large size", "When making saves against fear effects, rerolls anything less than 10","Empowered strikes: sacrifice all movement speed during turn, adds 2*STR modifier damage to all attacks until its next turn","Advantage on CON saves","Disadvantage on DEX saves","Advantage on checks using smell")), new ArrayList<>(Arrays.asList(Languages.common, "other")),18,300,4, 4),
            new Race(elf, Sizes.medium, 30, 0, 15, 15, 20, 20, 20, 4, 3, 3, 10, 10, 10, 0, 2, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("Immune to magical sleep", "Advantage against any charm effect","Only sleeps 4 hrs per day in a trance")), new ArrayList<>(Arrays.asList(Languages.common, Languages.elvish)),18,750,0, 5),
            new Race(firbolg, Sizes.medium, 30, 0, 15, 15, 15, 15, 15, 5, 5, 5, 10, 10, 10, 1, 0, 0, 2, 0, 0, new ArrayList<>(Arrays.asList("Cantrips: Detect magic, Disguise self", "Once per rest can go invisible for 1 turn for a bonus action. Any action it takes that would affect another person breaks dispels this.","Can somewhat communicate with beasts and plants")), new ArrayList<>(Arrays.asList(Languages.common, Languages.giant,Languages.elvish)),18,500,3, 5),
            new Race(genasi, Sizes.medium, 30, 0, 15, 15, 5, 5, 5, 5, 5, 5, 23, 24, 23, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,120,0, 3),
            new Race(gith, Sizes.medium, 30, 0, 15, 15, 39, 2, 2, 39, 2, 2, 10, 2, 2, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,100,0, 5),
            new Race(gnome, Sizes.medium, 30, 0, 15, 15, 15, 15, 15, 5, 5, 5, 10, 10, 10, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,400,-2, 7),
            new Race(goliath, Sizes.medium, 30, 0, 15, 15, 15, 15, 15, 3, 9, 3, 10, 15, 15, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,90,7, 3),
            new Race(goblin, Sizes.medium, 30, 0, 15, 15, 1, 2, 2, 27, 27, 26, 5, 5, 5, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),24,60,-6, 12),
            new Race(halfElf, Sizes.medium, 30, 0, 15, 15, 15, 15, 15, 5, 5, 5, 10, 10, 10, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,180,0, 8),
            new Race(halfOrc, Sizes.medium, 30, 0, 15, 15, 12, 11, 11, 11, 11, 11, 11, 11, 11, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,75,4, 6),
            new Race(halfling, Sizes.medium, 30, 0, 15, 15, 15, 15, 15, 5, 5, 5, 10, 10, 10, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),14,250,-4, 10),
            new Race(hobgoblin, Sizes.medium, 30, 0, 15, 15, 1, 2, 2, 27, 27, 26, 5, 5, 5, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,90,-1, 6),
            new Race(human, Sizes.medium, 30, 0, 15, 15, 15, 15, 15, 5, 5, 5, 10, 10, 10, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,90,0, 8),
            new Race(kenku, Sizes.medium, 30, 0, 15, 15, 5, 5, 5, 5, 5, 5, 23, 24, 23, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,60,-2, 12),
            new Race(kobold, Sizes.medium, 30, 0, 15, 15, 0, 0, 0, 90, 1, 6, 1, 1, 1, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,135,-4, 12),
            new Race(lizardfolk, Sizes.medium, 30, 0, 15, 15, 12, 11, 11, 11, 11, 11, 11, 11, 11, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),16,80,-1, 12),
            new Race(minotaur, Sizes.medium, 30, 0, 15, 15, 8, 8, 8, 8, 8, 8, 17, 18, 17, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),20,80,8, 3),
            new Race(orc, Sizes.medium, 30, 0, 15, 15, 1, 2, 2, 27, 27, 26, 5, 5, 5, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,50,5, 5),
            new Race(tabaxi, Sizes.medium, 30, 0, 15, 15, 5, 5, 5, 5, 5, 5, 23, 24, 23, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),30,90,-2, 7),
            new Race(tiefling, Sizes.medium, 30, 0, 15, 15, 9, 17, 8, 8, 17, 8, 8, 17, 8, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),20,120,0, 4),
            new Race(triton, Sizes.medium, 30, 0, 15, 15, 80, 5, 5, 0, 0, 0, 3, 4, 3, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,200,1, 6),
            new Race(tortle, Sizes.medium, 30, 0, 30, 15, 20, 20, 20, 4, 3, 3, 10, 10, 10, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,50,2, 5),
            new Race(vedalken, Sizes.medium, 30, 0, 15, 15, 15, 15, 15, 5, 5, 5, 10, 10, 10, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,500,0, 7),
            new Race(yuanTi, Sizes.medium, 30, 0, 15, 15, 12, 11, 11, 11, 11, 11, 11, 11, 11, 0, 0, 0, 0, 0, 0, new ArrayList<>(Arrays.asList("", "")), new ArrayList<>(Arrays.asList("", "")),18,120,-1, 8)
        )));
        return raceData;
    }
}
