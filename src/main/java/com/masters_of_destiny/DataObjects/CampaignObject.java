package com.masters_of_destiny.DataObjects;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Overall game object, just a rough sample
public class CampaignObject {
    PartyInfo partyInfo;
    List<PartyMember> partyMembers;
    List<Location> locations;
    List<Person> killedList;
    List<Person> capturedList;

    ArrayList<SavedCommonerList> savedCommonerLists;
    HardData hardData;

    public CampaignObject() {
        partyInfo = new PartyInfo();
        partyMembers = new ArrayList<>(Arrays.asList(
            new PartyMember("Mark (Mork)", 86, 86, 15, 8, 5, 3, 3,2),
            new PartyMember("Chris (Gandwarf)", 113, 113, 22, 7, 14, 10, 0,2),
            new PartyMember("Ellie (Ember)", 63, 63, 16, 4, 9, 7, 3,1)
        ));
        locations = new ArrayList<>();
        killedList = new ArrayList<>();
        capturedList = new ArrayList<>();
        hardData = new HardData();
        savedCommonerLists = new ArrayList<>();
    }

    public PartyInfo getPartyInfo() {
        return partyInfo;
    }

    public CampaignObject setPartyInfo(PartyInfo partyInfo) {
        this.partyInfo = partyInfo;
        return this;
    }

    public List<PartyMember> getPartyMembers() {
        return partyMembers;
    }

    public CampaignObject setPartyMembers(List<PartyMember> partyMembers) {
        this.partyMembers = partyMembers;
        return this;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public CampaignObject setLocations(List<Location> locations) {
        this.locations = locations;
        return this;
    }

    public List<Person> getKilledList() {
        return killedList;
    }

    public CampaignObject setKilledList(List<Person> killedList) {
        this.killedList = killedList;
        return this;
    }

    public List<Person> getCapturedList() {
        return capturedList;
    }

    public CampaignObject setCapturedList(List<Person> capturedList) {
        this.capturedList = capturedList;
        return this;
    }

    public HardData getHardData() {
        return hardData;
    }

    public CampaignObject setHardData(HardData hardData) {
        this.hardData = hardData;
        return this;
    }

    public ArrayList<SavedCommonerList> getSavedCommonerLists() {
        return savedCommonerLists;
    }

    public CampaignObject setSavedCommonerLists(ArrayList<SavedCommonerList> savedCommonerLists) {
        this.savedCommonerLists = savedCommonerLists;
        return this;
    }
}
