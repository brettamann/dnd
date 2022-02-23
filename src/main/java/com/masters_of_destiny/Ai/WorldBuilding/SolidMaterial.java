package com.masters_of_destiny.Ai.WorldBuilding;

import com.masters_of_destiny.DataObjects.Items.DamageTypes;

import java.util.List;

public class SolidMaterial {
    public String name;
    public String description;

    public double density; // weight per cubic inch
    public double hardness; //mohs scale. Greater than or equal to can scratch it

    public double freezePoint; // degrees at which it will no longer bend without breaking
    public double bendToShatterPoint; //0-100%, amount it can bend before breaking. 100% doesn't break. 0% doesn't bend.
    public boolean isFlammable; // does it burn?
    public double burnMeltPoint; // degrees heat needed to burn or melt
    public double heatWeakness; // % weaker the object gets at max due to heat before melt/burn
    public double iceShatterPoint; // degrees at which it becomes so unstable due to cold that it breaks with minor effort
    public double conductivity; //0-100 % electricity that makes it through object (hitting a held sword with 50% would deal 50% damage to wielder)
    public double magnetism;
    public boolean attractsMagnets;

    public double gasPermeation; //0-100 % how much gas can pass through. A 20mph breeze would feel like 10mph on the other side at 50%
    public double liquidPermeation; //0-100, % how much liquid can pass through &/or remain "soaked up"
    public double soundPermeation; //0-100, % how much sound it blocks if it covers your ears or isolates you from source
    public double lightPermeation; //0-100, % how much light it blocks
    public double radiationPermeation; //0-100, % how much radiation it blocks
    public double heatPermeation; //[-100,100], % how much it resists its temperature being changed
    // ^^^ May need to look into a more scientific way of doing this one

    public double hydroSwelling; // % the object grows when completely soaked by liquid
    public double heatSwelling; // % object grows at maximum due to heat
    public double coldSwelling; // % object grows at maximum due to freezing

    public double buoyancy; // (+/-) any percentage number.
        // This assumes a ball of the material. Shape matters but is not counted here.
        // buoyancy > 0: floats with force that % of weight.
        // buoyancy = 0: neither floats nor sinks, stays where it is in water. Force down == force up.
        // buoyancy < 0: sinks at % rate of gravity

    public double magicResistance; //0-100, % spell resistance.
        //A more rare trait, resists all effects.
        //ex. at 50% res on a 100 lbs object you would need a levitation spell of 200 lbs to lift it.
    public double magicBlocking; //0-100 how much it prevents spells going through it
        //ex. at 50%, a helmet of this material would block 50% magic psychic damage

    public double corrosionResistance; //How resistant it is to acid
    public double corrosionBreakpoint; //amount of acid damage needed to even start dealing damage

    public double cohesionStrength;
        // How much it resists piercing, slashing, shearing, etc
        // AT 1" thickness
    public double cohesionExponent; //the more material, the greater the strength.
        //2 is for every inch it squares its strength
        //ex. a metal has 5 cohesionStrength at 1". at 2" it would have 25, @3=125. at 0.5 it would have squareroot(5)
    public List<DamageTypes> minorWeaknesses; // these deal 50% extra damage
    public List<DamageTypes> majorWeaknesses; // these deal 100% extra damage
}