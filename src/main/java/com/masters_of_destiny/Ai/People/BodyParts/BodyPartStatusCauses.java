package com.masters_of_destiny.Ai.People.BodyParts;

public enum BodyPartStatusCauses {
    BENIGNOBJECT,
    OLDWOUND, // like a bone that healed wrong
    MAGICALOBJECT,
    SPELL, // or curse, could be temporary or permanent
    AGE,
    FOREIGNOBJECT, //like an arrow to the knee
    BIRTHDEFECT,
    AMPUTATION // all "downstream" parts are gone
}
