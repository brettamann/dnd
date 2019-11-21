package com.dnd.Utilities;

import com.dnd.DataObjects.Guards.GuardTypes;
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

        int recallClericCount = 0;
        if (repSelector >= 5 && RandomGenerator.randomIntInRange(1, 100) <= 20) {
            recallClericCount = 1;
        }

        int aeromancerCount = 0;
        if (repSelector >= 5) {
            aeromancerCount = Math.min(6, Math.max(0, RandomGenerator.randomIntInRange(1, 4) - 5 + (repSelector / 2)));
        }

        int subhydromancerCount = 0;
        if (repSelector >= 6) {
            subhydromancerCount = Math.min(6, Math.max(0, RandomGenerator.randomIntInRange(1, 4) - 5 + (repSelector / 2)));
        }

        int healerCount = 0;
        if (repSelector >= 6) {
            healerCount = Math.min(2, Math.max(0, RandomGenerator.randomIntInRange(1, 6) - 5 + (repSelector / 5)));
            //Once they are placed in, they don't get removed
        }

        int pyromancerCount = 0;
        if (repSelector >= 7) {
            pyromancerCount = Math.min(6, Math.max(0, RandomGenerator.randomIntInRange(1, 4) - 5 + (repSelector / 2)));
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

        int geomancerCount = 0;
        if (repSelector >= 11) {
            geomancerCount = Math.min(6, Math.max(0, RandomGenerator.randomIntInRange(1, 4) - 5 + (repSelector / 2)));
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

        int linebreakerCount = 0;
        if (repSelector >= 15) {
            linebreakerCount = Math.min(15, Math.max(0, RandomGenerator.randomIntInRange(1, 6) - 7 + (repSelector / 4)));
        }

        int suppressorCount = 0;
        if (repSelector >= 16) {
            suppressorCount = Math.min(15, Math.max(0, RandomGenerator.randomIntInRange(1, 8) - 9 + (repSelector / 6)));
        }

        int holyArchmageCount = 0;
        if (repSelector >= 16) {
            holyArchmageCount = Math.min(15, Math.max(0, RandomGenerator.randomIntInRange(1, 8) - 9 + (repSelector / 6)));
        }

        int demonHunterCount = 0;
        if (repSelector >= 18) {
            demonHunterCount = Math.min(15, Math.max(0, RandomGenerator.randomIntInRange(1, 8) - 9 + (repSelector / 6)));
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

        int totalGuards = standardGuardCount + recallClericCount + arresterCount + aeromancerCount + watchmanCount + lawcasterCount + healerCount + subhydromancerCount + pyromancerCount + entanglerCount + enforcerCount + purgerCount + skyhelmCount + geomancerCount + sniperCount + earthHelmCount + holyArchmageCount + suppressorCount + linebreakerCount + bastionShieldCount + demonHunterCount + dawnbringerCount;
        while (totalGuards >= totalReinforcementsCap) {
            totalGuards = standardGuardCount + recallClericCount + arresterCount + aeromancerCount + watchmanCount + lawcasterCount + healerCount + subhydromancerCount + pyromancerCount + entanglerCount + enforcerCount + purgerCount + skyhelmCount + geomancerCount + sniperCount + earthHelmCount + holyArchmageCount + linebreakerCount + bastionShieldCount + demonHunterCount + dawnbringerCount;
            //this loop removes the "worse" guards in the group until the number is within the cap. Quality over quantity
            //I want there to be potential variance in who gets removed, so even the worst guards have a small chance to stick around
            if (standardGuardCount > 0 && RandomGenerator.randomIntInRange(1,100) <= 95) {
                standardGuardCount--;
            } else if (arresterCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 90) {
                arresterCount--;
            } else if (watchmanCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 85) {
                watchmanCount--;
            } else if (lawcasterCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 80) {
                lawcasterCount--;
            } else if (aeromancerCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 75) {
                aeromancerCount--;
            } else if (subhydromancerCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 70) {
                subhydromancerCount--;
            } else if (pyromancerCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 65) {
                pyromancerCount--;
            } else if (entanglerCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 60) {
                entanglerCount--;
            } else if (enforcerCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 55) {
                enforcerCount--;
            } else if (purgerCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 50) {
                purgerCount--;
            } else if (geomancerCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 45) {
                geomancerCount--;
            } else if (skyhelmCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 40) {
                skyhelmCount--;
            } else if (sniperCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 35) {
                sniperCount--;
            } else if (earthHelmCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 30) {
                earthHelmCount--;
            } else if (linebreakerCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 25) {
                linebreakerCount--;
            } else if (suppressorCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 20) {
                if (RandomGenerator.randomIntInRange(1,100) <= 50) {
                    suppressorCount--;
                } else {
                    holyArchmageCount--;
                }
            } else if (holyArchmageCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 20) {

            } else if (demonHunterCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 15) {
                demonHunterCount--;
            } else if (bastionShieldCount > 0 && RandomGenerator.randomIntInRange(1, 100) <= 10) {
                bastionShieldCount--;
            }
        }

        for (int i = 0; i < standardGuardCount; i++) {
            hardData.guardsInArea.add(GuardTypes.standardGuard);
        }
        for (int i = 0; i < recallClericCount; i++) {
            hardData.guardsInArea.add(GuardTypes.recallCleric);
        }
        for (int i = 0; i < arresterCount; i++) {
            hardData.guardsInArea.add(GuardTypes.arrester);
        }
        for (int i = 0; i < aeromancerCount; i++) {
            hardData.guardsInArea.add(GuardTypes.aeromancer);
        }
        for (int i = 0; i < subhydromancerCount; i++) {
            hardData.guardsInArea.add(GuardTypes.subhydromancer);
        }
        for (int i = 0; i < pyromancerCount; i++) {
            hardData.guardsInArea.add(GuardTypes.pyromancer);
        }
        for (int i = 0; i < watchmanCount; i++) {
            hardData.guardsInArea.add(GuardTypes.watchman);
        }
        for (int i = 0; i < lawcasterCount; i++) {
            hardData.guardsInArea.add(GuardTypes.lawcaster);
        }
        for (int i = 0; i < healerCount; i++) {
            hardData.guardsInArea.add(GuardTypes.healer);
        }
        for (int i = 0; i < entanglerCount; i++) {
            hardData.guardsInArea.add(GuardTypes.entangler);
        }
        for (int i = 0; i < enforcerCount; i++) {
            hardData.guardsInArea.add(GuardTypes.enforcer);
        }
        for (int i = 0; i < purgerCount; i++) {
            hardData.guardsInArea.add(GuardTypes.purger);
        }
        for (int i = 0; i < geomancerCount; i++) {
            hardData.guardsInArea.add(GuardTypes.geomancer);
        }
        for (int i = 0; i < skyhelmCount; i++) {
            hardData.guardsInArea.add(GuardTypes.skyHelm);
        }
        for (int i = 0; i < sniperCount; i++) {
            hardData.guardsInArea.add(GuardTypes.sniper);
        }
        for (int i = 0; i < earthHelmCount; i++) {
            hardData.guardsInArea.add(GuardTypes.earthHelm);
        }
        for (int i = 0; i < linebreakerCount; i++) {
            hardData.guardsInArea.add(GuardTypes.linebreaker);
        }
        for (int i = 0; i < suppressorCount; i++) {
            hardData.guardsInArea.add(GuardTypes.suppressor);
        }
        for (int i = 0; i < holyArchmageCount; i++) {
            hardData.guardsInArea.add(GuardTypes.holyArchmage);
        }
        for (int i = 0; i < demonHunterCount; i++) {
            hardData.guardsInArea.add(GuardTypes.demonHunter);
        }
        for (int i = 0; i < bastionShieldCount; i++) {
            hardData.guardsInArea.add(GuardTypes.bastionShield);
        }
        for (int i = 0; i < dawnbringerCount; i++) {
            hardData.guardsInArea.add(GuardTypes.dawnbringer);
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
