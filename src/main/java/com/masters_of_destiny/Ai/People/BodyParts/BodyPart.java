package com.masters_of_destiny.Ai.People.BodyParts;

import com.masters_of_destiny.Ai.Actions.Action;

import java.util.HashMap;
import java.util.List;

public class BodyPart {
    public String name;
    public String description;
    public HashMap<BodyPartStatuses, Object> statuses; // in db, a list of status values
    //public List<BodyPartAbilities> abilities; // connected by uuid in db
    public List<BodyPartTraits> traits; // in db, a list of uuid's of abilities
    public double approxVolumePercentage;
    public BodyPartTypes type;
    public BodyPartTypes upstreamPart; // the part that holds this one (eg finger's upstream is palm)
    public boolean isVital;
    public boolean expectBones; //an arm could have no bone, for example, but SHOULD
    public boolean hasBones; // if expectBones == false, hasBones == false
    public boolean expectFlesh;
    public boolean hasFlesh;
    public Object foreignObject; // Like an arrow in the knee or earring. Something attached/inside. connected by uuid in db
    public boolean canBleed;
    public double approxLength;
    public double approxWidth;
    public double approxDepth;
    public double breakPoint; // how much in % of 180 it can bend in the wrong direction before breaking. tails would be 100, bones more like 2
                    // basically this can be used so a player can say "bend his arm to the limit" and the AI understands that any more and
                    // the arm is going to be broken, and that an arm CAN be broken by bending too much.
    public List<Action> purposeList; // things this part is normally used for. gives the ai an idea of what it should first use for things
                        // and to detect abnormal behavior. is a list of uuid's in the DB
    public String side; // left, right, other, 1/2/3/4/5/6/etc

    public BodyPart(String name, String description, HashMap<BodyPartStatuses, Object> statuses, List<BodyPartAbilities> abilities, List<BodyPartTraits> traits, double approxVolumePercentage, BodyPartTypes type, BodyPartTypes upstreamPart, boolean isVital, boolean expectBones, boolean hasBones, Object foreignObject) {
        this.name = name;
        this.description = description;
        this.statuses = statuses;
        this.abilities = abilities;
        this.traits = traits;
        this.approxVolumePercentage = approxVolumePercentage;
        this.type = type;
        this.upstreamPart = upstreamPart;
        this.isVital = isVital;
        this.expectBones = expectBones;
        this.hasBones = hasBones;
        this.foreignObject = foreignObject;
    }



    //weight would be decided by how much % volume it is of the whole
    //if an arm is 20% the total volume of a 200 lb person, we guess it weighs 40 lbs
//'BodyPart(java.lang.String, java.lang.String, java.util.List<com.dnd.Ai.People.BodyParts.BodyPartStatuses>, java.util.List<com.dnd.Ai.People.BodyParts.BodyPartAbilities>, double)' in 'com.dnd.Ai.People.BodyParts.BodyPart' cannot be applied to '(java.lang.String)'
}
