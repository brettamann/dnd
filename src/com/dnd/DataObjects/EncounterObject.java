package com.dnd.DataObjects;

import com.dnd.DataObjects.Items.Armor;
import com.dnd.DataObjects.Items.Loot;
import com.dnd.DataObjects.Items.Weapon;

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
    public List<Weapon> lootedWeapons = new ArrayList<>();
    public List<Armor> lootedArmor = new ArrayList<>();
    public List<Loot> lootedLoot = new ArrayList<>();
    public boolean encounterFinished = false;
    public long averageRoll = 0;
    public int totalGoldFound = 0;


}
