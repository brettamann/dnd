package com.masters_of_destiny;

import com.masters_of_destiny.DataObjects.*;
import com.masters_of_destiny.Menus.ChangeLocation;
import com.masters_of_destiny.Menus.MainMenu;

public class Main {

    public static void main(String[] args) {
        //List<Person> opponents = new ArrayList<>();
        //CampaignObject gameObject = FileUtility.getFileOnStartup(); TODO: uncomment this when ready
        CampaignObject gameObject = new CampaignObject();
        ChangeLocation.changeSelectedLocation(false, gameObject.getHardData());
        MainMenu.display(gameObject, gameObject.getHardData());
        //for (int i = 0; i < 25; i++){
        //    opponents.add(new Person().create(hardData));
        //}


        //AutocombatHandler.epicCombat(gameObject.getPartyInfo(), gameObject.getPartyMembers(), opponents, hardData.getLocationList().get(6));


        //gameObject.getPartyMembers().add(new PartyMember("GanDwarf", 113, 113, 22, 7, 14, 10, 0));
        //FileUtility.save(gameObject);
    }
}
