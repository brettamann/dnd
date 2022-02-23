package com.masters_of_destiny.DataObjects.Items;

public class WeaponTypes {
    public static final String light = "light";
    public static final String loading = "loading"; //Because of the time required to load this weapon, you can fire only one piece of Ammunition from it when you use an action, Bonus Action, or Reaction to fire it, regardless of the number of attacks you can normally make.
    public static final String reach = "reach"; //melee weapon with extra 5 ft range for attacks and attack of opportunity triggers
    public static final String special = "special";
    public static final String thrown = "thrown";
    public static final String twoHanded = "two-handed";
    public static final String versatile = "versatile"; //can be 1 or 2-handed, with differing stats for each
    public static final String improvised = "improvised"; //anything from a fork to a dead goblin. 1d4 damage unless determines as really close to another weapon (like table leg ~= club). also 1d4 to throw a weapon not meant to be thrown. normal range 20 ft, long 60
    public static final String silvered = "silvered"; //(100gp for 10 ammo or 1 weapon) allows it to harm certain creatures
    public static final String lance = "lance"; //2-handed when not mounted, disadvantage when attacking something within 5 ft
    public static final String net = "net"; //creatures large or smaller are restrained until freed. dc 10 str check to free itself or another creature within its reach. net has 5hp and 10 AC
    public static final String finesse = "finesse";
    public static final String ranged = "ranged";
    public static final String ammo = "ranged";
    public static final String unarmed = "unarmed";
    public static final String heavy = "heavy";
    public static final String martial = "martial";
}
