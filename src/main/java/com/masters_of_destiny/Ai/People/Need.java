package com.masters_of_destiny.Ai.People;

public class Need {
    public String name;
    public NeedTypes needType;
    public double amount; // 0-100%, 100 is desperate and 0 is completely satisfied
    public double degenerationFactor; // 1 is normal. Less is something that doesn't need as often, greater is needs more than usual
    public int positionInHierarchy; // 0 is most needed. They can be tied, for instance a fatal injury with no oxygen
}
