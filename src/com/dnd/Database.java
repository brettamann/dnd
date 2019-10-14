package com.dnd;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.*;

public class Database {
    private String url = "jdbc:sqlite:/Users/bamann/Desktop/Scripts/Test_Files/bastion.db";
    private Input input = new Input();
    private String locationColumns = "name TEXT,description TEXT,pointsOfInterest TEXT,connectsTo TEXT,reputationInArea INT,alertLevel INT,mostCommonRaces TEXT,commonRaces TEXT,uncommonRaces text,leastCommonRaces TEXT,travelerChance INT,beggarChance INT,poorChance INT,middleClassChance INT,wealthyChance INT,toleranceModifier INT,aggressionModifier INT,chanceToCallGuardsModifier INT,pickpocketDcModifier INT,platinumLow INT,platinumHigh INT,goldLow INT,goldHigh INT,silverLow INT,silverHigh INT,copperLow INT,copperHigh INT,lockDCLow INT,lockDCHigh INT,itemsCarriedLow INT,itemsCarriedHigh INT,chanceOfGuardsInArea INT,guardGroupLowSize INT,guardGroupHighSize INT,fastestCallTime INT,slowestCallTime INT,chanceOfCommonersInArea INT,commonerGroupLowSize INT,commonerHighLowSize INT";
    private String personColumns = "name Text,economicClass TEXT,race TEXT,racialTraits TEXT,gender TEXT,alignment TEXT,quirks TEXT,age INT,agepercentage INT,xpValue INT,level INT,hp INT,ac INT,weaponText TEXT,weaponToHitScore INT,weaponToHitLowScore INT,weaponToHitHighScore INT,armor TEXT,hasShield TEXT,abilities TEXT,passivePerception INT,tolerance INT,aggressionModifier INT,violentOnRollLowerThan INT,callsGuardsOnLowerThan INT,chanceToRecognizePlayer INT,strength INT,strMod INT,dexterity INT,dexMod INT,constitution INT,conMod INT,intelligence INT,intMod INT,wisdom INT,wisMod INT,charisma INT,chrMod INT,platinum INT,gold INT,silver INT,copper INT,items TEXT,dcToPickpocket INT,hasCallGlyph TEXT, callGlyphType TEXT,hasBodyguard TEXT,isBodyguard TEXT,bodyguardForName TEXT,bodyguardName TEXT,hasFamily TEXT,familyMemberCount INT,familyNames TEXT,areaOfResidence TEXT";
    private String partyInfoColumns = "memberCount INT,currentXP INT,reputation INT,averageLevel INT";
    private String playerColumns = "";
    private String crimesColumns = "";
    private String crimeStatisticsColumns = "";
    private String killsColumns = "";
    private Connection conn = null;

