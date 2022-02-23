package com.masters_of_destiny.Ai.Actions;

import com.masters_of_destiny.Ai.People.BodyParts.BodyPart;
import com.masters_of_destiny.Ai.WorldBuilding.Vector;

import java.util.List;

public class PhysicalMovementAct extends Action {
    public Vector speedDirection; // includes direction and speed
    public boolean disruptive; // Whether it causes the thing to spill/empty/harm
    public double force; // momentum, damage
    public List<BodyPart> partRequirements; // like walking needs 2 legs min, talking requires tongue, breath


    public enum movementType {

    }

    public void execute()
    {

    }
}

/*
How will I tell the action what it's working on? What it's targeting?
it's not at simple as passing in a single object type as I have to many
 */