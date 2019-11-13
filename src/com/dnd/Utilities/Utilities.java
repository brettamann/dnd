package com.dnd.Utilities;

import com.dnd.DataObjects.HardData;
import com.dnd.DataObjects.Items.Weapon;
import com.dnd.DataObjects.Location;
import com.dnd.DataObjects.PartyInfo;
import com.dnd.DataObjects.Person;

import java.util.ArrayList;
import java.util.List;

public class Utilities {
    public static String translateAlertLevelToString(int alertlevel) {
        switch (alertlevel) {
            case 0:
                return "Relaxed, normal life";
            case 1:
                return "Town criers mention recent crimes from players";
            case 2:
                return "'Wanted alive' posters with vague descriptions of players have appeared";
            case 3:
                return "Detailed wanted posters are frequent, with 100gp reward fo info leading to capture. People are on edg.";
            case 4:
                return "Guard patrols and wanted posters are more frequent, people are are much more suspicious";
            case 5:
                return "Wanted posters are 'Dead or alive' with 500gp reward. Bounty hunters are on the prowl";
            case 6:
                return "Streets are emptier than normal save for frequent guard partols, homes are becoming more fortified and watchful";
            case 7:
                return "Wanted posters offer 2000gp with plenty of detail. People don't want to interact with strangers. Streets are emptier. Homes have traps";
            case 8:
                return "Many shops are shutting down. Mandatory curfew in place. People are moving out";
            case 9:
                return "Full paranoia. Those who can have left the area. Homes do night watch shifts. Security checkpoints are up. Most homes empty";
            default: //10+
                return "Military shutdown. Nobody in or out without a search. Strict curfew. Nobody wants to be in streets";
        }
    }

    public static void getWhatsAroundMe(HardData hardData) {
        //There won't always be people around, so check if there are any
        if (RandomGenerator.randomIntInRange(0, 100) <= hardData.currentSelectedLocation.chanceOfCommonersInArea) {
            createCommonerList(getCommonerCountInArea(hardData), hardData);
            Screen.println("There are " + hardData.commonersInArea.size() + " commoners in the area.");
        } else {
            Screen.println("There are no commoners in the area.");
        }
        if (RandomGenerator.randomIntInRange(0, 100) <= hardData.currentSelectedLocation.chanceOfGuardsInArea) {
            hardData.guardCountInArea = getGuardCountInArea(hardData);
        }
    }

    public static int getCommonerCountInArea(HardData hardData) {
        return RandomGenerator.randomIntInRange(hardData.currentSelectedLocation.commonerGroupLowSize, hardData.currentSelectedLocation.commonerGroupHighSize);
    }

    public static int getGuardCountInArea(HardData hardData) {
        return RandomGenerator.randomIntInRange(hardData.currentSelectedLocation.guardGroupLowSize, hardData.currentSelectedLocation.guardGroupHighSize);
    }

    public static int getCallTimeBasic(HardData hardData) {
        return RandomGenerator.randomIntInRange(hardData.currentSelectedLocation.fastestCallTime, hardData.currentSelectedLocation.slowestCallTime);
    }

    public static int getCallTimeRunner(HardData hardData) {
        return RandomGenerator.randomIntInRange(4, 12) + RandomGenerator.randomIntInRange(hardData.currentSelectedLocation.fastestCallTime, hardData.currentSelectedLocation.slowestCallTime) + RandomGenerator.randomIntInRange(hardData.currentSelectedLocation.fastestCallTime, hardData.currentSelectedLocation.slowestCallTime);
    }

    public static void getGuardsInArea() {

    }

    public static void createGuardList() {

    }

