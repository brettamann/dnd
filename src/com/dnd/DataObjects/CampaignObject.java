package com.dnd.DataObjects;


import java.util.ArrayList;
import java.util.List;

// Overall game object, just a rough sample
public class CampaignObject {
    PartyInfo partyInfo;
    List<PartyMember> partyMembers;
    List<Location> locations;
    List<Person> killedList;
    List<Person> capturedList;

    public CampaignObject() {
        partyInfo = new PartyInfo();
        partyMembers = new ArrayList<>();
        locations = new ArrayList<>();
        killedList = new ArrayList<>();
        capturedList = new ArrayList<>();
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

}
