package com.masters_of_destiny.Ai.Actions;

import com.masters_of_destiny.Ai.WorldBuilding.Object;

import java.util.List;

public class Action {
    public String name;
    public String description;
    public List<ActionTags> actionTagsList;
    public ActionCost cost;
    public List<Object> requiredObjects;
    public double range; // defines the max origin of the shape
    public double force;
    public double effectiveness;
    public AreaOfEffect shape;
}
/*
How would I represent pushing as opposed to levitating?
I think each action is going to have to be a method, whose method is determined by its type(s)
that are tagged to it... but how do I make it into objects to save code?

 */