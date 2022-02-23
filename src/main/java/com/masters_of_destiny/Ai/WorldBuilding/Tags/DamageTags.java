package com.masters_of_destiny.Ai.WorldBuilding.Tags;

/**
 * This will tell certain methods what kind of action CAN be taken with an object, regardless of its purpose
 * For example, a sword can be used to cut, stab, blunt force with the handle, slap with the flat side
 */
public enum DamageTags {
    SHARP,
    POINTED,
    BLUNT,
    CORROSIVE,
    //MAGNETIC, // somehow damaging with magnets? this should probably be a trait of the material
    ELECTRIC,
    STICKY,
    MAGIC,
    SONIC,
    BURNING,
    FREEZING,
    RADIOACTIVE,
    FORCE, // good for shoving
    POISON,
    DISEASE,
    ROT, // necrotic
    DISINTEGRATION, // completely destroys what it hits
    HOLY,
    DEMONIC,
}