    public static void createGuardEncounter(HardData hardData) {
        //The higher the party's reputation added to the alert level, the more, and more powerful, the called reinforcements are
        List<String> guardList = new ArrayList<>();
        int repSelector = Math.max(1, hardData.partyInfo.getReputation() / 100) + hardData.currentSelectedLocation.alertLevel;

        int totalReinforcementsCap = Math.min(15, RandomGenerator.randomIntInRange(repSelector, repSelector + (repSelector / 2)));
        //Don't make a guard encounter over 15 people

        int standardGuardCount = Math.min(10, RandomGenerator.randomIntInRange(1, repSelector));

        int recallClericCount = 0;
        if (RandomGenerator.randomIntInRange(1, 5) == 1) {
            //20% chance for a recall cleric in any encounter
            //If these are in the group, they don't get removed
            recallClericCount++;
        }

        int arresterCount = 0;
        if (repSelector >= 1) {
            arresterCount = Math.min(6, Math.max(0, RandomGenerator.randomIntInRange(1, 6) - 5 + (repSelector / 5)));
        }

        int watchmanCount = 0;
        if (repSelector >= 3) {
            watchmanCount = Math.min(8, Math.max(0, RandomGenerator.randomIntInRange(1, 4) - 2 + (repSelector / 3)));
        }

        int lawcasterCount = 0;
        if (repSelector >= 4) {
            lawcasterCount = Math.min(6, Math.max(0, RandomGenerator.randomIntInRange(1, 4) - 5 + (repSelector / 2)));
        }

        int healerCount = 0;
        if (repSelector >= 6) {
            healerCount = Math.min(2, Math.max(0, RandomGenerator.randomIntInRange(1, 6) - 5 + (repSelector / 5)));
            //Once they are placed in, they don't get removed
        }

        int entanglerCount = 0;
        if (repSelector >= 8) {
            entanglerCount = Math.min(6, Math.max(0, (RandomGenerator.randomIntInRange(1, 6) / 2) - 3 + (repSelector / 5)));
        }

        int enforcerCount = 0;
        if (repSelector >= 9) {
            enforcerCount = Math.min(15, Math.max(0, (RandomGenerator.randomIntInRange(1, 6) / 4) - 5 + (repSelector / 5)));
        }

        int purgerCount = 0;
        if (repSelector >= 10) {
            purgerCount = Math.min(15, Math.max(0, RandomGenerator.randomIntInRange(1, 6) - 7 + (repSelector / 3)));
        }

        int skyhelmCount = 0;
        if (repSelector >= 12) {
            skyhelmCount = Math.min(15, Math.max(0, RandomGenerator.randomIntInRange(1, 4) - 5 + (repSelector / 5)));
        }

        int sniperCount = 0;
        if (repSelector >= 13) {
            sniperCount = Math.min(15, Math.max(0, RandomGenerator.randomIntInRange(1, 6) - 6 + (repSelector / 10)));
        }

        int earthHelmCount = 0;
        if (repSelector >= 14) {
            earthHelmCount = Math.min(15, Math.max(0, RandomGenerator.randomIntInRange(1, 6) - 7 + (repSelector / 4)));
        }

        int holyArchmageCount = 0;
        if (repSelector >= 16) {
            holyArchmageCount = Math.min(15, Math.max(0, RandomGenerator.randomIntInRange(1, 8) - 9 + (repSelector / 6)));
        }

        int bastionShieldCount = 0;
        if (repSelector >= 20) {
            bastionShieldCount = Math.min(15, Math.max(0, RandomGenerator.randomIntInRange(1, 6) - 9 + (repSelector / 5)));
        }

        int dawnbringerCount = 0;
        if (repSelector >= 30) {
            dawnbringerCount = Math.min(2, Math.max(0, RandomGenerator.randomIntInRange(1, 10) - 10 + (repSelector / 10)));
            //once they are put in, they don't get removed
        }

        int totalGuards = standardGuardCount + recallClericCount + arresterCount + watchmanCount + lawcasterCount + healerCount + entanglerCount + enforcerCount + purgerCount + skyhelmCount + sniperCount + earthHelmCount + holyArchmageCount + bastionShieldCount + dawnbringerCount;
        while (totalGuards >= totalReinforcementsCap) {
            totalGuards = standardGuardCount + recallClericCount + arresterCount + watchmanCount + lawcasterCount + healerCount + entanglerCount + enforcerCount + purgerCount + skyhelmCount + sniperCount + earthHelmCount + holyArchmageCount + bastionShieldCount + dawnbringerCount;
            //this loop removes the "worse" guards in the group until the number is within the cap. Quality over quantity
            if (standardGuardCount > 0) {
                standardGuardCount--;
            } else if (arresterCount > 0) {
                arresterCount--;
            } else if (watchmanCount > 0) {
                watchmanCount--;
            } else if (lawcasterCount > 0) {
                lawcasterCount--;
            } else if (entanglerCount > 0) {
                entanglerCount--;
            } else if (enforcerCount > 0) {
                enforcerCount--;
            } else if (purgerCount > 0) {
                purgerCount--;
            } else if (skyhelmCount > 0) {
                skyhelmCount--;
            } else if (sniperCount > 0) {
                sniperCount--;
            } else if (earthHelmCount > 0) {
                earthHelmCount--;
            } else if (holyArchmageCount > 0) {
                holyArchmageCount--;
            } else if (bastionShieldCount > 0) {
                bastionShieldCount--;
            }
        }

        for (int i = 0; i < standardGuardCount; i++) {
            hardData.guardsInArea.add("Standard Guard");
        }
        for (int i = 0; i < recallClericCount; i++) {
            hardData.guardsInArea.add("Recall Cleric");
        }
        for (int i = 0; i < arresterCount; i++) {
            hardData.guardsInArea.add("Arrester");
        }
        for (int i = 0; i < watchmanCount; i++) {
            hardData.guardsInArea.add("Watchman");
        }
        for (int i = 0; i < lawcasterCount; i++) {
            hardData.guardsInArea.add("Lawcaster");
        }
        for (int i = 0; i < healerCount; i++) {
            hardData.guardsInArea.add("Healer");
        }
        for (int i = 0; i < entanglerCount; i++) {
            hardData.guardsInArea.add("Entangler");
        }
        for (int i = 0; i < enforcerCount; i++) {
            hardData.guardsInArea.add("Enforcer");
        }
        for (int i = 0; i < purgerCount; i++) {
            hardData.guardsInArea.add("Purger");
        }
        for (int i = 0; i < skyhelmCount; i++) {
            hardData.guardsInArea.add("Skyhelm");
        }
        for (int i = 0; i < sniperCount; i++) {
            hardData.guardsInArea.add("Sniper");
        }
        for (int i = 0; i < earthHelmCount; i++) {
            hardData.guardsInArea.add("Earth-Helm");
        }
        for (int i = 0; i < holyArchmageCount; i++) {
            hardData.guardsInArea.add("Holy Archmage");
        }
        for (int i = 0; i < bastionShieldCount; i++) {
            hardData.guardsInArea.add("Bastion's Shield");
        }
        for (int i = 0; i < dawnbringerCount; i++) {
            hardData.guardsInArea.add("Dawnbringer");
        }
    }

    public static void addGuardEncounterToGuardList() {

    }

    public static void createCommonerList(int numberToCreate, HardData hardData) {
        //reset the current list
        hardData.commonersInArea = new ArrayList<Person>();
        for (int i = 0; i < numberToCreate; i++) {
            hardData.commonersInArea.add(new Person().create(hardData));
        }
    }
}
