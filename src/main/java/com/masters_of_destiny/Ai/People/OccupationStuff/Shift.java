package com.masters_of_destiny.Ai.People.OccupationStuff;

/**
 * A shift is a block of time in which there is an expectation to work.
 * Allowed breaks are defined which would be unexpected breaks - not for a meal.
 * This would determine if a player could get a person to leave what they're doing.
 * For example, a person has not taken their max breaks. Player asks for them to follow them
 * for something - an npc will not consider their job in danger if they have a break and guess that
 * the task will not take longer than the allotted max time.
 */
public class Shift {
    public int startHour;
    public int finishHour;
    public int startMin;
    public int finishMin;
    public int maxBreaks;
    public int maxBreakTimeHours;
    public int maxBreakTimeMin;
    public DaysOfWeek shiftDay; // the day of the week in which this shift takes place.
}
