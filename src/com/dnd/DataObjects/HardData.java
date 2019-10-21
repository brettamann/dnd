package com.dnd.DataObjects;

import com.dnd.DataObjects.Races.Race;
import com.dnd.DataObjects.Races.Races;
import com.dnd.Utilities.Input;
import com.dnd.Utilities.Screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardData {
    Races races = new Races();
    List<Race> raceData = races.generateRaceData();

    public Races getRaces() {
        return races;
    }

    public List<Race> getRaceData() {
        return raceData;
    }

    public List<Location> getLocationData() {
        return locationData;
    }

    //TODO: fill out all location data, give location a constructor
    List<Location> locationData = new ArrayList<Location>(Arrays.asList(
        new Location(),
        new Location()
    ));
}