    public void connect() {
        DriverManager.registerDriver(new org.sqlite.JDBC());
        try {
            //String url = "jdbc:sqlite:C:/sqlite/bastion.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        }

    public void createNewDatabase(String fileName) {
        connect();
        /*
        createNewTable("location", locationColumns);
        createNewTable("person", personColumns);
        createNewTable("partyInfo", partyInfoColumns);
        createNewTable("player", playerColumns);
        createNewTable("crimes", crimesColumns);
        createNewTable("crime_statistics", crimeStatisticsColumns);
        createNewTable("kills", killsColumns);

        insertIntoTable("partyInfo", partyInfoColumns, "3,0,0,0");

        insertLocationData("'The Citadel'", "'The capital building of Grand Bastion. Beautiful, well lit, heavily guarded.'", "'Council chambers, Meeting hall, Offices, Kitchens, High Court, Living spaces, Dungeon'", "'Overlook Ridge'",0,0,"'human elf half_elf'","'genasi firbolg gith gnome dwarf halfling tabaxi elephantine triton'","''","''",0,0,0,0,100,10,10,10,15,1,20,10,200,0,100,0,100,15,40,1,15,100,3,8,1,3,90,1,12);
        insertLocationData("'Overlook Ridge'", "'The place of the wealthy and elite of the city. Mansions, clean streets, and guard patrols abound.'", "'Cathedral, Hospital, Jewelcourt Market, bath-house, performance hall, Hilltop Mansions'", "'War & Judgement District, Angelfall, Dragons Landing'", 0, 0, "'human elf half_elf'", "'genasi firbolg gith gnome dwarf halfling'", "''", "''", 4,6,0,40,50,7,-2,75,8,0,10,15,200,0,100,0,100,15,40,3,10,60,1,5,2,6,90,1,8);
        insertLocationData("'Carnival'", "'A colorful sprawl of tents and booths with few permanent structures. People of all types visit. Popular with tourists especially given its proximity to the Roost Inn'","'See encounters for more info'","'Woodland Haven, The Roost Inn'", 0,0,"''", "''", "''", "''", 85,15,0,0,0,0,0,-4,-2,0,0,0,30,0,100,0,100,5,15,0,5,60,1,2,4,12,95,1,25);
        insertLocationData("'Woodland Haven'", "'Nearly free of structures, many woodland creatures roam the area contained by a tall wall. Druids tend to the grounds and animals. The main road is kept free of vegetation but the rest grows mostly wild.'", "'Carnival, The Roost Inn, Dragons Landing'", "'Carnival, Greenbelt, The Roost Inn'", 0,0,"'elf, animal_hybrid bugbear centaur firbolg lizardfolk half_elf tortle'", "''", "''", "''",50,20,15,3,2,5,5,-7,4,0,0,0,10,0,100,0,100,1,5,0,6,2,1,2,10,25,10,1,10);
        insertLocationData("'The Roost Inn'", "'A huge circular pit was dug into the earth, leveled out, and then the walls of the pit were fashioned into multiple floors of rooms leaving a large open common area in the center. The ground floor holds most services. A long ramp goes into the inn area. Tall pipes extending through the earth into the rooms allow smoke from rooms to escape'", "'Entertainers platform, wine cellar, managers offices, kitchens, stables, bar'", "'Carnival, Woodland Haven'", 0,0,"''","''","''","''",90,7,1,1,1,0,0,0,0,0,0,0,50,0,100,0,100,8,20,0,10,100,3,10,2,8,95,2,30);
        insertLocationData("'Dragons Landing'", "'Dragons landing is a large, somewhat man-made rock formation towering over the woodland haven. Similar to the Roost Inn the center is hollowed out and turned into a tower full of apartments. The top of the tower opens to the sky and allows winged creatures easy access. Aven creatures abound, although others also take advantage of the cheaper living spaces there.'", "'Dragon Dens, Winged Stables, Spire homes'", "'Woodland Haven, The Roost Inn'", 0,0,"'aarakocra aasimar kenku animal_hybrid'","''","''","''",10,10,30,45,5,4,4,-2,0,0,0,0,10,0,100,0,100,10,20,0,5,5,1,2,5,25,55,1,8);
        insertLocationData("'Thunderfoot'", "'Caters to the larger creatures, most of which work in the construction in the area.'","'Construction Center, Machine Yards, Giants Retreat Homes'","'Woodland Haven, War & Judgement District, Berlstrom, Dragons Landing'", 0,0,"'elephantine orc minotaur goliath half_orc firbolg dragonborn'","''","''","''",10,5,46,35,4,2,10,5,0,0,0,5,25,0,100,0,100,6,25,1,7,10,1,4,4,10,50,1,6);
        insertLocationData("'Berlstrom'","'The poor flock here for its cheap housing and sometimes leave for its lax security. Most windows are barred, most sensible people off the streets at night, and home to several gangs.'","'Thieves hideout, Ramshackle Hospital, orphanage, peddler street, Shack City'","'East Gate & Market, War & Judgement District, Thunderfoot, Woodland Haven, Lakeshore'", 0,0,"'human tabaxi kenku tiefling gith half_orc vedalken'","''","''","''",15,25,55,5,0,5,8,-7,4,0,0,0,5,0,100,0,100,5,15,0,4,15,2,4,10,25,80,1,15);
        insertLocationData("'East Gate'", "'A large market just inside the city next to the enormous gates. Responsible for a lot of the food distribution of the city. Many merchants sell in bulk.'","'Carriage for hire, basic shops for food, gear, armor, weapons, and other supplies.'","'Berlstrom'",0,0,"''","''","''","''",85,15,0,0,0,-2,2,4,-2,0,2,0,100,0,100,0,100,2,20,0,10,90,2,3,3,6,100,6,30);
        insertLocationData("'West Gate'", "'A large market just inside the city next to the enormous gates. Responsible for a lot of the food distribution of the city. Many merchants sell in bulk.'", "'Carriage for hire, basic shops for food, gear, armor, weapons, and other supplies.'", "'Berlstrom'", 0, 0, "''", "''", "''", "''", 85, 15, 0, 0, 0, -2, 2, 4, -2, 0, 2, 0, 100, 0, 100, 0, 100, 2, 20, 0, 10, 90, 2, 3, 3, 6, 100, 6, 30);
        insertLocationData("'Lakeshore'","'Extending around most of the lake, the area certainly has more money than its surroundings. Nice homes form orderly rows and tritons especially love the caves dug into the lake for them'","'Swimming Pier, flooded triton caverns, community garden, lakeshore rows housing'","'Berlstrom, Woodland Haven, Upper Caverns, Rethsburg Hills'",0,0,"'triton elephantine human tortle genasi dragonborn'","''","''","''",5,5,13,65,12,-5,-2,4,0,0,3,0,80,0,100,0,100,10,25,0,8,40,1,3,3,6,60,1,6);
        insertLocationData("'Angelfall Square Memorial'","'A large square ringed with statues, monuments, and carefully constructed buildings.'","'Pelor & Dawnbringer Statue, Memorial of the Fallen, The Arcanum Library, Grand Bastion Museum, Bastion Central Bank'","'Overlook Ridge, Greenbelt, Woodland Haven, Dragons Landing'",0,0,"''","''","''","''",100,0,0,0,0,-8,4,8,-2,0,5,0,100,0,100,0,100,18,30,0,10,100,5,12,2,6,100,2,30);
        insertLocationData("'Rethsberg Hills'","'Tons of earth-shaped hills wind around forming dwellings for mostly shorter folk. Most activities and attractions are underground, and although most homes are for small people the main thoroughfares accomodate even large citizens.'","'The Burrows, Tammer tavern, Cavernforge Smithy, the Line apartments'","'Upper Caverns, Lakeshore Community, Woodland Haven, Greenbelt, West Gate & Market'",0,0,"'dwarf halfling gnome'","'kobold hobgoblin goblin minotaur'","''","'human centaur elf half_elf'",10,5,40,40,5,-5,3,-4,5,0,5,0,100,0,100,0,100,8,25,0,6,25,1,3,4,10,33,1,10);
        insertLocationData("'Upper Caverns'", "'The upper cavers are mostly industrial and those who work there. Darkness-loving creatures enjoy the dimly lit areas and little supervision afforded by the cave systems.'","'Mining Guild Offices, Foundries, Worker Dorms, DarkDweller Hovel'", "'Lower Caverns, Rethsburg'",0,0,"'goblin bugbear orc tiefling hobgoblin minotaur gith kenku kobold dwarf'","''","''","'human elf half_elf centaur elephantine triton tortle tabaxi aarakocra'",0,40,35,20,5,2,6,20,0,0,0,0,20,0,100,0,100,2,25,0,4,5,2,4,5,12,95,1,20);
        insertLocationData("'Lower Caverns'","'The lower caverns are dangerous and full of mostly abandoned mining areas.'","'Black Market, Hobo Camp'","'Upper Caverns'",0,0,"'goblin kobold hobgoblin minotaur tiefling orc half_orc dwarf'","''","''","'human elf half_elf centaur elephantine triton tortle tabaxi aarakocra'",20,60,15,4,1,10,10,-9,5,0,1,0,25,0,100,0,100,0,20,0,10,0,2,4,18,100,10,1,14);
        insertLocationData("'War & Judgement District'", "'The main training center for both the city watch and the portal chasers. Full of guards. Holds the lower court system and prisons.'","'Courthouse, Barracks, Captains Mansion, Training yards, Academy, Translocator Center, Prison, Gallows'","'Berlstrom, Thunderfoot, Overlook Ridge'",0,0,"''","''","''","''",80,10,0,5,5,-10,5,95,8,0,5,0,100,0,100,0,100,15,30,0,6,95,1,10,1,4,85,1,10);
        //insertLocationData("'Jewelcourt Market'");

         */

    }

    /*
    public void insertIntoTable(String tableName, String tableColumns, String tableValues) {
        //Connection c = null;
        Statement stmt = null;
        connect();
        try {
            Class.forName("org.sqlite.JDBC");
            //c = DriverManager.getConnection(url);
            //c.setAutoCommit(false);
            //System.out.println("Opened database successfully");

            stmt = conn.createStatement();
            String sql = "INSERT INTO " + tableName + " (" + tableColumns + ") " +
                    "VALUES (" + tableValues + ");";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.commit();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void createNewTable(String newTableName, String dataset) {
        // SQLite connection string
        //String url = "jdbc:sqlite:C://sqlite/db/bastion.db";

        // SQL statement for creating a new table
        connect();
        String sql = "CREATE TABLE IF NOT EXISTS " + newTableName + "(\n"
                + "    id integer PRIMARY KEY,\n"
                + "    " + dataset + ");";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertLocationData(String name, String description, String pointsOfInterest, String connectsTo , int reputationInArea, int alertLevel, String mostCommonRaces, String commonRaces, String uncommonRaces, String leastCommonRaces, int travelerChance, int beggarChance, int poorChance, int middleClassChance, int wealthyChance, int toleranceModifier, int aggressionModifier, int chanceToCallGuardsModifier, int pickpocketDcModifier, int platinumLow, int platinumHigh, int goldLow, int goldHigh, int silverLow, int silverHigh, int copperLow, int copperHigh, int lockDCLow, int lockDCHigh, int itemsCarriedLow, int itemsCarriedHigh, int chanceOfGuardsInArea, int guardGroupLowSize, int guardGroupHighSize, int fastestCallTime, int slowestCallTime, int chanceOfCommonersInArea, int commonerGroupLowSize, int commonerGroupHighSize) {
        //Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            //c = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = conn.createStatement();
            String sql = "INSERT INTO " + name + " (" + locationColumns + ") " +
                    "VALUES (" + name + "," + description + "," + pointsOfInterest + "," + connectsTo + "," + reputationInArea + "," + alertLevel + "," + mostCommonRaces + "," + commonRaces + "," + uncommonRaces + "," + leastCommonRaces + "," + travelerChance + "," + beggarChance + "," + poorChance + "," + middleClassChance + "," + wealthyChance + "," + toleranceModifier + "," + aggressionModifier + "," + chanceToCallGuardsModifier + "," + pickpocketDcModifier + "," + platinumLow + "," + platinumHigh + "," + goldLow + "," + goldHigh + "," + silverLow + "," + silverHigh + "," + copperLow + "," + copperHigh + "," + lockDCLow + "," + lockDCHigh + "," + itemsCarriedLow + "," + itemsCarriedHigh + "," + chanceOfGuardsInArea + "," + guardGroupLowSize + "," + guardGroupHighSize + "," + fastestCallTime + "," + slowestCallTime + "," + chanceOfCommonersInArea + "," + commonerGroupLowSize + "," + commonerGroupHighSize + ");";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.commit();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

     */
}
