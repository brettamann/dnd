package com.dnd.Menus;

import com.dnd.Autocombat.AutocombatHandler;
import com.dnd.DataObjects.CampaignObject;
import com.dnd.DataObjects.HardData;
import com.dnd.Utilities.Colors;
import com.dnd.Utilities.Input;
import com.dnd.Utilities.Screen;
import com.dnd.Utilities.Utilities;

import java.util.List;

public class MainMenu {

    public static void display(CampaignObject gameObject, HardData hardData) {
        boolean quitProgram = false;
        while (!quitProgram) {
            Screen.println("In " + Colors.YELLOW + hardData.currentSelectedLocation.name + Colors.RESET + " with " + Colors.YELLOW + hardData.currentSelectedLocation.reputationInArea + Colors.RESET + " rep in the area. (Alert Level " + hardData.currentSelectedLocation.reputationInArea + ": " + Utilities.translateAlertLevelToString(hardData.currentSelectedLocation.alertLevel) + ")");
            Screen.println("");
            //Screen.clear();
            Screen.print("\t\t\tMain Menu\n\n");
            String input = Input.promptTextInput("0. Change Location\n1. DC & Person Generator Menu\n2. Autocombat Simulator\n3. Update Party XP & Rep\n4. Update Area Alert & Rep\n\nd. Display What's Around", List.of("0","1","2","3","4"));
            switch (input) {
                case "0":
                    ChangeLocation.changeSelectedLocation(hardData);
                    break;
                case "1":
                    GeneratorMenu.display(hardData);
                    break;
                case "2":
                    switch (Input.promptTextInput("What are we loading into the combat?\n1. The last set of commoners made\n2. A new set of commoners based on the area\n3. A new set of commoners of a specific number\nb. Back (cancel)", List.of("1","2","3","b"))) {
                        case "1":
                            AutocombatHandler.epicCombat(hardData.partyInfo, gameObject.getPartyMembers(), hardData.commonersInArea, hardData.currentSelectedLocation);
                            break;
                        case "2":
                            Utilities.createCommonerList(Utilities.getCommonerCountInArea(hardData), hardData);
                            AutocombatHandler.epicCombat(hardData.partyInfo, gameObject.getPartyMembers(), hardData.commonersInArea, hardData.currentSelectedLocation);
                            break;
                        case "3":
                            Utilities.createCommonerList(Input.promptIntInputWithinRange("How many?", 0, 200), hardData);
                            AutocombatHandler.epicCombat(hardData.partyInfo, gameObject.getPartyMembers(), hardData.commonersInArea, hardData.currentSelectedLocation);
                            break;
                        default:
                            Screen.println("Cancelled");
                            break;
                    }
                    break;
                case "3":
                    //TODO update party rep & xp
                    break;
                case "4":
                    //TODO update area rep & alert level
                    break;
                case "d":
                    //TODO display created commoners & guards
                    break;
            }
                    //change location
                    //autocombat
                    //lock DC
                    //guard encounter
                    //recognition (in generator)
            //travel recognition
                    //generate commoners in generator
            //display commoners
                    //call time in generator
            //update player rep and exp
        }
    }
}
