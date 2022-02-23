package com.masters_of_destiny.Ai.WorldBuilding;

import com.masters_of_destiny.Ai.Actions.ActionTags;

import java.util.List;

public class Object {
    public String name;
    public String description;
    public List<Container> containers;
    // Containers are any place you could put other objects/substances
    // EX a mug has 1 container, the inside. A coat could have multiple due to pockets
    public List<ActionTags> actionTags; //things that you can do with the object
    public double weight; //lbs
    public double depth; //inches
    public double width; //inches
    public double thickness; //inches
    public double volume; //cubic ft
    public double height;
    public List<MaterialDistribution> materialDistribution; // 10% steel 50% wood, etc
    public double value;
    public List<ObjectTags> damageTypes; // objects aren't meant to be weapons but can be made so depending on traits given here
    public Vector position;
    public Vector movement;
    public Vector rotation;
}

