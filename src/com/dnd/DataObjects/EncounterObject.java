package com.dnd.DataObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: cweeter
 * Date: 2019-11-05
 */
public class EncounterObject {

    public int experiencePerMember = 0;

    public List<PartyMember> playersWhoDied = new ArrayList<>();
    public List<Person> opponentsWhoDied = new ArrayList<>();
    public List<Person> opponentsWhoRanAway = new ArrayList<>();
    public List<Person> opponentsWhoStayed = new ArrayList<>();
    public boolean encounterFinished = false;
    public long averageRoll = 0;
    public int totalGoldFound = 0;


}
