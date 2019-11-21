package com.dnd.DataObjects;

public class PartyMember {
    private String name;
    private int hpMax;
    private int currentHp;
    private int ac;

    public PartyMember(String name, int hpMax, int currentHp, int ac, int damageRangeLow, int damageRangeHigh, int toHitBonus, int initiativeBonus, int numberOfAttacks) {
        this.name = name;
        this.hpMax = hpMax;
        this.currentHp = currentHp;
        this.ac = ac;
        this.damageRangeLow = damageRangeLow;
        this.damageRangeHigh = damageRangeHigh;
        this.toHitBonus = toHitBonus;
        this.initiativeBonus = initiativeBonus;
        this.numberOfAttacks = numberOfAttacks;
    }

    private int damageRangeLow;
    private int damageRangeHigh;
    private int toHitBonus;
    private int initiativeBonus;
    private int numberOfAttacks;


    public PartyMember(PartyMember other) {
        this.name = other.name;
        this.hpMax = other.hpMax;
        this.currentHp = other.currentHp;
        this.ac = other.ac;
        this.damageRangeLow = other.damageRangeLow;
        this.damageRangeHigh = other.damageRangeHigh;
        this.toHitBonus = other.toHitBonus;
        this.initiativeBonus = other.initiativeBonus;
        this.numberOfAttacks = other.numberOfAttacks;
    }

    public PartyMember() {
    }

    public String getName() {
        return name;
    }

    public PartyMember setName(String name) {
        this.name = name;
        return this;
    }

    public int getHpMax() {
        return hpMax;
    }

    public PartyMember setHpMax(int hpMax) {
        this.hpMax = hpMax;
        return this;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public PartyMember setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
        return this;
    }

    public int getAc() {
        return ac;
    }

    public PartyMember setAc(int ac) {
        this.ac = ac;
        return this;
    }

    public int getDamageRangeLow() {
        return damageRangeLow;
    }

    public PartyMember setDamageRangeLow(int damageRangeLow) {
        this.damageRangeLow = damageRangeLow;
        return this;
    }

    public int getDamageRangeHigh() {
        return damageRangeHigh;
    }

    public PartyMember setDamageRangeHigh(int damageRangeHigh) {
        this.damageRangeHigh = damageRangeHigh;
        return this;
    }

    public int getToHitBonus() {
        return toHitBonus;
    }

    public PartyMember setToHitBonus(int toHitBonus) {
        this.toHitBonus = toHitBonus;
        return this;
    }

    public int getInitiativeBonus() {
        return initiativeBonus;
    }

    public PartyMember setInitiativeBonus(int initiativeBonus) {
        this.initiativeBonus = initiativeBonus;
        return this;
    }

    public int getNumberOfAttacks() {
        return numberOfAttacks;
    }

    public PartyMember setNumberOfAttacks(int numberOfAttacks) {
        this.numberOfAttacks = numberOfAttacks;
        return this;
    }
}
