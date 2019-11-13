package com.dnd.Menus;

import com.dnd.DataObjects.HardData;
import com.dnd.DataObjects.PartyInfo;
import com.dnd.Utilities.*;

import java.util.List;

public class GeneratorMenu {
    public static void display(HardData hardData) {
        String input = Input.promptTextInput("What do you want to get?\n0. What's around me?\n1. Create Commoners\n2. Create a Guard Encounter\n3. Call Time\n4. Lock DC\n5. Recognition DC\n\nb. Back", List.of("0","1","2","3","4","5","b"));
        if (!input.equals("b")) {
            switch (Integer.parseInt(input)) {
                case 0:
                    Utilities.getWhatsAroundMe(hardData);
                case 1:
                    switch (Input.promptTextInput("\nHow?\n1. Completely based on area\n2. Specific Number\nb. Back (Cancel)", List.of("1", "2", "b"))) {
                        case "1":
                            Utilities.createCommonerList(Utilities.getCommonerCountInArea(hardData), hardData);
                            break;
                        case "2":
                            Utilities.createCommonerList(Input.promptIntInputWithinRange("How many?", 0, 200), hardData);
                            break;
                        default:
                            Screen.println("Cancelled");
                    }
                    break;
                case 2:
                    Utilities.createGuardEncounter(hardData);
                    //TODO: need to display the guard encounter
                    break;
                case 3:
                    switch (Input.promptTextInput("\n\nWhat kind of call time?\n1. Call Glyph is in area\n2.Person ran away and is looking for guards\nb. Back (cancel)", List.of("1","2","b"))) {
                        case "1":
                            Screen.println("There are " + Utilities.getCallTimeBasic(hardData) + " rounds until reinforcements would arrive");
                            break;
                        case "2":
                            Screen.println("There are " + Utilities.getCallTimeRunner(hardData) + " rounds until reinforcements would arrive");
                            break;
                        default:
                            Screen.println("Cancelled");
                            break;
                    }
                    break;
                case 4:
                    Screen.println("Lock DC: " + Colors.YELLOW + RandomGenerator.randomIntInRange(hardData.currentSelectedLocation.lockDCLow, hardData.currentSelectedLocation.lockDCHigh) + Colors.RESET);
                    break;
                case 5:
                    int disguiseLevel = Input.promptIntInputWithinRange("Enter the Player (or Party average) disguise level by adding the following situations up:\n+0 No disguise or attempt to hide\n+1 Change of outfit, height, or weight\n+3 Prominant gear is hidden\n+5 Change of Face\n+4 It is dark\n+10 Change of race\n-5 Committed a crime nearby within last 24 hours\n-10 is at the scene of the crime or interacting with a former victim",-20,100);
                    int opponentModifier = Input.promptIntInputWithinRange("Enter the average passive perception of the creature(s) in question (or wisdom modifier), adding +5 if it's a guard or city official:", -5,50);
                    int recognitionDC = (hardData.partyInfo.getReputation() / 100) + opponentModifier - disguiseLevel;
                    Screen.println("The player must roll a D20 (can use persuasion skill if interacting) against a DC of " + Colors.YELLOW + recognitionDC + Colors.RESET);
                    break;
                default:
                    Screen.println("Cancelled");
                    break;
            }
        }
    }
}
