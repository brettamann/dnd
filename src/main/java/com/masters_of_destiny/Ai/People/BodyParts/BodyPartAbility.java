package com.masters_of_destiny.Ai.People.BodyParts;

import java.util.List;

// things like echolocation or eel shocks, etc, require multiple components and will be attached to the body as a whole
public class BodyPartAbility {
    // A BodyPartAbility is any ability that requires physical parts to work. A spell requiring force of will doesn't require a body part
    /*
     I'm not sure how I want to do this. actions cover body part abilities, if you connect an action to a body part
     I guess I could list typical purposes for a body part just for narration sake? I dunno...

     */
    /*
    ECHOLOCATION
    ELECTRIC_SHOCK
    FIRE_BREATH
    POISON_STING
    BITE
    EAT
    BREATH

    SIGHT,
    HEARING,
    ESP,
    FEELING, // distinguishing textures, sensing wind
    TASTE, // detect poisons, identify certain substances
    SMELL, // tracking, identifying unseen objects
    VESTIBULAR // coordination when blind
    */
    public String name;
    public String description;
    public String sensitivity; //used for checks, like how echolocation requires much better hearing than normal speech
    public List<BodyPartTypes> requiredParts;
}
