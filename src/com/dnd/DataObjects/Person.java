package com.dnd.DataObjects;

import com.dnd.DataObjects.Items.*;
import com.dnd.DataObjects.Races.Race;
import com.dnd.DataObjects.Races.Races;
import com.dnd.Utilities.Colors;
import com.dnd.Utilities.RandomCollectionWeighted;
import com.dnd.Utilities.RandomGenerator;
import com.dnd.Utilities.Screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
    Rarities rarities = new Rarities();
    private RandomCollectionWeighted<String> rc;
    private RandomGenerator randGen = new RandomGenerator();

    private String economicClass;
    private boolean isTraveler;
    private Location livesIn;
    private String race;
    private String name;
    private String gender;
    private String alignment;
    private List<String> quirks; //personality traits and physical descriptions
    private int age;
    private int agePercent;
    private int xpValue;
    private Pack packCarried = new Pack();
    private Boolean hasFamily;
    private int familyMemberCount;
    private String mood;

    private int level;
    private int hpMax;
    private int hpCurrent;
    private int ac;
    private List<Weapon> wornWeapons;
    private List<Armor> wornArmor = new ArrayList<>(2); //index 0 is the main armor, index 1 is shield, if applicable
    private boolean hasShield = false;
    //String racialTraits; this is now in raceData
    //List<String> abilities; this is now in raceData
    private Race raceData;

    private int passivePerception;
    private int bravery;//what intimidation roll (&+) that makes them flee or submit

    private int strength;
    private int strMod;
    private int dexterity;
    private int dexMod;
    private int constitution;
    private int conMod;
    private int intelligence;
    private int intMod;
    private int wisdom;
    private int wisMod;
    private int charisma;
    private int chrMod;

    private int platinum;
    private int gold;
    private int silver;
    private int copper;
    private int dcToPickpocket;

    private Boolean hasCallGlyph;
    private String callGlyphType;
    private Boolean hasBodyguard;
    //TODO: create a function that attaches bodyguards to the person
    private List<Person> bodyguardList;

    public void displayAll(Screen screen) {
        screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), name + ", the " + age + " (" + agePercent + "% of " + raceData.maxAge + ") yrs old " + gender + " " + raceData.raceName + ". Level " + level + ", EXP Value: " + xpValue);
        screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass),hpCurrent + "/" + hpMax + " hp, " + ac + " AC");
        displayPersonalityTraits(screen);
        displayCombatStats(screen, false);
        displayPackContents(screen);
        screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), "Pickpocket DC: " + dcToPickpocket);
    }

    public void displayPersonalityTraits(Screen screen) {
        screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), "Personality Traits: (" + alignment + ", " + mood + " mood)");
        for (int i = 0; i < quirks.size() - 1; i++) {
            if (!quirks.get(i).equals("")) {
                screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), "\t" + quirks.get(i));
            }
        }
    }

    public void displayPackContents(Screen screen) {
        screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), "Items in " + name + "'s pack:");
        for (int i = 0; i < packCarried.weaponsCarried.size() - 1; i++) {
            screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), "\t" + packCarried.weaponsCarried.get(i).getWeaponStatsStringForDisplay());
        }
        for (int i = 0; i < packCarried.armorCarried.size() - 1; i++) {
            screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), "\t" + packCarried.armorCarried.get(i).getArmorStatsStringForDisplay(screen));
        }
        for (int i = 0; i < packCarried.lootCarried.size() - 1; i++) {
            screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), "\t" + packCarried.lootCarried.get(i).getDescriptionStringForDisplay(screen));
        }
    }

    public void displayCombatStats(Screen screen, boolean shouldPrintName) {
        if (shouldPrintName) {
            screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), name + ", the " + raceData.raceName + ": " + hpCurrent + "/" + hpMax + " hp, " + ac + " AC");
        }
        screen.printByColor(rarities.getColorByRarityOrEconomy(economicClass), "STR: " + strength + "(" + strMod + ")," + " DEX: " + dexterity + "(" + dexMod + "), " + " CON: " + constitution + "(" + conMod + "), " + " INT: " + intelligence + "(" + intMod + "), " + " WIS: " + wisdom + "(" + wisMod + "), " + " CHR: " + charisma + "(" + chrMod + "), " + "Passive Perception: " + passivePerception);
        screen.printByColor(rarities.getColorByRarityOrEconomy(economicClass), "Armor: " + wornArmor.get(0).name);
        if (hasShield) {
            screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), " + " + wornArmor.get(1).name);
        } else {
            System.out.println(" ");
        }
        for (int i = 0; i < wornArmor.size() - 1; i++) {
            screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), wornArmor.get(i).name + " abilities:");
            for (int j = 0; j < wornArmor.get(i).abilities.size() - 1; j++) {
                screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), wornArmor.get(i).name + " ability " + j + ": " + wornArmor.get(i).abilities.get(j));
            }
        }
        if (wornWeapons.get(0).getIsTwoHanded()) {
            screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), "Both Hands: " + wornWeapons.get(0).getWeaponStatsStringForDisplay());
        } else {
            screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), "Main Hand: " + wornWeapons.get(0).getWeaponStatsStringForDisplay());
            if (wornWeapons.size() > 1) {
                screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), "Off Hand: " + wornWeapons.get(1).getWeaponStatsStringForDisplay());
            } else if (hasShield) {
                screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), "Off Hand: (Shield)");
            }
        }
        for (int i = 0; i < raceData.abilities.size() - 1; i++) {
            if (!raceData.abilities.get(i).equals("")) {
                screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass), raceData.raceName + " ability: " + raceData.abilities.get(i));
            }
        }
        //screen.printLnByColor(rarities.getColorByRarityOrEconomy(economicClass),name + ", the " + raceData.raceName + ", " + age + " yrs (" + "");
    }

    public void create(Location currentLocation, HardData hardData) {
        //economic traits
        getEconomicClassFromLocation(currentLocation, hardData.locationList);
        getQuirksFromEconomicClass();
        getLevelFromClass();
        getInventoryFromClass(currentLocation);

        getRaceFromLocation();
        getNameFromRace(raceData.raceName);
        getAlignmentFromRace(hardData);
        getRacialTraitsFromRace();
        getStatsBasedOnLevel();
        calculateDcToPickpocket();
        determineBodyguards();
        determineCallGlyphs();
        determineFamily();
        mood = randGen.getRandomMood();

        calculateXPValue();
    }

    public void determineIfTraveler(Location currentLocation, List<Location> locationlist) {
        //"Traveler" means they don't live in the area. A traveler must still have an area, however, which is the "livesIn" value.
        rc = new RandomCollectionWeighted<String>()
            .add(currentLocation.travelerChance, EconomicClasses.traveler).add(currentLocation.beggarChance, EconomicClasses.beggar).add(currentLocation.poorChance, EconomicClasses.poor).add(currentLocation.middleClassChance, EconomicClasses.middleClass).add(currentLocation.wealthyChance, EconomicClasses.wealthy);
        if (rc.next().equals(EconomicClasses.traveler)) {
            isTraveler = true;
            livesIn = randGen.getRandomLocation(locationlist);
        } else {
            isTraveler = false;
            livesIn = currentLocation;
        }
    }

    public void getEconomicClassFromLocation(Location currentLocation, List<Location> locationlist) {
        determineIfTraveler(currentLocation, locationlist);
        //because travelers are no longer in the equation but are a part of the 100% this divides the chance evenly among all types
        rc = new RandomCollectionWeighted<String>()
            .add(livesIn.beggarChance + (livesIn.travelerChance / 4), EconomicClasses.beggar)
            .add(livesIn.poorChance + (livesIn.travelerChance / 4), EconomicClasses.poor)
            .add(livesIn.middleClassChance + (livesIn.travelerChance / 4), EconomicClasses.middleClass)
            .add(livesIn.wealthyChance + (livesIn.travelerChance / 4), EconomicClasses.wealthy);
        economicClass = rc.next();
    }

    public void getLevelFromClass() {
        switch(economicClass) {
            case EconomicClasses.beggar:
                rc = new RandomCollectionWeighted<String>()
                    .add(37,"1")
                    .add(31,"2")
                    .add(19,"3")
                    .add(10,"4")
                    .add(3,"5");
                break;
            case EconomicClasses.poor:
                rc = new RandomCollectionWeighted<String>()
                    .add(16, "1")
                    .add(26, "2")
                    .add(21, "3")
                    .add(16, "4")
                    .add(10, "5")
                    .add(6,"6")
                    .add(5,"7");
                break;
            case EconomicClasses.middleClass:
                rc = new RandomCollectionWeighted<String>()
                    .add(8, "1")
                    .add(10, "2")
                    .add(15, "3")
                    .add(18, "4")
                    .add(14, "5")
                    .add(10, "6")
                    .add(10, "7")
                    .add(8, "8")
                    .add(4, "9")
                    .add(3, "10");
                break;
            case EconomicClasses.wealthy:
                rc = new RandomCollectionWeighted<String>()
                    .add(1, "1")
                    .add(3, "2")
                    .add(9, "3")
                    .add(10, "4")
                    .add(11, "5")
                    .add(15, "6")
                    .add(20, "7")
                    .add(16, "8")
                    .add(8, "9")
                    .add(7, "10");
                break;
            case EconomicClasses.elite:
                rc = new RandomCollectionWeighted<String>()
                        .add(25, "10")
                        .add(20, "11")
                        .add(15, "12")
                        .add(12, "13")
                        .add(7, "14")
                        .add(6, "15")
                        .add(5, "16")
                        .add(4, "17")
                        .add(3, "18")
                        .add(2, "19")
                        .add(1, "20");
                break;
        }
        level = Integer.parseInt(rc.next());
    }

    public void getQuirksFromEconomicClass() {
        List<String> possibleQuirks = new ArrayList<>((Arrays.asList("", "", "")));
        switch (economicClass) {
            case EconomicClasses.beggar:
            //TODO: put in the possible quirks data
                possibleQuirks = new ArrayList<>((Arrays.asList("","")));
                break;
            case EconomicClasses.poor:
                possibleQuirks = new ArrayList<>((Arrays.asList("", "")));
                break;
            case EconomicClasses.middleClass:
                possibleQuirks = new ArrayList<>((Arrays.asList("", "")));
                break;
            case EconomicClasses.wealthy:
                possibleQuirks = new ArrayList<>((Arrays.asList("", "")));
                break;
            case EconomicClasses.elite:
                possibleQuirks = new ArrayList<>((Arrays.asList("", "")));
                break;
        }
        for (int i = 0; i < randGen.randomIntInRange(1,3); i++) {
            quirks.set(i, randGen.getRandomFromStringList(possibleQuirks));
        }
    }

    public void getRaceFromLocation() {
        rc = new RandomCollectionWeighted<String>()
            .add(livesIn.aarakocraChance, Races.aarakocra)
            .add(livesIn.aasimarChance, Races.aasimar)
            .add(livesIn.animalHybridChance, Races.animalHybrid)
            .add(livesIn.bugbearChance, Races.bugbear)
            .add(livesIn.centaurChance, Races.centaur)
            .add(livesIn.dragonbornChance, Races.dragonborn)
            .add(livesIn.dwarfChance, Races.dwarf)
            .add(livesIn.elephantineChance, Races.elephantine)
            .add(livesIn.elfChance, Races.elf)
            .add(livesIn.firbolgChance, Races.firbolg)
            .add(livesIn.genasiChance, Races.genasi)
            .add(livesIn.githChance, Races.gith)
            .add(livesIn.gnomeChance, Races.gnome)
            .add(livesIn.goblinChance, Races.goblin)
            .add(livesIn.goliathChance, Races.goliath)
            .add(livesIn.halfElfChance, Races.halfElf)
            .add(livesIn.halfOrcChance, Races.halfOrc)
            .add(livesIn.halflingChance, Races.halfling)
            .add(livesIn.hobgoblinChance, Races.hobgoblin)
            .add(livesIn.humanChance, Races.human)
            .add(livesIn.kenkuChance, Races.kenku)
            .add(livesIn.koboldChance, Races.kobold)
            .add(livesIn.lizardfolkChance, Races.lizardfolk)
            .add(livesIn.minotaurChance, Races.minotaur)
            .add(livesIn.orcChance, Races.orc)
            .add(livesIn.yuanTiChance, Races.yuanTi)
            .add(livesIn.tabaxiChance, Races.tabaxi)
            .add(livesIn.tieflingChance, Races.tiefling)
            .add(livesIn.tritonChance, Races.triton)
            .add(livesIn.tortleChance, Races.tortle)
            .add(livesIn.vedalkenChance, Races.vedalken);
        race = rc.next();
    }

    public void getNameFromRace(String raceToGetNameFrom) {
        String firstName = "";
        String lastName = "";
        List<String> possibleNames;
        //TODO: fill out the name data
        switch(raceToGetNameFrom) {
            case Races.aarakocra:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.aasimar:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.animalHybrid:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.bugbear:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.centaur:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.dragonborn:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.dwarf:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.elephantine:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.elf:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.firbolg:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.genasi:
                //Genasi take the names of the people among whom they were raised but may take other names to capture their heritage, such as Flame, Ember, Wave, or Onyx.
                if (randGen.randomIntInRange(1, 100) <= 10) {
                    List<String> genasiNames = new ArrayList<>(Arrays.asList(
                            "Onyx",
                            "Ember",
                            "Sapphire",
                            "Wave",
                            "Flame",
                            "Gust",
                            "Breeze",
                            "Hurricane",
                            "Wind",
                            "Cinder",
                            "Malachite",
                            "Earth",
                            "Current",
                            "Puddle",
                            "Tsunami",
                            "Tornado",
                            "Steel",
                            "Diamond",
                            "Earthquake",
                            "Cavern",
                            "Blaze",
                            "Glacier",
                            "Scorch",
                            "Boulder",
                            "Blizzard",
                            "Volcano",
                            "Torch",
                            "Whirlwind"
                    ));
                    firstName = randGen.getRandomFromStringList(genasiNames);
                } else {
                    getNameFromRace(randGen.getRandomRace());
                }
                break;
            case Races.gith:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.gnome:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.goliath:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.goblin:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.halfElf:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.halfOrc:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.halfling:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.hobgoblin:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.human:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.kenku:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.kobold:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.lizardfolk:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.minotaur:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.orc:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.tabaxi:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.tiefling:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.triton:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.tortle:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.vedalken:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.yuanTi:
                possibleNames = new ArrayList<>(Arrays.asList("",""));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
        }
        if (lastName.isEmpty()) {
            name = firstName;
        } else {
            name = firstName + " " + lastName;
        }
    }

    public Race getRaceDataFromRace(HardData hardData) {
        for (int i = 0; i < (hardData.raceData.size() - 1); i++) {
            if (hardData.raceData.get(i).raceName.equals(race)) {
                return hardData.raceData.get(i);
            }
        }
        return null;
    }

    public void getAlignmentFromRace(HardData hardData) {
        raceData = getRaceDataFromRace(hardData);
        rc = new RandomCollectionWeighted<String>()
            .add(raceData.lawfulGoodChance,Alignments.lawfulGood)
            .add(raceData.neutralGoodChance, Alignments.neutralGood)
            .add(raceData.chaoticGoodChance, Alignments.chaoticGood)
            .add(raceData.lawfulNeutralChance, Alignments.lawfulNeutral)
            .add(raceData.trueNeutralChance, Alignments.trueNeutral)
            .add(raceData.chaoticNeutralChance, Alignments.chaoticNeutral)
            .add(raceData.lawfulEvilChance, Alignments.lawfulEvil)
            .add(raceData.neutralEvilChance, Alignments.neutralEvil)
            .add(raceData.chaoticEvilChance, Alignments.chaoticEvil);
        alignment = rc.next();
    }

    public int getModifierForStat(int stat) {
        return (stat - 10) / 2;
    }

    public void getStatsBasedOnLevel() {
        //calculate bonuses and penalties for economic classes
        hpMax = 5;//all creatures get at least 5 hp to start with.
        int dieMax = 5;
        /*
        Technically the hit die would go as follows:
        d6  :  Sorcerer, Wizard
        d8  :  Bard, Cleric, Druid, Monk, Rogue, Warlock
        d10 :  Fighter, Paladin, Ranger
        d12 :  Barbarian
        but as "class" isn't a thing here I'm going off the economy class to modify it. Richer people have more access to more training, education, and nutrition
         */
        int classStr = 0;
        int classDex = 0;
        int classCon = 0;
        int classWis = 0;
        int classInt = 0;
        int classChr = 0;
        switch (economicClass) {
            case EconomicClasses.beggar:
                dieMax = randGen.randomIntInRange(1, 3);
                classStr = randGen.randomIntInRange(-3, 1); //low nutrition leads to low str, but living on the streets is physically demanding so could be a boon
                classDex = randGen.randomIntInRange(-3, 3); //could be anywhere from sickly to well-practiced thief
                classCon = randGen.randomIntInRange(-3, -1); //beggars are unlikely to be well nourished. Even a good beggar-thief might not score a good 3 meals a day
                classWis = randGen.randomIntInRange(-3, 2); //could represent "street smarts"
                classInt = randGen.randomIntInRange(-4, -1); //low money leads to low education
                classChr = randGen.randomIntInRange(-3, 2); //could be a well practiced liar
                break;
            case EconomicClasses.poor: // lots of manual labor but not the best nutrition or education
                dieMax = randGen.randomIntInRange(2, 5);
                classStr = randGen.randomIntInRange(-1, 2);
                classDex = randGen.randomIntInRange(-1, 1);
                classCon = randGen.randomIntInRange(-1, 0);
                classWis = randGen.randomIntInRange(-2, 2); //could be street smarts and survival skills
                classInt = randGen.randomIntInRange(-3, 0);
                classChr = randGen.randomIntInRange(-1, 0);
                break;
            case EconomicClasses.middleClass:
                dieMax = randGen.randomIntInRange(4, 10);//will always be better than the beggars
                classStr = randGen.randomIntInRange(-1, 1); //the middle class has such a wide range of jobs that their day-to-day could easily lend toward - or against - these skills
                classDex = randGen.randomIntInRange(-1, 1);
                classCon = randGen.randomIntInRange(0, 1);
                classWis = randGen.randomIntInRange(-1, 1);
                classInt = randGen.randomIntInRange(0, 1);
                classChr = randGen.randomIntInRange(-1, 1);
                break;
            case EconomicClasses.wealthy: //some wealthy vocations could lead to a sedentary lifestyle, but most wealthy people would have access to the best education, adventuring opportunities, and nutrition
                dieMax = randGen.randomIntInRange(7, 12); //will always be better than the poor
                classStr = randGen.randomIntInRange(-2, 2); //both str and dex could be lower due to lazy lifestyles, or higher due to good training
                classDex = randGen.randomIntInRange(-2, 2);
                classCon = randGen.randomIntInRange(0, 2); //the wealthy are well nourished and have access to good health care.
                classWis = randGen.randomIntInRange(-1, 3); //wealth certainly doesn't lead to wisdom automatically but education helps
                classInt = randGen.randomIntInRange(1, 3); //money = good education = good int
                classChr = randGen.randomIntInRange(-1, 2); //wealth tends to breed confidence, boldness, and good social skills among the elite in particular, but can also lend toward arrogance and dismissive-ness
                break;
            case EconomicClasses.elite: //these are the top of the wealth category, the big business moguls, the mayors, the famed adventurers, etc
                dieMax = randGen.randomIntInRange(10, 12); //
                classStr = randGen.randomIntInRange(0, 6); //
                classDex = randGen.randomIntInRange(0, 6); //
                classCon = randGen.randomIntInRange(0, 6); //
                classWis = randGen.randomIntInRange(0, 6); //
                classInt = randGen.randomIntInRange(0, 6); //
                classChr = randGen.randomIntInRange(0, 6); //
                break;
        }
        if (agePercent > 80) {// old people get more intelligence and wisdom, but weaker bodies
            classStr = classStr - 1;
            classDex = classDex - 1;
            classCon = classCon - 1;
            classWis = classWis + 2;
            classInt = classInt + 1;
            raceData.walkSpeed = raceData.walkSpeed - 5;
        }

        strength = randGen.randomIntInRange(8, 14) + (level / 2) + raceData.strMod + classStr;
        strMod = getModifierForStat(strength);

        dexterity = randGen.randomIntInRange(8, 14) + (level / 2) + raceData.dexMod + classDex;
        dexMod = getModifierForStat(dexterity);

        constitution = randGen.randomIntInRange(8, 14) + (level / 2) + raceData.conMod + classCon;
        conMod = getModifierForStat(constitution);
        for (int i = 0; i < level; i++) {
            hpMax = hpMax + randGen.randomIntInRange(1,(dieMax + conMod));
        }
        hpCurrent = hpMax;

        wisdom = randGen.randomIntInRange(8, 14) + (level / 2) + raceData.wisMod + classWis;
        wisMod = getModifierForStat(wisdom);

        intelligence = randGen.randomIntInRange(8, 14) + (level / 2) + raceData.intMod + classInt;
        intMod = getModifierForStat(intelligence);

        charisma = randGen.randomIntInRange(8, 14) + (level / 2) + raceData.chrMod + classChr;
        chrMod = getModifierForStat(charisma);

        passivePerception = 10 + wisMod;
    }

    public void getLanguagesFromRace() {
        for (int i = 0; i < (raceData.languages.size() - 1); i++) {
            if (raceData.languages.get(i).equals("other")) {
                //get another language, but make sure it's not a language already in the languages list
                boolean endLoop = false;
                while (!endLoop) {
                    //this will get a new language for the "other" slot and then check if that language was already chosen. If so, it will roll a new language until it rolls a unique one.
                    endLoop = true;
                    raceData.languages.set(i, randGen.getRandomLanguage());
                    for (int j = 0; j < (raceData.languages.size() - 1); j++) {
                        if (i != j && raceData.languages.get(j).equals(raceData.languages.get(i))) {
                            raceData.languages.set(i, randGen.getRandomLanguage());
                            endLoop = false;
                        }
                    }
                }
            }
        }
    }

    public void getRacialTraitsFromRace() {
        bravery = raceData.braveryMod + randGen.randomIntInRange(5,25);
        getLanguagesFromRace();
        age = randGen.randomIntInRange(raceData.minAge, raceData.maxAge); //the min age prevents children from being present in battles, which I don't want in the campaign
        agePercent = age * 100 / raceData.maxAge; //this data point just gives a feel for relative age compared to a human. Like a 100 yr old elf would only be about 45-55 in human years
        if (randGen.randomIntInRange(1,2) == 1) {
            gender = Genders.male;
        } else {
            gender = Genders.female;
        }
    }

    public void getInventoryFromClass(Location currentLocation) {
        //weapons, armor, gold, items carried
        getArmor();
        getWeapons();
        getLoot();


    }

    public void getArmor() {
        //figure out if they have a shield. Won't be used by the poor & beggar classes
        switch (economicClass) {
            case EconomicClasses.middleClass:
                if (randGen.randomIntInRange(0, 100) <= 3) {
                    hasShield = true;
                }
                break;
            case EconomicClasses.wealthy:
                if (randGen.randomIntInRange(0, 100) <= 8) {
                    hasShield = true;
                }
                break;
        }
        //get their armor type
        //Armor wornArmor = StandardArmor.natural;
        int armorTierSelected = randGen.randomIntInRange(0, 100);
        switch (economicClass) {
            case EconomicClasses.beggar:
                if (armorTierSelected <= 75) {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.beggar,1));//75%
                } else if (armorTierSelected <= 95) {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.beggar, 2));//20%
                } else {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.beggar, 3));//5%
                }
                break;
            case EconomicClasses.poor:
                if (armorTierSelected <= 60) {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.poor, 1));//65%
                } else if (armorTierSelected <= 90) {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.poor, 2));//30%
                } else {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.poor, 3));//5%
                }
                break;
            case EconomicClasses.middleClass:
                if (armorTierSelected <= 50) {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.middleClass, 1));//50%
                } else if (armorTierSelected <= 75) {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.middleClass, 2));//25%
                } else if (armorTierSelected <= 90) {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.middleClass, 3));//15%
                } else {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.middleClass, 4));//5%
                }
                break;
            case EconomicClasses.wealthy:
                if (armorTierSelected <= 35) {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.wealthy, 1));//35%
                } else if (armorTierSelected <= 60) {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.wealthy, 2));//25%
                } else if (armorTierSelected <= 80) {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.wealthy, 3));//20%
                } else if (armorTierSelected <= 95) {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.wealthy, 4));//15%
                } else {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.wealthy, 5));//5%
                }
                break;
            case EconomicClasses.elite:
                 if (armorTierSelected <= 50) {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.wealthy, 3));//50%
                } else if (armorTierSelected <= 75) {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.wealthy, 4));//25%
                } else {
                    wornArmor.set(0, randGen.getArmorByEconomyAndTier(EconomicClasses.wealthy, 5));//25%
                }
                break;
        }
        ac = wornArmor.get(0).ac;

        //account for dex modifiers on the armor
        if (dexMod < 0 && wornArmor.get(0).dexBonusMax > 0) {
            ac += dexMod; //negative dexterity only affects AC if the armor allows for dexterity to modify the AC of the armor
        }
        if (wornArmor.get(0).dexBonusMax > 0 && dexMod >= wornArmor.get(0).dexBonusMax) { //can't add more than the max dex possible
            ac += wornArmor.get(0).dexBonusMax;
        } else if (wornArmor.get(0).dexBonusMax > 0 && dexMod > 0 && dexMod < wornArmor.get(0).dexBonusMax) { //just add some if you're not negative but not at or over the max
            ac += dexMod;
        }

        if (hasShield && economicClass.equals(EconomicClasses.beggar) || economicClass.equals(EconomicClasses.poor)) {
            wornArmor.set(1, StandardArmor.shield);
        } else {
            //TODO: allow wealthier people to have access to better shields
        }
        if (hasShield) {
            ac = ac + wornArmor.get(1).ac;
        }
        if (wornArmor.get(0).strRequirement > strength) {
            wornArmor.get(0).abilities.add("Is too heavy for " + name + " to use. Disadvantage on all physical saves and can't cast spells");
        }
    }

    public void getWeapons() {
        //TODO: make it so a versatile weapon is wielded as 2-handed (takes alt damage) when not using a shield
        wornWeapons = new ArrayList<Weapon>(Arrays.asList());
        wornWeapons.set(0,StandardWeapons.unarmed);
        wornWeapons.set(1, StandardWeapons.unarmed);
        if (hasShield) {
            getSingleWeapon(0, false);
        } else {
            getSingleWeapon(0, true);
        }

        if (!wornWeapons.get(0).type.equals(WeaponTypes.twoHanded) && randGen.randomIntInRange(0,100) < 25) {
            //25% chance that somebody will duel-wield if using a 1-hander
            getSingleWeapon(1, false);
        }

        for (int i = 0; i < wornWeapons.size() - 1; i++) {
            if (wornWeapons.get(i).equals(WeaponTypes.finesse) || wornWeapons.get(i).equals(WeaponTypes.loading) || wornWeapons.get(i).equals(WeaponTypes.ranged) || wornWeapons.get(i).equals(WeaponTypes.thrown)) {
                wornWeapons.get(i).toHitFromStats = dexMod;
            } else {
                wornWeapons.get(i).toHitFromStats = strMod;
            }
            int isProficientPicker = randGen.randomIntInRange(0, 100);
            switch (economicClass) {
                case EconomicClasses.beggar:
                    if (isProficientPicker <= 15) {
                        wornWeapons.get(i).userIsProficient = true;
                    }
                    break;
                case EconomicClasses.poor:
                    if (isProficientPicker <= 20) {
                        wornWeapons.get(i).userIsProficient = true;
                    }
                    break;
                case EconomicClasses.middleClass:
                    if (isProficientPicker <= 40) {
                        wornWeapons.get(i).userIsProficient = true;
                    }
                    break;
                case EconomicClasses.wealthy:
                    if (isProficientPicker <= 75) {
                        wornWeapons.get(i).userIsProficient = true;
                    }
                    break;
                case EconomicClasses.elite:
                    wornWeapons.get(i).userIsProficient = true;
                    break;
            }
            if ( wornWeapons.get(i).userIsProficient = true) {
                wornWeapons.get(i).combinedToHitBonus = (level / 5); //*IF* they are proficient, they gain +1 for every 2 levels so a level 10 with proficiency can actually be a threat with + stats to hit and +5 proficiency.
            }
            wornWeapons.get(i).combinedToHitBonus = wornWeapons.get(i).combinedToHitBonus + wornWeapons.get(i).toHitFromStats + wornWeapons.get(i).toHitBonus;
        }
    }

    public void getSingleWeapon(int hand, boolean canBeTwoHanded) { //0 is 1 first hand, 1 is second hand
        int weaponTierSelected = randGen.randomIntInRange(0, 100);
        switch (economicClass) {
            case EconomicClasses.beggar:
                if (weaponTierSelected <= 75) {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass,1));//75%
                } else if (weaponTierSelected <= 95) {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass, 2));//20%
                } else {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass, 3));//5%
                }
                break;
            case EconomicClasses.poor:
                if (weaponTierSelected <= 60) {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass, 1));//65%
                } else if (weaponTierSelected <= 90) {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass, 2));//30%
                } else {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass, 3));//5%
                }
                break;
            case EconomicClasses.middleClass:
                if (weaponTierSelected <= 50) {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass, 1));//50%
                } else if (weaponTierSelected <= 75) {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass, 2));//25%
                } else if (weaponTierSelected <= 90) {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass, 3));//15%
                } else {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass, 4));//5%
                }
                break;
            case EconomicClasses.wealthy:
                if (weaponTierSelected <= 20) {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass, 1));//35%
                } else if (weaponTierSelected <= 45) {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass, 2));//25%
                } else if (weaponTierSelected <= 65) {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass, 3));//20%
                } else if (weaponTierSelected <= 75) {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass, 4));//15%
                } else {
                    wornWeapons.set(hand, randGen.getWeaponByEconomyAndTier(economicClass, 5));//5%
                }
                break;
            case EconomicClasses.elite:
                randGen.getRandomCustomWeaponByTier(4);
                break;
        }
        if (wornWeapons.get(hand).type.equals(WeaponTypes.twoHanded) && !canBeTwoHanded) {
            //if it has to be 1-handed and we rolled a 2-hander, roll again
            getSingleWeapon(hand,false);
        }
    }

    public void getLoot() {
        platinum = randGen.randomIntInRange(livesIn.platinumLow, livesIn.platinumHigh);
        gold = randGen.randomIntInRange(livesIn.goldLow, livesIn.goldHigh);
        silver = randGen.randomIntInRange(livesIn.silverLow, livesIn.silverHigh);
        copper = randGen.randomIntInRange(livesIn.copperLow, livesIn.copperHigh);
        switch (economicClass) {
            //the high/low values given in the location settings determine what the wealthiest people in that area would carry around, and the poorer classes gain fractions of that.
            case EconomicClasses.beggar:
                platinum = 0;
                gold = gold / 16;
                silver = silver / 4;
                copper = copper * 2; //the poorer classes are much more likely to have higher amounts of the small coin. in particular beggars would have lots of chump change
                break;
            case EconomicClasses.poor:
                platinum = 0;
                gold = gold / 8;
                silver = silver * 2;
                copper = copper * 2;
                break;
            case EconomicClasses.middleClass:
                platinum = platinum / 2;
                gold = gold / 2;
                break;
            case EconomicClasses.elite:
                platinum = platinum * 2;
                gold = gold * 3;
                silver = silver * 4;
                copper = copper * 5;
                break;
        }
        int luckyGoldRoll = randGen.randomIntInRange(1, 1000); //there's a 10% chance for any commoner to get a bonus to the money they carry.
        if (luckyGoldRoll == 1) { //0.1% chance for a LOT of gold
            platinum = (platinum + randGen.randomIntInRange(11, 25)) * (level);
            gold = (gold + randGen.randomIntInRange(5,20)) * (level * 3);
            silver = (silver + randGen.randomIntInRange(5,20)) * (level * 15);
            copper = (copper + randGen.randomIntInRange(5,20)) * (level * 30);
        } else if (luckyGoldRoll == 5) { //0.5% chance
            platinum = (platinum + randGen.randomIntInRange(1, 10)) * (level / 2);
            gold = gold * level;
            silver = silver * (level * 4);
            copper = copper * (level * 8);
        } else if (luckyGoldRoll <= 50) { //5% chance
            platinum = platinum + randGen.randomIntInRange(1,10);
            gold = (gold + 1) * (level / 4);
            silver = (silver + randGen.randomIntInRange(1,100)) * (level / 2);
            copper = copper * level;
        } else if (luckyGoldRoll <= 80) { //8% chance
            gold = gold + randGen.randomIntInRange(6,15);
            silver = silver + randGen.randomIntInRange(1,100);
            copper = copper * 4;
        } else if (luckyGoldRoll <= 100) { //10% chance
            gold = gold + randGen.randomIntInRange(1, 5);
            silver = silver + randGen.randomIntInRange(1,10);
            copper = copper * 2;
        }
        packCarried.nameOfOwner = name;
        packCarried.fillPackRandomly(economicClass,randGen,livesIn);
    }

    public void calculateDcToPickpocket() {
        dcToPickpocket = passivePerception;
        switch (economicClass) {
            case EconomicClasses.beggar:
                dcToPickpocket = dcToPickpocket + randGen.randomIntInRange(-5, (level + 2)); //beggars would likely be well acquainted with the streets and pickpocketing techniques ... or be mentally unstable
                break;
            case EconomicClasses.poor:
                dcToPickpocket = dcToPickpocket + randGen.randomIntInRange(-3, (level + 1));
                break;
            case EconomicClasses.middleClass:
                dcToPickpocket = dcToPickpocket + randGen.randomIntInRange(-2, level);
                break;
            case EconomicClasses.wealthy:
                dcToPickpocket = dcToPickpocket + randGen.randomIntInRange(-1, level);
                break;
            case EconomicClasses.elite:
                dcToPickpocket = dcToPickpocket + randGen.randomIntInRange(5, (level + 5));
                break;
        }
    }

    public void determineBodyguards() {
        if (economicClass.equals(EconomicClasses.beggar) || economicClass.equals(EconomicClasses.poor)) {
            hasBodyguard = false;
        } else if (economicClass.equals(EconomicClasses.middleClass) && randGen.randomIntInRange(1, 100) <= 5) {
            hasBodyguard = true;
        } else if (economicClass.equals(EconomicClasses.wealthy) && randGen.randomIntInRange(1, 100) <= 20) {
            hasBodyguard = true;
        } else if (economicClass.equals(EconomicClasses.elite) && randGen.randomIntInRange(1, 100) <= 65) {
            hasBodyguard = true;
        } else {
            hasBodyguard = false;
        }
        if (hasBodyguard && economicClass.equals(EconomicClasses.middleClass)) {
            //get one bodyguard
            //TODO: create a function to create a bodyguard and link the guard to the person they guard
        } else if (hasBodyguard && economicClass.equals(EconomicClasses.wealthy)) {
            for (int i = 0; i < randGen.randomIntInRange(1,3); i++) {
                //create 1-3 bodyguards for this person
            }
        } else if (hasBodyguard && economicClass.equals(EconomicClasses.elite)) {
            for (int i = 0; i < randGen.randomIntInRange(1, 8); i++) {
                //create 1-3 bodyguards for this person
            }
        }
    }

    public void determineCallGlyphs() {
        switch (economicClass) {
            case EconomicClasses.beggar:
                if (randGen.randomIntInRange(1,10000) == 1) {//0.01% chance
                    hasCallGlyph = true;
                    if (wornArmor.get(0).name.equals(StandardArmor.natural.name)) { //if somebody isn't wearing armor then it can't have an etching
                        callGlyphType = CallGlyphTypes.tablet;
                        packCarried.lootCarried.add(StandardLoot.callGlyph);
                    } else {
                        wornArmor.get(0).hasCallGlyph = true;
                        callGlyphType = CallGlyphTypes.armorEtching;
                    }
                }
                break;
            case EconomicClasses.poor:
                if (randGen.randomIntInRange(1, 10000) <= 5) {//0.05% chance
                    hasCallGlyph = true;
                    if (wornArmor.get(0).name.equals(StandardArmor.natural.name)) {
                        callGlyphType = CallGlyphTypes.tablet;
                        packCarried.lootCarried.add(StandardLoot.callGlyph);
                    } else if (randGen.randomIntInRange(1, 100) <= 80) {
                        wornArmor.get(0).hasCallGlyph = true;
                        callGlyphType = CallGlyphTypes.armorEtching;
                    }
                }
                break;
            case EconomicClasses.middleClass:
                if (randGen.randomIntInRange(1, 100) <= 3) {//3% chance
                    hasCallGlyph = true;
                    if (wornArmor.get(0).name.equals(StandardArmor.natural.name)) {
                        callGlyphType = CallGlyphTypes.tablet;
                        packCarried.lootCarried.add(StandardLoot.callGlyph);
                    } else if (randGen.randomIntInRange(1,100) <= 66) {
                        wornArmor.get(0).hasCallGlyph = true;
                        callGlyphType = CallGlyphTypes.armorEtching;
                    }
                }
                break;
            case EconomicClasses.wealthy:
                if (randGen.randomIntInRange(1, 100) <= 15) {//15% chance
                    hasCallGlyph = true;
                    if (wornArmor.get(0).name.equals(StandardArmor.natural.name)) {
                        callGlyphType = CallGlyphTypes.tablet;
                        packCarried.lootCarried.add(StandardLoot.callGlyph);
                    } else if (randGen.randomIntInRange(1, 100) <= 50) {
                        wornArmor.get(0).hasCallGlyph = true;
                        callGlyphType = CallGlyphTypes.armorEtching;
                    }
                }
                break;
            case EconomicClasses.elite:
                if (randGen.randomIntInRange(1, 100) <= 70) {//70% chance
                    hasCallGlyph = true;
                    if (wornArmor.get(0).name.equals(StandardArmor.natural.name)) {
                        callGlyphType = CallGlyphTypes.tablet;
                        packCarried.lootCarried.add(StandardLoot.callGlyph);
                    } else if (randGen.randomIntInRange(1, 100) <= 50) {
                        wornArmor.get(0).hasCallGlyph = true;
                        callGlyphType = CallGlyphTypes.armorEtching;
                    }
                }
                break;
        }
    }

    public void determineFamily() {
        if (economicClass.equals(EconomicClasses.beggar) && randGen.randomIntInRange(1,100) <= 10) { //10% chance to have a family
            hasFamily = true;
        } else if (economicClass.equals(EconomicClasses.poor) && randGen.randomIntInRange(1, 100) <= 95) {
            hasFamily = true;
        } else if (economicClass.equals(EconomicClasses.middleClass) && randGen.randomIntInRange(1, 100) <= 92) {
            hasFamily = true;
        } else if (economicClass.equals(EconomicClasses.wealthy) && randGen.randomIntInRange(1, 100) <= 90) {
            hasFamily = true;
        } else if (economicClass.equals(EconomicClasses.elite) && randGen.randomIntInRange(1, 100) <= 40) {
            hasFamily = true;
        } else {
            hasFamily = false;
        }
        if (hasFamily) {
            //familyMemberCount represents how many members OTHER than this creature are in the family.
            familyMemberCount = randGen.randomIntInRange(1, raceData.familySizeMax);
        } else {
            familyMemberCount = 0;
        }
    }

    public void calculateXPValue() {
        xpValue = ((hpMax / 9) * hpMax)
            + (level * 5) //5 pts per level. As most other xp related traits are boosted by this it will get minimal attention, but guarantees a little bit.
            + (wornWeapons.get(0).combinedToHitBonus * 5)
            + ((wornWeapons.get(0).getTotalUntypedDamageMin() + 1) * wornWeapons.get(0).getTotalUntypedDamageMax())
            + ((ac - 10) * 20) //20 pts for each ac above 10
            + (strMod * 10) //10 pts for each 2 main stats (can detract from xp value if less than 10 main stat)
            + (dexMod * 10)
            + (conMod * 8) //conMod is partially accounted for in the hpMax bonus (more conMod = more hp = more xp)
            + (wisMod * 10)
            + (intMod * 10)
            + (chrMod * 10)
            + dcToPickpocket; //as it's not a combat trait it won't add much, but it'll still add
        //account for dual-wielding
        if (!wornWeapons.get(1).name.equals(StandardWeapons.unarmed.name) && !hasShield) {
            xpValue = xpValue + ((wornWeapons.get(1).getTotalUntypedDamageMin() + 1) * wornWeapons.get(1).getTotalUntypedDamageMax()) + (wornWeapons.get(1).combinedToHitBonus * 5);
        }
        if (hasBodyguard) {
            xpValue = xpValue + (100 * bodyguardList.size());
        }
        switch (economicClass) {
            case EconomicClasses.beggar:
                xpValue = xpValue - 25;
                break;
            case EconomicClasses.poor:
                xpValue = xpValue - 15;
                break;
            case EconomicClasses.middleClass:
                xpValue = xpValue + 5;
                break;
            case EconomicClasses.wealthy:
                xpValue = xpValue + 15;
                break;
            case EconomicClasses.elite:
                xpValue = xpValue + 150;
                break;
        }
    }
}


