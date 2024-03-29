package com.masters_of_destiny.DataObjects;

public class PartyInfo {
    int memberCount = 3;
    int currentXP = 0;
    int reputation = 0;
    int averageLevel = 10;

    //public PartyInfo(int memberCount, int currentXP, int reputation, int averageLevel) {
    //    this.memberCount = memberCount;
    //    this.currentXP = currentXP;
    //    this.reputation = reputation;
    //    this.averageLevel = averageLevel;
    //}

    public int getMemberCount() {
        return memberCount;
    }

    public PartyInfo setMemberCount(int memberCount) {
        this.memberCount = memberCount;
        return this;
    }

    public int getCurrentXP() {
        return currentXP;
    }

    public PartyInfo setCurrentXP(int currentXP) {
        this.currentXP = currentXP;
        return this;
    }

    public int getReputation() {
        return reputation;
    }

    public PartyInfo setReputation(int reputation) {
        this.reputation = reputation;
        return this;
    }

    public int getAverageLevel() {
        return averageLevel;
    }

    public PartyInfo setAverageLevel(int averageLevel) {
        this.averageLevel = averageLevel;
        return this;
    }
}
