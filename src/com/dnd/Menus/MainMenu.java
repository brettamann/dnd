package com.dnd.Menus;

import com.dnd.Autocombat.AutocombatHandler;
import com.dnd.DataObjects.*;
import com.dnd.Utilities.*;

import java.io.File;
import java.util.List;

public class MainMenu {

    public static void display(CampaignObject gameObject, HardData hardData) {
        boolean quitProgram = false;
        while (!quitProgram) {
            Screen.print("\t\t\tMain Menu\n\n");
            Screen.println("In " + Colors.YELLOW + hardData.currentSelectedLocation.name + Colors.RESET + " with " + Colors.YELLOW + hardData.currentSelectedLocation.reputationInArea + Colors.RESET + " rep in the area. (Alert Level " + (hardData.currentSelectedLocation.reputationInArea / 100) + ": " + Utilities.translateAlertLevelToString(hardData.currentSelectedLocation.alertLevel) + ")\n");
            Screen.println("Commoners in area: " + hardData.commonersInArea.size() + ", Guards in area: " + hardData.guardsInArea.size());
            String input = Input.promptTextInput("0. Change Location\n1. Generator Menu\n2. Autocombat Simulator\n3. Update Party XP & Rep\n4. Update Area Alert & Rep\n5. See, save, load form previous commoner lists\n\nd. Display What's Around\nreset. Reset all data", List.of("0","1","2","3","4","5","d","s","reset"));
            switch (input) {
                case "0":
                    ChangeLocation.changeSelectedLocation(true, hardData);
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
                    switch (Input.promptTextInput("What are we updating?\n1. Reputation\n2. XP\nb. Back", List.of("1", "2", "b"))) {
                        case "1":
                            gameObject.getPartyInfo().setReputation(Input.promptIntInputWithinRange("Enter the new reputation value:",0,9999999));
                            FileUtility.save(gameObject);
                            break;
                        case "2":
                            gameObject.getPartyInfo().setCurrentXP(Input.promptIntInputWithinRange("Enter the new XP value:",0,999999999));
                            FileUtility.save(gameObject);
                            break;
                    }
                    break;
                case "4":
                    ChangeLocation.updateLocationRep(hardData);
                    break;
                case "5":
                    SaveLoadCommonerLists.saveLoadCommonerMenu(gameObject);
                case "d":
                    switch (Input.promptTextInput("What are we displaying?\n1. Commoners\n2. Guards\n3. Both\nb. Back", List.of("1", "2", "3", "b"))) {
                        case "1":
                            for (Person temp : hardData.commonersInArea) {
                                temp.displayAll();
                            }
                            break;
                        case "2":
                            for (String guard : hardData.guardsInArea) {
                                Screen.println(guard);
                            }
                            break;
                        case "3":
                            for (Person temp : hardData.commonersInArea) {
                                temp.displayAll();
                            }
                            for (String guard : hardData.guardsInArea) {
                                Screen.println(guard);
                            }
                            break;
                        default:
                            Screen.println("Cancelling");
                            break;
                    }
                    break;
                case "s":
                    FileUtility.save(gameObject);
                    Screen.greenText("Game saved!");
                case "reset":
                    if (Input.promptTextInput(Colors.RED + "THIS ERASES ALL DATA! ARE YOU SURE YOU WANT TO?! (y/n)" + Colors.RESET, List.of("y","n")).equals("y")) {{
                        gameObject = new CampaignObject();
                        FileUtility.save(gameObject);
                        ChangeLocation.changeSelectedLocation(false, gameObject.getHardData());
                        FileUtility.save(gameObject);
                    }

                }
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
