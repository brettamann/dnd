package com.masters_of_destiny.DataObjects.Spells;

public class Spell {
    public String name;
    public int level;
    public String school;
    public String castingTime;
    public int range;
    public String components;
    public String duration;
    public String classes;
    public String description;

    public Spell(String name, int level, String school, String castingTime, int range, String components, String duration, String classes, String description) {
        this.name = name;
        this.level = level;
        this.school = school;
        this.castingTime = castingTime;
        this.range = range;
        this.components = components;
        this.duration = duration;
        this.classes = classes;
        this.description = description;
    }

    public Spell(Spell other) {
        this.name = other.name;
        this.level = other.level;
        this.school = other.school;
        this.castingTime = other.castingTime;
        this.range = other.range;
        this.components = other.components;
        this.duration = other.duration;
        this.classes = other.classes;
        this.description = other.description;
    }

    public String getSpellTextForDisplay() {
        return name + ": " + castingTime + ", " + duration + ", " + range + " ft, " + components + ", " + description;
    }
}
