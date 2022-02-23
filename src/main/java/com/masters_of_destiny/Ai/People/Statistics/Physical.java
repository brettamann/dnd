package com.masters_of_destiny.Ai.People.Statistics;

public class Physical {
    public int base; // affects all
    public int quickness; // dodging, blocking, partial boost to crits, initiative, action points
    public int strength; // affects damage of melee weapons, requirements, carrying capacity, str checks
    public int athletics; // movement per turn, acrobatics, climbing, jumping, swimming, etc
    public int constitution;
    /*
        This is not going to be the typical "constitution = hit points".
        I won't have "HP". You can't kill someone by repeatedly punching their toe.
        Instead, constitution affects:
        resistance to poisons, corrosion, bleeding, rot
        Resistance to eating bad food, disease, illness
        pain tolerance, which will be really big for npcs
     */
    public int senses; // all checks related to non-magical senses
    /*
        Helps display items a creature has
        detects stealth
        passive perception
        finding secrets
        partial boost to crits
     */
    public int muscleMemory; // how many special abilities you can know
}
