package com.dnd.DataObjects;

import com.dnd.DataObjects.Races.Race;
import com.dnd.DataObjects.Races.Races;
import com.dnd.DataObjects.Spells.Spell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardData {
    public PartyInfo partyInfo = new PartyInfo();
    public List<Person> commonersInArea = new ArrayList<>();
    public List<String> guardsInArea = new ArrayList<>();
    public int guardCountInArea = 0;
    public Location currentSelectedLocation = new Location("Berlstrom", "Slums on the east side of the city", new ArrayList<>(Arrays.asList("Thieves hideout", "Ramshackle Hospital", "orphanage", "peddler street", "Shack City")), new ArrayList<>(Arrays.asList("War & Judgement District", "Lakeshore Community", "Woodland Haven Forest", "Thunderfoot", "East Gate Market", "The Sewers")), 0, 0, 1, 1, 4, 4, 0, 3, 1, 1, 3, 3, 4, 3, 1, 1, 2, 3, 6, 2, 3, 6, 10, 4, 3, 1, 6, 3, 5, 9, 1, 1, 1, 10, 15, 70, 5, 0, 0, 3, 3, -5, 2, 0, 0, 0, 20, 0, 100, 0, 100, 0, 0, 0, 3, 1, 1, 2, 10, 25, 80, 1, 10);
    Races races = new Races();
    List<Race> raceData = races.generateRaceData();
    List<Location> locationList = new ArrayList<Location>((Arrays.asList(
            new Location(Locations.citadel),
            new Location(Locations.overlookRidge),
            new Location(Locations.jewelcourt),
            new Location(Locations.warJudgement),
            new Location(Locations.thunderfoot),
            new Location(Locations.berlstrom),
            new Location(Locations.woodlandHaven),
            new Location(Locations.carnival),
            new Location(Locations.roostInn),
            new Location(Locations.dragonsLanding),
            new Location(Locations.eastGate),
            new Location(Locations.westGate),
            new Location(Locations.lakeshore),
            new Location(Locations.angelfallSquare),
            new Location(Locations.greenbelt),
            new Location(Locations.rethsberg),
            new Location(Locations.upperCaverns),
            new Location(Locations.lowerCaverns),
            new Location(Locations.sewers)
    )));

    /*
    31 races
    ~3% per is an even distribution for a race, leaving 7 remaining to boost 7 up to 4%
     */

    public List<Location> getLocationList() {
        return locationList;
    }

    public Races getRaces() {
        return races;
    }

    public List<Race> getRaceData() {
        return raceData;
    }
}
