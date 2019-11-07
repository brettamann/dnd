package com.dnd;

import com.dnd.Autocombat.AutocombatHandler;
import com.dnd.DataObjects.*;
import com.dnd.DataObjects.Races.Race;
import com.dnd.DataObjects.Races.Races;
import com.dnd.Utilities.Database;
import com.dnd.Utilities.FileUtility;
import com.dnd.Utilities.Input;
import com.dnd.Utilities.Screen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Screen screen = new Screen();
        Input input = new Input();
        HardData hardData = new HardData();
        List<Person> opponents = new ArrayList<>();

        CampaignObject gameObject = FileUtility.load();
        for (int i = 0; i < 25; i++){
            opponents.add(new Person().create(hardData.getLocationList().get(6), hardData));
        }
        AutocombatHandler.epicCombat(gameObject.getPartyInfo(), gameObject.getPartyMembers(), opponents, hardData.getLocationList().get(6));
        //gameObject.getPartyMembers().add(new PartyMember("GanDwarf", 113, 113, 22, 7, 14, 10, 0));
        //PartyInfo partyInfo = new PartyInfo();
        //Database database = new Database();
        //database.createNewDatabase("bastion.db");
        screen.redText("this should be red");
        screen.print("this is just printed");
        screen.cyanText("this should be cyan");
        screen.print("ready for some input?");
        //input.promptTextInput("Enter something here!@!!");
        //input.readInputText();

 //       FileUtility.save(gameObject);
    }
}
