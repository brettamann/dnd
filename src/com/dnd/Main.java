package com.dnd;

import com.dnd.DataObjects.CampaignObject;
import com.dnd.DataObjects.PartyInfo;
import com.dnd.DataObjects.PartyMember;
import com.dnd.Utilities.Database;
import com.dnd.Utilities.FileUtility;
import com.dnd.Utilities.Input;
import com.dnd.Utilities.Screen;

public class Main {

    public static void main(String[] args) {
        Screen screen = new Screen();
        Input input = new Input();

        CampaignObject gameObject = FileUtility.load();
        //gameObject.getPartyMembers().add(new PartyMember("GanDwarf", 113, 113, 22, 7, 14, 10, 0));
        //PartyInfo partyInfo = new PartyInfo();
        //Database database = new Database();
        //database.createNewDatabase("bastion.db");
        screen.redText("this should be red");
        screen.print("this is just printed");
        screen.cyanText("this should be cyan");
        screen.print("ready for some input?");
        input.promptTextInput("Enter something here!@!!");
        input.readInputText();

        FileUtility.save(gameObject);
    }
}
