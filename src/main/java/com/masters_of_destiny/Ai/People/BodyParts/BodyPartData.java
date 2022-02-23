package com.masters_of_destiny.Ai.People.BodyParts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BodyPartData {
    public List<BodyPart> BodyParts() {
        List<BodyPart> BodyPartData = new ArrayList<BodyPart>((Arrays.asList(
            new BodyPart("Torso", "Chest area", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), 55),
            new BodyPart("Torso", "Chest area", new ArrayList<BodyPartStatuses>(), new ArrayList<BodyPartAbilities>(), new ArrayList<BodyPartTraits>(), 55)
        )));
        return BodyPartData;
    }
}
