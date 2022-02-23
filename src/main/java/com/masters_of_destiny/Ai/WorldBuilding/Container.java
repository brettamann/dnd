package com.masters_of_destiny.Ai.WorldBuilding;
import java.util.List;

public class Container {
    public String name; //simple, like "inside of mug"

    // Need to know size to see what can fit inside it
    public double openingLength; //inches
    public double openingWidth; //inches
    public double capacity; //cubic ft

    public List<Object> contents;

}
