package com.dnd.DataObjects.Items;

import com.dnd.Utilities.Screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Weapon {
    //non-combat
    public String name;
    public String description;
    public int range;
    public int shortRange; //for throwing/missiles
    public int longRange; //for throwing/missiles
    public List<String> type;
    public List<String> abilities;
    public int valuePlatinum;
    public int valueGold;
    public int valueSilver;
    public int valueCopper;
    public String rarity;

    public int toHitBonus;

    //physical
    public int slashingDamageMin;
    public int slashingDamageMax;

    public int bludgeoningDamageMin;
    public int bludgeoningDamageMax;

    public int piercingDamageMin;
    public int piercingDamageMax;

    public int alternateDamageMin;
    public int alternateDamageMax;
    public String alternateDamageType;

    //elemental
    public int acidDamageMin;
    public int acidDamageMax;

    public int coldDamageMin;
    public int coldDamageMax;

    public int fireDamageMin;
    public int fireDamageMax;

    public int forceDamageMin;
    public int forceDamageMax;

    public int lightningDamageMin;
    public int lightningDamageMax;

    public int necroticDamageMin;
    public int necroticDamageMax;

    public int poisonDamageMin;
    public int poisonDamageMax;

    public int psychicDamageMin;
    public int psychicDamageMax;

    public int radiantDamageMin;
    public int radiantDamageMax;

    public int thunderDamageMin;
    public int thunderDamageMax;

    public int toHitFromStats; //this comes from the wielder, not from the weapon but is attached to the weapon for ease of use
    public boolean userIsProficient;
    public int combinedToHitBonus;

    public Weapon(String name, String description, int range, int shortRange, int longRange, List<String> type, List<String> abilities, int valuePlatinum, int valueGold, int valueSilver, int valueCopper, String rarity, int toHitBonus, int slashingDamageMin, int slashingDamageMax, int bludgeoningDamageMin, int bludgeoningDamageMax, int piercingDamageMin, int piercingDamageMax, int alternateDamageMin, int alternateDamageMax, String alternateDamageType, int acidDamageMin, int acidDamageMax, int coldDamageMin, int coldDamageMax, int fireDamageMin, int fireDamageMax, int forceDamageMin, int forceDamageMax, int lightningDamageMin, int lightningDamageMax, int necroticDamageMin, int necroticDamageMax, int poisonDamageMin, int poisonDamageMax, int psychicDamageMin, int psychicDamageMax, int radiantDamageMin, int radiantDamageMax, int thunderDamageMin, int thunderDamageMax, int toHitFromStats, boolean userIsProficient, int combinedToHitBonus) {
        this.name = name;
        this.description = description;
        this.range = range;
        this.shortRange = shortRange;
        this.longRange = longRange;
        this.type = type;
        this.abilities = abilities;
        this.valuePlatinum = valuePlatinum;
        this.valueGold = valueGold;
        this.valueSilver = valueSilver;
        this.valueCopper = valueCopper;
        this.rarity = rarity;
        this.toHitBonus = toHitBonus;
        this.slashingDamageMin = slashingDamageMin;
        this.slashingDamageMax = slashingDamageMax;
        this.bludgeoningDamageMin = bludgeoningDamageMin;
        this.bludgeoningDamageMax = bludgeoningDamageMax;
        this.piercingDamageMin = piercingDamageMin;
        this.piercingDamageMax = piercingDamageMax;
        this.alternateDamageMin = alternateDamageMin;
        this.alternateDamageMax = alternateDamageMax;
        this.alternateDamageType = alternateDamageType;
        this.acidDamageMin = acidDamageMin;
        this.acidDamageMax = acidDamageMax;
        this.coldDamageMin = coldDamageMin;
        this.coldDamageMax = coldDamageMax;
        this.fireDamageMin = fireDamageMin;
        this.fireDamageMax = fireDamageMax;
        this.forceDamageMin = forceDamageMin;
        this.forceDamageMax = forceDamageMax;
        this.lightningDamageMin = lightningDamageMin;
        this.lightningDamageMax = lightningDamageMax;
        this.necroticDamageMin = necroticDamageMin;
        this.necroticDamageMax = necroticDamageMax;
        this.poisonDamageMin = poisonDamageMin;
        this.poisonDamageMax = poisonDamageMax;
        this.psychicDamageMin = psychicDamageMin;
        this.psychicDamageMax = psychicDamageMax;
        this.radiantDamageMin = radiantDamageMin;
        this.radiantDamageMax = radiantDamageMax;
        this.thunderDamageMin = thunderDamageMin;
        this.thunderDamageMax = thunderDamageMax;
        this.toHitFromStats = toHitFromStats;
        this.userIsProficient = userIsProficient;
        this.combinedToHitBonus = combinedToHitBonus;
    }

    public int getTotalUntypedDamageMin() {
        return slashingDamageMin
            + bludgeoningDamageMin
            + piercingDamageMin
            + fireDamageMin
            + coldDamageMin
            + poisonDamageMin
            + psychicDamageMin
            + necroticDamageMin
            + radiantDamageMin
            + lightningDamageMin
            + thunderDamageMin
            + forceDamageMin;
    }

    public int getTotalUntypedDamageMax() {
        return slashingDamageMin
            + slashingDamageMax
            + bludgeoningDamageMax
            + piercingDamageMax
            + fireDamageMax
            + coldDamageMax
            + poisonDamageMax
            + psychicDamageMax
            + necroticDamageMax
            + radiantDamageMax
            + lightningDamageMax
            + thunderDamageMax
            + forceDamageMax;
    }

    public String getMainPhysicalDamageType() {
        if (piercingDamageMax > 0 && piercingDamageMax > bludgeoningDamageMax && piercingDamageMax > slashingDamageMax) {
            return DamageTypes.piercing;
        } else if (bludgeoningDamageMax > 0 && bludgeoningDamageMax > piercingDamageMax && bludgeoningDamageMax > slashingDamageMax) {
            return DamageTypes.bludgeoning;
        } else if (slashingDamageMax > 0 && slashingDamageMax > piercingDamageMax && slashingDamageMax > bludgeoningDamageMax) {
            return DamageTypes.slashing;
        } else {
            return "none";
        }
    }

    public void setPlusLevelEnchantment(int levelEnchantment) {
        toHitBonus = levelEnchantment;
        switch (getMainPhysicalDamageType()) {
            case DamageTypes.piercing:
                piercingDamageMin += levelEnchantment;
                piercingDamageMax += levelEnchantment;
                break;
            case DamageTypes.slashing:
                slashingDamageMin += levelEnchantment;
                slashingDamageMax += levelEnchantment;
                break;
            case DamageTypes.bludgeoning:
                bludgeoningDamageMin += levelEnchantment;
                bludgeoningDamageMax += levelEnchantment;
                break;
            default:
                Screen screen = new Screen();
                screen.print("Looks like a +" + levelEnchantment + " damage enchantment couldn't be applied to " + name);
                break;
        }
    }

    public String returnStringIfHasDamage(String damageType) {
        switch (damageType) {
            case DamageTypes.slashing:
                if (slashingDamageMax > 0) {
                    if (slashingDamageMin == slashingDamageMax) {
                        return slashingDamageMax + " " + DamageTypes.slashing + " damage";
                    } else {
                        return slashingDamageMin + "-" + slashingDamageMax + DamageTypes.slashing + " damage";
                    }
                }
                break;
            case DamageTypes.bludgeoning:
                if (bludgeoningDamageMax > 0) {
                    if (bludgeoningDamageMin == bludgeoningDamageMax) {
                        return bludgeoningDamageMax + " " + DamageTypes.bludgeoning + " damage";
                    } else {
                        return bludgeoningDamageMin + "-" + bludgeoningDamageMax + DamageTypes.bludgeoning + " damage";
                    }
                }
                break;
            case DamageTypes.piercing:
                if (piercingDamageMax > 0) {
                    if (piercingDamageMin == piercingDamageMax) {
                        return piercingDamageMax + " " + DamageTypes.piercing + " damage";
                    } else {
                        return piercingDamageMin + "-" + piercingDamageMax + DamageTypes.piercing + " damage";
                    }
                }
                break;
            case DamageTypes.fire:
                if (fireDamageMax > 0) {
                    if (fireDamageMin == fireDamageMax) {
                        return fireDamageMax + " " + DamageTypes.fire + " damage";
                    } else {
                        return fireDamageMin + "-" + fireDamageMax + DamageTypes.fire + " damage";
                    }
                }
                break;
            case DamageTypes.cold:
                if (coldDamageMax > 0) {
                    if (coldDamageMin == coldDamageMax) {
                        return coldDamageMax + " " + DamageTypes.cold + " damage";
                    } else {
                        return coldDamageMin + "-" + coldDamageMax + DamageTypes.cold + " damage";
                    }
                }
                break;
            case DamageTypes.poison:
                if (poisonDamageMax > 0) {
                    if (poisonDamageMin == poisonDamageMax) {
                        return poisonDamageMax + " " + DamageTypes.poison + " damage";
                    } else {
                        return poisonDamageMin + "-" + poisonDamageMax + DamageTypes.poison + " damage";
                    }
                }
                break;
            case DamageTypes.psychic:
                if (psychicDamageMax > 0) {
                    if (psychicDamageMin == psychicDamageMax) {
                        return psychicDamageMax + " " + DamageTypes.psychic + " damage";
                    } else {
                        return psychicDamageMin + "-" + psychicDamageMax + DamageTypes.psychic + " damage";
                    }
                }
                break;
            case DamageTypes.necrotic:
                if (necroticDamageMax > 0) {
                    if (necroticDamageMin == necroticDamageMax) {
                        return necroticDamageMax + " " + DamageTypes.necrotic + " damage";
                    } else {
                        return necroticDamageMin + "-" + necroticDamageMax + DamageTypes.necrotic + " damage";
                    }
                }
                break;
            case DamageTypes.radiant:
                if (radiantDamageMax > 0) {
                    if (radiantDamageMin == radiantDamageMax) {
                        return radiantDamageMax + " " + DamageTypes.radiant + " damage";
                    } else {
                        return radiantDamageMin + "-" + radiantDamageMax + DamageTypes.radiant + " damage";
                    }
                }
                break;
            case DamageTypes.lightning:
                if (lightningDamageMax > 0) {
                    if (lightningDamageMin == lightningDamageMax) {
                        return lightningDamageMax + " " + DamageTypes.lightning + " damage";
                    } else {
                        return lightningDamageMin + "-" + lightningDamageMax + DamageTypes.lightning + " damage";
                    }
                }
                break;
            case DamageTypes.thunder:
                if (thunderDamageMax > 0) {
                    if (thunderDamageMin == thunderDamageMax) {
                        return thunderDamageMax + " " + DamageTypes.thunder + " damage";
                    } else {
                        return thunderDamageMin + "-" + thunderDamageMax + DamageTypes.thunder + " damage";
                    }
                }
                break;
            case DamageTypes.force:
                if (forceDamageMax > 0) {
                    if (forceDamageMin == forceDamageMax) {
                        return forceDamageMax + " " + DamageTypes.force + " damage";
                    } else {
                        return forceDamageMin + "-" + forceDamageMax + DamageTypes.force + " damage";
                    }
                }
                break;

        }
        return "";
    }

    public String returnStringIfHasDamageNoPhysical(String damageType) {
        switch (damageType) {
            case DamageTypes.fire:
                if (fireDamageMax > 0) {
                    if (fireDamageMin == fireDamageMax) {
                        return fireDamageMax + " " + DamageTypes.fire + " damage";
                    } else {
                        return fireDamageMin + "-" + fireDamageMax + DamageTypes.fire + " damage";
                    }
                }
                break;
            case DamageTypes.cold:
                if (coldDamageMax > 0) {
                    if (coldDamageMin == coldDamageMax) {
                        return coldDamageMax + " " + DamageTypes.cold + " damage";
                    } else {
                        return coldDamageMin + "-" + coldDamageMax + DamageTypes.cold + " damage";
                    }
                }
                break;
            case DamageTypes.poison:
                if (poisonDamageMax > 0) {
                    if (poisonDamageMin == poisonDamageMax) {
                        return poisonDamageMax + " " + DamageTypes.poison + " damage";
                    } else {
                        return poisonDamageMin + "-" + poisonDamageMax + DamageTypes.poison + " damage";
                    }
                }
                break;
            case DamageTypes.psychic:
                if (psychicDamageMax > 0) {
                    if (psychicDamageMin == psychicDamageMax) {
                        return psychicDamageMax + " " + DamageTypes.psychic + " damage";
                    } else {
                        return psychicDamageMin + "-" + psychicDamageMax + DamageTypes.psychic + " damage";
                    }
                }
                break;
            case DamageTypes.necrotic:
                if (necroticDamageMax > 0) {
                    if (necroticDamageMin == necroticDamageMax) {
                        return necroticDamageMax + " " + DamageTypes.necrotic + " damage";
                    } else {
                        return necroticDamageMin + "-" + necroticDamageMax + DamageTypes.necrotic + " damage";
                    }
                }
                break;
            case DamageTypes.radiant:
                if (radiantDamageMax > 0) {
                    if (radiantDamageMin == radiantDamageMax) {
                        return radiantDamageMax + " " + DamageTypes.radiant + " damage";
                    } else {
                        return radiantDamageMin + "-" + radiantDamageMax + DamageTypes.radiant + " damage";
                    }
                }
                break;
            case DamageTypes.lightning:
                if (lightningDamageMax > 0) {
                    if (lightningDamageMin == lightningDamageMax) {
                        return lightningDamageMax + " " + DamageTypes.lightning + " damage";
                    } else {
                        return lightningDamageMin + "-" + lightningDamageMax + DamageTypes.lightning + " damage";
                    }
                }
                break;
            case DamageTypes.thunder:
                if (thunderDamageMax > 0) {
                    if (thunderDamageMin == thunderDamageMax) {
                        return thunderDamageMax + " " + DamageTypes.thunder + " damage";
                    } else {
                        return thunderDamageMin + "-" + thunderDamageMax + DamageTypes.thunder + " damage";
                    }
                }
                break;
            case DamageTypes.force:
                if (forceDamageMax > 0) {
                    if (forceDamageMin == forceDamageMax) {
                        return forceDamageMax + " " + DamageTypes.force + " damage";
                    } else {
                        return forceDamageMin + "-" + forceDamageMax + DamageTypes.force + " damage";
                    }
                }
                break;

        }
        return "";
    }

    public String getDamageForDisplay() {
        String weaponDamageText = "+" + combinedToHitBonus + " to hit, ";
        switch (getMainPhysicalDamageType()) {
            case DamageTypes.piercing:
                weaponDamageText = weaponDamageText + piercingDamageMin + "-" + piercingDamageMax + " " + DamageTypes.piercing + " ";
                break;
            case DamageTypes.slashing:
                weaponDamageText = weaponDamageText + slashingDamageMin + "-" + slashingDamageMax + " " + DamageTypes.slashing + " ";
                break;
            case DamageTypes.bludgeoning:
                weaponDamageText = weaponDamageText + bludgeoningDamageMin + "-" + bludgeoningDamageMax + " " + DamageTypes.bludgeoning + " ";
                break;
            default:
                weaponDamageText = "(No physical damage)";
                break;
        }
        for (int i = 0; i < DamageTypes.damageTypesList.size() - 1; i++) {
            if (!returnStringIfHasDamageNoPhysical(DamageTypes.damageTypesList.get(i)).equals("")) {
                weaponDamageText = weaponDamageText + " + " + returnStringIfHasDamageNoPhysical(DamageTypes.damageTypesList.get(i));
            }
        }
        return weaponDamageText;
    }

    public boolean getIsTwoHanded() {
        for (int i = 0; i < abilities.size() - 1; i++) {
            if (abilities.get(i).equals(WeaponTypes.twoHanded)) {
                return true;
            }
        }
        return false;
    }

    public String getWeaponStatsStringForDisplay() {
        String textToReturn = name + ": " + getDamageForDisplay();
        if (abilities.size() > 0) {
            for (int i = 0; i < abilities.size() - 1; i++) {
                if (!abilities.get(i).equals("")) {
                    textToReturn = textToReturn + "\n\t" + name + " ability " + i + ": " + abilities.get(i);
                }
            }
        }
        return textToReturn;
    }
}
