package com.masters_of_destiny.DataObjects.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DamageTypes {
    public static final String acid = "acid";
    public static final String bludgeoning = "bludgeoning";
    public static final String cold = "cold";
    public static final String fire = "fire";
    public static final String necrotic = "necrotic";
    public static final String force = "force";
    public static final String lightning = "lightning";
    public static final String piercing = "piercing";
    public static final String poison = "poison";
    public static final String psychic = "psychic";
    public static final String radiant = "radiant";
    public static final String slashing = "slashing";
    public static final String thunder = "thunder";

    public static final List<String> damageTypesList = new ArrayList<>(Arrays.asList(acid, bludgeoning, cold, fire, necrotic, force, lightning, piercing, poison, psychic, radiant, slashing, thunder));

}
