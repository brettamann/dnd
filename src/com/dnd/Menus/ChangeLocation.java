package com.dnd.Menus;

import com.dnd.DataObjects.HardData;
import com.dnd.DataObjects.Location;
import com.dnd.Utilities.Colors;
import com.dnd.Utilities.Input;
import com.dnd.Utilities.Screen;

import java.util.List;

public class ChangeLocation {
    public static void changeSelectedLocation(boolean askAboutTravel, HardData hardData) {
        String travelSelection = "";
        if (askAboutTravel) {
            travelSelection = Input.promptTextInput("Roll to see if players are recognized during travel? (y/n)", List.of("y", "yes", "n", "no"));
            if (travelSelection.equals("y") || travelSelection.equals("yes")) {
                int travelSafelyDC = Input.promptIntInputWithinRange("Enter the Player (or Party average) disguise level by adding " + hardData.currentSelectedLocation.alertLevel + " to the following situations (is cumulative):\n+0 No disguise or attempt to hide\n+1 Change of outfit, height, or weight\n+3 Prominant gear is hidden\n+5 Change of Face\n+4 It is dark\n+10 Change of race\n", -20, 100) - (hardData.partyInfo.getReputation() / 100);
                Screen.println("Let the players make a stealth roll, and average it. The DC to beat is " + Colors.YELLOW + travelSafelyDC + Colors.RESET);
                if (Input.promptTextInput("Did the players beat it? y/n", List.of("y", "n")).equalsIgnoreCase("y")) {
                    travelSelection = "n";
                } else {
                    Screen.println("Then the players get recognized! Roll a call time but add a couple. Decide what the players want to do. Once they beat this, let them move to the next area.");
                }
            }
        }
        if (!travelSelection.equalsIgnoreCase("y") && !travelSelection.equalsIgnoreCase("yes")){
            Screen.println("\t\tPlease select a location to move to:\n");
            displayLocations(hardData);
            int selectedLocation = Integer.parseInt(Input.promptTextInputQuiet(List.of("0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "18")));
            hardData.currentSelectedLocation = hardData.getLocationList().get(selectedLocation);
        }
    }

    public static void updateLocationRep(HardData hardData) {
        Screen.println("\t\tPlease select a location to update rep for (or 'b' for back):\n");
        displayLocations(hardData);
        String selection = Input.promptTextInputQuiet(List.of("0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "b"));
        if (!selection.equals("b")) {
            int selectedLocation = Integer.parseInt(selection);
            int newReputation = Input.promptIntInputWithinRange("Selected: " + hardData.getLocationList().get(selectedLocation).name + ". Update " + hardData.getLocationList().get(selectedLocation).reputationInArea + " to what?", 0, 999999);
            String confirm = Input.promptTextInput("Setting " + hardData.getLocationList().get(selectedLocation).name + " to " + Colors.RED + newReputation + Colors.RESET + ". Is that ok?\ny (yes) / n (no)", List.of("y", "yes", "n", "no"));
            if (confirm.equals("y") || confirm.equals("yes")) {
                hardData.getLocationList().get(selectedLocation).reputationInArea = newReputation;
                //update the alert level according to reputation
                hardData.getLocationList().get(selectedLocation).alertLevel = newReputation / 200;
            }
        }
    }

    public static void displayLocations(HardData hardData) {
        for (int i = 0; i <= hardData.getLocationList().size() - 1; i++) {
            Screen.println(i + ": " + hardData.getLocationList().get(i).name + ", Rep: " + hardData.getLocationList().get(i).reputationInArea);
        }
    }
}
