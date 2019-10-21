package com.dnd.DataObjects.Items;

import java.util.ArrayList;
import java.util.Arrays;

public class StandardWeapons {
    //TODO: create a magical weapon class, and a "custom weapon" class for legendaries
    //TODO: finish mapping out the basic weapons https://roll20.net/compendium/dnd5e/Weapons#content
    public static final Weapon unarmed = new Weapon("Unarmed", "Attacks with fist, claw, etc", 5, 0, 0, new ArrayList<>(Arrays.asList(WeaponTypes.light)), new ArrayList<>(Arrays.asList("+ 1 damage for each STR mod")), 0, 0, 0, 0, Rarities.common, 0, 0, 0, 1, 1, 0, 0, 0, 0, "DamageTypes.thing", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0);
    public static final Weapon club = new Weapon("Club","",5,0,0, new ArrayList<>(Arrays.asList(WeaponTypes.light)), new ArrayList<>(Arrays.asList("")),0,0,1,0,Rarities.common,0,0,0,1,4,0,0,0,0,"",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,false,0);
    public static final Weapon dagger = new Weapon("Dagger", "", 5,20,60, new ArrayList<>(Arrays.asList(WeaponTypes.light,WeaponTypes.finesse,WeaponTypes.thrown)), new ArrayList<>(Arrays.asList("")), 0, 2, 0, 0, Rarities.common, 0, 0, 0, 0, 0, 1, 4, 0, 0, "",0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,false,0);
    public static final Weapon greatclub = new Weapon("Greatclub", "", 5, 0, 0, new ArrayList<>(Arrays.asList(WeaponTypes.twoHanded)), new ArrayList<>(Arrays.asList("")), 0, 0, 2, 0, Rarities.common, 0, 0, 0, 1, 8, 0, 0, 0, 0, "",0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,false,0);
    public static final Weapon handaxe = new Weapon("Handaxe", "", 5, 20, 60, new ArrayList<>(Arrays.asList(WeaponTypes.light,WeaponTypes.thrown)), new ArrayList<>(Arrays.asList("")), 0, 5, 0, 0, Rarities.common, 0, 1, 5, 0, 0, 0, 0, 0, 0, "",0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,false,0);
    public static final Weapon javelin = new Weapon("Javelin", "", 5, 30, 120, new ArrayList<>(Arrays.asList(WeaponTypes.thrown)), new ArrayList<>(Arrays.asList("")), 0, 0, 5, 0, Rarities.common, 0, 0, 0, 0, 0, 1, 6, 0, 0, "",0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,false,0);
    public static final Weapon lightHammer = new Weapon("Light Hammer", "", 5, 20, 60, new ArrayList<>(Arrays.asList(WeaponTypes.light,WeaponTypes.thrown)), new ArrayList<>(Arrays.asList("")), 0, 2, 0, 0, Rarities.common, 0, 0, 0, 1, 4, 0, 0, 0, 0, "",0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,false,0);
    public static final Weapon mace = new Weapon("mace", "", 5, 0, 0, new ArrayList<>(Arrays.asList("")), new ArrayList<>(Arrays.asList("")), 0, 5, 0, 0, Rarities.common, 0, 0, 0, 1, 6, 0, 0, 0, 0, "",0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,false,0);
    public static final Weapon quarterstaff = new Weapon("Quarterstaff", "", 5, 0, 0, new ArrayList<>(Arrays.asList(WeaponTypes.versatile)), new ArrayList<>(Arrays.asList("abilities")), 0, 0, 2, 0, Rarities.common, 0, 0, 1, 6, 0, 0, 0, 1, 8, DamageTypes.bludgeoning,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,false,0);
    public static final Weapon sickle = new Weapon("Sickle", "", 5, 0, 0, new ArrayList<>(Arrays.asList(WeaponTypes.light)), new ArrayList<>(Arrays.asList("")), 0, 1, 0, 0, Rarities.common, 0, 1, 4, 0, 0, 0, 0, 0, 0, "DamageTypes.thing", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,false,0);
    //public static final Weapon thing = new Weapon("name","desc",5,0,0, new ArrayList<>(Arrays.asList(WeaponTypes.light)), new ArrayList<>(Arrays.asList(abilities"")),0,0,0,0,Rarities.common,0,0,0,0,0,0,0,0,0,"DamageTypes.thing",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,false,0);
}
