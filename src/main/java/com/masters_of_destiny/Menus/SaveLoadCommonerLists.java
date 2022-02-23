package com.masters_of_destiny.Menus;

import com.masters_of_destiny.DataObjects.CampaignObject;
import com.masters_of_destiny.DataObjects.Person;
import com.masters_of_destiny.DataObjects.SavedCommonerList;
import com.masters_of_destiny.Utilities.FileUtility;
import com.masters_of_destiny.Utilities.Input;
import com.masters_of_destiny.Utilities.Screen;

import java.util.ArrayList;
import java.util.List;

public class SaveLoadCommonerLists {
    public static void saveLoadCommonerMenu(CampaignObject gameObject) {
        String userInput = "run";
        while (!userInput.equalsIgnoreCase("b")) {
            Screen.println("\n");
            if (gameObject.getSavedCommonerLists().size() == 0) {
                for (int i = 0; i < gameObject.getSavedCommonerLists().size(); i++) {
                    Screen.println(i + ": " + gameObject.getSavedCommonerLists().get(i).getListName() + ", " + gameObject.getSavedCommonerLists().get(i).getNote() + ", " + gameObject.getSavedCommonerLists().get(i).getDate());
                }
                Screen.println("\n");
                userInput = Input.promptOpenInput("Select a list, or b for back, or s for Save the current commoners");
                if (userInput.matches("-?\\d+(\\.\\d+)?") && !userInput.matches(".*?[A-Za-z]")) {
                    int inputToInt = Integer.parseInt(userInput);
                    Screen.println("\nSelected: " + gameObject.getSavedCommonerLists().get(inputToInt).getListName() + ", " + gameObject.getSavedCommonerLists().get(inputToInt).getNote() + ", " + gameObject.getSavedCommonerLists().get(inputToInt).getDate());
                    userInput = Input.promptTextInput("1. Replace current commoners with this list\n2. Append this list to the current one\nd. Delete this entry\nb. Back", List.of("1", "2", "d", "b"));
                    switch (userInput) {
                        case "1":
                            gameObject.getHardData().commonersInArea = new ArrayList<Person>(gameObject.getSavedCommonerLists().get(inputToInt).getCommoners());
                            break;
                        case "2":
                            gameObject.getHardData().commonersInArea.addAll(gameObject.getSavedCommonerLists().get(inputToInt).getCommoners());
                            break;
                        case "d":
                            gameObject.getSavedCommonerLists().remove(inputToInt);
                            break;
                        case "b":
                            break;
                    }
                } else if (userInput.equals("s")) {
                    gameObject.getSavedCommonerLists().add(new SavedCommonerList(Input.promptOpenInput("Enter the list name: "), new ArrayList<Person>(gameObject.getHardData().commonersInArea), Input.promptOpenInput("Enter the date"), Input.promptOpenInput("Enter any notes")));
                    FileUtility.save(gameObject);
                }
            } else {
                if (Input.promptTextInput("No saved commoner lists exist. Save the current commoners? y/n", List.of("y","n")).equals("y")) {
                    gameObject.getSavedCommonerLists().add(new SavedCommonerList(Input.promptOpenInput("Enter the list name: "), new ArrayList<Person>(gameObject.getHardData().commonersInArea), Input.promptOpenInput("Enter the date"), Input.promptOpenInput("Enter any notes")));
                    FileUtility.save(gameObject);
                } else {
                    userInput = "b";
                }
            }
        }
    }
}
