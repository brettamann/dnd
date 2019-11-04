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

    private Boolean hasFamily;
    private int familyMemberCount;
    private String mood;

    private int level;
    private int hpMax;
    private int hpCurrent;
    private int ac;
    //Equipped gear
    private List<Weapon> wornWeapons;
    private List<Armor> wornArmor = new ArrayList<>(2); //index 0 is the main armor, index 1 is shield, if applicable
    private boolean hasShield = false;

    //non-equipped items that are being carried
    private Pack packCarried = new Pack();

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
        //"Traveler" means they don't live in the area. A person, traveler or not, must still have an Location however, which is the "livesIn" value.
        //Most people in most areas will live in the area they were encountered, but all areas have at least a slight traveler chance and a couple are 100% traveler chance (nobody lives in the area, like a market)
        rc = new RandomCollectionWeighted<String>()
            .add(currentLocation.travelerChance, EconomicClasses.traveler).add(currentLocation.beggarChance, EconomicClasses.beggar).add(currentLocation.poorChance, EconomicClasses.poor).add(currentLocation.middleClassChance, EconomicClasses.middleClass).add(currentLocation.wealthyChance, EconomicClasses.wealthy);
        if (rc.next().equals(EconomicClasses.traveler)) {
            isTraveler = true;
            livesIn = randGen.getRandomLocation(locationlist);
            //Make sure they aren't a traveler from somewhere that either people don't really live, or you really wouldn't find them traveling out of like the sewers
            while (livesIn.name.equals("The Carnival") || livesIn.name.equals("The Roost Inn") || livesIn.name.equals("East Gate Market") || livesIn.name.equals("West Gate Market") || livesIn.name.equals("Angelfall Square Memorial") || livesIn.name.equals("Lower Caverns") || livesIn.name.equals("The Sewers") || livesIn.name.equals("Jewelcourt Market")) {
                livesIn = randGen.getRandomLocation(locationlist);
            }
        } else {
            isTraveler = false;
            livesIn = currentLocation;
        }
    }

    public void getEconomicClassFromLocation(Location currentLocation, List<Location> locationlist) {
        determineIfTraveler(currentLocation, locationlist);
        //because travelers are no longer in the equation but are a part of the 100% (and we need to add up to 100%) this divides the traveler chance evenly among all types
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

    private void getNameFromRace(String raceToGetNameFrom) {
        String firstName = "";
        String lastName = "";
        List<String> possibleNames;
        switch(raceToGetNameFrom) {
            case Races.aarakocra:
                //unisex first names only
                possibleNames = new ArrayList<>(Arrays.asList("Gis", "Rhi", "Klark", "Qrar", "Err", "Krelliac", "Kakirk", "Accig", "Qlurrarc", "Kakkeack", "Cluhk", "Coo", "Uark", "Qhuc", "Rhef", "Gekas", "Clureck", "Irahk", "Eref", "Yecas", "Garrk", "Crus", "Grahk", "De", "Guc", "Rharrearrk", "Clilirk", "Clarrack", "Aqi", "Keci", "Klark", "Haia", "As", "Qhack", "Ic", "Yaekkie", "Daellerc", "Qheccierk", "Kheqal", "Dikick", "Kreg", "Craehk", "Rhak", "Qreck", "Keck", "Quqaarr", "Krillehk", "Qlarra", "Yakkeg", "Aqaf", "Uk", "Rhag", "Er", "Raf", "Is", "Keellas", "Sureerr", "Illir", "Khakkarrk", "Klaiallirr", "Clu", "Di", "Ak", "Kroo", "Kheef", "Ruqass", "Claeraar", "Allerc", "Krace", "Uqahk", "Qhoug", "Ka", "Yoorr", "Curc", "Uss", "Oolaac", "Ruarerc", "Qleccearc", "Yuaqak", "Rherreg", "Gerr", "Ka", "Ye", "Qlarrk", "Zar", "Qalaarrk", "Cukke", "Qluielirc", "Ceccerrk", "Klekarr", "Qluf", "Ick", "Qurr", "Irc", "Clik", "Zura", "Koukaahk", "Klelle", "Ceerra", "Hakkid", "Ar", "Us", "Ag", "Sirrk", "Qhif", "Qhares", "Klureerc", "Qrirec", "Ecce", "Ruiecceack", "Klar", "Qhad", "Qrerr", "Gris", "Rherk", "Uqa", "Khaqer", "Ekar", "Clerihk", "Recea", "Aera", "Aial", "Aur", "Deekek", "Errk", "Heehk", "Ikki", "Kleeck", "Oorr", "Ouss", "Quaf", "Quierk", "Salleek", "Urreek", "Zeed"));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.aasimar:
                //first name only
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Aritian", "Beltin", "Cernan", "Cronwier", "Eran", "Ilamin", "Maudril", "Okrin", "Parant", "Tural", "Wyran", "Zaigan", "Zerwil", "Zeldiant", "Likleint", "Cuggem", "Pydrin", "Vulril", "Enlainant", "Belwivam", "Cygrudiel", "Pukidient", "Mynral", "Vudrel", "Okran", "Braltam", "Leilteim", "Ladeint", "Bailwaivum", "Urnaniant", "Nonlivim", "Ukrimin", "Zornil", "Crikrar", "Yrlint", "Painlal", "Wyrnim", "Breiggeint", "Beldadin", "Rulwovon", "Airleinaint", "Hidatir", "Zuggur", "Credrant", "Mydrial", "Poklin", "Lakram", "Lolgar", "Ealitan", "Ykuner", "Nokiven", "Berlavam", "Brauder", "Cukleim", "Celtal", "Yrwil", "Neklom", "Rolgor", "Hanwalun", "Tolgeval", "Cuvratim", "Augilent", "Braigwol", "Lainwal", "Udril", "Maurnal", "Merlur", "Hyldim", "Runrilont", "Carlodil", "Hedratir", "Agwatal", "Enreir", "Ildant", "Oklar", "Cranrar", "Neakriem", "Nurwam", "Mylgitil", "Nevaler", "Altemient", "Hodramien"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Rimna", "Vini", "Nilde", "Erso", "Wiommi", "Drinri", "Vinerau", "Darisar", "Aslore", "Drimnimi", "Nirsa", "Phodo", "Reldear", "Ardo", "Drajoh", "Zandra", "Iosleze", "Nasrorin", "Branvoza", "Briaveane", "Zana", "Hille", "Raje", "Willo", "Dasor", "Dronma", "Ivienou", "Bromiazel", "Iomnomi", "Phaltili", "Thesrieh", "Andrin", "Ninreal", "Lemo", "Elto", "Brerki", "Osezi", "Hiavizim", "Thilime", "Winrini", "Drelvi", "Rhioldro", "Ianram", "Wialdol", "Hoje", "Zeoldrea", "Drildeze", "Ammosi", "Thenvela", "Themoser", "Iaro", "Vealto", "Hali", "Rhadi", "Dova", "Lija", "Himmara", "Viandrozi", "Bresrezel", "Brasleza", "Rirso", "Anla", "Masli", "Ode", "Phimmea", "Olte", "Brealvorau", "Minaze", "Inmosi", "Hanlime", "Indro", "Onria", "Tholli", "Orsa", "Phiado", "Riave", "Ronmeni", "Bravazi", "Wislile", "Oslizer", "Arken", "Arsinoe", "Davina", "Drinma", "Imesah", "Masozi", "Nijena", "Niramour", "Ondrea", "Rhialla", "Valtyra", "Zalarya"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.animalHybrid:
                //first name only
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Lohareth", "Ciwmelk", "Gheskhad", "Tewmelk", "Bulad", "Olosalor", "Thegeiros", "Craro", "Eljeon", "Heijeon", "Zewkosh", "Balaulad", "Kikosh", "Sisaulad", "Dulad", "Traquinal", "Morwraek", "Sarro", "Keazeiros", "Mirapetor"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Maltara", "Tishara", "Lishara", "Nashana", "Bivtara", "Reyxina", "Faevyre", "Quirel", "Xyrwynn", "Dabanise", "Datara", "Gavakri", "Khawtara", "Hashtai", "Ghiloashtai", "Yllavyre", "Qiyra", "Reyzana", "Qithyra", "Jorona"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.bugbear:
                //first name only
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Tamkk", "Khon", "Navilk", "Stazzir", "Khork", "Datrank", "Nutrirk", "Vizank", "Dath", "Zoduth", "Run", "Ghirgomkk", "Tann", "Zhoggink", "Dik", "Ruvin", "Khiddirk", "Bruk", "Chronn", "Therrok", "Tetronk", "Stevruth", "Ghon", "Stuvunn", "Dudrun", "Vizzak", "Garrik", "Khutinn", "Thighok", "Brizorr", "Ratunn", "Nedath", "Khank", "Chruzuth", "Stivrank", "Bok", "Vattimkk", "Zhatilk", "Virgimkk", "Ghurrork", "Studdin", "Thevun", "Narrath", "Didronn", "Chredrar", "Steghamkk", "Gunn", "Hrurdark", "Stinn", "Vettamkk", "Hrardilk", "Hrorr", "Ramkk", "Bradroth", "Nevank", "Gegrir", "Zhazzark", "Zittunn", "Zhalk", "Tezik", "Buvrark", "Rak", "Ghulk", "Thegharr", "Ghurrurk", "Stin", "Tazzink", "Khizzork", "Khidramkk", "Thiddinn", "Derrith", "Chrighir", "Gegith", "Noghath", "Ritark", "Khedrunk", "Hrurk", "Bredrar", "Stuth", "Bao'or'et", "Cretin", "Gregek", "Kugruet", "Malka'vec", "Thimdul", "Bo'kalek", "Mugrow"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Tamkk", "Khon", "Navilk", "Stazzir", "Khork", "Datrank", "Nutrirk", "Vizank", "Dath", "Zoduth", "Run", "Ghirgomkk", "Tann", "Zhoggink", "Dik", "Ruvin", "Khiddirk", "Bruk", "Chronn", "Therrok", "Tetronk", "Stevruth", "Ghon", "Stuvunn", "Dudrun", "Vizzak", "Garrik", "Khutinn", "Thighok", "Brizorr", "Ratunn", "Nedath", "Khank", "Chruzuth", "Stivrank", "Bok", "Vattimkk", "Zhatilk", "Virgimkk", "Ghurrork", "Studdin", "Thevun", "Narrath", "Didronn", "Chredrar", "Steghamkk", "Gunn", "Hrurdark", "Stinn", "Vettamkk", "Hrardilk", "Hrorr", "Ramkk", "Bradroth", "Nevank", "Gegrir", "Zhazzark", "Zittunn", "Zhalk", "Tezik", "Buvrark", "Rak", "Ghulk", "Thegharr", "Ghurrurk", "Stin", "Tazzink", "Khizzork", "Khidramkk", "Thiddinn", "Derrith", "Chrighir", "Gegith", "Noghath", "Ritark", "Khedrunk", "Hrurk", "Bredrar", "Stuth", "An'hek", "Gretru", "Lungra", "Sept", "Um'ra", "Zel", "Far'ktu", "Orblit"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.centaur:
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Joh", "Vrol", "Rhal", "Vraz'hir", "Kathilk", "Bizren", "Vithag", "Aldrudis", "Am'zine", "Ona", "Trobur", "Viddram", "Rhoban", "Zovron", "Erapatos", "Ilalan", "Claban", "Uibys", "Gykon", "Pikres", "Veboth", "Plemare", "Fezivin", "Vifogone", "Ceweid"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Belgas", "Fylreh", "Laresh", "Nelnath", "Shyrget", "Ryzag", "Lelras", "Eneh", "Sheglag", "Augrin", "Livor", "Somo", "Elilynn", "Crymoth", "Kotytion", "Brylates", "Xizorn", "Drylates", "Eyvoeus", "Elorous", "Bidaumas", "Zozorn", "Slobobor", "Phifan", "Pusal"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("Thornbreaker", "Oakenhoof", "Vinemane", "Starcatcher", "Dustborne", "Rocktree", "Mudtrekker", "Forestlegs", "Bushtail", "Stonehand", "Swifthoof", "Broadhoof", "Proudmane", "Orchardside", "Rivercatch", "Reedtail", "Earthbrawn", "Snowdance", "Boulderhoof", "Streamsong", "Rootstrength", "Mountainclad", "Pathfinder", "Trailwinder"));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.dragonborn:
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Morsashi", "Parash", "Aliseth", "Worbor", "Tozavur", "Belxan", "Orlahazar", "Rhozire", "Kilkul", "Frobor", "Lornaar", "Narqiroth", "Wudaar", "Wulrinn", "Iorgrax", "Pavarax", "Hiqull", "Caersashi", "Orlagrax", "Goravull", "Medtrin", "Durkris", "Nesqrin", "Tazhazar", "Morprax", "Vyulin", "Brenroth", "Wulnaar", "Faerhazar", "Iorhadur", "Orlazire", "Udoqiroth", "Vrakfarn", "Udoprax", "Tazkris", "Rhobroth", "Bhazire", "Kilprax", "Raskris", "Wranaar", "Otigrax", "Bamash", "Vorqiroth", "Ravoprax", "Vrakbor", "Dravarax", "Jarxiros", "Wuzire", "Belqiroth", "Qelzire", "Iordhall", "Zrakax", "Xarrash", "Medwarum", "Qelvroth", "Narrash", "Faerythas", "Bhaythas", "Parakas", "Durkax", "Belroth", "Wuskan", "Sharakas", "Gheziros", "Gheseth", "Sulkul", "Brenqull", "Ravokax", "Narghull", "Wumash", "Hebor", "Durtrin", "Vyudaar", "Draxiros", "Brensashi", "Worseth", "Vordorim", "Narrakas", "Wukax", "Caluhadur", "Vrakwunax", "Marwunax", "Balghull", "Nesrakas", "Aliwunax", "Aliciar", "Otiziros", "Tazlin", "Wravarax", "Prizavur", "Faerjurn", "Sulzavur", "Marturim", "Lorythas", "Iorrakas", "Zrahadur", "Caerzire", "Pasashi", "Rhorash", "Naroth", "Arjhan", "Balasar", "Bharash", "Donaar", "Ghesh", "Heskan", "Kriv", "Medrash", "Mehen", "Nadarr", "Pandjed", "Patrin", "Rhogar", "Shamash", "Shedinn", "Tarhun", "Torinn"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Zofvyre", "Rashithibra", "Jeswyn", "Zofzys", "Iriehymm", "Xyzita", "Eshgissa", "Oriqwen", "Sothibra", "Vyravayla", "Arigil", "Nalyassa", "Axiris", "Yarish", "Kanorae", "Sobirith", "Kazita", "Nesthibra", "Hafyire", "Grirish", "Arigil", "Nalyassa", "Axiris", "Yarish", "Kanorae", "Sobirith", "Kazita", "Nesthibra", "Hafyire", "Grirish", "Yrrann", "Zofvys", "Yrsaadi", "Dryslarys", "Malmyse", "Belriel", "Thasaadi", "Rairith", "Ophipora", "Adrish", "Ushipora", "Gurpatys", "Yrthibra", "Zoflyassa", "Lilomyse", "Urihymm", "Vyrayries", "Irlythibra", "Perhime", "Kanys", "Wrawophyl", "Nabis", "Eshyassa", "Aliann", "Yawophyl", "Kelyassa", "Dawophyl", "Yrrann", "Zennys", "Erlidalynn", "Eshcys", "Maldrish", "Drysshann", "Rashiliann", "Kowophyl", "Welsishann", "Ushipora", "Kelgil", "Subirith", "Valkira", "Crisdalynn", "Rairith", "Ophithibra", "Socys", "Belliann", "Nadalynn", "Nyshime", "Gridrith", "Neshymm", "Theryassa", "Malrith", "Yayassa", "Xiszys", "Yathibra", "Eshrinn", "Sudrish", "Hasira", "Faeyassa", "Kakaryn", "Therkaryn", "Akra", "Biri", "Daar", "Farideh", "Harann", "Havilar", "Jheri", "Kava", "Korinn", "Mishann", "Nala", "Perra", "Raiann", "Sora", "Surina", "Thava", "Uadjit"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("Gilmindik", "Shiaphojiadar", "Ulthak", "Nupharamuuth", "Myummacmath", "Arinkamon", "Dimbacnith", "Nirjisor", "Monxaandiash", "Fiathteastaak", "Kricuathed", "Laamral", "Irdol", "Dranxuk", "Drelthesadul", "Tiltitardian", "Cluaral", "Neris", "Kliphurec", "Alkiak", "Kricuathed", "Laamral", "Irdol", "Dranxuk", "Drelthesadul", "Tiltitardian", "Cluaral", "Neris", "Kliphurec", "Alkiak", "Nyaaldruur", "Fiarnedujil", "Gumtas", "Dualmujiled", "Mimtocmis", "Myustar", "Clilred", "Femrol", "Uccaath", "Lulthear", "Camtenkal", "Mampeal", "Ialmath", "Sherjiakmid", "Feldrod", "Darjistash", "Lanxethallak", "Ilkor", "Vaccethur", "Dalmal", "Aldraac", "Exaath", "Claphir", "Arthadal", "Elmetak", "Crechishkmargid", "Cardiak", "Klancic", "Prildralic", "Clarnar", "Inceshteth", "Druurnaasamur", "Danxuuxomor", "Dromphenshtuk", "Geccosh", "Dralduukmendir", "Cupean", "Nyiccecal", "Demphin", "Coxokath", "Thaphestellos", "Delmak", "Shecith", "Techokmer", "Kuldronthar", "Yuarrhithus", "Lastishtergol", "Nyorrhen", "Therakmedol", "Aldrijargir", "Thammustak", "Nelrustiamor", "Dephen", "Myumpuc", "Festijic", "Ilder", "Ethtas", "Tucekimuar", "Drastad", "Iarnur", "Tarrhonshtorgas", "Thochendrimak", "Tumtesh", "Culxenkud", "Nyirdor", "Yechan", "Nianxac", "Milrenkoruash", "Krixoshkmemish", "Yomphidurdar", "Krirdush", "Eamresolar", "Thommanshtural", "Dronkiacmaak", "Fepish", "Karthudearath", "Loncel", "Muuper", "Vialxalid", "Garjodialuur", "Accith", "Uphunshtin", "Venkojith", "Erjicmath", "Shuapin", "Eamtes", "Prechestor", "Clecostin", "Thulrir", "Duulthajargar", "Istuacmimer", "Klachukmuan", "Laldiacmed", "Yaardashkmirrad", "Ciankekmurrel", "Yirjeatilek", "Irrhinthic", "Sherdak", "Immundec", "Corrhes", "Nyuambes", "Prulronthik", "Uuncur", "Marthaan", "Emrothas", "Cluccean", "Aldixialloth", "Cluulthijialis", "Yuccicared", "Kenxes", "Yilthik", "Eamphastin", "Luumbinargur", "Dimrek", "Clelthushkmec", "Drearnikendel", "Myemphek", "Myimrid", "Daltukmed", "Nilxojas", "Cimphaad", "Myaldeal", "Crumpenkek", "Nenxisiath", "Melxaar", "Myeldrar", "Sherdeth", "Cuambath", "Enxiash", "Liaccuas", "Nyastad", "Komrecmilir", "Lethtian", "Nuultojaash", "Limtuac", "Orjucarden", "Achak", "Uuthtaadiargik", "Tualren", "Yultid", "Oltakmush", "Myulthed", "Shincek", "Komtaacmurgeal", "Elkish", "Cistak", "Shicasiad", "Cilkinshtelloc", "Encen", "Naathtun", "Vulxinkas", "Aathtenkiac", "Iltheacosh", "Thurneduk", "Yeltoth", "Myuamphenshtian", "Destel", "Yompiar", "Shithtuc", "Galduud"));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.dwarf:
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Adrik", "Alberich", "Baern", "Barendd", "Brottor", "Bruenor", "Dain", "Darrak", "Delg", "Eberk", "Einkil", "Fargrim", "Flint", "Gardain", "Harbek", "Kildrak", "Morgran", "Orsik", "Oskar", "Rangrim", "Rurik", "Taklinn", "Thoradin", "Thorin", "Tordek", "Traubon", "Travok", "Ulfgar", "Veit", "Vondal", "Bobor", "Norek", "Shalek", "Barom", "Dardren", "Thurmun", "Urmgus", "Hormiir", "Gardan", "Bamnar", "Belrig", "Ebkuhm", "Andmin", "Kharmar", "Thynir", "Armnur", "Krumdren", "Balkahm", "Hyldan", "Dalgrom", "Gerren", "Harrak", "Bromnus", "Thormar", "Bamnar", "Belrig", "Ebkuhm", "Andmin", "Kharmar", "Thynir", "Armnur", "Krumdren", "Balkahm", "Hyldan", "Dalgrom", "Gerren", "Harrak", "Bromnus", "Thormar"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Amber", "Artin", "Audhild", "Bardryn", "Dagnal", "Diesa", "Eldeth", "Falkrunn", "Finellen", "Gunnloda", "Gurdis", "Helja", "Hlin", "Kathra", "Kristryd", "Ilde", "Liftrasa", "Mardred", "Riswynn", "Sannl", "Torbera", "Torgga", "Vistra", "Jennryn", "Daerri", "Lyswin", "Angwyn", "Solthel", "Redleil", "Mystmura", "Lyeswin", "Tisbera", "Belglian", "Dimdyl", "Tismura", "Dimnera", "Gwynglia", "Bellelen", "Raebelle", "Tiznia", "Elmyla", "Brulva", "Gernia", "Tishryl", "Barvia", "Laswyn", "Tizlinn", "Baernyss", "Brylniss", "Torselle", "Brynmora", "Karlinn", "Nasswyn", "Bellenan", "Jenryn", "Brynbera", "Darnyss", "Nasstin", "Jinthel", "Einrielle", "Nysnis", "Elnar", "Beldyl", "Sardelle", "Daerros", "Nysres", "Ansael"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("Balderk", "Battlehammer", "Brawnanvil", "Dankil", "Fireforge", "Frostbeard", "Gorunn", "Holderhek", "Ironfist", "Loderr", "Lutgehr", "Rumnaheim", "Strakeln", "Torunn", "Ungart", "Shattershield", "Hammerfall", "Stinemir", "Myrfast", "Gemseeker", "Norbdurk", "Calrund", "Dunhart", "Lochlon", "Shieldbearer", "Naftbold", "Oakenshield", "Tarntwain"));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.elephantine:
                //first name only
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Choom", "Sves", "Veboos", "Drondrun", "Birumoz", "Throdjomoz", "Rebomoz", "Braton", "Ekoz", "Sebonol", "Gojoonosh", "Bodool", "Svijunov", "Vreluj", "Kemulon", "Ooden", "Gen", "Thrimoz", "Deldrool", "Dratemozh", "Throsurov", "Herdoloz", "Hadomoz", "Thrinrel", "Heborov", "Goguj", "Brefjoorom", "Frazh", "Svov", "Didrel", "Bav", "Ihul", "Svakos", "Aluzh", "Hages", "Rohuzh", "Orlrumozh", "Thorl", "Sviv", "Rohun", "Deten", "Zanruron"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Laruy", "Ifoy", "Alnis", "Rulyo", "Turhul", "Lyalrun", "Jenyur", "Boolrus", "Toorjol", "Lyatre", "Shunor", "Moota", "Foncem", "Yurju", "Moto", "Yalre", "Fedo", "Utrir", "Olnun", "Yoncoj", "Lasa", "Doobej", "Yeltuj", "DUno", "Kolnim", "Zeder", "Jenyon", "Lyoorjom", "Lonte", "Ira", "Kelyuy", "Lison", "Vasmes", "Balnin", "Yije", "Bancuy", "Yantu", "Kofyar", "Janci", "Bofos", "Velni", "Lyentus", "Keltum", "Vifi", "Dooncel", "Divi", "Oni", "Risi", "Zalyon"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.elf:
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Adran", "Aelar", "Aramil", "Arannis", "Aust", "Beiro", "Berrian", "Carric", "Enialis", "Erdan", "Erevan", "Galinndan", "Hadarai", "Heian", "Himo", "Immeral", "Ivellios", "Laucian", "Mindartis", "Paelias", "Peren", "Quarion", "Riardon", "Rolen", "Soveliss", "Thamior", "Tharivol", "Theren", "Varis", "Morvlulaar", "Ralopeiros", "Genmenor", "Umelimin", "Genlen", "Keacan", "Perris", "Fensalor", "Qixalim", "Virhorn", "Elhorn", "Farneiros", "Umeren", "Vamenor", "Adberos", "Cralamin", "Zumven", "Quinqen", "Aeren", "Ololar", "Heradan", "Norpetor", "Lolqen", "Qinnorin", "Aewarin", "Vaxidor"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Adrie", "Althaea", "Anastrianna", "Andraste", "Antinua", "Bethrynna", "Birel", "Caelynn", "Drusilia", "Enna", "Felosial", "Ielenia", "Jelenneth", "Keyleth", "Leshanna", "Lia", "Meriele", "Mialee", "Naivara", "Quelenna", "Quillathe", "Sariel", "Shanairra", "Shava", "Silaqui", "Theirastra", "Thia", "Vadania", "Valanthe", "Xanaphia", "Phiralei", "Mairona", "Wysarel", "Lianala", "Ravaharice", "Yllaxisys", "Eillee", "Eifiel", "Vensatra", "Gilwyn", "Dalee", "Zylrona", "Holadove", "Zylrel", "Fafiel", "Kriskalyn", "Neribanise", "Geharice", "Gilxina", "", "Nericyne", "Gremys", "Faelana", "Rayroris", "Ravastina", "Jophyra", "Miavaris", "Bryleth", "Ravadi", "Loramana", "Holabanise"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.firbolg:
                //Firbolgs often take elven names but I've thrown in a few extra for variety. First name only
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Zumtumal", "Waesceran", "Zinhice", "Ralodan", "Umexalim", "Sylgolor", "Kelceran", "Beiro", "Petro", "Fenhorn", "Adran", "Aelar", "Aramil", "Arannis", "Aust", "Beiro", "Berrian", "Carric", "Enialis", "Erdan", "Erevan", "Galinndan", "Hadarai", "Heian", "Himo", "Immeral", "Ivellios", "Laucian", "Mindartis", "Paelias", "Peren", "Quarion", "Riardon", "Rolen", "Soveliss", "Thamior", "Tharivol", "Theren", "Varis", "Morvlulaar", "Ralopeiros", "Genmenor", "Umelimin", "Genlen", "Keacan", "Perris", "Fensalor", "Qixalim", "Virhorn", "Elhorn", "Farneiros", "Umeren", "Vamenor", "Adberos", "Cralamin", "Zumven", "Quinqen", "Aeren", "Ololar", "Heradan", "Norpetor", "Lolqen", "Qinnorin", "Aewarin", "Vaxidor"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Chaeyra", "Olamys", "Liavyre", "Adxina", "Sylphine", "Wysazana", "Bigella", "Inara", "Ulagella", "Olaphine", "Kaynala", "Adrie", "Althaea", "Anastrianna", "Andraste", "Antinua", "Bethrynna", "Birel", "Caelynn", "Drusilia", "Enna", "Felosial", "Ielenia", "Jelenneth", "Keyleth", "Leshanna", "Lia", "Meriele", "Mialee", "Naivara", "Quelenna", "Quillathe", "Sariel", "Shanairra", "Shava", "Silaqui", "Theirastra", "Thia", "Vadania", "Valanthe", "Xanaphia", "Phiralei", "Mairona", "Wysarel", "Lianala", "Ravaharice", "Yllaxisys", "Eillee", "Eifiel", "Vensatra", "Gilwyn", "Dalee", "Zylrona", "Holadove", "Zylrel", "Fafiel", "Kriskalyn", "Neribanise", "Geharice", "Gilxina", "", "Nericyne", "Gremys", "Faelana", "Rayroris", "Ravastina", "Jophyra", "Miavaris", "Bryleth", "Ravadi", "Loramana", "Holabanise"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.genasi:
                //Genasi often take the names of the people among whom they were raised but may take other names to capture their heritage (type), such as Flame, Ember, Wave, or Onyx.
                if (randGen.randomIntInRange(1, 100) <= 33) {
                    List<String> genasiNames = new ArrayList<>(Arrays.asList("Onyx", "Ember", "Sapphire", "Wave", "Flame", "Gust", "Breeze", "Hurricane", "Wind", "Cinder", "Malachite", "Earth", "Current", "Puddle", "Tsunami", "Tornado", "Steel", "Diamond", "Earthquake", "Cavern", "Blaze", "Glacier", "Scorch", "Boulder", "Blizzard", "Volcano", "Torch", "Whirlwind", "Mudslide", "Burn", "Stream", "Monsoon", "Ocean", "Lake", "Cloud", "Rain", "Hail", "Meteor", "Iron", "Diamond", "Copper", "Earthquake", "Mountain", "Corundom", "Gemstone"));
                    firstName = randGen.getRandomFromStringList(genasiNames);
                } else {
                    getNameFromRace(randGen.getRandomRace());
                }
                break;
            case Races.gith:
                //first name only
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Unakiak", "Sadahn", "Zarniar", "Furzirg", "Radarr", "Brudh", "Fagh", "Srakiak", "Shraniar", "Drazak", "Urlag", "Gretig", "Brand", "Orodak", "Khak", "Granod", "Fanod", "Bardran", "Oradar", "Rugh", "Orozth", "Razar", "Unanak", "Sharm", "Drokk", "Brulid", "Mamak", "Runiar", "Dak", "Sarek", "Bartar", "Unrth", "Gruzeg", "Khamiak", "Krolis", "Nalahr", "Zartar", "Duzar", "Hurek", "Amnag", "Rinnag", "Uratig", "Karth", "Barrdi", "Amdh", "Rinllak", "Nunrg"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Halmniya", "Nagrena", "Aranith", "Erzherra", "Ilnel", "Harnekus", "Uwanya", "Uwaka", "Shundnia", "Khazelna", "Shundya", "Umeka", "Lhashilzin", "Ellnia", "Lhashane", "Almilzin", "Mireya", "Adaka", "Nashekus", "Ihrilias", "Sharmiris", "Genrenah", "Hanalla", "Raszanya", "Helnanith", "Arwnera", "Izamira", "Arniya", "Ashin", "Ashel", "Dahalla", "Lezekus", "Mireth", "Arwilias", "Orith", "Shundilzin", "Ezhnera", "Raszeketh", "Kurakka", "Nagduza", "Magdiza", "Nalmelzal", "Grinel", "Leznel", "Dahelya", "Shundihn"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.gnome:
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Alston", "Alvyn", "Boddynock", "Brocc", "Burgell", "Cornan", "Dimble", "Eldon", "Eninan", "Erky", "Erwor", "Fargim", "Fellin", "Fonkin", "Frug", "Gerbo", "Gimble", "Glim", "Grapip", "Grawor", "HorminZilhim", "Hormop", "Jebeddo", "Jorxif", "Kellen", "Manyry", "Marryn", "Merziver", "Namfoodle", "Orryn", "Pipplin", "Quokas", "Roondar", "Salin", "Salni", "Seebo", "Sindri", "Tanfan", "Togrim", "Uriser", "Valni", "Valpos", "Valybar", "Warryn", "Wilnan", "Wrenn", "Xalkas", "Zook"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Alumiphi", "Alurhana", "Arili", "Bandysa", "Bantina", "Bimpnottin", "Breena", "Breepine", "Caramip", "Carlin", "Cartra", "Cartri", "Cartrora", "Celza", "Donella", "Duvamil", "Ella", "Ellyjobell", "Ellywick", "Fenfyx", "Fenroe", "Folxis", "Grendysa", "Hesnove", "Hestra", "Johani", "Klossa", "Knokasys", "Kriroe", "Lilli", "Lilxis", "Loopmottin", "Lorilla", "Lorixi", "Mardnab", "Nissa", "Nyx", "Nyxi", "Oda", "Orla", "Orlinana", "Orvanhona", "Queqaryn", "Queqys", "Redira", "Reli", "Roywyn", "Selkini", "Selza", "Shamil", "Slpine", "Tana", "Ufenoa", "Venmila", "Waywocket", "Wrobi", "Xagyra", "Xawyn", "Zaniqys", "Zanna", "ZIngyra", "Zinza"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("Aggrit", "Aleslosh", "Ashhearth", "Badger", "Beren", "Booplesnoot", "Bumblegass", "Bup", "Bushbait", "Cappatap", "Cloak", "Daergel", "Doublelock", "Durrdur", "Feedledum", "Filchbatter", "Floofen", "Fnipper", "Folkor", "Forkenshtein", "Forokensmock", "Freedabear", "Gandywinder", "Garrick", "Goopliesplit", "Goradboard", "Gormamoople", "Grapegarum", "Hackafoot", "Hagormorter", "Handyfist", "Harpagrout", "Harporharpoon", "Hookafish", "Hopple", "Jumpscotch", "Ku", "Larkenschport", "Laughabout", "Leejalcook", "Lickilly", "Loffle", "Lollabout", "Loudcafoomph", "Meistparoogle", "Murnig", "Nackle", "Nibbitigibbit", "Nim", "Ningel", "Noodlebork", "Nooger", "Norkasnork", "Noxiumstiss", "Ondeleet", "Oneshoe", "Opalithp", "Parrymater", "Perumafloo", "Pock", "Raulnor", "Rollaway", "Rucksacksnout", "Sandypaws", "Scheppen", "Sparklegem", "Stumbleduck", "Timbers", "Trombas", "Turen", "Turtletum", "Zoosaslosh"));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.goliath:
                //goliaths typically have 3 names, the middle being a "description" or nickname of sorts
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Ergmahk", "Neorein", "Ilagath", "Veganath", "Ergthak", "Naumahg", "Keorhan", "Lazalath", "Zaulig", "Kramahg", "Virok", "Geamahg", "Gaglath", "Thovek", "Marazak", "Khuvith", "Kanamith", "Meavek", "Panak", "Aunoth", "Koraveith", "Thavaglath", "Lorokin", "Kavakan", "Varian", "Neodath", "Vegaveith", "Maralok", "Naukein", "Kanamul", "Vomith", "Ergrath", "Tarakan", "Taumahl", "Thokein", "Vokin", "Eagmul", "Neogith", "Aurnath", "Naukin", "Kavavhal", "Taragith", "Kazadak", "Gamahg", "Khumahk", "Vegarath", "Aggal", "Zaurhak", "Thamahk", "Lorolok", "Moziath", "Augkon", "Paziath", "Eagvhik", "Aurroth", "Agthi", "Tauvhik", "Eagvhal", "Gagak", "Taunak", "Nagath", "Kanamahk", "Keothag", "Aurkin", "Panihl", "Laukhal", "Ilavhik", "Kavagath", "Iragan", "Iranihl", "Vegamul", "Kazakon", "Nararhak", "Lazaroth", "Naugath", "Marad", "Kavaghan", "Egthag", "Keothi", "Lazadath", "Maradhan", "Mauziath", "Kavanak", "Aurgath", "Khurath", "Pamak", "Keogan", "Tharian", "Zaurok", "Mauveith", "Kranath", "Ghalig", "Madak", "Kramul", "Nagun", "Vidhan", "Kavarin", "Thakon", "Auglok", "Kazamith", "Thavarath", "Krathag", "Kazadath", "Vamahg", "Ergdak", "Lazavek", "Zaukon", "Malath", "Ilavhal", "Neophak"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Vegu", "Lami", "Gelo", "Anenia", "Orileo", "Naukea", "Kemi", "Paurra", "Lethea", "Penna", "Zaala", "Lone", "Zaugeo", "Gaulea", "Naupeu", "Lenna", "Olavea", "Gelmi", "Orerheo", "Lanu", "Megu", "Nonia", "Manlo", "Orenna", "Nikeo", "Ageghu", "Kethio", "Olarea", "Kuovi", "Olani", "Tharra", "Zaala", "Laugeo", "Nalnna", "Kemeo", "Lapeo", "Paakio", "Thauria", "Inageo", "Olathia", "Manrheo", "Parrea", "Thauneo", "Manleo", "Galnia", "Thenea", "Mauthia", "Gelgeo", "Vauria", "Loneo", "Gaurea", "Ageggeo", "Zaavu", "Thenea", "Zaathea", "Daaghu", "Manlane", "Nothea", "Nalvu", "Daala", "Naurea", "Anethia", "Parra", "Thuthu", "Thanu", "Kuovu", "Pekea", "Ilathe", "Gelne", "Paakea", "Kaukea", "Vene", "Vauri", "Lavea", "Kaurea", "Lauri", "Gelgu", "Vaameo", "Vauthe", "Onennio", "Naria", "Gagu", "Kuolai", "Theri", "Zaapeo", "Meni", "Gaugu", "Olakio", "Maalo", "Pethia", "Niria", "Keghu", "Veria", "Maugu", "Kaulane", "Olakeo", "Maapeu", "Kuokeo", "Lenna", "Geri", "Ilapeu", "Kaurrea", "Mepeu", "Kemeo", "Vopu", "Arekha", "Mankko", "Orinna", "Daurrea", "Noma"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);

                //middle name addition
                possibleNames = new ArrayList<>(Arrays.asList("Dreamjumper", "Nightwalker", "Wanderworker", "Lowbreaker", "Frightwatcher", "Wildspeaker", "Mindsmasher", "Bravecook", "Lowdream", "Lumberspeaker", "Silenttwister", "Flowerstalker", "Stoneaid", "Dreamwarrior", "Threadwanderer", "Dreamlander", "Brightfrightener", "Skyguard", "Brightfinder", "Rivertwister", "Highvigor", "Dreamleaper", "Adeptlogger", "Fearlesswalker", "Hideherder", "Foodfrightener", "Hornworker", "Thundereye", "Smartfist", "Woundjumper", "Hidestriker", "Wildwatcher", "Bravefist", "Wanderbearer", "Rootcook", "Bravekiller", "Stormwarrior", "Wildcarver", "Rootmaker", "Strongmaker", "Steadyfinder", "Dreamtanner", "Mindhand", "Hardbreaker", "Rivertwister", "Mindlander", "Dreamlander", "Lumbercaller", "Tribestalker", "Fearlessmaker", "Dayfinder", "Smartspeaker", "Mindrunner", "Longspeaker", "Woundmaker", "Honestmaker", "Lumbereye", "Stonespeaker", "Rootleader", "Fearlesshand", "Masteraid", "Bearwatcher", "Tribebearer", "Mountainclimber", "Mindlander", "Strongwanderer", "Woundweaver", "Lowjumper", "Lonerunner", "Stronghand", "Fearlessworker", "Hidewanderer", "Longaid", "Stoneweaver", "Flintlogger", "Wildweaver", "Silentrunner", "Hidechaser", "Dawnleaper", "Wanderclimber", "Longstriker", "Honesthunter", "Truthbreaker", "Skychaser", "Flowerstalker", "Hornwatcher", "Bravehunter", "Lumbercaller", "Brightweaver", "Longdream", "Wanderfriend", "Truebreaker", "Wanderclimber", "Flintfrightener", "Threadfriend", "Rainheart", "Truthmaker", "Wanderfrightener", "Flinttanner", "Rootaid", "Woundbearer", "Honesteye", "Lumberfriend", "Hornwalker", "Woundtwister", "Adeptfriend", "Slyhauler", "Stormlander", "Wisekiller", "Deerleaper", "Rocktanner", "Horndrifter", "Slymender", "Nightfist", "Highwarrior", "Highfrightener-Gatake", "Tribeeye-Vatake", "Wildmaker", "Fearlessfrightener-Gigo", "Flintchaser", "Dreamtwister-Gavone", "Skywarrior", "Flinthauler", "Fearlesshauler", "Slytanner", "Goatpicker", "Bearcarver-Mukane", "Longmender", "Wildworker", "Keenfriend", "Flintfriend", "Stormvigor", "Hardcarver-Olekali", "Skyhauler", "Rivermaker", "Flintpicker-Lolake", "Thundersmasher", "Foodshot", "Masterrunner-Kiago", "Smartchaser-Leaku", "Steadyvigor", "Hidefriend-Lathai", "Slycook", "Highwatcher-Kiano", "Lonebreaker", "Lowaid", "Bravedream", "Swiftchaser", "Swiftguard", "Flowermaker", "Goatkiller-Olakume", "Riverlander", "Fearlessfist", "Honesthunter", "Tribeherder", "Slywanderer", "Lowheart", "Honestguard-Ulutha", "Riverpicker", "Mountainstriker", "Daydrifter-Oligone", "Frightcook", "Mountainfist", "Slystalker", "Wisebearer", "Bravedream", "Longwanderer-Vageane", "Honestshot-Viago", "Rainhand", "Slykiller", "Dawnrunner-Vatake", "Treecook", "Truthwarrior-Makane", "Dayweaver-Mamino", "Mountainshot", "Smartworker-Lathai", "Riverheart", "Rootcaller", "Keensmasher", "Flowerleaper-Kukane", "Rockdrifter-Kamune", "Brightshot", "Adeptstalker", "Treewarrior", "Rootworker", "Lonekiller", "Highwatcher", "Bravecaller-Lakane", "Threadleaper", "Rockbreaker", "Skykiller", "Thunderlogger", "Swiftchaser-Miago", "Hardcook", "Threadfist", "Wildeye-Lamino", "Lowleaper", "Honestbearer", "Stonepicker-Nulane", "Swiftkiller", "Rainfist", "Foodmender-Vekali", "Mountainclimber", "Longcarver", "Bravewalker", "Dawnfrightener", "Slyleader", "Nightmender-Vigo", "Longfist-Gugoni", "Rockweaver-Ulamino", "Longfinder", "Goatworker-Nekali", "Dawnguard-Vuthea", "Masterdrifter", "Flintmender", "Wanderkiller-Ulakane", "Threadfrightener", "Hardspeaker", "Stormstalker", "Strongwalker"));
                firstName = firstName + " " + randGen.getRandomFromStringList(possibleNames);

                possibleNames = new ArrayList<>(Arrays.asList("Kulanamino", "Agu-Vileana", "Thunukolake", "Agu-Vamune", "Agu-Ulamune", "Nalakiago", "Apuna-Maga", "Kalukukena", "Ugunakanu", "Ovethavone", "Egena-Vakane", "Nulakigano", "Agu-Vigano", "Vunakigala", "Kolae-Gaga", "Egumavea", "Muthalolake", "Geanukate", "Kolakakume", "Munakatho", "Nulakugate", "Nugalathai", "Uthenu-Kavea", "Kulanatake", "Gathakolake", "Malukakume", "Ogolileana", "Thunukageane", "Egena-Vekali", "Vathunavea", "Kalukileana", "Inulatake", "Athunulane", "Nalakiago", "Ugunanathi", "Thunukakane", "Kulumelo", "Nulakigane", "Egena-Veaku", "Nola-Kigone", "Munakanathi", "Nalakigano", "Uthenu-Kithino", "Geanamune", "Muthalathai", "Kulanolake", "Veomolake", "Nulakugate", "Munakathala", "Elanileana", "Katho-Oluthea", "Uthenu-Kakanu", "Ogolukena", "Vuma-Thukane", "Gathakutha", "Agu-Vavi", "Apuna-Mavi", "Kalagigone", "Kulumukane", "Gathakigano", "Egena-Vathai", "Veomathala", "Thunukiala", "Ugunakume", "Anakalatho", "Nalakiago", "Valu-Nathala", "Muthaliano", "Inulakume", "Thunukatho", "Gathakathai", "Ugunavi", "Uthenu-Kigala", "Katho-Oligala", "Kalagupine", "Kalukukate", "Apuna-Miano", "Egena-Vithino", "Katho-Oligone", "Munakamune", "Ogolatake", "Egena-Vatake", "Ganu-Mamune", "Nugaliano", "Egena-Vigone", "Vunakamune", "Veomigane", "Ovethupine", "Ganu-Muthea", "Thenalugoni", "Kolakigano", "Valu-Nuthea", "Anakalugoni", "Elaniaga", "Vathunaga", "Ogolekali", "Vaimei-Lavi", "Munakiano", "Apuna-Matho", "Malukiago", "Agu-Vugate", "Vathunekali", "Katho-Olatho", "Kulaniala", "Elanolake", "Ovethugate", "Ogolakume", "Katho-Olugate", "Munakatho", "Ovethamino", "Kalagiala", "Kulanelo", "Malukathai", "Muthalugate", "Munakamino", "Kolae-Gatake", "Agu-Vatake", "Nugaliano", "Kolae-Gigo", "Muthalukate", "Kolae-Gavone", "Kulanaga", "Anakalavi", "Ogolithino", "Kulanamune", "Gathakamune", "Apuna-Mukane", "Nalakugoni", "Inulugoni", "Kolakathala", "Kalukathala", "Kalukavone", "Katho-Olekali", "Kulumupine", "Veomiago", "Vaimei-Lolake", "Nalakamune", "Kulumathala", "Uthenu-Kiago", "Vaimei-Leaku", "Thenalugoni", "Vaimei-Lathai", "Veomigane", "Nola-Kiano", "Egumolake", "Munakekali", "Gathakugate", "Kulumaga", "Kulanugate", "Kalagavi", "Katho-Olakume", "Thenalalathi", "Elanigane", "Lakumathala", "Munakaga", "Geanulane", "Thulolake", "Agu-Ulutha", "Thenalatake", "Nulakigano", "Katho-Oligone", "Egumigano", "Elanigano", "Elanaga", "Lakumithino", "Ugunupine", "Egena-Vageane", "Egena-Viago", "Veomiala", "Gathakiago", "Agu-Vatake", "Athunatake", "Ganu-Makane", "Apuna-Mamino", "Athunigano", "Vaimei-Lathai", "Inulukate", "Kolakigane", "Kolakileana", "Nola-Kukane", "Uthenu-Kamune", "Munakakanu", "Kalagigala", "Gathakukane", "Geanigo", "Inulileana", "Kulanigala", "Vaimei-Lakane", "Ovethukena", "Vathuneaku", "Ogolalathi", "Thenalolake", "Apuna-Miago", "Nugalukena", "Kolakaga", "Vaimei-Lamino", "Gathakithino", "Ogolithino", "Valu-Nulane", "Nugaleaku", "Kalukuthea", "Egena-Vekali", "Kalagamune", "Geanakanu", "Nalakigo", "Thunukakume", "Malukeaku", "Agu-Vigo", "Kolae-Gugoni", "Agu-Ulamino", "Geanamino", "Valu-Nekali", "Agu-Vuthea", "Lakumaga", "Ogolugate", "Agu-Ulakane", "Kalukukate", "Kulaneaku", "Malukathai", "Vathunigone"));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.goblin:
                //first name only
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Mullalk", "Sedgas", "Cillas", "Dejulk", "Mab", "Lousehead", "Globmaw", "Brubbone", "Boardung", "Leechbrain", "Zrarrurk", "Zris", "Tegdut", "Cojark", "Vajes", "Lumpfeet", "Mudface", "No-Nose", "Snailbones", "Pighead", "Tork", "Uchek", "Tegluk", "Rab", "Uggag", "Dirtgace", "Uglymug", "Smugknuckles", "Mossgob", "Brainless", "Edges", "Herk", "Dark", "Murkarms", "Wartface", "Pinkeye", "One-eye", "Bonenose", "Maggulk", "Zrallirk", "Dardark", "Har", "Steg", "Stump", "Boneear", "Chowder", "Slimeteeth", "Viledrool", "Gnat", "Globteeth", "Nobfingers", "Flat-face", "Flab", "Arri", "Tichulk", "Crochub", "Gars", "Gadrut", "Gabgut", "Gutterlegs", "Mossleg", "Wormflap", "Bentarms", "Slimecheek", "Limp", "Gumb", "Grugg", "Crog", "Jorg", "Krab", "Dak", "Dirttooth", "Slaggo", "Runt", "Bucket", "Stinkknuckles", "Maggot", "Goutknees", "Rottooth", "Fleeceface", "Nirdob", "Poglak", "Pegrogg", "Snack", "Brokenbrain", "Palebones"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Rigul", "Bugrizi", "Vilgindin", "Nalgir", "Zandul", "Moldnose", "Fatness", "Murkfeet", "Sleaze", "Louseback", "Horrmuck", "Greasetoes", "Armjam", "Trollbait", "Antbed", "Grime-eye", "Slob", "Fishchunks", "Zurtis", "Weakflesh", "Gilzu", "Oafmarrow", "Dirtmaw", "Leeches", "Grubhead", "Mudrik", "Ichorlegs", "Venomstare", "Velva", "Shrillchin", "Gratesqueak", "Wideknuckle", "Shame", "Spinehair", "Dirgol", "Gulzu", "Pilvas", "Grimeflank", "Halfbrain", "Moldguts", "Toadface", "Mirrorbreaker", "Glob", "Vadds", "Glump", "Vat", "Bush", "Snailtongue", "Bitenose", "Sagshoulder", "Courseflesh", "Spinehug", "Birdbrain", "Malformed", "Wormfood", "Ugrun", "Dindi", "Ratscowl", "Cowdung", "Lurk", "Lurch", "Sloth", "Slurp", "WartWearer", "Slag", "Vorsh", "Mumps", "Runt", "Dumpskin", "Gil", "Fishbone", "Pigmud", "Frogwart", "Waste", "Stubflab", "Mitemouth", "Lurch", "Hobble", "Muckcrawler", "Sin", "Bile-eater", "Dross", "Fool", "Gur", "Partar", "Ranrar", "Mirgol", "Gadir", "Oafbrain", "Spiderlips", "Zak", "Jal", "Elgon", "Peon", "Bearbutt", "Gobsmacker"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.halfElf:
                if (randGen.randomIntInRange(1,100) <=50) {
                    getNameFromRace(Races.human);
                } else {
                    getNameFromRace(Races.elf);
                }
                break;
            case Races.halfOrc:
                if (randGen.randomIntInRange(1, 100) <= 50) {
                    getNameFromRace(Races.human);
                } else {
                    getNameFromRace(Races.orc);
                }
                break;
            case Races.halfling:
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Zowan", "Quinlos", "Ribul", "Kaswan", "Teemin", "Daeagol", "Gruffo", "Jolly", "Largo", "Williabald", "Willimar", "Carl", "Tobold", "Togo", "Tolman", "Tammit", "Sordo", "Briffo", "Bruno", "Isengrin", "Otho", "Olo", "Ted", "Theodoric", "Tobias", "Andwise", "Ansegar", "Doderic", "Dinodas", "Cottar", "Cotman", "Cosimo", "Porro", "Renigard", "Robin", "Robur", "Roderic", "Erling", "Bladud", "Blanco", "Bucca", "Bob", "Ferumbras", "Garlos", "Belwan", "Ridal", "Merry", "Pippin", "Samwise", "Alton", "Ander", "Cade", "Corrin", "Eldon", "Errich", "Finnan", "Garret", "Lindal", "Lyle", "Merric", "Milo", "Osborn", "Perrin", "Reed", "Roscoe", "Wellby"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Adaldrida", "Ashpodel", "Belba", "Belinda", "Bellisima", "Berylla", "Camelia", "Celendine", "Cora", "Dina", "Dora", "Durenna", "Estella", "Fatima", "Gerda", "Gertrude", "Gilly", "Grinda", "Joy", "Lalia", "Lamsi", "Laura", "Lavinia", "Lilime", "Lilly", "Melissa", "Mentha", "Mimosa", "Miranda", "Myrtle", "Nina", "Orphi", "Pearl", "Pervina", "Pimpernell", "Poppy", "Prima", "Primula", "Rhoda", "Rimlay", "Rose", "Sage", "Savanna", "Semolina", "Shaleesa", "Silma", "Sunflower", "Tanta", "Tulip", "Verona", "Windy", "Yolanda"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("Gamgee", "Landershill", "Jarkobsriver", "Amster", "Dudley", "Bandawax", "Brushgather", "Brownlock", "Cotton", "Tighfield", "Thorngage", "Weatherbee", "Melilough", "Gardner", "Kaese", "Millbridge", "Ostgood", "Trill", "Greenspan", "Gammidge", "Boffin", "Bullroarer", "Dale", "Grandbody", "Ashworthy", "Bolger", "Farseeth", "Forst", "Hidigard", "Dildibrand", "Minto", "Moro", "Saraddas", "Sago", "Samlad", "Fastred", "Ferdinand", "Filibert", "Bladud", "Basso", "Meridock", "Fulvus", "Inigo", "Gorbulas", "Isengar", "Paelladin", "Celcamore", "Brushgather", "Goodbarrel", "Greenbottle", "High-hill", "Hilltopple", "Leagallow", "Tealeaf", "Thorngage", "Tosscobble", "Underbough", "Underhill", "Overhill", "Goodharvest", "Goodbeer", "Rurickstead", "Tumbledown", "Loftdannon"));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.hobgoblin:
                //unisex first name only
                possibleNames = new ArrayList<>(Arrays.asList("Vozec", "Dogerg", "Lok", "Lakur", "Nakkover", "Glozuk the Giant", "Krozrud the Wretched", "Dorkak the Vengeful", "Zarz Bully", "Arberg Snarl", "Volvirerg", "Kazed", "Khalvrelun", "Rukovan", "Rhodeleg", "Garkozon Shred", "Gloc Conquer", "Kluvlal the Edge", "Monkel the Behemoth", "Glevlac the Corrupt", "Grolvel", "Zrolzac", "Valdrec", "Relvarz", "Markal", "Glokkunod witch", "Krakned the Hunter", "Gud Shred", "Mazrurs Stomp", "Kazor the Snake", "Morok", "Zrolvers", "Kag", "Geldrurs the Strong", "Arboc Devour", "Khordel Lash", "Zorg Glare", "Zazrul the Reckless", "Makkor", "Drors", "Zrulzavurz", "Ravrovarz", "Agun Maul", "Klagar Pummel", "Zazrar the Warrior", "Klagar Pummel", "Zulzarg the Vengeful", "Shugrorg the Loud", "Lokrilar", "Ozarg", "Glol", "Grokkor", "Shavruzurg", "Drovloc the Demon", "Lurdal the Ox", "Kuvluc Bolster", "Gadar the Serpent", "Vandrak Bolt", "Zrardorg", "Dondok", "Shazrol", "KlandrorgOnkul the Marked", "Vok Crush", "Makravok the Might"));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.human:
                //First name only
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Busur", "Nannol", "Misud", "Rane", "Tingeg", "Twofeather", "Tankem", "Jason", "Grom", "Bob", "Sam", "James", "Jim", "Dolvod", "Lu", "Quang", "Hotef", "Jueh-Kahid", "Rur", "Piscis", "Melville", "Stanwick", "Werner", "Dionte", "Blais", "Pierto", "Vlaiborne", "Jost", "Wade", "Ramzi", "Utto", "Acton", "Manley", "Ulrico", "Gerward", "Ogden", "Rolando", "Sestrey", "Marc", "Newton", "Levi", "Allie", "Berthold", "Rodal", "Collin", "Miguel", "Chadwick", "Arwin", "Toby", "Lowe", "Ackerley", "Thibaud", "Donovan", "Werther", "Malin", "Walmund", "Tito", "Eppend", "Heimo", "Bronson", "Ursus", "Lyonel", "Newton", "Mitchell", "Garrin", "Marley", "Deryck", "Kjell", "Byrne", "Jose", "Philip", "Eugerus", "Utto", "Bogdan", "Jay", "Per", "Tombke", "Calhoun", "Tarik", "Gar", "Geof", "Marlo", "Westleigh", "Hastings", "Thoralf", "Vardan", "Tomkin", "Ferdy", "Leland", "Grigor", "Sennet", "Hanno", "Fancis", "Bellamy", "Dexter", "Fidelio", "Quinn", "Wirth", "Olaf", "Blaisdell", "Wain", "Masford", "Thorbert", "Alan", "Hardmod", "Michael", "Redd", "Beale", "Kinnser", "Osborn", "Blayze", "Delmon", "Ursinus", "Alcot", "Guarniero", "Kallist", "Harman", "Orville", "Verne", "Franek", "Mick", "Denzel", "Gabriel", "Carlo", "Jefferson", "Wakeley", "Leeroy", "Lothar", "Ingwar", "Parry", "Agrican", "Faust", "Nelles", "Adriel", "Teriel", "Shea"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Audey", "Fernly", "Hulda", "Merteena", "Aileen", "Fernanda", "Gracy", "Fernly", "Milva", "Palmyra", "Diana", "Estefani", "Marcelle", "Magnolia", "Ulva", "Lucy", "Yolanda", "Nella", "Chantel", "Silvia", "Audrey", "Dannie", "Kacie", "Katelynn", "Alondra", "Karly", "Jeanice", "Mckenna", "Gerda", "Jaycee", "Clothilde", "Elfrida", "Enrica", "Hedi", "Jocelin", "Sarai", "Sheila", "Hilde", "Alexandrea", "Geneve", "Miranda", "Germaine", "Rodericka", "Fantina", "Chante", "Bridgette", "Sonja", "Merlene", "Ina", "Jasmyne", "Tia", "Golda", "Carolyn", "Alisia", "Guiliana", "Paulina", "Mechthilde", "Molly", "Maidie", "Lorraina", "Varinka", "Saxona", "Beverly", "Erin", "Cierra", "Amia", "Miracle", "Wincke", "Walburg", "Oriel", "Richards", "Julee", "Jeannie", "Clementine", "Genie", "Eldrida", "Berthe", "Hadley", "Yelena", "Jasmeen", "Floria", "Tamara", "Mystique", "Lauretta", "Kyra", "Charmayne", "Chereen", "Gretel", "Alexia", "Tabitha", "Adelaide", "Janeesa", "Maegan", "Orlena", "Gerti", "Devondra", "Vivien", "Tanjura", "Kendra", "Luise", "Valentine", "Sasna", "Lorrin", "Tilly", "Sydnee", "Anjuschka", "Renee", "Halfeida", "Bnaka", "Sasha", "Aubire", "Jutta", "Elissa", "Hidie", "Damiane", "Alanis", "Romilda", "Marion", "Clementina", "Andrea", "Ryleigh", "Marion", "Xavierra", "Harrietta", "Janja", "Zeider", "Leia", "Dalia", "Malica"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.kenku:
                //unisex First name only. Usually named after sounds
                possibleNames = new ArrayList<>(Arrays.asList("Shaker", "Growler", "Cobbler", "Squealer", "Roar", "Deer Scratch", "Singer", "Crate Creak", "Caulrdon Stir", "Book Slam", "Buzzer", "Swiper", "Chimer", "Squeaker", "Beaver Call", "Frog Splash", "Honker", "Brush Stroke", "Hatchet Chop", "Nail Scratch", "Clamor", "Scrubber", "Mauler", "Owl Hoot", "Chirper", "Cricketer", "Bell Ring", "Tree Creak", "Fire Crackle", "Slicer", "Drummer", "Lion Growl", "Badger Grunt", "Duck Quack", "Lute String", "Kettle Bubble", "Crier Bell", "Clicker", "Scribbler", "Sheep Baa", "Hisser", "Hammer Drop", "Crate Smash", "Armor Clank", "Crystal Shatter", "Carver", "Rattler", "Goat Bleat", "Horse Sneeze", "Dragon Roar", "Bubble pop", "Mallet Crash", "Sword Clang", "Dog Bark", "Toad Croak", "Hoof Clop", "Mug Swish", "Whip Crack", "Crow Call", "Cat Screech", "Robin Song", "Wing Flutter", "Fox Yelp", "Water Splash", "Hoe Scrape", "Hog Oink", "Baby Cry", "Splash", "Wolf Howl", "Wheeze", "Horse Bray", "Slap", "Tearing Paper", "Rain Droplet", "Cork Pop", "Branch Snap", "Cat Meow", "Kettle Hiss", "Steel Scrape", "Duster", "Anchor Drop", "Door Creak", "Door Slam", "Dice Roll", "Dog Growl", "Pebble Drop", "Rat Squeak", "Giggle", "Small Explosion", "Squirrel Chatter", "Egg Crack", "Bowstring Stretch", "Page Turn", "Clatter", "Snort", "Splat", "Clicker", "Gouger", "Falling Sand", "Fruit Squish", "Wood Scratch", "Belt Unbuckle", "Leather Snap", "Bee Buzz", "Tree Fall", "Trumpeter", "Sizzle", "Rumble", "Sail Snap", "Pheasant Call", "Nailer", "Eagle Screech", "Saw", "Butcher", "Bat Chirp", "Door knock", "Thunderclap", "Raven Caw", "Dog Pant"));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.kobold:
                //unisex first names only
                possibleNames = new ArrayList<>(Arrays.asList("Kuss", "Zux", "Vess", "Gar", "Mugge", "Ude", "Nevnu", "Kuhro", "Rirki", "Gella", "Zuk", "Souk", "Rex", "Vim", "Kadi", "Nikke", "Tiri", "Mevni", "Hilti", "Nahze", "Has", "Vin", "Tox", "Tett", "Halli", "Mignu", "Ziku", "Sokda", "Gole", "Golgu", "Rott", "Sud", "Gex", "Zugs", "Kohzi", "Mokbi", "Salle", "Silda", "Tehzu", "Ilto", "Mir", "Kes", "Kud", "Tode", "Rilla", "Eppe", "Gigga", "Zukde", "Egu", "Ekla", "Zis", "Duge", "Apu", "Gera", "Urbo", "Ivi", "Arpu", "Huks", "Zatt", "Mag", "Regre", "Teglin", "Kilbo", "Vodra", "Zart", "Gokko", "Rorpe", "Kov", "Vek", "Zitt", "Gure", "Geba", "Sigga", "Hro", "Snodri", "Ahru", "Sasg", "Sern", "Zuppu", "Maldo", "Zeldo"));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.lizardfolk:
                //unisex first names only
                possibleNames = new ArrayList<>(Arrays.asList("Thror", "Tok", "Sharu", "Orgaes", "Dipirt", "Vachurt", "Treskusj", "Kuggesre", "Oshugax", "Kadragnun", "Thond", "Thro", "Throshresh", "Vollint", "Cardint", "Vauthrax", "Lidhot", "Thagrognia", "Jhesligraesj", "Multugnu", "Kau", "Sird", "Argor", "Ishru", "Altark", "Orku", "Jhelthich", "Thristrustuch", "Igistith", "Verdussu", "Thirk", "Thrink", "Bichoth", "Ultuant", "Ethord", "Ido", "Daulthush", "Thriltogres", "Aaretont", "Sushise", "Isj", "Bax", "Gapi", "Rislisk", "Erkarth", "Sipork", "Agheat", "Trulurras", "Thuslitind", "Dapustrisk", "Aank", "Ru", "Therta", "Golti", "Burket", "Eskin", "Asloss", "Bushrikus", "Bidrassuch", "Oligno", "De", "Thu", "Ogresk", "Risle", "Bererd", "Thegraech", "Jhaultha", "Troskorech", "Naarthogont", "Terhtetrox", "Or", "Rotrox", "Thadyv", "Vushrend", "Maaghurd", "Athren", "Ethotres", "Laghuthaa", "Taachastiss", "Gach", "Jhork", "Kalthesk", "Deshyx", "Kusho", "Thada", "Boltastor", "Uderask", "Salarrosh", "Sherth", "En", "Traeskis", "Trugoss", "Taatrank", "Voslo"));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.minotaur:
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Veoza", "Anekea", "Muuza", "Noolian", "Tiadra", "Munbur", "Arban", "Arkus", "Minfran", "Podfaruk", "Teelo", "Duupe", "Veoken", "Mouvera", "Irezara", "Kurnus", "Carvrak", "Mundrin", "Kargajan", "Dorranak", "Winavena", "Uovafen", "Hesfa", "Reotred", "Henedane", "Bjorgajan", "Harkus", "Cartiran", "Hunrapak", "Manrat", "Areza", "Duuven", "Aselo", "Raaslas", "Lootrin", "Rakdiar", "Noekar", "Farkun", "Minrat", "Kurmanuk", "Laantrin", "Entilo", "Seoven", "Oenpen", "Veoris", "Djardor", "Minbaran", "Jaturok", "Foosrakar", "Kirtaruk", "Miravena", "Raastin", "Ireren", "Nuopen", "Anepe", "Doengajan", "Kranras", "Brantaruk", "Karrakar", "Karfaruk", "Oestris", "Miravena", "Fasmin", "Eramira", "Weota", "Djarrilak", "Zamtagar", "Grankarat", "Arefaruk", "Mirkurat", "Nanmas", "Laantred", "Winasia", "Duutin", "Hilamas", "Noerut", "Koorilak", "Koorron", "Djunnarak", "Kookun", "Nanza", "Winasen", "Vita", "Anenim", "Weomas", "Mirnus", "Carkar", "Narrapak", "Carrat", "Bjormaruk", "Hesren", "Tinanore", "Sinazin", "Denza", "Teetri", "Trakraduk", "Rakmaruk", "Podnarak", "Jamaruk", "Karranak", "Tiamin", "Linedera", "Viken", "Miraren", "Moutrin", "Minkan", "Durrios", "Arnir", "Kranrios", "Krumnark"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Teetra", "Fasru", "Tinatri", "Fentri", "Oeskia", "Neodera", "Faslas", "Teetred", "Rinamira", "Laanvin", "Erares", "Kuomira", "Heneren", "Neaken", "Iasru", "Lineris", "Kilin", "Entimi", "Duonim", "Linevin", "Areres", "Loodera", "Seesven", "Henenu", "Duutrin", "Duula", "Neomas", "Fasru", "Fendin", "Vianan", "Estela", "Hilasen", "Teeres", "Sinatra", "Vira", "Aamdane", "Muurin", "Seesven", "Nuoren", "Denmin", "Weotred", "Fenna", "Seesmi", "Uovafin", "Heslen", "Noope", "Duura", "Seesfen", "Teetris", "Erazara", "Seora", "Linemi", "Rasren", "Denme", "Reomira", "Irepen", "Laantra", "Iasdin", "Kiafin", "Linesen", "Testra", "Mouna", "Anetra", "Anevena", "Seesfin", "Linemi", "Emvin", "Eradin", "Teenan", "Hilaris", "Heneken", "Noola", "Neakea", "Emnore", "Arelo", "Erasen", "Uovalian", "Muuza", "Hinesia", "Seoris", "Tiater", "Viasia", "Laanmas", "Looza", "Aamdin", "Oenmi", "Rinapen", "Fastris", "Iresen", "Oesvera", "Laanpe", "Raaspen", "Noonim", "Erala", "Veoren", "Esterin", "Kialas", "Weorin", "Denfen", "Anevin", "Emdin", "Aamnim", "Reonu", "Moudin", "Irera", "Weofa", "Linedin", "Oeslas", "Estedra", "Moufen", "Iretred", "Kuosen", "Aamdane", "Vivera", "Noolo", "Rasdin", "Kuodin", "Iasres", "Nuokea", "Virin", "Nandra", "Arepen", "Oeslen", "Tinadin", "Linetra", "Henekane", "Mirazara", "Arepen", "Nuofin", "Moufin"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("Fearlessskull", "Toughleader", "Brightwarrior", "Agilehoof", "Greateye", "Orcfury", "Agilestep", "Swiftpelt", "Heavyspeaker", "Stoutskin", "Goblinwalker", "Bearstep", "Brightspeaker", "Valiantbody", "Stouteye", "Glorybane", "Steelpelt", "Vigilleader", "Stormfighter", "Steadyheart", "Ironskull", "Truthmind", "Thickbane", "Orchunter", "Wolfheart", "Honorslash", "Thickleader", "Honorhunter", "Swifthoof", "Truthheart", "Stormwalker", "Agilehunter", "Goblinhide", "Steelwarrior", "Fistheart", "Sharpstep", "Brightpelt", "Ruggedskull", "Silentleader", "Steelhunter", "Boulderstriker", "Goblinroar", "Sharpeye", "Boulderskull", "Brightfighter", "Heavyskin", "Goblineye", "Boldhunter", "Ruggedroar", "Heavystep", "Valiantbody", "Stonehorns", "Valiantskin", "Sharpspeaker", "Greatstep", "Wolfbane", "Rockvigor", "Strongwalker", "Honorheart", "Nimblehunter", "Keenwarrior", "Ironhide", "Steelpelt", "Swifthorn", "Glorypelt", "Heavyhorn", "Keenhand", "Thunderheart", "Strongrunner", "Fearlessheart", "Thunderspeaker", "Vigilslash", "Greatfury", "Bravefighter", "Heavyhorns", "Stoneskull", "Nimblerunner", "Orcrunner", "Valianthand", "Rockheart", "Steadyhunter", "Bravefist", "Stormstep", "Jaggedstep", "Rockskull", "Boldleader", "Steelslayer", "Greatrunner", "Rockhunter", "Valiantstriker", "Goblinrunner", "Ironbody", "Honorhoof", "Stronghoof", "Keenslayer", "Thunderhide", "Strongskin", "Brighthoof", "Fistvigor", "Honorfighter", "Swiftstep", "Tougheye", "Swiftbane", "Toughleader", "Fistheart", "Greatbane", "Stouthoof", "Goblinskin", "Nimbleheart", "Sharphide", "Singleskin", "Heavyfury", "Bravehide", "Braveheart", "Ironhide", "Steadyslayer", "Keenhorn", "Stoneroar", "Singlehorns", "Steadyslash", "Truthbody", "Silentfighter", "Toughskin", "Strongfury", "Gloryskull", "Stonehorn", "Steelhoof", "Valiantslash", "Steadyhorns", "Goblineye", "Jaggedhorn", "Stormfist", "Fearlessbane", "Brightbane", "Valiantslayer", "Singleeye", "Sharpslash", "Steelhand", "Greathorns", "Nimblehunter", "Ironskull", "Fisteye", "Sharpwarrior", "Stoneleader", "Truthbane", "Stouteye", "Toughrunner", "Steadyslash", "Agileskull", "Nimblespeaker", "Singlehide", "Truthhide", "Brightmind", "Fearlesshand", "Stonewalker", "Honorskull", "Boldhide", "Bearwarrior", "Fistmind", "Nimbleskull", "Rockheart", "Keenhorns", "Swiftheart", "Fiststep", "Tougheye", "Jaggedslash", "Thickspeaker", "Orchorns", "Steelmind", "Truthskull", "Brighthoof", "Toughwalker", "Stormhorns", "Boldfist", "Fearlessspeaker", "Boulderheart", "Heavyfighter", "Bouldervigor", "Brightfighter", "Bouldermind", "Swiftwarrior", "Strongslayer", "Stoutskull", "Stronghorns", "Sharpslash", "Brightmind", "Rockhide", "Orchunter", "Greatbody", "Steadyslash", "Boldhorn", "Heavybody", "Thickleader", "Steelhand", "Goblinfighter", "Silentleader", "Gloryfist", "Silenthide", "Ruggedbody", "Vigilfury", "Keenhand", "Goblinvigor", "Greatstriker", "Honorskin", "Steadyleader", "Jaggedskull", "Orceye", "Vigilwalker", "Goblinleader", "Heavyslash", "Greatskull", "Orchunter", "Keenvigor", "Boldfist", "Bravefury", "Swiftstep", "Sharpfury", "Thickrunner", "Bearroar", "Steadyrunner", "Silentskull", "Valiantrunner", "Braveslayer", "Vigilfist", "Swiftheart", "Brightskin", "Stonefist", "Vigilpelt", "Goblineye", "Thickeye", "Thickheart", "Keenhunter", "Sharphorns", "Orcspeaker", "Stonerunner", "Boulderleader", "Fistfury", "Jaggedfury", "Fearlesswalker", "Ruggedleader"));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.orc:
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Zok", "Mokk", "Lull", "Bak", "Bhuguk", "Rutral", "Oddokk", "Lobok", "Ghudzob", "Dorag", "Rukk", "Dor", "Bal", "Duk", "Lurzokk", "Rogur", "Ghujob", "Zhamzuk", "Brarzakk", "Ghodzug", "Gran", "Dhol", "Lag", "Lun", "Noggakk", "Zhubrak", "Dhomog", "Dorzuk", "Bhuvob", "Zhujob", "Shull", "Mak", "Rhok", "Dhug", "Bruball", "Nudgar", "Rahzuk", "Zovrog", "Zojak", "Gokzag", "Dron", "Gur", "Rub", "Lall", "Zonub", "Drugvug", "Grurlok", "Drungall", "Andug", "Ruzok", "Luk", "Dhol", "Bhan", "Mal", "Agall", "Dragrur", "Zhavrukk", "Rhabzoll", "Bahrak", "Granull", "Rod", "Ghob", "Bhar", "Log", "Dartak", "Bhojokk", "Bongal", "Ghungog", "Bojakk", "Ukrab", "Gholl", "Mur", "Rhak", "Zuk", "Borlukk", "Guvrok", "Ruvan", "Ghondakk", "Nagall", "Brakzal", "Ghar", "Brar", "Bhag", "Gob", "Zurzab", "Notrag", "Nardub", "Rhudron", "Grudgor", "Zhardad", "Shun", "Drag", "Rhob", "Dab", "Mukrukk", "Zhohzug", "Brotub", "Bhudzag", "Oggod", "Grubrob", "Dhak", "Grag", "Rhull", "Bhad", "Grurtan", "Barzod", "Zugol", "Jodzon", "Shortul", "Bongad"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Dhuaf", "Duam", "Ghuam", "Buz", "Bhothra", "Ghivgong", "Kulleh", "Hawnu", "Avre", "Heeddeek", "Bhiel", "Duan", "Shong", "Zul", "Riddeen", "Dhaadkoz", "Komvo", "Ghiwnkak", "Memvin", "Seggul", "Rhuam", "Nah", "Dhil", "Nuv", "Shagzi", "Sigguv", "Dellen", "Hyemdi", "Ghinsaon", "Rheddo", "Shong", "Dhuv", "Mong", "Vel", "Kaodgao", "Ouvrek", "Uwgeeng", "Ghodgiz", "Bouwneng", "Suvu", "Dhauk", "Kyel", "Dhuv", "Nam", "Muathro", "Selvek", "Gaavram", "Raowgi", "Bedkuf", "Uwnem", "Siem", "Nyef", "Dan", "Zaoh", "Umduz", "Zomvov", "Rowgef", "Igvieng", "Dathrang", "Dhimvung", "Zal", "Mul", "Huz", "Bel", "Dhudkuz", "Gankauk", "Selling", "Nuvgoung", "Gumvof", "Iwgok", "Suf", "Zov", "Raf", "Shieh", "Kyeggouz", "Nemvual", "Daownim", "Evauh", "Nivnem", "Shotho", "Zaah", "Dang", "Koul", "Raaf", "Dhensa", "Allu", "Gaggo", "Keggi", "Rhawnuv", "Mauthoh", "Keev", "Rih", "Ghuz", "Gheh", "Dhomdum", "Rhovez", "Vingee", "Rodgez", "Bhewnieng", "Shelluaf", "Noh", "Kiel", "Rhuf", "Duaz", "Gothum", "Vilving", "Ugil", "Raavgaz", "Guavgyen", "Anze", "Man", "Bhong", "Bhaz", "Mal", "Otaav", "Iwnen", "Gigze", "Shuggau", "Gownao", "Ghiegzi", "Mek", "Haum", "Rhuf", "Gen", "Mengaov", "Guwnkef", "Ghuve", "Avnun", "Nigzing", "Ghivrok"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                //"last names" are all "the x"
                possibleNames = new ArrayList<>(Arrays.asList("The Broken", "Chaos Mutilator", "The Mad", "The Barbarian", "The Angry", "The Frantic", "The Volatile", "The Noxious", "Horror Splitter", "The Reckless", "The Violent", "Muscle Quasher", "The Gruesome", "The Angry", "The Gargantuan", "The Merciless", "Slave Squelcher", "Fiend Cracker", "Giant Masher", "The Barbarian", "Toe Axe", "Nose Hammer", "The Broad", "Poison Crusher", "The Broken", "Vermin Destroyer", "Pest Squisher", "Battle Clobberer", "The Glorious", "The Broad", "Chaos Snapper", "The Coarse", "Flame Masher", "Gnoll Razer", "The Vivid", "The Merciless", "Pride Quelcher", "Gnoll Quelcher", "The Fearless", "The Outlandish", "The Crazy", "The Barbaric", "Elf Razer", "Spite Snapper", "Knee Snapper", "The Smug", "Fang Snapper", "The Swift", "Slave Butcher", "The Smug", "The Cold", "Heart Dissector", "The Volatile", "The Fierce", "The Ugly", "Power Slicer", "The Volatile", "The Outlandish", "Heel Mutilator", "The Fearless", "The Proud", "Venom Brand", "The Maniac", "Throat Glaive", "Finger Strangler", "The Mighty", "Iron Razer", "Brass Lance", "The Venomous", "The Giant", "Brain Hammer", "The Wild", "Battle Crusher", "The Turbulent", "The Barbarian", "Blood Sword", "Giant Hammer", "Muscle Pummel", "The Brutal", "The Loyal", "Bone Razer", "The Turbulent", "Giant Razer", "Steel Ender", "Heel Piercer", "Joint Marauder", "The Gruesome", "Feet Smasher", "Ghost Piercer", "The Berserk", "The Hollow", "Spine Smasher", "Gnome Lance", "Teeth Brand", "The Infernal", "Breath Cleaver", "Heart Breaker", "Chin Queller", "Sorrow Quasher", "Power Cruncher", "The Turbulent", "Hate Hacker", "Fang Burster", "The Arrogant", "The Worthless", "The Repulsive", "The Wretched", "Steel Hacker", "The Prime", "The Hollow", "The Loyal", "The Violent", "War Cruncher", "The Worthless", "The Barbaric", "Poison Chopper", "Fiend Carver", "Chin Shatterer", "The Putrid", "Flame Blade", "The Repulsive", "The Reckless", "Scale Chopper", "The Anguished", "The Grave", "Pest Crusher", "The Cold", "The Feisty", "The Shady", "Dark Chopper", "The Filthy", "The Mighty", "The Infernal", "The Prime", "Hand Scalper", "Foot Skinner", "Skin Conquerer", "The Disfigured", "Flame Mutilator", "The Vivid", "Kill Breaker", "The Berserk", "The Feisty", "The Enormous", "Power Cruncher", "The Mad", "The Feisty", "Flesh Sword", "Pest Lance", "Battle Dagger", "The Colossal", "The Brute", "War Sabre", "Sorrow Conquerer", "Iron Burster", "Spine Squasher", "The Vicious", "The Wretched", "Power Sabre", "The Feisty", "Flesh Brand", "The Warped", "The Enraged", "Gnome Lance", "Horror Flayer", "Blood Smasher", "The Gross", "Power Piercer", "Poison Conquerer", "Kidney Quasher", "Hand Burster", "The Coarse", "Heel Spear", "Teeth Hammer", "Bone Skinner", "The Noxious", "Chest Wrecker", "Joint Squelcher", "The Bitter", "Venom Cruncher", "Gnome Squisher", "The Wretched", "The Cruel", "Thunder Squisher", "Rib Smasher", "The Brute", "Tooth Saber", "The Repulsive", "Scale Hacker", "Finger Wrecker", "The Grand", "The Crooked", "The Lethal", "Flesh Pummel", "The Radical", "The Putrid", "Rib Cruncher", "The Barbaric", "Finger Queller", "Chaos Sabre", "Power Squasher", "Venom Glaive", "Flesh Hammer", "Spine Glaive", "Giant Masher", "Kill Squasher", "The Feisty", "Head Cruncher", "Joint Gasher", "Gnome Sabre", "The Angry", "The Mad", "The Simple", "Power Squelcher", "Teeth Cleaver", "The Gargantuan", "The Mad", "Brass Slayer", "Pest Slicer", "Fang Breaker", "The Ugly", "Toe Lance", "Bone Splitter", "The Wrathful", "Kill Breaker", "The Colossal", "Dream Breaker", "Dream Marauder", "Gore Pummel", "Battle Crusher", "Battle Dissector", "Vermin Mutilator", "Ankle Mutilator", "Elf Snapper", "Throat Chopper", "Fang Hacker", "The Enraged", "Eye Cruncher", "Bitter Piercer", "The Sick"));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.tabaxi:
                //tabaxi usually have a nickname, shown in parenthesis
                possibleNames = new ArrayList<>(Arrays.asList("Burning-Fire (Fire)", "Tricking-Treat (Trick)", "Kite-in-the-Wind (Kite)", "Branch-of-a-River (River)", "Night-of-Dreams (Night)", "Austere-Scratch (Scratch)", "Pure-Bell (Bell)", "Gold-Rock (Gold)", "Violet-Guide (Violet)", "Three-Board (Three)", "Autumn-Harvest (Autumn)", "Flower-of-Ivory (Ivory)", "Winter-Breath (Winter)", "Blank-Board (Board)", "Rope-in-a-Knot (Knot)", "Six-Kite (Kite)", "Defiant-Carriage (Carriage)", "Misty-Storm (Misty)", "Elite-Shore (Elite)", "Swift-Snowflake (Swift)", "Tree-Blossom (Blossom)", "Crescent-Moon (Moon)", "Guest-at-Home (Guest)", "Remnants-of-History (Remnant)", "Beats-of-a-Heart (Beats)", "Two-Deer (Two)", "Gold-Fire (Gold)", "Faint-Star (Faint)", "Light-Dust (Dust)", "Hushed-Ice (Hushed)", "Sailing-Ship (Ship)", "Stripes-of-a-Tiger (Tiger)", "Screech-of-Bats (Bat)", "Veil-of-a-Mask (Veil)", "Four-Leaf-Clover (Clover)", "Eager-Plume (Eager)", "Lazy-Guest (Lazy)", "Elegant-Book (Book)", "Faint-Shadow (Faint)", "Hearty-Bite (Bite)", "Garden-of-Flowers (Flower)", "Three-Tree (Three)", "Mountain-Boulder (Boulder)", "Endless-Time (Time)", "Looping-Coil (Coil)", "Sapphire-Wave (Sapphire)", "Amusing-Song (Song)", "Stout-Tree (Tree)", "Faint-Bird (Bird)", "Lone-Grass (Lone)", "Belly-of-a-Beast (Beast)", "Night-of-Dreams (Night)", "Beauty-of-Summer (Summer)", "Trail-in-the-Woods (Trail)", "Song-of-Paradise (Song)", "Dynamic-Mirror (Dynamic)", "Single-Bubble (Single)", "Light-Patch (Light)", "Cheeky-Chains (Chains)", "Lone-Tree (Tree)", "Locket-on-a-Heart (Locket)", "Melting-of-Snow (Snow)", "Sand-of-the-Beach (Sand)", "Tree-Blossom (Blossom)", "Mountain-Boulder (Boulder)", "Eager-Wing (Wing)", "Elite-Bite (Elite)", "Lone-Riddle (Riddle)", "Hidden-Spark (Spark)", "Brave-Stream (Stream)", "Sky-Full-of-Stars (Sky)", "Owl-in-the-Morning (Owl)", "Sea-of-Opportunity (Sea)", "Aura-of-Passion (Aura)", "Mark-of-Life (Mark)", "Curious-Boot (Boot)", "Clever-Bear (Bear)", "Arctic-Spark (Arctic)", "Silent-Bell (Silent)", "Misty-Bat (Bat)", "Dangling-Button (Button)", "Fallen-Twig (Twig)", "Edge-of-the-World (Edge)", "End-of-Winter (Winter)", "Wave-on-the-Shore (Wave)", "Clever-Rain (Clever)", "Single-Locket (Locket)", "Silent-Branch (Branch)", "Ethereal-Thrill (Ethereal)", "Kind-Rock (Rock)", "Guide-of-Life (Guide)", "Hot-Flame (Flame)", "Edge-of-the-World (Edge)", "Spark-of-Life (Spark)", "Hen-of-the-Flock (Hen)", "Misty-Quilt (Quilt)", "Brave-Kite (Kite)", "Subtle-Cake (Cake)", "Rare-Scratch (Rare)", "Quiet-Branch (Quiet)", "Cake-of-Chocolate (Cake)", "Windy-Shore (Shore)", "Leaf-on-the-Water (Leaf)", "Three-Tree (Three)", "Peak-of-Mountains (Peak)", "Pure-Kite (Kite)", "Ruby-Leaf (Leaf)", "Subtle-Plume (Subtle)", "Sweet-Wish (Sweet)", "Cheeky-Clock (Cheeky)", "Song-of-Paradise (Song)", "Mist-in-the-Morning (Mist)", "Rain-in-Summer (Rain)", "Fish-in-the-River (River)", "Fallen-Twig (Twig)", "Fragile-Shore (Shore)", "Gold-Wonder (Wonder)", "Half-Time (Time)", "Ethereal-Candy (Ethereal)", "Lazy-Snowflake (Snowflake)"));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.tiefling:
                //first name only
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Erira", "Maleus", "Rolron", "Arros", "Xarros", "Xarnon", "Rolrakir", "Ecstasy", "Urmong", "Aranthor", "Ebmeros", "Kilmarir", "Zeril", "Zarthos", "Thyxik", "Light", "Awe", "Dharmenos", "Andrakir", "Malil", "Salmarir", "Guxire", "Lokemus", "Kosus", "Immortal", "Ashes", "Karthos", "Barrut", "Rexire", "Eradius", "Zardos", "Valxes", "Guxius", "Erxikas", "Sirrakas", "Ekvir", "Gumeros", "Dammong", "Arros", "Ozlyre", "Void", "Truth", "Akvius", "Ralshoon", "Iamong", "Mavmir", "Ralxikas", "Rolcius", "Nephris", "Esteem", "Mastery", "Sorrow", "Damthus", "Kilmeros", "Gureus", "Barmus", "Kosmir", "Guecius", "Ozchar", "Courage", "Valcis", "Kavius", "Rolzer", "Casrus", "Carthor", "Arkron", "Kyrius", "Carrion", "Promise", "Carrias", "Thexes", "Meus", "Guelyre", "Andros", "Kosxes", "Dharmeros", "Arandos", "Ammarir", "Valus", "Kilzire", "Barnon", "Ralira", "Maladius", "Piety", "Ekthos", "Iaichar", "Thyneemon", "Aknon", "Kailius", "Rolakos", "Zorlech", "Relentless"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Sarsolis", "Valhiri", "Griqine", "Briza", "Agnegoria", "Doryola", "Naxibis", "Enduring", "Panic", "Anivine", "Afcyra", "Aralypsis", "Levphi", "Riseis", "Velcyra", "Nebis", "Shaspira", "Mavine", "Orilypsis", "Hiszes", "Aninise", "Agnepione", "Qulia", "Art", "Gentle", "Yorafirith", "Yugrea", "Zaidoris", "Zaimeia", "Yasolis", "Aramine", "Anifaris", "Voyage", "Hope", "Pure", "Brilaia", "Ariaxibis", "Fritish", "Kalqine", "Phelypsis", "Seirimeia", "Misxibis", "Deceit", "Afwure", "Nithmine", "Nethdani", "Leborys", "Dorlaia", "Lezes", "Nithsolis", "Brilaia", "Yupunith", "Shaseis", "Pesyola", "Hismine", "Innarei", "Rolia", "Bright", "Yaki", "Qutish", "Creloth", "Yayis", "Nethlia", "Zarali", "Aftish", "Safirith", "Mithki", "Hisgrea", "Misfirith", "Levlaia", "Natmeia", "Zacyra", "Phedoris", "Anidoris", "Rikaria", "Dorhala", "Pesdani", "Magoria", "Mislia", "Levlista", "Ininirith", "Yoraseis", "Dimlies", "Dirissa", "Anihala", "Ingrea", "Yazes", "Zaimeia", "Easolis", "Nerissa", "Shasolis", "Ariwure", "Incyra", "Oribis", "Arigoria", "Legrea", "Phesolis", "Yutari", "Phelies", "Ealyvia", "Velcyra", "Zaixibis", "Hismaia", "Mithza", "Inloth", "Grinarei", "Yahala", "Atonement", "Rolies", "Nenise", "Agnewure", "Mithloth", "Afwure", "Gridoris", "Kaldoris", "Redemption", "Peshiri", "Oriwala", "Cremine", "Dimfaris", "Leyola", "Daborys", "Valborys", "Yabis", "Rilia", "Inlith", "Valvine", "Nathiri", "Intari", "Gricyra"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.triton:
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Movnos", "Mimris", "Vemes", "Dunrus", "Rahnas", "Kelges", "Rurlus", "Ralnas", "Jedes", "Khehles", "Dunnus", "Ruvnus", "Vannas", "Kamras", "Dernes", "Cenles", "Munrus", "Zahnas", "Cavas", "Konvos", "Molgos", "Kaddas", "Rurvus", "Muhrus", "Dhernes", "Juhnus", "Vogos", "Zirvis", "Dhulnus", "Jhomos", "Zanvas", "Cimis", "Reldes", "Kunrus", "Kudus", "Komnos", "Khazas", "Valdas", "Jhamnas", "Jelnes", "Jholmos", "Dhezes", "Merles", "Jennes", "Dhoglos", "Jhehles", "Dhorvos", "Mizis", "Khorlos", "Muldus", "Deres", "Kuvus", "Dhennes", "Dhehres", "Nirnis", "Ceges", "Dhaglas", "Rihnis", "Rumrus", "Virzis", "Nunlus", "Randas", "Cildis", "Khulmus", "Ronlos", "Dihnis", "Calmas", "Nelzes", "Kolzos", "Jomros", "Dhandas", "Dolos", "Zuldus", "Jhanas", "Zoglos", "Dagas", "Khadas", "Nilnis", "Rinis", "Kalmas", "Zonos", "Runlus", "Dilnis", "Kuldus", "Juvnus", "Cennes", "Manas", "Nurlus", "Jerles", "Kuldus", "Keres", "Zehres", "Nolzos", "Jholdos", "Kulgus", "Nohros", "Jaddas", "Cemnes", "Khunvus", "Zolgos", "Zundus", "Nendes", "Nilzis", "Cehles", "Zirnis", "Vernes", "Civis", "Jherzes", "Zildis", "Jorzos", "Miglis", "Cimris", "Khehres", "Denves", "Dhimnis", "Reges", "Dilnis", "Ragas", "Venes", "Kiddis", "Korzos", "Zildis", "Khomnos", "Jhimnis", "Radas", "Mahras", "Rizis", "Cedes", "Johnos", "Corvos"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Nulen", "Vlosnyn", "Vlodryn", "Wherryn", "Asnyn", "Agrahyn", "Sotlolyn", "Dhonthemyn", "Ethinyn", "Losloryn", "Waddyn", "Sehnyn", "Usnen", "Whetyn", "Nenryn", "Whulthodyn", "Dhurnemyn", "Mathradyn", "Uhniryn", "Whenlaryn", "Udyn", "Oshyn", "Ethyn", "Fludryn", "Bhinryn", "Usturen", "Dhadrahyn", "Agrinyn", "Yidrahen", "Eluhyn", "Alren", "Biddyn", "Uddyn", "Edryn", "Oten", "Lolthelyn", "Yerruryn", "Durnenyn", "Magloryn", "Intharyn", "Vladdyn", "Vliryn", "Lodryn", "Huddyn", "Iglen", "Bodralyn", "Yalrohyn", "Wholthodyn", "Hehnadyn", "Vloleryn", "Wathyn", "Unlyn", "Olryn", "Inlyn", "Yoltyn", "Ohnonyn", "Unramyn", "Benthumyn", "Noddudyn", "Atrenyn", "Inryn", "Yotryn", "Wusnyn", "Wamlyn", "Wherryn", "Whutaden", "Metlodyn", "Orrenyn", "Arnedyn", "Shunloryn", "Yolten", "Fathlyn", "Arlyn", "Oshyn", "Ernyn", "Uslenyn", "Nerlunyn", "Solthonyn", "Vlotlumyn", "Ohleryn", "Worryn", "Monthyn", "Ehnyn", "Eddyn", "Whathyn", "Adramyn", "Moslenyn", "Vlemlodyn", "Suhnuryn", "Arnadyn", "Usnen", "Whathlyn", "Wislyn", "Atlen", "Fityn", "Lamlalyn", "Shultunen", "Berlelyn", "Sotrelyn", "Dhirneryn", "Utlyn", "Higlyn", "Whisnyn", "Hadyn", "Sholthyn", "Letlumyn", "Baltodyn", "Ithimyn", "Huthredyn", "Eshinen", "Sashyn", "Utlyn", "Budryn", "Enlyn", "Vlegryn", "Dhonlomyn", "Elthulen", "Ohlinyn", "Hehlunyn", "Saduhen"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                possibleNames = new ArrayList<>(Arrays.asList("Rulorsath", "Ohnolath", "Ahrodath", "Saghellath", "Uhnarath", "Murollath", "Maghadath", "Behrursath", "Ahranzath", "Bhumorath", "Mudellath", "Ughugath", "Dagarath", "Zogalnath", "Uhnallath", "Robazath", "Buhmorsath", "Javersath", "Rehredath", "Gehmusath", "Muhmamath", "Ehmanath", "Bhavasnath", "Pavuzath", "Aregath", "Zanunsath", "Gavulvath", "Ruvemnath", "Bhevuxath", "Dhuhregath", "Lumurath", "Bhurolmath", "Bhalarath", "Nahnumnath", "Magarath", "Vulomath", "Ravexath", "Dhahrorsath", "Mobarath", "Bhobamath", "Vubonath", "Danomath", "Vuhregath", "Onarath", "Lenorath", "Zavezath", "Ulesnath", "Gehrasnath", "Garonath", "Sahnelvath", "Suhmolvath", "Suhmasnath", "Dholonsath", "Lahnogath", "Malulnath", "Pudalath", "Umugath", "Ruvumath", "Lahnomnath", "Rumudath", "Gubumnath", "Avodath", "Lamasath", "Nobugath", "Mahmanzath", "Nugolvath", "Rudolath", "Evullath", "Sehrollath", "Dobesath", "Zuvomath", "Uhnensath", "Buralath", "Rahrorath", "Uhmonzath", "Aghezath", "Ahmedath", "Bhaghulmath", "Muhnozath", "Unaxath", "Zugunath", "Jevasath", "Bhahlazath", "Obuxath", "Bhubesnath", "Jevolmath", "Pobemath", "Unemath", "Adolmath", "Salansath", "Bhalollath", "Gobosnath", "Lughallath", "Onalnath", "Numozath", "Arolmath", "Lehludath", "Dhavorath", "Nuradath", "Ehmolath", "Buhramath", "Udozath", "Bagersath", "Mabolath", "Ragulvath", "Bhubolmath", "Avexath", "Rudorsath", "Lobomath", "Mogunsath", "Bhabonzath", "Zubamnath", "Runalath", "Uradath", "Baghunsath", "Ugulvath", "Menexath", "Juhlolvath", "Muhmozath", "Luhnedath", "Ahmamath", "Laburath", "Sogenzath", "Radelvath", "Omolvath", "Buhranzath", "Bhahmulmath", "Pahmolnath", "Vulonath", "Panarsath", "Lunosnath", "Uhralnath", "Gehlogath", "Lahnarath", "Solumnath", "Vahnemnath", "Melomath", "Ulanzath", "Juhmarath", "Uhrosath", "Dharodath", "Bhahnolnath", "Ruvogath", "Ubodath", "Sunasath", "Vahmurath", "Dheganzath", "Bhughonzath", "Mabamnath", "Rahlalvath", "Vanozath", "Gabodath", "Nahmamnath", "Bhurozath", "Ahmonath", "Muhnollath", "Dagolvath", "Noghagath", "Ruhralmath", "Bhuhmusnath", "Pabulath", "Lahrurath", "Manolvath", "Jahmursath", "Ravasath", "Bherelvath", "Umagath", "Dhanolath", "Murolath", "Gabexath", "Ravaxath", "Zugezath", "Zagursath", "Mavalvath", "Dhuvuzath", "Unallath", "Dohramath", "Pahlosath", "Bhuledath", "Jarexath", "Pegallath", "Bagomnath", "Ovazath", "Ahmazath", "Uhmonsath", "Balullath", "Gabunsath", "Radagath", "Rudarsath", "Varoxath", "Zuhlorsath", "Anerath", "Bhomaxath", "Dhedorath", "Dugullath", "Bemogath", "Novalmath", "Galamnath", "Bhahmallath", "Bahnanzath", "Zamomnath", "Anumath", "Davazath", "Nahrelnath", "Panamnath", "Badesnath", "Badelnath", "Sagholath", "Ravazath", "Marunsath", "Dhahmursath", "Puhralath", "Ugarath", "Bughaxath", "Bhahlosnath", "Ugorsath", "Behnadath", "Ragellath", "Dahmullath", "Sehlunsath", "Mabazath", "Guvunath", "Unedath", "Zahnogath", "Baledath", "Rahnenath", "Jebomath", "Ohmuzath", "Ruhmunath", "Bhomorath", "Pugarsath", "Maghasath", "Ughodath", "Dughelath", "Bhoghulvath", "Ahnulath", "Rugaxath", "Zurulmath", "Ohlosath", "Magorsath", "Omallath", "Puhnosnath", "Bhahnolath", "Lahmonzath", "Dharulnath", "Luhnuxath", "Suhnarath", "Bhurogath", "Dunamath", "Jahrasath"));
                lastName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.tortle:
                //unisex first names only
                possibleNames = new ArrayList<>(Arrays.asList("Urtlet", "Dannuc", "Keki", "Jinik", "Krimott", "Kruarug", "Gardlac", "Xilbe", "Jody", "Ur", "Duekul", "Sizle", "Kruazlyd", "Qa", "Nordlid", "Uag", "Guppag", "Be", "Talyn", "Did", "Ya", "Jomill", "Krakec", "Xalkyll", "Wizel", "Pliam", "Qiardlym", "Iqwal", "Qut", "Biaqwad", "Tue", "Qatt", "Yazlo", "Xinqell", "Duartlac", "Xunqe", "Wull", "Uqwic", "Gul", "Ipa", "Ga", "Denell", "Yueppo", "Bo", "Ibol", "Nonne", "Duoldo", "Plipyd", "Golkyl", "Kirdlig", "Kronnig", "Guc", "Temu", "Gull", "Lor", "Duott", "Suertoc", "Udig", "Sek", "Um", "Bappid", "Nekur", "Qom", "Yortlad", "Jok", "Tiardlun", "Lupon", "Xubul", "Kelin", "Tuoqwe", "Tonqok", "Gardlall", "Womi", "Nuerdlo", "Suot", "Buzlin", "Yodem", "Gak", "Sirtar", "Ganqe", "Quzlad", "Serdla", "Onqwe", "Jibik", "Wokyc", "Wiatt", "Pluo", "Datt", "Xonne", "Diqwull", "Wuonlut", "Donqwu", "Emo", "Ildum", "Ardlag", "Nuo", "Qok", "Xartyc", "Gine", "Ju", "On", "Burtla", "Plaby", "Bemor", "Uanlod", "Ac", "Idec", "Ko", "Plazlen", "Simoc", "Krilbutt", "Jopy", "Xerem", "Plildutt", "Pluko", "Wull", "Gunqwutt", "Lolbak", "Krubut", "Uk", "Kral", "Uk", "Ig", "Nueg", "Semi", "Tora", "Nani", "Qek", "Jabitt", "Solkuk", "Wal", "Bannid", "Tizu", "Wozlatt", "Uki", "Ja", "Idyn", "Kruer", "Doldig", "Aput", "Biarull", "Kanu", "Gury", "Qiall", "Krer", "Kroqwi", "Krune", "Wuqwi", "Gennon", "Di"));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.vedalken:
                //first name only
                if (gender.equals(Genders.male)) {
                    possibleNames = new ArrayList<>(Arrays.asList("Nathvec", "Khitil", "Dedvid", "Idrot", "Lirellitt", "Uthvav", "Uglish", "Yithad", "Butoner", "Oplett", "Nitlav", "Etrec", "Zovez", "Dotlolush", "Udul", "Zodvash", "Kullud", "Pudrec", "Ogled", "Drivoz", "Ublazet", "Zoggoc", "Drubleziv", "Druplazud", "Odat", "Muvloret", "Othvad", "Bhovatt", "Trulvun", "Forvin", "Eglin", "Enall", "Zurvon", "Diber", "Dhelvac", "Bugguzod", "Yablol", "Eglill", "Pulirit", "Milur", "Dhablel", "Itruc", "Nhulvinuc", "Trardurev", "Illun", "Kuthvollor", "Khaplesh", "Kardezon", "Oggatt", "Khiplellel", "Buthizash", "Ithott", "Rollivoc", "Rulvut", "Travrill", "Bhelvovad", "Oblirov", "Umilor", "Zulderud", "Ziplitt", "Avon", "Udol", "Ruvluval", "Otlar", "Bhular", "Abloroz", "Moglull", "Dravloz", "Zutill", "Arvinaz", "Bhonevod", "Diplott", "Patalish", "Kethol", "Modrov", "Ivlir", "Damoc", "Athuv", "Malvul", "Detlitt", "Ithvev", "Ibov", "Norilet", "Trovruzett", "Kilviresh", "Yavlurev", "Bhardot", "Uron", "Uvush", "Ilvorod", "Edvavat", "Dimush", "Podran", "Adullir", "Nhiblan", "Trarval", "Dhivun", "Othvar", "Betrav", "Ninezir", "Nhulviruc", "Atush", "Labat", "Betrazett", "Rildish", "Dredatt", "Kutlull", "Khardezoll", "Yadrin", "Pothvuvott"));
                } else {
                    possibleNames = new ArrayList<>(Arrays.asList("Idre", "Zlodvaiss", "Klillane", "Drelne", "Orvili", "Fadda", "Drodevash", "Moddellenn", "Leda", "Hiavizo", "Pievinna", "Grigaa", "Pese", "Slezish", "Grievezoh", "Reldi", "Grerro", "Filgaa", "Fidviall", "Zarrash", "Borro", "Blogreh", "Igra", "Daidrivish", "Blelganni", "Zereh", "Estrel", "Blerve", "Daso", "Radrol", "Iatrazall", "Klotriyo", "Reidreh", "Hetrayaas", "Slaistrelon", "Kildo", "Drolgolos", "Yeddol", "Lirvas", "Dilno", "Pasayill", "Idralas", "Koyinn", "Trirve", "Tralnannass", "Eldizess", "Slalva", "Beirvosh", "Klesih", "Melvah", "Hirilell", "Yelezai", "Yili", "Kligrall", "Yelvi", "Bleilgeh", "Falevass", "Madden", "Klistroh", "Slerve", "Nasove", "Brilvon", "Zlildannian", "Liress", "Narrinn", "Zlitrell", "Roggo", "Ive", "Elgil", "Nastrele", "Belveh", "Pilli", "Odvol", "Feldash", "Adra", "Riddale", "Zlielgell", "Slirvole", "Blalvennash", "Aldiall", "Edvanna", "Zloyan", "Bloggayo", "Drelvizia", "Zliellalin", "Klovosann", "Hidvallen", "Yestrail", "Riedo", "Sleiggozos", "Rillih", "Holasan", "Klollonn", "Sorvennias", "Zladdo", "Trirva", "Illonnoss", "Sleidvis", "Klevis", "Hedro", "Pose", "Slairroh", "Kailless", "Kisso", "Fiyanni", "Agia", "Ograa", "Olenn", "Ziye", "Dodresh"));
                }
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
            case Races.yuanTi:
                //unisex first names only
                possibleNames = new ArrayList<>(Arrays.asList("Ssesie", "Szossu", "Zhutzi", "Hoshiah", "Soanih", "Oztla", "Elkuissi", "Szitshohlei", "Naztlasal", "Yoashethi", "Shuskeis", "Iltsa", "Hetziell", "Thohsiuh", "Zussia", "Uhshiuh", "Utshezi", "Szeszuhsu", "Uhtlessu", "Zoskashliuss", "Ssitish", "Sshotass", "Saltsi", "Shezshih", "Tessu", "Uhlu", "Uhluithass", "Szitoheis", "Shoktlehsah", "Olsushlal", "Iklui", "Zsoku", "Uli", "Nolsull", "Sshutshash", "Shitza", "Thizshishal", "Shasziyu", "Tholtlathui", "Issiyah", "Ssisha", "Eltsi", "Usah", "Sshustluh", "Ossi", "Sholseih", "Uistluiyiuh", "Zsuiskuhee", "Oatstlaziu", "Soaskaseess", "Tuizshiel", "Atsu", "Yussiull", "Tihtli", "Shultliush", "Selku", "Huihshotha", "Setszoazia", "Soaszusui", "Ohshozia", "Otsza", "Hiska", "Estluss", "Muzshu", "Thustas", "Zazshiuh", "Meshiyuss", "Matszoyuih", "Okhossu", "Zolsholli", "Altlu", "Atstla", "Ssheski", "Szikha", "Tilsee", "Zhossi", "Yahlisi", "Usassi", "Haskishu", "Yotzuthah", "Silsha", "Meluh", "Azhu", "Totsi", "Ihshus", "Ihei", "Azshozhis", "Thuzhaya", "Nezsusi", "Zsoshohli", "Ussu", "Zsalsiess", "Yiksi", "Maki", "Sshikiu", "Ssuhlash", "Azhussu", "Ahlithu", "Tahsitee", "Astluhla", "Misku", "Saltsi", "Ahlu", "Ssina", "Itshash", "Alsui", "Sshohshishlah", "Ssheksoassia", "Yohshozhi", "Uiktluishu", "Tinia", "Sshahtlull", "Ostuil", "Sziltleish", "Tazha", "Shalsi", "Taztlussus", "Szamillieh", "Zokezhu", "Nukulu", "Ssakli", "Muituih", "Hezshuh", "Zehsal", "Shuskall", "Sziskuh", "Thoashusheeh", "Zsumathu", "Sshamizhie", "Ilati", "Solseil", "Shotshul", "Multsa", "Yuiksi", "Zahtlu", "Ital", "Sukelli", "Shohoyih", "Noanehluiss", "Alashall"));
                firstName = randGen.getRandomFromStringList(possibleNames);
                break;
        }
        if (lastName.isEmpty() || lastName.equals("")) {
            name = firstName;
        } else {
            name = firstName + " " + lastName;
        }
    }

    private Race getRaceDataFromRace(HardData hardData) {
        for (int i = 0; i < (hardData.raceData.size() - 1); i++) {
            if (hardData.raceData.get(i).raceName.equals(race)) {
                return hardData.raceData.get(i);
            }
        }
        return null;
    }

    private void getAlignmentFromRace(HardData hardData) {
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

    private int getModifierForStat(int stat) {
        return (stat - 10) / 2;
    }

    private void getStatsBasedOnLevel() {
        //calculate bonuses and penalties for economic classes
        hpMax = 5;//all creatures get at least 5 hp to start with.
        int dieMax = 5;
        /*
        Technically the hit die would go as follows:
        d6  :  Sorcerer, Wizard
        d8  :  Bard, Cleric, Druid, Monk, Rogue, Warlock
        d10 :  Fighter, Paladin, Ranger
        d12 :  Barbarian
        but as "class" isn't a thing here I'm going off the economy class to modify it. Richer people have more access to more training, education, and nutrition, and would therefore be expected to usually have better stats than a beggar
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
                classCon = randGen.randomIntInRange(1, 2); //the wealthy are well nourished and have access to good health care.
                classWis = randGen.randomIntInRange(-1, 3); //wealth certainly doesn't lead to wisdom automatically but education helps
                classInt = randGen.randomIntInRange(1, 3); //money = good education = better int
                classChr = randGen.randomIntInRange(-1, 2); //wealth tends to breed confidence, boldness, and good social skills among the elite in particular, but can also lend toward arrogance and dismissive-ness
                break;
            case EconomicClasses.elite: //these are the top of the wealth category, the big business moguls, the mayors, the famed adventurers, guard captains, heroes, etc. Guaranteed no penalties from class
                dieMax = randGen.randomIntInRange(10, 12); //
                classStr = randGen.randomIntInRange(0, 6); //
                classDex = randGen.randomIntInRange(0, 6); //
                classCon = randGen.randomIntInRange(0, 6); //
                classWis = randGen.randomIntInRange(0, 6); //
                classInt = randGen.randomIntInRange(0, 6); //
                classChr = randGen.randomIntInRange(0, 6); //
                break;
        }
        if (agePercent >= 80) {// old people get more intelligence and wisdom, but weaker bodies
            classStr -= randGen.randomIntInRange(1, 3);
            classDex -= randGen.randomIntInRange(1, 3);
            classCon -= randGen.randomIntInRange(1, 3);
            classWis += randGen.randomIntInRange(1, 4);
            classInt += randGen.randomIntInRange(1, 4);
            raceData.walkSpeed -= randGen.randomIntInRange(1, 3) * 5;
        }
        strength = randGen.randomIntInRange(((level / 2) + 7), ((level / 2) + 15)) + raceData.strMod + classStr;
        strMod = getModifierForStat(strength);

        dexterity = randGen.randomIntInRange(((level / 2) + 7), ((level / 2) + 15)) + raceData.dexMod + classDex;
        dexMod = getModifierForStat(dexterity);

        constitution = randGen.randomIntInRange(((level / 2) + 7), ((level / 2) + 15)) + raceData.conMod + classCon;
        conMod = getModifierForStat(constitution);
        for (int i = 0; i < level; i++) {
            hpMax = hpMax + randGen.randomIntInRange(1,(dieMax + conMod));
        }
        hpCurrent = hpMax;

        wisdom = randGen.randomIntInRange(((level / 2) + 7), ((level / 2) + 15)) + raceData.wisMod + classWis;
        wisMod = getModifierForStat(wisdom);

        intelligence = randGen.randomIntInRange(((level / 2) + 7), ((level / 2) + 15)) + raceData.intMod + classInt;
        intMod = getModifierForStat(intelligence);

        charisma = randGen.randomIntInRange(((level / 2) + 7), ((level / 2) + 15)) + raceData.chrMod + classChr;
        chrMod = getModifierForStat(charisma);

        passivePerception = 10 + wisMod;
    }

    private void getLanguagesFromRace() {
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

    private void getRacialTraitsFromRace() {
        bravery = raceData.braveryMod + randGen.randomIntInRange(5,25);
        getLanguagesFromRace();
        age = randGen.randomIntInRange(raceData.minAge, raceData.maxAge); //the min age prevents children from being present in battles, which I don't want in the campaign
        agePercent = age * 100 / raceData.maxAge; //this data point just gives a feel for relative age compared to a human. Like a 100 yr old elf would only be about 45-55 in human years, so it helps with role playing
        if (randGen.randomIntInRange(1,2) == 1) {
            gender = Genders.male;
        } else {
            gender = Genders.female;
        }
    }

    private void getInventoryFromClass(Location currentLocation) {
        //weapons, armor, gold, items carried
        getArmor();
        getWeapons();
        getLoot();
    }

    private void getArmor() {
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

    private void getWeapons() {
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

    private void getSingleWeapon(int hand, boolean canBeTwoHanded) { //0 is 1 first hand, 1 is second hand
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
        int luckyGoldRoll = randGen.randomIntInRange(1, 1000); //there's a 10% chance for any commoner to get a bonus to the money they carry, with the lower the roll the better the bonus.
        if (luckyGoldRoll == 1) { //0.1% chance for a LOT of gold
            platinum = (platinum + randGen.randomIntInRange(11, 25)) * (level);
            gold = (gold + randGen.randomIntInRange(5,20)) * (level * 3);
            silver = (silver + randGen.randomIntInRange(5,20)) * (level * 15);
            copper = (copper + randGen.randomIntInRange(5,20)) * (level * 30);
        } else if (luckyGoldRoll <= 5) { //0.5% chance
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

    private void calculateDcToPickpocket() {
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

    private void determineBodyguards() {
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

    private void determineCallGlyphs() {
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
                    } else if (randGen.randomIntInRange(1, 100) <= 45) {
                        wornArmor.get(0).hasCallGlyph = true;
                        callGlyphType = CallGlyphTypes.armorEtching;
                    }
                }
                break;
        }
    }

    public void determineFamily() {
        if (economicClass.equals(EconomicClasses.beggar) && randGen.randomIntInRange(1,100) <= 10) { //10% chance to have a family. Most beggars will be those without families
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
            + (conMod * 5) //conMod is already partially accounted for in the hpMax bonus (more conMod = more hp = more xp)
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
                xpValue = xpValue - 10;
                break;
            case EconomicClasses.poor:
                xpValue = xpValue - 5;
                break;
            case EconomicClasses.middleClass:
                xpValue = xpValue + 5;
                break;
            case EconomicClasses.wealthy:
                xpValue = xpValue + 25;
                break;
            case EconomicClasses.elite:
                xpValue = xpValue + 200;
                break;
        }
    }
}


