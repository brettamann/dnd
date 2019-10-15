package com.dnd.DataObjects;

public class PartyMember {
    private String name;
    private int hpMax;
    private int currentHp;
    private int ac;
    private int damageRangeLow;
    private int damageRangeHigh;
    private int toHitBonus;
    private int initiativeBonus;

    public PartyMember(String name, int hpMax, int currentHp, int ac, int damageRangeLow, int damageRangeHigh, int toHitBonus, int initiativeBonus) {
        this.name = name;
        this.hpMax = hpMax;
        this.currentHp = currentHp;
        this.ac = ac;
        this.damageRangeLow = damageRangeLow;
        this.damageRangeHigh = damageRangeHigh;
        this.toHitBonus = toHitBonus;
        this.initiativeBonus = initiativeBonus;
    }

    public PartyMember() {
    }
}
