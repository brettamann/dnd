package com.dnd.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.dnd.DataObjects.*;
import com.dnd.DataObjects.Items.*;
import com.dnd.DataObjects.Races.Races;
import com.dnd.DataObjects.Spells.Spell;
import com.dnd.DataObjects.Spells.StandardSpells;

import javax.swing.text.MaskFormatter;
import java.util.List;

public class RandomGenerator {
    public static int randomIntInRange(int min, int max) {
        //https://www.mkyong.com/java/java-generate-random-integers-in-a-range/
        //this function includes both the max and the min in the range. entering min=3 and max=22 can be any number 3-22
        Random r = new Random();
        try {
            return r.nextInt((max - min) + 1) + min;
        }
        catch (IllegalArgumentException ex){
            return min;
        }
    }

    public static int randomD20Roll(){
        return randomIntInRange(1, 20);
    }

    public double randomDouble() {
        Random r = new Random();
        return r.nextDouble();
    }

    public double randomPercent(double min, double max) {
        return Math.random() * 100;
    }

    public double randomDoubleInRange(double min, double max) {
        double random = new Random().nextDouble();
        return min + (random * (max - min));

    }

    public Location getRandomLocation(List<Location> locationlist) {
        return locationlist.get(randomIntInRange(0, locationlist.size() - 1));
    }

    public String getRandomFromStringList(List<String> stringList) {
        return stringList.get(randomIntInRange(0, stringList.size() - 1));
    }

    public String getRandomRace() {
        List<String> allRaces = new ArrayList<>(Arrays.asList(
                Races.aarakocra,
                Races.aasimar,
                Races.animalHybrid,
                Races.bugbear,
                Races.centaur,
                Races.dragonborn,
                Races.dwarf,
                Races.elephantine,
                Races.elf,
                Races.firbolg,
                Races.genasi,
                Races.gith,
                Races.gnome,
                Races.goliath,
                Races.goblin,
                Races.halfElf,
                Races.halfOrc,
                Races.halfling,
                Races.hobgoblin,
                Races.human,
                Races.kenku,
                Races.kobold,
                Races.lizardfolk,
                Races.minotaur,
                Races.orc,
                Races.tabaxi,
                Races.tiefling,
                Races.triton,
                Races.tortle,
                Races.vedalken,
                Races.yuanTi
        ));
        return getRandomFromStringList(allRaces);
    }

    public String getRandomLanguage() {
        List<String> allLanguages = new ArrayList<>(Arrays.asList(
            Languages.abyssal,
            Languages.aquan,
            Languages.auran,
            Languages.celestial,
            Languages.common,
            Languages.deepSpeech,
            Languages.draconic,
            Languages.druidic,
            Languages.dwarvish,
            Languages.elvish,
            Languages.giant,
            Languages.gnomish,
            Languages.goblin,
            Languages.gnoll,
            Languages.halfling,
            Languages.ignan,
            Languages.infernal,
            Languages.orc,
            Languages.primordial,
            Languages.sylvan,
            Languages.terran,
            Languages.undercommon
        ));
        return getRandomFromStringList(allLanguages);
    }

    public Armor getArmorByEconomyAndTier(String economicClass, int tier) {
        if (tier > 3 || tier <= 0) {
            tier = randomIntInRange(0, 3);
        }
        switch (economicClass) {
            case EconomicClasses.beggar:
                if (tier > 3 || tier <= 0) {
                    tier = randomIntInRange(0, 3);
                }
                switch (tier) {
                    case 1:
                        return new Armor(getBeggarArmorTier1());
                    case 2:
                        return new Armor(getBeggarArmorTier2());
                    case 3:
                        return new Armor(getBeggarArmorTier3());
                    default:
                        return new Armor(getBeggarArmorTier1());
                }
            case EconomicClasses.poor:
                if (tier > 3 || tier <= 0) {
                    tier = randomIntInRange(1, 3);
                }
                switch (tier) {
                    case 1:
                        return new Armor(getPoorArmorTier1());
                    case 2:
                        return new Armor(getPoorArmorTier2());
                    case 3:
                        return new Armor(getPoorArmorTier3());
                    default:
                        return new Armor(getPoorArmorTier1());
                }
            case EconomicClasses.middleClass:
                if (tier > 4 || tier <= 0) {
                    tier = randomIntInRange(1, 4);
                }
                switch (tier) {
                    case 1:
                        return new Armor(getMiddleClassArmorTier1());
                    case 2:
                        return new Armor(getMiddleClassArmorTier2());
                    case 3:
                        return new Armor(getMiddleClassArmorTier3());
                    case 4:
                        return new Armor(getMiddleClassArmorTier4());
                    default:
                        return new Armor(getMiddleClassArmorTier1());
                }
            case EconomicClasses.wealthy:
                if (tier > 5 || tier <= 0) {
                    tier = randomIntInRange(1, 5);
                }
                switch (tier) {
                    case 1:
                        return new Armor(getWealthyArmorTier1());
                    case 2:
                        return new Armor(getWealthyArmorTier2());
                    case 3:
                        return new Armor(getWealthyArmorTier3());
                    case 4:
                        return new Armor(getWealthyArmorTier4());
                    case 5:
                        return new Armor(getWealthyArmorTier5());
                    default:
                        return new Armor(getWealthyArmorTier1());
                }
            default:
                return new Armor(getBeggarArmorTier1());
        }
    }

    public Armor getRandomStandardArmor() {
        List<Armor> standardArmorList = new ArrayList<Armor>(Arrays.asList(
            StandardArmor.padded,
                StandardArmor.leather,
                StandardArmor.studdedLeather,
                StandardArmor.hide,
                StandardArmor.breastplate,
                StandardArmor.chainShirt,
                StandardArmor.halfPlate,
                StandardArmor.chainMail,
                StandardArmor.fullPlate,
                StandardArmor.ringMail,
                StandardArmor.splint
        ));
        return new Armor(standardArmorList.get(randomIntInRange(0, standardArmorList.size() -1)));
    }

    private Armor getBeggarArmorTier1() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
            .add(100, new Armor(StandardArmor.natural));
        return rc.next();
    }

    private Armor getBeggarArmorTier2() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
            .add(50, new Armor(StandardArmor.padded))
            .add(30, new Armor(StandardArmor.leather))
            .add(20, new Armor(StandardArmor.hide));
        return rc.next();
    }

    private Armor getBeggarArmorTier3() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
            .add(50, new Armor(StandardArmor.studdedLeather))
            .add(50, new Armor(StandardArmor.scaleMail));
        return rc.next();
    }

    //TODO: add in weapon and armor data to these classes
    private Armor getPoorArmorTier1() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(100, new Armor(StandardArmor.natural));
        return rc.next();
    }

    private Armor getPoorArmorTier2() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(50, new Armor(StandardArmor.padded))
                .add(30, new Armor(StandardArmor.leather))
                .add(20, new Armor(StandardArmor.hide));
        return rc.next();
    }

    private Armor getPoorArmorTier3() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(50, new Armor(StandardArmor.studdedLeather))
                .add(50, new Armor(StandardArmor.scaleMail));
        return rc.next();
    }

    private Armor getMiddleClassArmorTier1() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(100, new Armor(StandardArmor.natural));
        return rc.next();
    }

    private Armor getMiddleClassArmorTier2() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(50, new Armor(StandardArmor.padded))
                .add(30, new Armor(StandardArmor.leather))
                .add(20, new Armor(StandardArmor.hide));
        return rc.next();
    }

    private Armor getMiddleClassArmorTier3() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(50, new Armor(StandardArmor.studdedLeather))
                .add(50, new Armor(StandardArmor.scaleMail));
        return rc.next();
    }

    private Armor getMiddleClassArmorTier4() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                //.add(50, StandardArmor.studdedLeather)
                //.add(50, StandardArmor.scaleMail)
                .add(10,new Armor(getRandomCustomArmorByTier(randomIntInRange(1,2), randomIntInRange(0,2))));
        return rc.next();
    }

    private Armor getWealthyArmorTier1() {
        RandomCollectionWeighted<Armor> rc = new RandomCollectionWeighted<Armor>()
                .add(25, new Armor(StandardArmor.natural))
                .add(70, new Armor(getRandomStandardArmor()))
                .add(5, new Armor(getRandomCustomArmorByTier(1,0)));
        return rc.next();
    }

    private Armor getWealthyArmorTier2() {
        return new Armor(getRandomCustomArmorByTier(randomIntInRange(1,2),1));
    }

    private Armor getWealthyArmorTier3() {
        return new Armor(getRandomCustomArmorByTier(randomIntInRange(2,3),1));
    }

    private Armor getWealthyArmorTier4() {
        Armor armorToReturn = new Armor(getRandomCustomArmorByTier(randomIntInRange(3,4),2));
        armorToReturn.setPlusEnchantmentByLevel(2);
        armorToReturn.addRandomAbilityByTier(3);
        if (randomIntInRange(1, 100) <= 50) {
            armorToReturn.addRandomAbilityByTier(2);
        }
        if (randomIntInRange(1, 100) <= 25) {
            armorToReturn.addRandomAbilityByTier(1);
        }
        return armorToReturn;
    }

    private Armor getWealthyArmorTier5() {
        return new Armor(getRandomCustomArmorByTier(5, 3));
    }

    public String getRandomArmorAbilityByTier(int tier) {
        switch (tier) {
            case 1:
                return getRandomArmorAbilityTier1();
            case 2:
                return getRandomArmorAbilityTier2();
            case 3:
                return getRandomArmorAbilityTier3();
            case 4:
                return getRandomArmorAbilityTier4();
            case 5:
                return getRandomArmorAbilityTier5();
        }
        return getRandomArmorAbilityTier1();
    }

    public Armor getRandomCustomArmorByTier(int tier, int enchantmentLevel) {
        Armor armorToReturn = new Armor(getRandomStandardArmor());
        armorToReturn.setPlusEnchantmentByLevel(enchantmentLevel);
        armorToReturn.abilities.add(getRandomArmorAbilityByTier(tier));
        if (tier >= 3) { //tier 3 gets 2 enchantments, 4 gets 3, 5 gets 4
            for (int i = 0; i < tier - 2; i++) {
                armorToReturn.abilities.add(getRandomArmorAbilityByTier(i));
            }
        }
        armorToReturn.setPlusEnchantmentByLevel(tier);
        return armorToReturn;
    }


    private String getRandomArmorAbilityTier1() {
        List<String> armorAbilityList = new ArrayList<>(Arrays.asList(
            "Wearer is resistant to " + getRandomDamageType() + "and is vulnerable to " + getRandomDamageType() + " and " + getRandomDamageType() + ".",
            "Advantage on all saving throws while wearing this armor, but movement is reduced by " + (randomIntInRange(3,5) * 5) + ", weight is increased by 100, and wearer cannot make bonus actions",
            "Reduces all damage received by the wearer by " + randomIntInRange(1,1),
            "Increases the wearer's speed by " + (randomIntInRange(1,1) * 5) + "and decreases the wearer's AC by " + randomIntInRange(2,4),
            "Teleports the wearer " + (randomIntInRange(1,2) * 5) + " feet in a straight line in a random direction when the wearer takes damage, " + randomIntInRange(1, 3) + " times per long rest",
            "Grants darkvision up to 60 ft to the wearer",
            "The worn armor weighs 1/4 its normal weight",
            "Increases the wearer's " + getRandomSecondarySkill() + " by " + randomIntInRange(1,2),
            "Increases the wearer's " + getRandomPrimarySkill() + " by " + randomIntInRange(1,1) + "and decreases the wearer's " + getRandomPrimarySkill() + " by " + randomIntInRange(2,4),
            "Increases the wearer's passive perception by " + randomIntInRange(1,3),
            "Increases the wearer's " + getRandomSecondarySkill() + " by " + randomIntInRange(1, 4) + "and decreases the wearer's " + getRandomSecondarySkill() + " by " + randomIntInRange(2, 5),
            "Critical hits against the wearer deal no extra damage (normal damage still applies), and when the wearer would make a critical hit it does no damage at all instead (normal damage is also negated).",
            "The wearer has 1 extra level " + randomIntInRange(1,2) + " spell slot",
            "The wearer may make " + randomIntInRange(1,2) + "extra bonus actions during a single turn, " + randomIntInRange(1,2) + " times per long rest",
            "When the wearer would be teleported or would change planes, the spell instead has no effect if the wearer succeeds in a WIS saving throw DC " + randomIntInRange(15,30),
            "The wearer has disadvantage on all saves and checks, and all checks made against the wearer do so at -" + randomIntInRange(1,4),
            "The wearer automatically fails all " + getRandomSecondarySkill() + " checks but makes " + getRandomSecondarySkill() + " checks with +" + randomIntInRange(1,5),
            randomIntInRange(1,2) + " of all non-physical damage is reflected back at its source.",
            randomIntInRange(1,2) + " times per long rest the wearer may redirect a physical projectile at its source (using that same attack roll)",
            randomIntInRange(1,2) + " times per long rest the wearer may for a bonus action go under a 1st level Sanctuary spell for 1 round. The WIS saving throw DC is " + randomIntInRange(8,15),
            randomIntInRange(1,2) + " times per long rest the wearer may teleport " + (randomIntInRange(1,1) * 5) + " ft in any unobstructed direction the wearer can see for a bonus action",
            "If the wearer would be targeted by non-damaging spell (eg stun, command, dominate person, etc) the wearer may lose half their current hp to cancel that spell, plus " + randomIntInRange(10,25),
            "If the wearer would be knocked unconscious, the wearer teleports up to " + (randomIntInRange(1,3) * 5) + " ft in a straight line towards the nearest allied creature",
            "The wearer can lose " + randomIntInRange(10, 30) + " hp to treat a 5 ft of movement through rough terrain as if it were not rough terrain.",
            "The wearer can swim with +" + (randomIntInRange(1, 3) * 5) + " speed",
            "The wearer can fly with +" + (randomIntInRange(1, 3) * 5) + " speed if he or she capable of flight",
            "The wearer may cause a critical fail to be rerolled. If that reroll is 5 or less, the wearer takes " + randomIntInRange(25,50) + " untyped damage, for which there can be no save.",
            "The wearer may reroll any check or save they make, once. If any dice in the reroll results in 8 or less, the wearer takes " + randomIntInRange(40, 100) + " untyped damage, for which there can be no save.",
            "The wearer loses " + randomIntInRange(8,12) + " hp every time the wearer rolls a dice, for each dice rolled, but gains +" + randomIntInRange(2,6) + " to all rolls the wearer makes",
            "The wearer cannot make critical fails or successes. Each is counted as if it were simply a 1 or a 20.",
            "The wearer cannot make attacks of opportunity, but has +1 AC when within " + (randomIntInRange(1,2) * 5) + " ft of at least " + randomIntInRange(2,4) + " opponents.",
            "The wearer cannot be the target of attacks of opportunity but has -" + randomIntInRange(2,5) + " AC",
            "The wearer gains +1 AC and -" + randomIntInRange(2,4) + " to hit",
            "The wearer gains +1 to hit and -1 AC for each opponent within " + (randomIntInRange(1,1) * 5) + " ft (max 3)",
            "The wearer gains -1 to hit and +1 AC for each opponent within " + (randomIntInRange(1,1) * 5) + " ft (max 3)",
            "The wearer gains +" + randomIntInRange(1, 2) + " on all checks against members of the wearer's race",
            "The wearer gains +" + randomIntInRange(1, 2) + " on all saves against members of the wearer's race",
            "The wearer gains +" + randomIntInRange(1, 3) + " on all checks against members of the " + getRandomRace() + " race and -" + randomIntInRange(1, 3) + " on all checks against members of the " + getRandomRace() + " race",
            "The wearer gains +" + randomIntInRange(1, 3) + " on all saves against members of the " + getRandomRace() + " race and -" + randomIntInRange(1, 3) + " on all saves against members of the " + getRandomRace() + " race",
            "The wearer deals an extra " + randomIntInRange(1, 3) + " untyped damage whenever damaging members of the " + getRandomRace() + " race"
        ));
        return armorAbilityList.get(randomIntInRange(0,armorAbilityList.size() - 1));
    }

    private String getRandomArmorAbilityTier2() {
        List<String> armorAbilityList = new ArrayList<>(Arrays.asList(
                "Wearer is resistant to " + getRandomDamageType() + "and is vulnerable to " + getRandomDamageType() + " and " + getRandomDamageType() + ".",
                "Advantage on all saving throws while wearing this armor, but movement is reduced by " + (randomIntInRange(2, 5) * 5) + ", weight is increased by 100, and wearer cannot make bonus actions",
                "Reduces all damage received by the wearer by " + randomIntInRange(1, 3),
                "Increases the wearer's speed by " + (randomIntInRange(1, 2) * 5) + "and decreases the wearer's AC by " + randomIntInRange(2, 3),
                "Teleports the wearer " + (randomIntInRange(1, 3) * 5) + " feet in a straight line in a random direction when the wearer takes damage, " + randomIntInRange(1, 3) + " times per long rest",
                "Grants darkvision up to 60 ft to the wearer",
                "The worn armor weighs 1/4 its normal weight",
                "Increases the wearer's " + getRandomSecondarySkill() + " by " + randomIntInRange(1, 3),
                "Increases the wearer's " + getRandomPrimarySkill() + " by " + randomIntInRange(1, 2) + "and decreases the wearer's " + getRandomPrimarySkill() + " by " + randomIntInRange(1, 3),
                "Increases the wearer's passive perception by " + randomIntInRange(2, 4),
                "Increases the wearer's " + getRandomSecondarySkill() + " by " + randomIntInRange(1, 4) + "and decreases the wearer's " + getRandomSecondarySkill() + " by " + randomIntInRange(1, 4),
                "Critical hits against the wearer deal no extra damage (normal damage still applies), and when the wearer would make a critical hit it does no damage at all instead (normal damage is also negated).",
                "The wearer has 1 extra level " + randomIntInRange(1, 3) + " spell slot",
                "The wearer may make " + randomIntInRange(1, 3) + "extra bonus actions during a single turn, " + randomIntInRange(1, 3) + " times per long rest",
                "When the wearer would be teleported or would change planes, the spell instead has no effect if the wearer succeeds in a WIS saving throw DC " + randomIntInRange(13, 26),
                "The wearer has disadvantage on all saves and checks, and all checks made against the wearer do so at -" + randomIntInRange(2, 5),
                "The wearer automatically fails all " + getRandomSecondarySkill() + " checks but makes " + getRandomSecondarySkill() + " checks with +" + randomIntInRange(2, 6),
                randomIntInRange(2, 3) + " of all non-physical damage is reflected back at its source.",
                randomIntInRange(1, 3) + " times per long rest the wearer may redirect a physical projectile at its source (using that same attack roll)",
                randomIntInRange(1, 3) + " times per long rest the wearer may for a bonus action go under a 1st level Sanctuary spell for 1 round. The WIS saving throw DC is " + randomIntInRange(10, 17),
                randomIntInRange(1, 3) + " times per long rest the wearer may teleport " + (randomIntInRange(1, 2) * 5) + " ft in any unobstructed direction the wearer can see for a bonus action",
                "If the wearer would be targeted by non-damaging spell (eg stun, command, dominate person, etc) the wearer may lose half their current hp to cancel that spell, plus " + randomIntInRange(5, 15),
                "If the wearer would be knocked unconscious, the wearer teleports up to " + (randomIntInRange(2, 4) * 5) + " ft in a straight line towards the nearest allied creature",
                "The wearer can lose " + randomIntInRange(7, 25) + " hp to treat a 5 ft of movement through rough terrain as if it were not rough terrain.",
                "The wearer can swim with +" + (randomIntInRange(2, 4) * 5) + " speed",
                "The wearer can fly with +" + (randomIntInRange(2, 4) * 5) + " speed if he or she capable of flight",
                "The wearer may cause a critical fail to be rerolled. If that reroll is 5 or less, the wearer takes " + randomIntInRange(20, 40) + " untyped damage, for which there can be no save.",
                "The wearer may reroll any check or save they make, once. If any dice in the reroll results in 8 or less, the wearer takes " + randomIntInRange(30, 80) + " untyped damage, for which there can be no save.",
                "The wearer loses " + randomIntInRange(6, 10) + " hp every time the wearer rolls a dice, for each dice rolled, but gains +" + randomIntInRange(2, 7) + " to all rolls the wearer makes",
                "The wearer cannot make critical fails or successes. Each is counted as if it were simply a 1 or a 20.",
                "The wearer cannot make attacks of opportunity, but has +1 AC when within " + (randomIntInRange(1, 3) * 5) + " ft of at least " + randomIntInRange(1, 4) + " opponents.",
                "The wearer cannot be the target of attacks of opportunity but has -" + randomIntInRange(2, 4) + " AC",
                "The wearer gains +1 AC and -" + randomIntInRange(1, 4) + " to hit",
                "The wearer gains +1 to hit and -1 AC for each opponent within " + (randomIntInRange(1, 2) * 5) + " ft (max 4)",
                "The wearer gains -1 to hit and +1 AC for each opponent within " + (randomIntInRange(1, 2) * 5) + " ft (max 4)",
                "The wearer gains +" + randomIntInRange(1, 3) + " on all checks against members of the wearer's race",
                "The wearer gains +" + randomIntInRange(1, 3) + " on all saves against members of the wearer's race",
                "The wearer gains +" + randomIntInRange(1, 4) + " on all checks against members of the " + getRandomRace() + " race and -" + randomIntInRange(1, 3) + " on all checks against members of the " + getRandomRace() + " race",
                "The wearer gains +" + randomIntInRange(1, 4) + " on all saves against members of the " + getRandomRace() + " race and -" + randomIntInRange(1, 3) + " on all saves against members of the " + getRandomRace() + " race",
                "The wearer deals an extra " + randomIntInRange(2, 5) + " untyped damage whenever damaging members of the " + getRandomRace() + " race"
        ));
        return armorAbilityList.get(randomIntInRange(0, armorAbilityList.size() - 1));
    }

    private String getRandomArmorAbilityTier3() {
        List<String> armorAbilityList = new ArrayList<>(Arrays.asList(
                "Wearer is resistant to " + getRandomDamageType() + "and is vulnerable to " + getRandomDamageType() ,
                "Advantage on all saving throws while wearing this armor, but movement is reduced by " + (randomIntInRange(1, 4) * 5) + ", weight is increased by 100, and wearer cannot make bonus actions",
                "Reduces all damage received by the wearer by " + randomIntInRange(1, 4),
                "Increases the wearer's speed by " + (randomIntInRange(1, 3) * 5) + "and decreases the wearer's AC by " + randomIntInRange(1, 3),
                "Teleports the wearer " + (randomIntInRange(2, 4) * 5) + " feet in a straight line in a random direction when the wearer takes damage, " + randomIntInRange(1, 4) + " times per long rest",
                "Grants darkvision up to 60 ft to the wearer",
                "The worn armor weighs 1/4 its normal weight",
                "Increases the wearer's " + getRandomSecondarySkill() + " by " + randomIntInRange(2, 4),
                "Increases the wearer's " + getRandomPrimarySkill() + " by " + randomIntInRange(2, 3) + "and decreases the wearer's " + getRandomPrimarySkill() + " by " + randomIntInRange(1, 2),
                "Increases the wearer's passive perception by " + randomIntInRange(3, 5),
                "Increases the wearer's " + getRandomSecondarySkill() + " by " + randomIntInRange(2, 7) + "and decreases the wearer's " + getRandomSecondarySkill() + " by " + randomIntInRange(1, 3),
                "Critical hits against the wearer deal no extra damage (normal damage still applies), and when the wearer would make a critical hit it does no damage at all instead (normal damage is also negated).",
                "The wearer has " + randomIntInRange(1,3) + " extra level " + randomIntInRange(2, 5) + " spell slot(s)",
                "The wearer may make " + randomIntInRange(2, 4) + "extra bonus actions during a single turn, " + randomIntInRange(1, 3) + " times per long rest",
                "When the wearer would be teleported or would change planes, the spell instead has no effect if the wearer succeeds in a WIS saving throw DC " + randomIntInRange(12, 22),
                "The wearer has disadvantage on all saves and checks, and all checks made against the wearer do so at -" + randomIntInRange(3, 6),
                "The wearer automatically fails all " + getRandomSecondarySkill() + " checks but makes " + getRandomSecondarySkill() + " checks with +" + randomIntInRange(3, 8),
                randomIntInRange(3, 4) + " of all non-physical damage is reflected back at its source.",
                randomIntInRange(1, 4) + " times per long rest the wearer may redirect a physical projectile at its source (using that same attack roll)",
                randomIntInRange(1, 3) + " times per long rest the wearer may for a bonus action go under a 1st level Sanctuary spell for 1 round. The WIS saving throw DC is " + randomIntInRange(12, 20),
                randomIntInRange(1, 3) + " times per long rest the wearer may teleport " + (randomIntInRange(2, 5) * 5) + " ft in any unobstructed direction the wearer can see for a bonus action",
                "If the wearer would be targeted by non-damaging spell (eg stun, command, dominate person, etc) the wearer may lose half their current hp to cancel that spell, plus " + randomIntInRange(5, 15),
                "If the wearer would be knocked unconscious, the wearer teleports up to " + (randomIntInRange(3, 5) * 5) + " ft in a straight line towards the nearest allied creature",
                "The wearer can lose " + randomIntInRange(6, 20) + " hp to treat a 5 ft of movement through rough terrain as if it were not rough terrain.",
                "The wearer can swim with +" + (randomIntInRange(3, 6) * 5) + " speed",
                "The wearer can fly with +" + (randomIntInRange(3, 6) * 5) + " speed if he or she capable of flight",
                "The wearer may cause a critical fail to be rerolled. If that reroll is 5 or less, the wearer takes " + randomIntInRange(15, 30) + " untyped damage, for which there can be no save.",
                "The wearer may reroll any check or save they make, once. If any dice in the reroll results in 8 or less, the wearer takes " + randomIntInRange(25, 60) + " untyped damage, for which there can be no save.",
                "The wearer loses " + randomIntInRange(5, 9) + " hp every time the wearer rolls a dice, for each dice rolled, but gains +" + randomIntInRange(3, 8) + " to all rolls the wearer makes",
                "The wearer cannot make critical fails or successes. Each is counted as if it were simply a 1 or a 20.",
                "The wearer cannot make attacks of opportunity, but has +1 AC when within " + (randomIntInRange(2, 4) * 5) + " ft of at least " + randomIntInRange(1, 3) + " opponents.",
                "The wearer cannot be the target of attacks of opportunity but has -" + randomIntInRange(2, 3) + " AC",
                "The wearer gains +1 AC and -" + randomIntInRange(1, 4) + " to hit",
                "The wearer gains +1 to hit and -1 AC for each opponent within " + (randomIntInRange(1, 3) * 5) + " ft (max 5)",
                "The wearer gains -1 to hit and +1 AC for each opponent within " + (randomIntInRange(1, 3) * 5) + " ft (max 5)",
                "The wearer gains +" + randomIntInRange(2, 4) + " on all checks against members of the wearer's race",
                "The wearer gains +" + randomIntInRange(2, 4) + " on all saves against members of the wearer's race",
                "The wearer gains +" + randomIntInRange(3, 7) + " on all checks against members of the " + getRandomRace() + " race and -" + randomIntInRange(0, 3) + " on all checks against members of the " + getRandomRace() + " race",
                "The wearer gains +" + randomIntInRange(3, 7) + " on all saves against members of the " + getRandomRace() + " race and -" + randomIntInRange(0, 3) + " on all saves against members of the " + getRandomRace() + " race",
                "The wearer deals an extra " + randomIntInRange(3, 6) + " untyped damage whenever damaging members of the " + getRandomRace() + " race"
        ));
        return armorAbilityList.get(randomIntInRange(0, armorAbilityList.size() - 1));
    }

    private String getRandomArmorAbilityTier4() {
        List<String> armorAbilityList = new ArrayList<>(Arrays.asList(
                "Wearer is resistant to " + getRandomDamageType() + "and is vulnerable to " + getRandomDamageType(),
                "Advantage on all saving throws while wearing this armor, but movement is reduced by " + (randomIntInRange(1, 3) * 5) + ", weight is increased by 100, and wearer cannot make bonus actions",
                "Reduces all damage received by the wearer by " + randomIntInRange(2, 5),
                "Increases the wearer's speed by " + (randomIntInRange(2, 3) * 5) + "and decreases the wearer's AC by " + randomIntInRange(1, 2),
                "Teleports the wearer " + (randomIntInRange(2, 5) * 5) + " feet in a straight line in a random direction when the wearer takes damage, " + randomIntInRange(2, 5) + " times per long rest",
                "Grants darkvision up to 60 ft to the wearer",
                "The worn armor weighs 1/4 its normal weight",
                "Increases the wearer's " + getRandomSecondarySkill() + " by " + randomIntInRange(3, 6),
                "Increases the wearer's " + getRandomPrimarySkill() + " by " + randomIntInRange(2, 4) + "and decreases the wearer's " + getRandomPrimarySkill() + " by " + randomIntInRange(1, 2),
                "Increases the wearer's passive perception by " + randomIntInRange(4, 7),
                "Increases the wearer's " + getRandomSecondarySkill() + " by " + randomIntInRange(4, 8) + "and decreases the wearer's " + getRandomSecondarySkill() + " by " + randomIntInRange(1, 2),
                "Critical hits against the wearer deal no extra damage (normal damage still applies), and when the wearer would make a critical hit it does no damage at all instead (normal damage is also negated).",
                "The wearer has " + randomIntInRange(2, 4) + " extra level " + randomIntInRange(3, 8) + " spell slot(s)",
                "The wearer may make " + randomIntInRange(2, 4) + "extra bonus actions during a single turn, " + randomIntInRange(2, 4) + " times per long rest",
                "When the wearer would be teleported or would change planes due to a targeted spell, the spell instead has no effect if the wearer succeeds in a WIS saving throw DC " + randomIntInRange(10, 20),
                "The wearer has disadvantage on all saves and checks, and all checks made against the wearer do so at -" + randomIntInRange(4, 7),
                "The wearer automatically fails all " + getRandomSecondarySkill() + " checks but makes " + getRandomSecondarySkill() + " checks with +" + randomIntInRange(4, 9),
                randomIntInRange(4, 5) + " of all non-physical damage is reflected back at its source.",
                randomIntInRange(2, 4) + " times per long rest the wearer may redirect a physical projectile at its source (using that same attack roll)",
                randomIntInRange(2, 4) + " times per long rest the wearer may for a bonus action go under a 1st level Sanctuary spell for 1 round. The WIS saving throw DC is " + randomIntInRange(15, 24),
                randomIntInRange(2, 4) + " times per long rest the wearer may teleport " + (randomIntInRange(3, 6) * 5) + " ft in any unobstructed direction the wearer can see for a bonus action",
                "If the wearer would be targeted by non-damaging spell (eg stun, command, dominate person, etc) the wearer may lose half their current hp to cancel that spell, plus " + randomIntInRange(4, 10),
                "If the wearer would be knocked unconscious, the wearer teleports up to " + (randomIntInRange(4, 6) * 5) + " ft in a straight line towards the nearest allied creature",
                "The wearer can lose " + randomIntInRange(5, 15) + " hp to treat a 5 ft of movement through rough terrain as if it were not rough terrain.",
                "The wearer can swim with +" + (randomIntInRange(4, 6) * 5) + " speed",
                "The wearer can fly with +" + (randomIntInRange(4, 6) * 5) + " speed if he or she capable of flight",
                "The wearer may cause a critical fail to be rerolled. If that reroll is 5 or less, the wearer takes " + randomIntInRange(10, 25) + " untyped damage, for which there can be no save.",
                "The wearer may reroll any check or save they make, once. If any dice in the reroll results in 8 or less, the wearer takes " + randomIntInRange(20, 45) + " untyped damage, for which there can be no save.",
                "The wearer loses " + randomIntInRange(4, 8) + " hp every time the wearer rolls a dice, for each dice rolled, but gains +" + randomIntInRange(4, 9) + " to all rolls the wearer makes",
                "The wearer cannot make critical fails or successes. Each is counted as if it were simply a 1 or a 20.",
                "The wearer cannot make attacks of opportunity, but has +1 AC when within " + (randomIntInRange(3, 5) * 5) + " ft of at least " + randomIntInRange(1, 2) + " opponents.",
                "The wearer cannot be the target of attacks of opportunity but has -" + randomIntInRange(1, 2) + " AC",
                "The wearer gains +1 AC and -" + randomIntInRange(1, 3) + " to hit",
                "The wearer gains +1 to hit and -1 AC for each opponent within " + (randomIntInRange(2, 4) * 5) + " ft (max 6)",
                "The wearer gains -1 to hit and +1 AC for each opponent within " + (randomIntInRange(2, 4) * 5) + " ft (max 6)",
                "The wearer gains +" + randomIntInRange(3, 5) + " on all checks against members of the wearer's race",
                "The wearer gains +" + randomIntInRange(3, 5) + " on all saves against members of the wearer's race",
                "The wearer gains +" + randomIntInRange(4, 8) + " on all checks against members of the " + getRandomRace() + " race and -" + randomIntInRange(0, 2) + " on all checks against members of the " + getRandomRace() + " race",
                "The wearer gains +" + randomIntInRange(4, 8) + " on all saves against members of the " + getRandomRace() + " race and -" + randomIntInRange(0, 2) + " on all saves against members of the " + getRandomRace() + " race",
                "The wearer deals an extra " + randomIntInRange(4, 8) + " untyped damage whenever damaging members of the " + getRandomRace() + " race"
        ));
        return armorAbilityList.get(randomIntInRange(0, armorAbilityList.size() - 1));
    }

    private String getRandomArmorAbilityTier5() {
        List<String> armorAbilityList = new ArrayList<>(Arrays.asList(
                "Wearer is resistant to " + getRandomDamageType(),
                "Advantage on all saving throws while wearing this armor, but movement is reduced by " + (randomIntInRange(1, 2) * 5) + ", weight is increased by 25,",
                "Reduces all damage received by the wearer by " + randomIntInRange(3, 6),
                "Increases the wearer's speed by " + (randomIntInRange(2, 3) * 5) + "and decreases the wearer's AC by " + randomIntInRange(1, 1),
                "Teleports the wearer " + (randomIntInRange(3, 6) * 5) + " feet in a straight line in a random direction when the wearer takes damage, " + randomIntInRange(3, 5) + " times per long rest",
                "Increases the wearer's " + getRandomSecondarySkill() + " by " + randomIntInRange(4, 7),
                "Increases the wearer's " + getRandomPrimarySkill() + " by " + randomIntInRange(2, 4) + "and decreases the wearer's " + getRandomPrimarySkill() + " by " + randomIntInRange(1, 1),
                "Increases the wearer's passive perception by " + randomIntInRange(5, 8),
                "Increases the wearer's " + getRandomSecondarySkill() + " by " + randomIntInRange(5, 9),
                "Critical hits against the wearer or made by the wearer deal no extra damage (normal damage still applies)",
                "The wearer has " + randomIntInRange(2, 4) + " extra level " + randomIntInRange(1, 9) + " spell slot(s)",
                "The wearer may make " + randomIntInRange(3, 5) + "extra bonus actions during a single turn, " + randomIntInRange(2, 4) + " times per long rest",
                "When the wearer would be teleported or would change planes due to a targeted spell, the spell instead has no effect if the wearer succeeds in a WIS saving throw DC " + randomIntInRange(9, 17),
                "The wearer has disadvantage on all saves and checks, and all checks made against the wearer do so at -" + randomIntInRange(5, 8),
                "The wearer automatically fails all " + getRandomSecondarySkill() + " checks but makes " + getRandomSecondarySkill() + " checks with +" + randomIntInRange(5, 10),
                randomIntInRange(5, 6) + " of all non-physical damage is reflected back at its source.",
                randomIntInRange(2, 4) + " times per long rest the wearer may redirect a physical projectile at its source (using that same attack roll but with +" + randomIntInRange(2,6) + ")",
                randomIntInRange(2, 4) + " times per long rest the wearer may for a bonus action go under a 1st level Sanctuary spell for 1 round. The WIS saving throw DC is " + randomIntInRange(18, 30),
                randomIntInRange(2, 4) + " times per long rest the wearer may teleport " + (randomIntInRange(4, 7) * 5) + " ft in any unobstructed direction the wearer can see for a bonus action",
                "If the wearer would be targeted by a non-damaging spell (eg stun, command, dominate person, etc) the wearer may lose half their current hp to cancel that spell, plus " + randomIntInRange(3, 5),
                "If the wearer is knocked unconscious, the wearer teleports up to " + (randomIntInRange(4, 6) * 5) + " ft in a straight line towards the nearest allied creature",
                "The wearer can lose " + randomIntInRange(4, 10) + " hp to treat 5 ft of movement through rough terrain as if it were not rough terrain.",
                "The wearer can swim with +" + (randomIntInRange(5, 6) * 5) + " speed",
                "The wearer can fly with +" + (randomIntInRange(5, 6) * 5) + " speed if he or she is capable of flight",
                "The wearer may cause a critical fail to be rerolled. If that reroll is 5 or less, the wearer takes " + randomIntInRange(9, 18) + " untyped damage, for which there can be no save.",
                "The wearer may reroll any check or save they make, once. If any dice in the reroll results in 8 or less, the wearer takes " + randomIntInRange(15, 30) + " untyped damage, for which there can be no save.",
                "The wearer loses " + randomIntInRange(3, 7) + " hp every time the wearer rolls a dice, for each dice rolled, but gains +" + randomIntInRange(5, 9) + " to all rolls the wearer makes",
                "The wearer cannot make critical fails or successes. Each is counted as if it were simply a 1 or a 20.",
                "The wearer cannot make attacks of opportunity, but has +" + randomIntInRange(1,2) + " AC when within " + (randomIntInRange(4, 5) * 5) + " ft of at least " + randomIntInRange(1, 1) + " opponent.",
                "The wearer cannot be the target of attacks of opportunity but has -" + randomIntInRange(1, 1) + " AC",
                "The wearer gains +1 AC and -" + randomIntInRange(1, 2) + " to hit",
                "The wearer gains +1 to hit and -1 AC for each opponent within " + (randomIntInRange(2, 5) * 5) + " ft (max 8)",
                "The wearer gains -1 to hit and +1 AC for each opponent within " + (randomIntInRange(2, 5) * 5) + " ft (max 8)",
                "The wearer gains +" + randomIntInRange(4, 6) + " on all checks against members of the wearer's race",
                "The wearer gains +" + randomIntInRange(4, 6) + " on all saves against members of the wearer's race",
                "The wearer gains +" + randomIntInRange(6, 8) + " on all checks against members of the " + getRandomRace() + " race and -" + randomIntInRange(1, 2) + " on all checks against members of the " + getRandomRace() + " race",
                "The wearer gains +" + randomIntInRange(6, 8) + " on all saves against members of the " + getRandomRace() + " race and -" + randomIntInRange(1, 2) + " on all saves against members of the " + getRandomRace() + " race",
                "The wearer deals an extra " + randomIntInRange(5, 10) + " untyped damage whenever damaging members of the " + getRandomRace() + " race",
                "The wearer gains +" + randomIntInRange(1,2) + " to hit",
                "When the wearer's hp would be reduced to 0, the wearer may make a CON save DC " + randomIntInRange(20,30) + " to be reduced to 1 instead",
                "The wearer gains +" + randomIntInRange(2,4) + " to all " + getRandomPrimarySkill() + " saves",
                randomIntInRange(2,4) + " times per long rest the wearer may stand up from prone without expending half their movement",
                "The wearer has advantage against all sleep and charm effects",
                "If the wearer would have an advantage roll, roll 3 dice instead of 2",
                randomIntInRange(1,3) + " times per long rest the wearer may escape or dispel an effect which prevents the wearer from moving, such as binding ropes falling off, a net coming untied, a stun or banishment spell being dispelled, etc",
                "The wearer always knows when someone who is speaking to the wearer specifically (must be verbal) is lying",
                "Persuasion checks against the wearer do so at -" + randomIntInRange(4,10),
                "Intimidation checks against the wearer do so at -" + randomIntInRange(4, 10),
                "Sleight of Hand checks against the wearer do so at -" + randomIntInRange(4, 10),
                "Whenever the wearer is targeted by an opponent's spell, the wearer may roll a d20 (AOE effects are not targeted). If the wearer rolls a natural 20, the opponent's spell instead targets itself",
                "During combat, the wearer regains 1 hp per turn.",
                "The wearer can understand " + getRandomLanguage() + " and " + getRandomLanguage() + " whether written or verbal. This effect does not grant the ability to speak or write these languages",
                "Saves against the wearer's spells have +" + randomIntInRange(1,2) + " DC",
                "The wearer may choose to lose half their hp to regain any 1 used spell slot",
                "The wearer regains 1d6 hp whenever killing or knocking an opponent unconscious"
        ));
        return armorAbilityList.get(randomIntInRange(0, armorAbilityList.size() - 1));
    }

    public Weapon getWeaponByEconomyAndTier(String economicClass, int tier) {
        if (tier > 3 || tier <= 0) {
            tier = randomIntInRange(0, 3);
        }
        switch (economicClass) {
            case EconomicClasses.beggar:
                if (tier > 3 || tier <= 0) {
                    tier = randomIntInRange(0, 3);
                }
                switch (tier) {
                    case 1:
                        return new Weapon(getBeggarWeaponTier1());
                    case 2:
                        return new Weapon(getBeggarWeaponTier2());
                    case 3:
                        return new Weapon(getBeggarWeaponTier3());
                    default:
                        return new Weapon(getBeggarWeaponTier1());
                }
            case EconomicClasses.poor:
                if (tier > 3 || tier <= 0) {
                    tier = randomIntInRange(1, 3);
                }
                switch (tier) {
                    case 1:
                        return new Weapon(getPoorWeaponTier1());
                    case 2:
                        return new Weapon(getPoorWeaponTier2());
                    case 3:
                        return new Weapon(getPoorWeaponTier3());
                    default:
                        return new Weapon(getPoorWeaponTier1());
                }
            case EconomicClasses.middleClass:
                if (tier > 4 || tier <= 0) {
                    tier = randomIntInRange(1, 4);
                }
                switch (tier) {
                    case 1:
                        return new Weapon(getMiddleClassWeaponTier1());
                    case 2:
                        return new Weapon(getMiddleClassWeaponTier2());
                    case 3:
                        return new Weapon(getMiddleClassWeaponTier3());
                    case 4:
                        return new Weapon(getMiddleClassWeaponTier4());
                    default:
                        return new Weapon(getMiddleClassWeaponTier1());
                }
            case EconomicClasses.wealthy:
                if (tier > 5 || tier <= 0) {
                    tier = randomIntInRange(1, 5);
                }
                switch (tier) {
                    case 1:
                        return new Weapon(getWealthyWeaponTier1());
                    case 2:
                        return new Weapon(getWealthyWeaponTier2());
                    case 3:
                        return new Weapon(getWealthyWeaponTier3());
                    case 4:
                        return new Weapon(getWealthyWeaponTier4());
                    case 5:
                        return new Weapon(getWealthyWeaponTier5());
                    default:
                        return new Weapon(getWealthyWeaponTier1());

                }
            default:
                return new Weapon(getBeggarWeaponTier1());
        }
    }

    private Weapon getBeggarWeaponTier1() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, new Weapon(StandardWeapons.club));
        return rc.next();
    }

    private Weapon getBeggarWeaponTier2() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, new Weapon(StandardWeapons.club));
        return rc.next();
    }

    private Weapon getBeggarWeaponTier3() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, new Weapon(StandardWeapons.club));
        return rc.next();
    }

    private Weapon getPoorWeaponTier1() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, new Weapon(StandardWeapons.club));
        return rc.next();
    }

    private Weapon getPoorWeaponTier2() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, new Weapon(StandardWeapons.club));
        return rc.next();
    }

    private Weapon getPoorWeaponTier3() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, new Weapon(StandardWeapons.club));
        return rc.next();
    }

    private Weapon getMiddleClassWeaponTier1() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, new Weapon(StandardWeapons.club));
        return rc.next();
    }

    private Weapon getMiddleClassWeaponTier2() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, new Weapon(StandardWeapons.club));
        return rc.next();
    }

    private Weapon getMiddleClassWeaponTier3() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, new Weapon(StandardWeapons.club));
        return rc.next();
    }

    private Weapon getMiddleClassWeaponTier4() {
        RandomCollectionWeighted<Weapon> rc = new RandomCollectionWeighted<Weapon>()
                .add(100, new Weapon(StandardWeapons.club));
        return rc.next();
    }

    private Weapon getWealthyWeaponTier1() {
        return new Weapon(getRandomStandardWeapon());
    }

    private Weapon getWealthyWeaponTier2() {
        Weapon selectedWeapon = new Weapon(getRandomStandardWeapon());
        selectedWeapon.rarity = Rarities.rare;
        selectedWeapon.valueGold += Rarities.rareCostModlow;
        selectedWeapon.setPlusLevelEnchantment(1);
        return selectedWeapon;
    }

    private Weapon getWealthyWeaponTier3() {
        Weapon selectedWeapon = new Weapon(getRandomStandardWeapon());
        selectedWeapon.rarity = Rarities.veryRare;
        selectedWeapon.valueGold += Rarities.veryRareCostModlow;
        selectedWeapon.setPlusLevelEnchantment(2);
        return selectedWeapon;
    }

    private Weapon getWealthyWeaponTier4() {
        if (randomIntInRange(1, 100) < 20) {
            return new Weapon(getRandomCustomWeaponByTier(randomIntInRange(1, 2)));
        } else {
            Weapon selectedWeapon = new Weapon(getRandomStandardWeapon());
            selectedWeapon.rarity = Rarities.legendary;
            selectedWeapon.valueGold += Rarities.legendaryCostModlow;
            selectedWeapon.setPlusLevelEnchantment(3);
            return selectedWeapon;
        }
    }

    private Weapon getWealthyWeaponTier5() {
        if (randomIntInRange(1,100) < 20) {
            return new Weapon(getRandomCustomWeaponByTier(randomIntInRange(3, 4)));
        } else {
            Weapon selectedWeapon = new Weapon(getRandomStandardWeapon());
            selectedWeapon.rarity = Rarities.legendary;
            selectedWeapon.valueGold += randomIntInRange(Rarities.legendaryCostModlow + 5000, Rarities.legendaryCostModlow + 20000);
            selectedWeapon.setPlusLevelEnchantment(4);
            return selectedWeapon;
        }
    }

    public Loot getLootByEconomyAndTier(String economicClass, int tier) {
        if (tier > 3 || tier <= 0) {
            tier = randomIntInRange(0, 3);
        }
        switch (economicClass) {
            case EconomicClasses.beggar:
                if (tier > 3 || tier <= 0) {
                    tier = randomIntInRange(0, 3);
                }
                switch (tier) {
                    case 1:
                        return new Loot(getBeggarLootTier1());
                    case 2:
                        return new Loot(getBeggarLootTier2());
                    case 3:
                        return new Loot(getBeggarLootTier3());
                    default:
                        return new Loot(getBeggarLootTier1());
                }
            case EconomicClasses.poor:
                if (tier > 3 || tier <= 0) {
                    tier = randomIntInRange(1, 3);
                }
                switch (tier) {
                    case 1:
                        return new Loot(getPoorLootTier1());
                    case 2:
                        return new Loot(getPoorLootTier2());
                    case 3:
                        return new Loot(getPoorLootTier3());
                    default:
                        return new Loot(getPoorLootTier1());
                }
            case EconomicClasses.middleClass:
                if (tier > 4 || tier <= 0) {
                    tier = randomIntInRange(1, 4);
                }
                switch (tier) {
                    case 1:
                        return new Loot(getMiddleClassLootTier1());
                    case 2:
                        return new Loot(getMiddleClassLootTier2());
                    case 3:
                        return new Loot(getMiddleClassLootTier3());
                    case 4:
                        return new Loot(getMiddleClassLootTier4());
                    default:
                        return new Loot(getMiddleClassLootTier1());
                }
            case EconomicClasses.wealthy:
                if (tier > 5 || tier <= 0) {
                    tier = randomIntInRange(1, 5);
                }
                switch (tier) {
                    case 1:
                        return new Loot(getWealthyLootTier1());
                    case 2:
                        return new Loot(getWealthyLootTier2());
                    case 3:
                        return new Loot(getWealthyLootTier3());
                    case 4:
                        return new Loot(getWealthyLootTier4());
                    case 5:
                        return new Loot(getWealthyLootTier5());
                    default:
                        return new Loot(getWealthyLootTier1());
                }
            default:
                return new Loot(getBeggarLootTier1());
        }
    }

    private Loot getBeggarLootTier1() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(3, new Loot(StandardLoot.barrel))
                .add(3, new Loot(StandardLoot.bucket))
                .add(3, new Loot(StandardLoot.basket))
                .add(3, new Loot(StandardLoot.arrow1))
                .add(3, new Loot(StandardLoot.bell))
                .add(3, new Loot(StandardLoot.blowgunNeedles1))
                .add(3, new Loot(StandardLoot.candle1))
                .add(3, new Loot(StandardLoot.chalk1))
                .add(5, new Loot(StandardLoot.commonClothes))
                .add(3, new Loot(StandardLoot.cooksUtinsels))
                .add(2, new Loot(StandardLoot.diceSet))
                .add(3, new Loot(StandardLoot.flask))
                .add(2, new Loot(StandardLoot.glassBottle))
                .add(3, new Loot(StandardLoot.ironPot))
                .add(2, new Loot(StandardLoot.ironSpikes1))
                .add(5, new Loot(StandardLoot.jug))
                .add(5, new Loot(StandardLoot.lamp))
                .add(3, new Loot(StandardLoot.manacles))
                .add(3, new Loot(StandardLoot.paperSheet1))
                .add(3, new Loot(StandardLoot.pouch))
                .add(5, new Loot(StandardLoot.dayRations1))
                .add(5, new Loot(StandardLoot.dayRations2))
                .add(3, new Loot(StandardLoot.shovel))
                .add(3, new Loot(StandardLoot.slingBullet1))
                .add(3, new Loot(StandardLoot.tankard))
                .add(5, new Loot(StandardLoot.tinderbox))
                .add(5, new Loot(StandardLoot.bundleOfSticks))
                .add(3, new Loot(StandardLoot.torch))
                .add(5, new Loot(StandardLoot.wornShoes));
        return rc.next();
    }

    private Loot getBeggarLootTier2() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(3, new Loot(StandardLoot.blowgunNeedles5))
                .add(3, new Loot(StandardLoot.ironSpikes5))
                .add(5, new Loot(StandardLoot.signalWhistle))
                .add(5, new Loot(StandardLoot.backpack))
                .add(5, new Loot(StandardLoot.ballBearings))
                .add(10, new Loot(StandardLoot.blanket))
                .add(5, new Loot(StandardLoot.componentPouch))
                .add(5, new Loot(StandardLoot.wand))
                .add(6, new Loot(StandardLoot.waterskin))
                .add(5, new Loot(StandardLoot.vial))
                .add(3, new Loot(StandardLoot.sprigOfMistletoe))
                .add(3, new Loot(StandardLoot.slingBullet5))
                .add(5, new Loot(StandardLoot.robes))
                .add(5, new Loot(StandardLoot.sack))
                .add(7, new Loot(StandardLoot.dayRations3))
                .add(7, new Loot(StandardLoot.dayRations4))
                .add(7, new Loot(StandardLoot.dayRations5))
                .add(2, new Loot(StandardLoot.minersPick))
                .add(5, new Loot(StandardLoot.hammer))
                .add(2, new Loot(StandardLoot.caltropsBag));
        return rc.next();
    }

    private Loot getBeggarLootTier3() {
        RandomCollectionWeighted<Loot> rc = new RandomCollectionWeighted<Loot>()
                .add(2, new Loot(StandardLoot.mapScrollCase))
                .add(4, new Loot(StandardLoot.bedroll))
                .add(2, new Loot(StandardLoot.messKit))
                .add(2, new Loot(StandardLoot.walkingStick))
                .add(4, new Loot(StandardLoot.travelersClothes))
                .add(2, new Loot(StandardLoot.trinket))
                .add(2, new Loot(StandardLoot.flute))
                .add(2, new Loot(StandardLoot.lock))
                .add(2, new Loot(StandardLoot.lute))
                .add(2, new Loot(StandardLoot.lyre))
                .add(2, new Loot(StandardLoot.violInstrument))
                .add(2, new Loot(StandardLoot.slingBullet10))
                .add(2, new Loot(StandardLoot.soap))
                .add(2, new Loot(StandardLoot.whetstone))
                .add(2, new Loot(StandardLoot.candle5))
                .add(2, new Loot(StandardLoot.arrows5))
                .add(2, new Loot(StandardLoot.bagofBallBearings1000))
                .add(2, new Loot(StandardLoot.paperSheet5))
                .add(2, new Loot(StandardLoot.playingCardSet))
                .add(2, new Loot(StandardLoot.chalk5))
                .add(2, new Loot(StandardLoot.healersKit))
                .add(2, new Loot(StandardLoot.hempenRope25ft))
                .add(2, new Loot(StandardLoot.herbalismKit))
                .add(2, new Loot(StandardLoot.holySymbol))
                .add(2, new Loot(StandardLoot.hoodedLantern))
                .add(2, new Loot(StandardLoot.hornInstrument))
                .add(2, new Loot(StandardLoot.ink1ozBottle))
                .add(2, new Loot(StandardLoot.inkPen))
                .add(2, new Loot(StandardLoot.mossAgateGem))
                .add(4, new Loot(StandardLoot.oilFlask))
                .add(2, new Loot(StandardLoot.pairEngravedBoneDice))
                .add(2, new Loot(StandardLoot.panFlute))
                .add(2, new Loot(StandardLoot.quiver))
                .add(2, new Loot(StandardLoot.signetRing))
                .add(8, new Loot(StandardLoot.twoPersonTent))
                .add(2, new Loot(StandardLoot.burglarsBackpack))
                .add(2, new Loot(StandardLoot.haversack))
                .add(2, new Loot(StandardLoot.grungyGlasses))
                .add(2, new Loot(StandardLoot.dayRations6))
                .add(2, new Loot(StandardLoot.dayRations7))
                .add(2, new Loot(StandardLoot.steelMirror))
                .add(4, new Loot(StandardLoot.thievesTools))
                .add(2, new Loot(StandardLoot.tigersEyeGem));
        return rc.next();
    }

    private Loot getPoorLootTier1() {
        List<Loot> lootList = new ArrayList<Loot>(Arrays.asList(
                new Loot(StandardLoot.backpack),
                new Loot(StandardLoot.basket),
                new Loot(StandardLoot.blanket),
                new Loot(StandardLoot.arrow1),
                new Loot(StandardLoot.blockTackleLifting),
                new Loot(StandardLoot.blowgunNeedles1),
                new Loot(StandardLoot.bucket),
                new Loot(StandardLoot.burglarsPack),
                new Loot(StandardLoot.candle1),
                new Loot(StandardLoot.climbersKit),
                new Loot(StandardLoot.commonClothes),
                new Loot(StandardLoot.commonClothes),
                new Loot(StandardLoot.commonClothes),
                new Loot(StandardLoot.commonClothes),
                new Loot(StandardLoot.crossbowBolts1),
                new Loot(StandardLoot.crowbar),
                new Loot(StandardLoot.diceSet),
                new Loot(StandardLoot.drum),
                new Loot(StandardLoot.fishingTackle),
                new Loot(StandardLoot.flask),
                new Loot(StandardLoot.hempenRope25ft),
                new Loot(StandardLoot.hammer),
                new Loot(StandardLoot.ironPot),
                new Loot(StandardLoot.jug),
                new Loot(StandardLoot.lamp),
                new Loot(StandardLoot.lock),
                new Loot(StandardLoot.manacles),
                new Loot(StandardLoot.messKit),
                new Loot(StandardLoot.minersPick),
                new Loot(StandardLoot.paperSheet1),
                new Loot(StandardLoot.parchment1),
                new Loot(StandardLoot.playingCardSet),
                new Loot(StandardLoot.pouch),
                new Loot(StandardLoot.quiver),
                new Loot(StandardLoot.dayRations1),
                new Loot(StandardLoot.dayRations2),
                new Loot(StandardLoot.rod),
                new Loot(StandardLoot.sack),
                new Loot(StandardLoot.shovel),
                new Loot(StandardLoot.sickle),
                new Loot(StandardLoot.signalWhistle),
                new Loot(StandardLoot.sledgeHammer),
                new Loot(StandardLoot.slingBullet5),
                new Loot(StandardLoot.soap),
                new Loot(StandardLoot.staff),
                new Loot(StandardLoot.tankard),
                new Loot(StandardLoot.tinderbox),
                new Loot(StandardLoot.torch),
                new Loot(StandardLoot.trinket),
                new Loot(StandardLoot.vial),
                new Loot(StandardLoot.wand),
                new Loot(StandardLoot.walkingStick),
                new Loot(StandardLoot.waterskin)

        ));
        return lootList.get(randomIntInRange(0, lootList.size() - 1));
    }

    private Loot getPoorLootTier2() {
        List<Loot> lootList = new ArrayList<Loot>(Arrays.asList(
                new Loot(StandardLoot.bagofBallBearings1000),
                new Loot(StandardLoot.arrows5),
                new Loot(StandardLoot.blowgunNeedles5),
                new Loot(StandardLoot.brewersSupplies),
                new Loot(StandardLoot.bullseyeLantern),
                new Loot(StandardLoot.candle5),
                new Loot(StandardLoot.carpentersTools),
                new Loot(StandardLoot.cartographersTools),
                new Loot(StandardLoot.cobblersTools),
                new Loot(StandardLoot.componentPouch),
                new Loot(StandardLoot.costumeClothes),
                new Loot(StandardLoot.crossbowBolts5),
                new Loot(StandardLoot.disguiseKit),
                new Loot(StandardLoot.entertainersPack),
                new Loot(StandardLoot.flute),
                new Loot(StandardLoot.glassblowersTools),
                new Loot(StandardLoot.haversack),
                new Loot(StandardLoot.hempenRope50ft),
                new Loot(StandardLoot.holyEmblem),
                new Loot(StandardLoot.healersKit),
                new Loot(StandardLoot.herbalismKit),
                new Loot(StandardLoot.holySymbol),
                new Loot(StandardLoot.hornInstrument),
                new Loot(StandardLoot.huntingTrap),
                new Loot(StandardLoot.ink1ozBottle),
                new Loot(StandardLoot.inkPen),
                new Loot(StandardLoot.leatherworkersTools),
                new Loot(StandardLoot.mapScrollCase),
                new Loot(StandardLoot.masonsTools),
                new Loot(StandardLoot.merchantsScale),
                new Loot(StandardLoot.panFlute),
                new Loot(StandardLoot.paperSheet5),
                new Loot(StandardLoot.parchment5),
                new Loot(StandardLoot.pottersTools),
                new Loot(StandardLoot.priestsPack),
                new Loot(StandardLoot.dayRations3),
                new Loot(StandardLoot.dayRations4),
                new Loot(StandardLoot.robes),
                new Loot(StandardLoot.signetRing),
                new Loot(StandardLoot.slingBullet10),
                new Loot(StandardLoot.smithsTools),
                new Loot(StandardLoot.thievesTools),
                new Loot(StandardLoot.travelersClothes),
                new Loot(StandardLoot.totem),
                new Loot(StandardLoot.whetstone),
                new Loot(StandardLoot.yewWand)
        ));
        return lootList.get(randomIntInRange(0, lootList.size() - 1));
    }

    private Loot getPoorLootTier3() {
        List<Loot> lootList = new ArrayList<Loot>(Arrays.asList(
                new Loot(StandardLoot.acidVial),
                new Loot(StandardLoot.arrows10),
                new Loot(StandardLoot.blowgunNeedles10),
                new Loot(StandardLoot.blueQuartz),
                new Loot(StandardLoot.carvedBoneStatuette),
                new Loot(StandardLoot.chalcedonyGem),
                new Loot(StandardLoot.crossbowBoltCase),
                new Loot(StandardLoot.crossbowBolts10),
                new Loot(StandardLoot.crystal),
                new Loot(StandardLoot.dragonChessSet),
                new Loot(StandardLoot.eyeAgateGem),
                new Loot(StandardLoot.forgeryKit),
                new Loot(StandardLoot.glassBottle),
                new Loot(StandardLoot.hematiteGem),
                new Loot(StandardLoot.hoodedLantern),
                new Loot(StandardLoot.hourglass),
                new Loot(StandardLoot.jasperGem),
                new Loot(StandardLoot.jewelersTools),
                new Loot(StandardLoot.lapisLazuliGem),
                new Loot(StandardLoot.malachiteGem),
                new Loot(StandardLoot.mossAgateGem),
                new Loot(StandardLoot.oilFlask),
                new Loot(StandardLoot.posonersKit),
                new Loot(StandardLoot.potionOfClimbing),
                new Loot(StandardLoot.potionOfHealing),
                new Loot(StandardLoot.dayRations5),
                new Loot(StandardLoot.dayRations6),
                new Loot(StandardLoot.rhodochositeGem),
                new Loot(StandardLoot.sealingWax),
                new Loot(StandardLoot.slingBullet15),
                new Loot(StandardLoot.tigersEyeGem),
                new Loot(StandardLoot.turquiseGem)
        ));
        return lootList.get(randomIntInRange(0, lootList.size() - 1));
    }

    private Loot getMiddleClassLootTier1() {
        List<Loot> lootList = new ArrayList<Loot>(Arrays.asList(
                new Loot(StandardLoot.abacus),
                new Loot(StandardLoot.antitoxin),
                new Loot(StandardLoot.arrows10),
                new Loot(StandardLoot.azuriteGem),
                new Loot(StandardLoot.backpack),
                new Loot(StandardLoot.bagpipes),
                new Loot(StandardLoot.bagofBallBearings1000),
                new Loot(StandardLoot.bandedAgateGem),
                new Loot(StandardLoot.basket),
                new Loot(StandardLoot.blowgunNeedles5),
                new Loot(StandardLoot.blowgunNeedles10),
                new Loot(StandardLoot.blueQuartz),
                new Loot(StandardLoot.brewersSupplies),
                new Loot(StandardLoot.burglarsBackpack),
                new Loot(StandardLoot.caltropsBag),
                new Loot(StandardLoot.candle1),
                new Loot(StandardLoot.candle5),
                new Loot(StandardLoot.carpentersTools),
                new Loot(StandardLoot.cartographersTools),
                new Loot(StandardLoot.chain5ft),
                new Loot(StandardLoot.climbersKit),
                new Loot(StandardLoot.cobblersTools),
                new Loot(StandardLoot.commonClothes),
                new Loot(StandardLoot.cooksUtinsels),
                new Loot(StandardLoot.componentPouch),
                new Loot(StandardLoot.costumeClothes),
                new Loot(StandardLoot.crossbowBolts5),
                new Loot(StandardLoot.crystal),
                new Loot(StandardLoot.diceSet),
                new Loot(StandardLoot.disguiseKit),
                new Loot(StandardLoot.entertainersPack),
                new Loot(StandardLoot.eyeAgateGem),
                new Loot(StandardLoot.fishingTackle),
                new Loot(StandardLoot.flask),
                new Loot(StandardLoot.flute),
                new Loot(StandardLoot.glassBottle),
                new Loot(StandardLoot.glassblowersTools),
                new Loot(StandardLoot.hammer),
                new Loot(StandardLoot.healersKit),
                new Loot(StandardLoot.hematiteGem),
                new Loot(StandardLoot.hempenRope25ft),
                new Loot(StandardLoot.herbalismKit),
                new Loot(StandardLoot.hoodedLantern),
                new Loot(StandardLoot.hourglass),
                new Loot(StandardLoot.huntingTrap),
                new Loot(StandardLoot.inkPen),
                new Loot(StandardLoot.ink1ozBottle),
                new Loot(StandardLoot.ironPot),
                new Loot(StandardLoot.ironSpikes5),
                new Loot(StandardLoot.jug),
                new Loot(StandardLoot.lamp),
                new Loot(StandardLoot.lapisLazuliGem),
                new Loot(StandardLoot.leatherworkersTools),
                new Loot(StandardLoot.lock),
                new Loot(StandardLoot.lute),
                new Loot(StandardLoot.lyre),
                new Loot(StandardLoot.malachiteGem),
                new Loot(StandardLoot.manacles),
                new Loot(StandardLoot.mapScrollCase),
                new Loot(StandardLoot.masonsTools),
                new Loot(StandardLoot.merchantsScale),
                new Loot(StandardLoot.messKit),
                new Loot(StandardLoot.minersPick),
                new Loot(StandardLoot.mossAgateGem),
                new Loot(StandardLoot.obsidianGem),
                new Loot(StandardLoot.oilFlask),
                new Loot(StandardLoot.paintersSupplies),
                new Loot(StandardLoot.panFlute),
                new Loot(StandardLoot.paperSheet5),
                new Loot(StandardLoot.parchment5),
                new Loot(StandardLoot.perfumeVial),
                new Loot(StandardLoot.playingCardSet),
                new Loot(StandardLoot.pottersTools),
                new Loot(StandardLoot.pouch),
                new Loot(StandardLoot.quiver),
                new Loot(StandardLoot.dayRations1),
                new Loot(StandardLoot.dayRations2),
                new Loot(StandardLoot.dayRations3),
                new Loot(StandardLoot.robes),
                new Loot(StandardLoot.sack),
                new Loot(StandardLoot.scholarsPack),
                new Loot(StandardLoot.sealingWax),
                new Loot(StandardLoot.shovel),
                new Loot(StandardLoot.sickle),
                new Loot(StandardLoot.signetRing),
                new Loot(StandardLoot.signalWhistle),
                new Loot(StandardLoot.sledgeHammer),
                new Loot(StandardLoot.slingBullet10),
                new Loot(StandardLoot.smithsTools),
                new Loot(StandardLoot.smokepowder),
                new Loot(StandardLoot.soap),
                new Loot(StandardLoot.staff),
                new Loot(StandardLoot.steelMirror),
                new Loot(StandardLoot.tankard),
                new Loot(StandardLoot.thievesTools),
                new Loot(StandardLoot.tinderbox),
                new Loot(StandardLoot.tinkersTools),
                new Loot(StandardLoot.torch),
                new Loot(StandardLoot.totem),
                new Loot(StandardLoot.travelersClothes),
                new Loot(StandardLoot.trinket),
                new Loot(StandardLoot.turquiseGem),
                new Loot(StandardLoot.vial),
                new Loot(StandardLoot.violInstrument),
                new Loot(StandardLoot.wand),
                new Loot(StandardLoot.waterskin),
                new Loot(StandardLoot.weaversTools),
                new Loot(StandardLoot.whetstone),
                new Loot(StandardLoot.woodcarversTools)
        ));
        return lootList.get(randomIntInRange(0, lootList.size() - 1));
    }

    private Loot getMiddleClassLootTier2() {
        List<Loot> lootList = new ArrayList<Loot>(Arrays.asList(
                new Loot(StandardLoot.explorersPack),
                new Loot(StandardLoot.bloodstoneGem),
                new Loot(StandardLoot.clothGoldVestments),
                new Loot(StandardLoot.forgeryKit),
                new Loot(StandardLoot.yewWand),
                new Loot(StandardLoot.arrows15),
                new Loot(StandardLoot.basicPoisonVial),
                new Loot(StandardLoot.book25gp),
                new Loot(StandardLoot.carvedBoneStatuette),
                new Loot(StandardLoot.embroideredSilkHandkerchief),
                new Loot(StandardLoot.haversack),
                new Loot(StandardLoot.silverEwer),
                new Loot(StandardLoot.poisonersKit),
                new Loot(StandardLoot.silkRope25ft),
                new Loot(StandardLoot.spellScrollLvlCantrip),
                new Loot(StandardLoot.spellScrollLvl1),
                new Loot(StandardLoot.spellScrollLvl2),
                new Loot(StandardLoot.staffAdornment),
                new Loot(StandardLoot.staffBirdcalls),
                new Loot(StandardLoot.staffFlowers),
                new Loot(StandardLoot.wandScowls),
                new Loot(StandardLoot.wandSmiles),
                new Loot(StandardLoot.wandMagicMissiles),
                new Loot(StandardLoot.tigersEyeGem),
                new Loot(StandardLoot.sardonyxGem),
                new Loot(StandardLoot.zirconGem),
                new Loot(StandardLoot.quartzGem),
                new Loot(StandardLoot.onyxGem),
                new Loot(StandardLoot.starRoseQuartzGem),
                new Loot(StandardLoot.moonstoneGem),
                new Loot(StandardLoot.jewelersTools),
                new Loot(StandardLoot.jasperGem),
                new Loot(StandardLoot.hempenRope50ft),
                new Loot(StandardLoot.smallGoldBracelet),
                new Loot(StandardLoot.smallMirrorPaintedWood),
                new Loot(StandardLoot.grapplingHook),
                new Loot(StandardLoot.fineClothes),
                new Loot(StandardLoot.carnelianGem),
                new Loot(StandardLoot.crossbowBolts10),
                new Loot(StandardLoot.chain10ft)
        ));
        return lootList.get(randomIntInRange(0, lootList.size() - 1));
    }

    private Loot getMiddleClassLootTier3() {
        List<Loot> lootList = new ArrayList<Loot>(Arrays.asList(
                new Loot(StandardLoot.silkRope50ft),
                new Loot(StandardLoot.spellbook),
                new Loot(StandardLoot.bootsFalseTracks),
                new Loot(StandardLoot.lockTrickery),
                new Loot(StandardLoot.spellScrollLvl3),
                new Loot(StandardLoot.spellScrollLvl4),
                new Loot(StandardLoot.slingBulletPlusOne1),
                new Loot(StandardLoot.tankardSobriety),
                new Loot(StandardLoot.staffAdder),
                new Loot(StandardLoot.ropeMending),
                new Loot(StandardLoot.paperBirdMagical),
                new Loot(StandardLoot.monsterHunterPack),
                new Loot(StandardLoot.orbDirection),
                new Loot(StandardLoot.oilSlipperiness),
                new Loot(StandardLoot.jadeGem),
                new Loot(StandardLoot.holyWaterFlask),
                new Loot(StandardLoot.enduringSpellbook),
                new Loot(StandardLoot.gogglesNight),
                new Loot(StandardLoot.potionOfHealing),
                new Loot(StandardLoot.potionPoison),
                new Loot(StandardLoot.potionOfClimbing),
                new Loot(StandardLoot.crossbowBoltsPlusOne1),
                new Loot(StandardLoot.crossbowBolts15),
                new Loot(StandardLoot.slingBullet15),
                new Loot(StandardLoot.blowgunNeedles15),
                new Loot(StandardLoot.clothesMending),
                new Loot(StandardLoot.beadNourishment),
                new Loot(StandardLoot.beadRefreshment),
                new Loot(StandardLoot.arrowPlusOne1),
                new Loot(StandardLoot.amberGem),
                new Loot(StandardLoot.truthSerum),
                new Loot(StandardLoot.cloakBillowing),
                new Loot(StandardLoot.alchemistsSupplies)
        ));
        return lootList.get(randomIntInRange(0, lootList.size() - 1));
    }

    private Loot getMiddleClassLootTier4() {
        List<Loot> lootList = new ArrayList<Loot>(Arrays.asList(
                new Loot(StandardLoot.wallopingArrow1),
                new Loot(StandardLoot.wallopingBlowgunNeedle1),
                new Loot(StandardLoot.wallopingCrossbowBolt1),
                new Loot(StandardLoot.wallopingSlingBullet1),
                new Loot(StandardLoot.spellScrollLvl5),
                new Loot(StandardLoot.spellScrollLvl6),
                new Loot(StandardLoot.slingBullet20),
                new Loot(StandardLoot.potionAcidResistance),
                new Loot(StandardLoot.potionColdResistance),
                new Loot(StandardLoot.potionFireBreath),
                new Loot(StandardLoot.potionfireResistance),
                new Loot(StandardLoot.potionForceResistance),
                new Loot(StandardLoot.potionGreaterHealing),
                new Loot(StandardLoot.potionHillGiantStrength),
                new Loot(StandardLoot.potionInvisibility),
                new Loot(StandardLoot.potionLightningResistance),
                new Loot(StandardLoot.potionNecroticResistance),
                new Loot(StandardLoot.potionPoisonResistance),
                new Loot(StandardLoot.potionPsychicResistance),
                new Loot(StandardLoot.potionRadiantResistance),
                new Loot(StandardLoot.potionThunderResistance),
                new Loot(StandardLoot.ringFeatherFalling),
                new Loot(StandardLoot.ringForceResistance),
                new Loot(StandardLoot.ringSwimming),
                new Loot(StandardLoot.ringTruthTelling),
                new Loot(StandardLoot.ringMending),
                new Loot(StandardLoot.unbreakableArrow1),
                new Loot(StandardLoot.wandConductiong),
                new Loot(StandardLoot.wandEntangle),
                new Loot(StandardLoot.slingBulletPlusOne5),
                new Loot(StandardLoot.instrumentScribing),
                new Loot(StandardLoot.instrumentIllusions),
                new Loot(StandardLoot.mysteryKey),
                new Loot(StandardLoot.glovesThievery),
                new Loot(StandardLoot.carvedIvoryStatuette),
                new Loot(StandardLoot.crossbowBoltsPlusOne5),
                new Loot(StandardLoot.arrowPlusOne5)
        ));
        return lootList.get(randomIntInRange(0, lootList.size() - 1));
    }

    private Loot getWealthyLootTier1() {
        List<Loot> lootList = new ArrayList<Loot>(Arrays.asList(
                new Loot(StandardLoot.alchemistsFireFlask),
                new Loot(StandardLoot.amethystGem),
                new Loot(StandardLoot.arrows20),
                new Loot(StandardLoot.blowgunNeedles20),
                new Loot(StandardLoot.bootsElvenkind),
                new Loot(StandardLoot.bottledBreath),
                new Loot(StandardLoot.candle10),
                new Loot(StandardLoot.chrysoberylGem),
                new Loot(StandardLoot.chrysopraseGem),
                new Loot(StandardLoot.citrineGem),
                new Loot(StandardLoot.cloakManyFashions),
                new Loot(StandardLoot.clockworkAmulet),
                new Loot(StandardLoot.crossbowBolts20),
                new Loot(StandardLoot.diplomatsPack),
                new Loot(StandardLoot.dungeoneersPack),
                new Loot(StandardLoot.fineWine5gp),
                new Loot(StandardLoot.fineWine10gp),
                new Loot(StandardLoot.fineWine12gp),
                new Loot(StandardLoot.fineWine15gp),
                new Loot(StandardLoot.fineWine25gp),
                new Loot(StandardLoot.fineWine30gp),
                new Loot(StandardLoot.fineWine40gp),
                new Loot(StandardLoot.fineWine60gp),
                new Loot(StandardLoot.fineWine80gp),
                new Loot(StandardLoot.fineWine100gp),
                new Loot(StandardLoot.garnetGem),
                new Loot(StandardLoot.goldDragonCombRedGarnets),
                new Loot(StandardLoot.jetGem),
                new Loot(StandardLoot.magnifyingGlass),
                new Loot(StandardLoot.mapGrandBastion),
                new Loot(StandardLoot.navigatorsTools),
                new Loot(StandardLoot.painting10gp),
                new Loot(StandardLoot.painting15gp),
                new Loot(StandardLoot.painting20gp),
                new Loot(StandardLoot.paperSheet10),
                new Loot(StandardLoot.paperSheet20),
                new Loot(StandardLoot.getParchment10),
                new Loot(StandardLoot.getParchment20),
                new Loot(StandardLoot.poetryBook5gp),
                new Loot(StandardLoot.poetryBook15gp),
                new Loot(StandardLoot.silkBedclothes),
                new Loot(StandardLoot.silkBlanket),
                new Loot(StandardLoot.slingBullet20),
                new Loot(StandardLoot.stoneIllLuck),
                new Loot(StandardLoot.windFan),
                new Loot(StandardLoot.spellScrollLvlCantrip),
                new Loot(StandardLoot.spellScrollLvl1),
                new Loot(StandardLoot.spellScrollLvl2),
                new Loot(StandardLoot.spellScrollLvl3),
                new Loot(StandardLoot.spellScrollLvl4),
                new Loot(StandardLoot.wandConductiong),
                new Loot(StandardLoot.wandEntangle),
                new Loot(StandardLoot.slingBulletPlusOne5),
                new Loot(StandardLoot.instrumentScribing),
                new Loot(StandardLoot.instrumentIllusions),
                new Loot(StandardLoot.crossbowBoltsPlusOne5),
                new Loot(StandardLoot.arrowPlusOne5),
                new Loot(StandardLoot.silkRope50ft),
                new Loot(StandardLoot.spellbook),
                new Loot(StandardLoot.bootsFalseTracks),
                new Loot(StandardLoot.lockTrickery),
                new Loot(StandardLoot.spellScrollLvl3),
                new Loot(StandardLoot.spellScrollLvl4),
                new Loot(StandardLoot.slingBulletPlusOne1),
                new Loot(StandardLoot.tankardSobriety),
                new Loot(StandardLoot.staffAdder),
                new Loot(StandardLoot.ropeMending),
                new Loot(StandardLoot.paperBirdMagical),
                new Loot(StandardLoot.monsterHunterPack),
                new Loot(StandardLoot.orbDirection),
                new Loot(StandardLoot.oilSlipperiness),
                new Loot(StandardLoot.jadeGem),
                new Loot(StandardLoot.holyWaterFlask),
                new Loot(StandardLoot.enduringSpellbook),
                new Loot(StandardLoot.gogglesNight),
                new Loot(StandardLoot.potionOfHealing),
                new Loot(StandardLoot.potionPoison),
                new Loot(StandardLoot.potionOfClimbing),
                new Loot(StandardLoot.crossbowBoltsPlusOne1),
                new Loot(StandardLoot.crossbowBolts15),
                new Loot(StandardLoot.slingBullet15),
                new Loot(StandardLoot.blowgunNeedles15),
                new Loot(StandardLoot.clothesMending),
                new Loot(StandardLoot.beadNourishment),
                new Loot(StandardLoot.beadRefreshment),
                new Loot(StandardLoot.arrowPlusOne1),
                new Loot(StandardLoot.amberGem),
                new Loot(StandardLoot.truthSerum),
                new Loot(StandardLoot.cloakBillowing),
                new Loot(StandardLoot.alchemistsSupplies),
                new Loot(StandardLoot.turquiseGem),
                new Loot(StandardLoot.tigersEyeGem),
                new Loot(StandardLoot.obsidianGem),
                new Loot(StandardLoot.eyeAgateGem),
                new Loot(StandardLoot.hematiteGem),
                new Loot(StandardLoot.mossAgateGem),
                new Loot(StandardLoot.quartzGem),
                new Loot(StandardLoot.staffFlowers),
                new Loot(StandardLoot.staffBirdcalls),
                new Loot(StandardLoot.staffAdornment),
                new Loot(StandardLoot.scholarsPack),
                new Loot(StandardLoot.explorersPack),
                new Loot(StandardLoot.fineClothes),
                new Loot(StandardLoot.fineClothes),
                new Loot(StandardLoot.fineClothes),
                new Loot(StandardLoot.fineClothes),
                new Loot(StandardLoot.fineClothes),
                new Loot(StandardLoot.fineClothes),
                new Loot(StandardLoot.fineClothes),
                new Loot(StandardLoot.fineClothes),
                new Loot(StandardLoot.clothGoldVestments),
                new Loot(StandardLoot.clothGoldVestments),
                new Loot(StandardLoot.clothGoldVestments),
                new Loot(StandardLoot.clothGoldVestments),
                new Loot(StandardLoot.alchemistsSupplies),
                new Loot(StandardLoot.parchment5),
                new Loot(StandardLoot.parchment1),
                new Loot(StandardLoot.paperSheet1),
                new Loot(StandardLoot.paperSheet5),
                new Loot(StandardLoot.jasperGem),
                new Loot(StandardLoot.crystal),
                new Loot(StandardLoot.playingCardSet),
                new Loot(StandardLoot.diceSet),
                new Loot(StandardLoot.pairEngravedBoneDice),
                new Loot(StandardLoot.waterskin),
                new Loot(StandardLoot.steelMirror),
                new Loot(StandardLoot.dayRations1),
                new Loot(StandardLoot.mapScrollCase),
                new Loot(StandardLoot.ink1ozBottle),
                new Loot(StandardLoot.inkPen),
                new Loot(StandardLoot.trinket),
                new Loot(StandardLoot.holyEmblem),
                new Loot(StandardLoot.holySymbol),
                new Loot(StandardLoot.componentPouch)
        ));
        return lootList.get(randomIntInRange(0, lootList.size() - 1));
    }

    private Loot getWealthyLootTier2() {
        List<Loot> lootList = new ArrayList<>(Arrays.asList(
                new Loot(StandardLoot.arrows30),
                new Loot(StandardLoot.blowgunNeedles30),
                new Loot(StandardLoot.unbreakableArrow1),
                new Loot(StandardLoot.staffPython),
                new Loot(StandardLoot.slingBullet30),
                new Loot(StandardLoot.scrollProtection),
                new Loot(StandardLoot.ringScintillatingColors),
                new Loot(StandardLoot.robeScintillatingColors),
                new Loot(StandardLoot.ringThunderResistance),
                new Loot(StandardLoot.pipeSmokeMonsters),
                new Loot(StandardLoot.pearlGem),
                new Loot(StandardLoot.paperBirdMagical5),
                new Loot(StandardLoot.orbTime),
                new Loot(StandardLoot.maskBeast),
                new Loot(StandardLoot.largeGoldBracelet),
                new Loot(StandardLoot.hideArmorGleaming),
                new Loot(StandardLoot.goldRingBloodstones),
                new Loot(StandardLoot.fineWine150gp),
                new Loot(StandardLoot.fineWine200gp),
                new Loot(StandardLoot.fineWine250gp),
                new Loot(StandardLoot.dreadHelm),
                new Loot(StandardLoot.crossbowBolts30),
                new Loot(StandardLoot.candleDeep),
                new Loot(StandardLoot.brassMugJadeInlay),
                new Loot(StandardLoot.boxturquiseanimalfigurines),
                new Loot(StandardLoot.ringFeatherFalling),
                new Loot(StandardLoot.ringForceResistance),
                new Loot(StandardLoot.ringSwimming),
                new Loot(StandardLoot.ringTruthTelling),
                new Loot(StandardLoot.ringMending),
                new Loot(StandardLoot.spellScrollLvl3),
                new Loot(StandardLoot.spellScrollLvl4),
                new Loot(StandardLoot.mysteryKey),
                new Loot(StandardLoot.glovesThievery),
                new Loot(StandardLoot.carvedIvoryStatuette),
                new Loot(StandardLoot.tankardSobriety),
                new Loot(StandardLoot.staffAdder),
                new Loot(StandardLoot.ropeMending),
                new Loot(StandardLoot.paperBirdMagical),
                new Loot(StandardLoot.monsterHunterPack),
                new Loot(StandardLoot.orbDirection),
                new Loot(StandardLoot.oilSlipperiness),
                new Loot(StandardLoot.jadeGem),
                new Loot(StandardLoot.holyWaterFlask),
                new Loot(StandardLoot.enduringSpellbook),
                new Loot(StandardLoot.gogglesNight),
                new Loot(StandardLoot.potionOfHealing),
                new Loot(StandardLoot.potionPoison),
                new Loot(StandardLoot.potionOfClimbing),
                new Loot(StandardLoot.wallopingArrow1),
                new Loot(StandardLoot.wallopingBlowgunNeedle1),
                new Loot(StandardLoot.wallopingCrossbowBolt1),
                new Loot(StandardLoot.wallopingSlingBullet1)
        ));
        return lootList.get(randomIntInRange(0, lootList.size() - 1));
    }

    private Loot getWealthyLootTier3() {
        List<Loot> lootList = new ArrayList<>(Arrays.asList(
                new Loot(StandardLoot.broochShielding),
                new Loot(StandardLoot.blowgunNeedles40),
                new Loot(StandardLoot.unbreakableArrow5),
                new Loot(StandardLoot.slingBullet40),
                new Loot(StandardLoot.shieldExpressions),
                new Loot(StandardLoot.ringRegeneration),
                new Loot(StandardLoot.potionAnimalFriendship),
                new Loot(StandardLoot.potionGrowth),
                new Loot(StandardLoot.potionSpeed),
                new Loot(StandardLoot.potionWaterBreathing),
                new Loot(StandardLoot.potionEvasion),
                new Loot(StandardLoot.potionMindShielding),
                new Loot(StandardLoot.potionProtection),
                new Loot(StandardLoot.potionRegeneration),
                new Loot(StandardLoot.potionAcidResistance),
                new Loot(StandardLoot.potionColdResistance),
                new Loot(StandardLoot.potionFireBreath),
                new Loot(StandardLoot.potionfireResistance),
                new Loot(StandardLoot.potionForceResistance),
                new Loot(StandardLoot.potionGreaterHealing),
                new Loot(StandardLoot.potionHillGiantStrength),
                new Loot(StandardLoot.potionLightningResistance),
                new Loot(StandardLoot.potionNecroticResistance),
                new Loot(StandardLoot.potionPoisonResistance),
                new Loot(StandardLoot.potionPsychicResistance),
                new Loot(StandardLoot.potionRadiantResistance),
                new Loot(StandardLoot.potionThunderResistance),
                new Loot(StandardLoot.hatWizardry),
                new Loot(StandardLoot.dustDisappearance),
                new Loot(StandardLoot.dustDryness),
                new Loot(StandardLoot.dustSneezingChoking),
                new Loot(StandardLoot.crossbowBolts40),
                new Loot(StandardLoot.circletBlasting),
                new Loot(StandardLoot.capWaterBreathing),
                new Loot(StandardLoot.chainShirtGleaming),
                new Loot(StandardLoot.breastplateGleaming),
                new Loot(StandardLoot.bootsArchery),
                new Loot(StandardLoot.bootsDefense),
                new Loot(StandardLoot.arrows40),
                new Loot(StandardLoot.spellScrollLvl5),
                new Loot(StandardLoot.spellScrollLvl6)
                ));
        return lootList.get(randomIntInRange(0, lootList.size() - 1));
    }

    private Loot getWealthyLootTier4() {
        List<Loot> lootList = new ArrayList<>(Arrays.asList(
                new Loot(StandardLoot.wandEnemyDetection),
                new Loot(StandardLoot.wandMagicDetection),
                new Loot(StandardLoot.stoneGoodLuck),
                new Loot(StandardLoot.staffHealing),
                new Loot(StandardLoot.slingBulletPlusOne10),
                new Loot(StandardLoot.slingBulletPlusOne10),
                new Loot(StandardLoot.silverNecklaceGemstonePendant),
                new Loot(StandardLoot.silkRobeGoldEmbroidery),
                new Loot(StandardLoot.periaptHealth),
                new Loot(StandardLoot.perfumeBewitching),
                new Loot(StandardLoot.hornSilentAlarm),
                new Loot(StandardLoot.hatVermin),
                new Loot(StandardLoot.hatDisguise),
                new Loot(StandardLoot.goldLocketPaintedPortrait),
                new Loot(StandardLoot.elixirHealth),
                new Loot(StandardLoot.electrumRing),
                new Loot(StandardLoot.electrumRing),
                new Loot(StandardLoot.crossbowBoltsPlusOne10),
                new Loot(StandardLoot.crossbowBoltsPlusOne10),
                new Loot(StandardLoot.blowgunNeedlesPlusOne10),
                new Loot(StandardLoot.blowgunNeedlesPlusOne10),
                new Loot(StandardLoot.arrowPlusOne10),
                new Loot(StandardLoot.arrowPlusOne10),
                new Loot(StandardLoot.spellScrollLvl7),
                new Loot(StandardLoot.potionInvisibility)
                ));
        return lootList.get(randomIntInRange(0, lootList.size() - 1));
    }

    private Loot getWealthyLootTier5() {
        List<Loot> lootList = new ArrayList<>(Arrays.asList(
                new Loot(StandardLoot.cloakElvenkind),
                new Loot(StandardLoot.gauntletsOgrePower),
                new Loot(StandardLoot.wandSecrets),
                new Loot(StandardLoot.wandPyrotechnics),
                new Loot(StandardLoot.smallGoldIdol),
                new Loot(StandardLoot.slingBulletPlusTwo5),
                new Loot(StandardLoot.silverGoldBroach),
                new Loot(StandardLoot.necklaceStringSmallPinkPearls),
                new Loot(StandardLoot.immovableRod),
                new Loot(StandardLoot.fineGoldChainFireOpal),
                new Loot(StandardLoot.elementalBlueSapphire),
                new Loot(StandardLoot.elementalEmerald),
                new Loot(StandardLoot.elementalRedCorundum),
                new Loot(StandardLoot.elementalYellowDiamond),
                new Loot(StandardLoot.crossbowBoltsPlusTwo5),
                new Loot(StandardLoot.blowgunNeedlesPlusTwo5),
                new Loot(StandardLoot.beltStoneGiantStrength),
                new Loot(StandardLoot.beltDwarvenkind),
                new Loot(StandardLoot.bagHolding),
                new Loot(StandardLoot.arrowsPlusTwo5),
                new Loot(StandardLoot.spellScrollLvl8),
                new Loot(StandardLoot.amuletOfProofAgainstDetectionLocation)
                ));
        return lootList.get(randomIntInRange(0, lootList.size() - 1));
    }

    public Weapon getRandomCustomWeaponByTier(int tier) {
        //TODO: make a way to randomly generate a weapon. This would be used in the high tiers for wealthy and for most elite commoners.
        switch (tier) {
            case 1:
                return new Weapon(getCustomWeaponRandomTier1());
            case 2:
                return new Weapon(getCustomWeaponRandomTier2());
            case 3:
                return new Weapon(getCustomWeaponRandomTier3());
            case 4:
                return  new Weapon(getCustomWeaponRandomTier4());
        }
        return new Weapon(getCustomWeaponRandomTier1());
    }

    public Weapon getRandomStandardWeapon() {
        List<Weapon> standardWeaponList = new ArrayList<>(Arrays.asList(
            StandardWeapons.club,
            StandardWeapons.dagger,
            StandardWeapons.greatclub,
            StandardWeapons.handaxe,
            StandardWeapons.javelin,
            StandardWeapons.lightHammer,
            StandardWeapons.mace,
            StandardWeapons.quarterstaff,
            StandardWeapons.sickle,
            StandardWeapons.spear,
            StandardWeapons.lightCrossbow,
            StandardWeapons.dart,
            StandardWeapons.shortbow,
            StandardWeapons.sling,
            StandardWeapons.battleaxe,
            StandardWeapons.flail,
            StandardWeapons.glaive,
            StandardWeapons.greataxe,
            StandardWeapons.halberd,
            StandardWeapons.lance,
            StandardWeapons.longsword,
            StandardWeapons.maul,
            StandardWeapons.morningstar,
            StandardWeapons.pike,
            StandardWeapons.rapier,
            StandardWeapons.scimitar,
            StandardWeapons.shortsword,
            StandardWeapons.trident,
            StandardWeapons.warPick,
            StandardWeapons.warhammer,
            StandardWeapons.whip,
            StandardWeapons.blowgun,
            StandardWeapons.handCrossbow,
            StandardWeapons.heavyCrossbow,
            StandardWeapons.longbow,
            StandardWeapons.net
        ));
        return new Weapon(standardWeaponList.get(randomIntInRange(0, (standardWeaponList.size() - 1))));
    }

    private Weapon getCustomWeaponRandomTier1() {
        //start with a base weapon and then change some values
        Weapon customWeapon = new Weapon(getRandomStandardWeapon());
        customWeapon.toHitBonus = randomIntInRange(0,1);
        customWeapon.rarity = Rarities.uncommon;
        customWeapon.valueGold = customWeapon.valueGold + randomIntInRange(Rarities.uncommonCostModlow, Rarities.uncommonCostModHigh);
        //get bonus damage
        switch (getRandomDamageType()) {
            case DamageTypes.acid:
                customWeapon.name += " of lesser " + DamageTypes.acid;
                customWeapon.acidDamageMin += 1;
                customWeapon.acidDamageMax += randomIntInRange(1,3);
                break;
            case DamageTypes.bludgeoning:
                customWeapon.name += " of lesser " + DamageTypes.bludgeoning;
                customWeapon.bludgeoningDamageMin +=  1;
                customWeapon.bludgeoningDamageMax += randomIntInRange(1, 3);
                break;
            case DamageTypes.cold:
                customWeapon.name += " of lesser " + DamageTypes.cold;
                customWeapon.coldDamageMin += 1;
                customWeapon.coldDamageMax += randomIntInRange(1, 3);
                break;
            case DamageTypes.fire:
                customWeapon.name += " of lesser " + DamageTypes.fire;
                customWeapon.fireDamageMin += 1;
                customWeapon.fireDamageMax += randomIntInRange(1, 3);
                break;
            case DamageTypes.necrotic:
                customWeapon.name = "lesser " + DamageTypes.necrotic + " " + customWeapon.name;
                customWeapon.necroticDamageMin += 1;
                customWeapon.necroticDamageMax += randomIntInRange(1, 3);
                break;
            case DamageTypes.force:
                customWeapon.name += " of lesser " + DamageTypes.force;
                customWeapon.forceDamageMin += 1;
                customWeapon.forceDamageMax += randomIntInRange(1, 3);
                break;
            case DamageTypes.lightning:
                customWeapon.name += " of lesser " + DamageTypes.lightning;
                customWeapon.lightningDamageMin += 1;
                customWeapon.lightningDamageMax += randomIntInRange(1, 3);
                break;
            case DamageTypes.piercing:
                customWeapon.name += " of lesser " + DamageTypes.piercing;
                customWeapon.piercingDamageMin += 1;
                customWeapon.piercingDamageMax += randomIntInRange(1, 3);
                break;
            case DamageTypes.poison:
                customWeapon.name += " of lesser " + DamageTypes.poison;
                customWeapon.poisonDamageMin += 1;
                customWeapon.poisonDamageMax += randomIntInRange(1, 3);
                break;
            case DamageTypes.psychic:
                customWeapon.name = "lesser " + DamageTypes.psychic + " " + customWeapon.name;
                customWeapon.psychicDamageMin += 1;
                customWeapon.psychicDamageMax += randomIntInRange(1, 3);
                break;
            case DamageTypes.radiant:
                customWeapon.name = "lesser" + DamageTypes.radiant + " " + customWeapon.name;
                customWeapon.radiantDamageMin += 1;
                customWeapon.radiantDamageMax += randomIntInRange(1, 3);
                break;
            case DamageTypes.slashing:
                customWeapon.name += " of lesser " + DamageTypes.slashing;
                customWeapon.slashingDamageMin += 1;
                customWeapon.slashingDamageMax += randomIntInRange(1, 3);
                break;
            case DamageTypes.thunder:
                customWeapon.name += " of lesser " + DamageTypes.thunder;
                customWeapon.thunderDamageMin += 1;
                customWeapon.thunderDamageMax += randomIntInRange(1, 3);
                break;
        }
        return customWeapon;
    }

    private Weapon getCustomWeaponRandomTier2() {
        //start with a base weapon and then change some values
        Weapon customWeapon = new Weapon(getRandomStandardWeapon());
        customWeapon.toHitBonus = randomIntInRange(1, 2);
        customWeapon.rarity = Rarities.rare;
        customWeapon.valueGold += randomIntInRange(Rarities.rareCostModlow, Rarities.rareCostModHigh);
        //get bonus damage
        for (int i = 0; i < randomIntInRange(1, 2); i++) {
            switch (getRandomDamageType()) {
                case DamageTypes.acid:
                    customWeapon.name += " of " + DamageTypes.acid;
                    customWeapon.acidDamageMin += randomIntInRange(1, 2);
                    customWeapon.acidDamageMax += randomIntInRange(2, 5);
                    break;
                case DamageTypes.bludgeoning:
                    customWeapon.name += " of " + DamageTypes.bludgeoning;
                    customWeapon.bludgeoningDamageMin += randomIntInRange(1, 2);
                    customWeapon.bludgeoningDamageMax += randomIntInRange(2, 5);
                    break;
                case DamageTypes.cold:
                    customWeapon.name += " of " + DamageTypes.cold;
                    customWeapon.coldDamageMin += randomIntInRange(1, 2);
                    customWeapon.coldDamageMax += randomIntInRange(2, 5);
                    break;
                case DamageTypes.fire:
                    customWeapon.name += " of " + DamageTypes.fire;
                    customWeapon.fireDamageMin += randomIntInRange(1, 2);
                    customWeapon.fireDamageMax += randomIntInRange(2, 5);
                    break;
                case DamageTypes.necrotic:
                    customWeapon.name = DamageTypes.necrotic + " " + customWeapon.name;
                    customWeapon.necroticDamageMin += randomIntInRange(1, 2);
                    customWeapon.necroticDamageMax += randomIntInRange(2, 5);
                    break;
                case DamageTypes.force:
                    customWeapon.name += " of " + DamageTypes.force;
                    customWeapon.forceDamageMin += randomIntInRange(1, 2);
                    customWeapon.forceDamageMax += randomIntInRange(2, 5);
                    break;
                case DamageTypes.lightning:
                    customWeapon.name += " of " + DamageTypes.lightning;
                    customWeapon.lightningDamageMin += randomIntInRange(1, 2);
                    customWeapon.lightningDamageMax += randomIntInRange(2, 5);
                    break;
                case DamageTypes.piercing:
                    customWeapon.name += " of " + DamageTypes.piercing;
                    customWeapon.piercingDamageMin += randomIntInRange(1, 2);
                    customWeapon.piercingDamageMax += randomIntInRange(2, 5);
                    break;
                case DamageTypes.poison:
                    customWeapon.name += " of " + DamageTypes.poison;
                    customWeapon.poisonDamageMin += randomIntInRange(1, 2);
                    customWeapon.poisonDamageMax += randomIntInRange(2, 5);
                    break;
                case DamageTypes.psychic:
                    customWeapon.name = DamageTypes.psychic + " " + customWeapon.name;
                    customWeapon.psychicDamageMin += randomIntInRange(1, 2);
                    customWeapon.psychicDamageMax += randomIntInRange(2, 5);
                    break;
                case DamageTypes.radiant:
                    customWeapon.name = DamageTypes.radiant + " " + customWeapon.name;
                    customWeapon.radiantDamageMin += randomIntInRange(1, 2);
                    customWeapon.radiantDamageMax += randomIntInRange(2, 5);
                    break;
                case DamageTypes.slashing:
                    customWeapon.name += " of " + DamageTypes.slashing;
                    customWeapon.slashingDamageMin += randomIntInRange(1, 2);
                    customWeapon.slashingDamageMax += randomIntInRange(2, 5);
                    break;
                case DamageTypes.thunder:
                    customWeapon.name += " of " + DamageTypes.thunder;
                    customWeapon.thunderDamageMin += randomIntInRange(1, 2);
                    customWeapon.thunderDamageMax += randomIntInRange(2, 5);
                    break;
            }
        }
        if (randomIntInRange(1, 100) < 50) {
            customWeapon.abilities.add(getRandomAbilityTier2());
        }
        return customWeapon;
    }

    private Weapon getCustomWeaponRandomTier3() {
        //start with a base weapon and then change some values
        Weapon customWeapon = new Weapon(getRandomStandardWeapon());
        customWeapon.toHitBonus = randomIntInRange(2, 3);
        customWeapon.rarity = Rarities.veryRare;
        customWeapon.valueGold += randomIntInRange(Rarities.veryRareCostModlow, Rarities.veryRareCostModHigh);
        //get bonus damage
        for (int i = 0; i < randomIntInRange(2, 4); i++) {
            switch (getRandomDamageType()) {
                case DamageTypes.acid:
                    customWeapon.name += " of major " + DamageTypes.acid;
                    customWeapon.acidDamageMin += randomIntInRange(2, 4);
                    customWeapon.acidDamageMax += randomIntInRange(4, 8);
                    break;
                case DamageTypes.bludgeoning:
                    customWeapon.name += " of major" + DamageTypes.bludgeoning;
                    customWeapon.bludgeoningDamageMin += randomIntInRange(2, 4);
                    customWeapon.bludgeoningDamageMax += randomIntInRange(4, 8);
                    break;
                case DamageTypes.cold:
                    customWeapon.name += " of major" + DamageTypes.cold;
                    customWeapon.coldDamageMin += randomIntInRange(2, 4);
                    customWeapon.coldDamageMax += randomIntInRange(4, 8);
                    break;
                case DamageTypes.fire:
                    customWeapon.name += " of major" + DamageTypes.fire;
                    customWeapon.fireDamageMin += randomIntInRange(2, 4);
                    customWeapon.fireDamageMax += randomIntInRange(4, 8);
                    break;
                case DamageTypes.necrotic:
                    customWeapon.name = "major " + DamageTypes.necrotic + " " + customWeapon.name;
                    customWeapon.necroticDamageMin += randomIntInRange(2, 4);
                    customWeapon.necroticDamageMax += randomIntInRange(4, 8);
                    break;
                case DamageTypes.force:
                    customWeapon.name += " of major " + DamageTypes.force;
                    customWeapon.forceDamageMin += randomIntInRange(2, 4);
                    customWeapon.forceDamageMax += randomIntInRange(4, 8);
                    break;
                case DamageTypes.lightning:
                    customWeapon.name += " of major " + DamageTypes.lightning;
                    customWeapon.lightningDamageMin += randomIntInRange(2, 4);
                    customWeapon.lightningDamageMax += randomIntInRange(4, 8);
                    break;
                case DamageTypes.piercing:
                    customWeapon.name += " of major " + DamageTypes.piercing;
                    customWeapon.piercingDamageMin += randomIntInRange(2, 4);
                    customWeapon.piercingDamageMax += randomIntInRange(4, 8);
                    break;
                case DamageTypes.poison:
                    customWeapon.name += " of major " + DamageTypes.poison;
                    customWeapon.poisonDamageMin += randomIntInRange(2, 4);
                    customWeapon.poisonDamageMax += randomIntInRange(4, 8);
                    break;
                case DamageTypes.psychic:
                    customWeapon.name = "major " + DamageTypes.psychic + " " + customWeapon.name;
                    customWeapon.psychicDamageMin += randomIntInRange(2, 4);
                    customWeapon.psychicDamageMax += randomIntInRange(4, 8);
                    break;
                case DamageTypes.radiant:
                    customWeapon.name = "major " + DamageTypes.radiant + " " + customWeapon.name;
                    customWeapon.radiantDamageMin += randomIntInRange(2, 4);
                    customWeapon.radiantDamageMax += randomIntInRange(4, 8);
                    break;
                case DamageTypes.slashing:
                    customWeapon.name += " of major " + DamageTypes.slashing;
                    customWeapon.slashingDamageMin += randomIntInRange(2, 4);
                    customWeapon.slashingDamageMax += randomIntInRange(4, 8);
                    break;
                case DamageTypes.thunder:
                    customWeapon.name += " of major " + DamageTypes.thunder;
                    customWeapon.thunderDamageMin += randomIntInRange(2, 4);
                    customWeapon.thunderDamageMax += randomIntInRange(4, 8);
                    break;
            }
        }
        customWeapon.abilities.add("Requires attunement.");
        //has 1-2 abilities
        customWeapon.abilities.add(getRandomAbilityTier3());
        if (randomIntInRange(1, 100) <= 50) {
            customWeapon.abilities.add(getRandomAbilityTier2());
        }
        return customWeapon;
    }

    private Weapon getCustomWeaponRandomTier4() {
        //start with a base weapon and then change some values
        Weapon customWeapon = new Weapon(getRandomStandardWeapon());
        customWeapon.toHitBonus = randomIntInRange(3, 4);
        customWeapon.rarity = Rarities.legendary;
        customWeapon.valueGold += randomIntInRange(Rarities.legendaryCostModlow, Rarities.legendaryCostModhigh);
        //get bonus damage
        for (int i = 0; i < randomIntInRange(3,5); i++) {
            switch (getRandomDamageType()) {
                case DamageTypes.acid:
                    customWeapon.name += " of legendary " + DamageTypes.acid;
                    customWeapon.acidDamageMin += randomIntInRange(4, 6);
                    customWeapon.acidDamageMax += randomIntInRange(6, 12);
                    break;
                case DamageTypes.bludgeoning:
                    customWeapon.name += " of legendary" + DamageTypes.bludgeoning;
                    customWeapon.bludgeoningDamageMin += randomIntInRange(4, 6);
                    customWeapon.bludgeoningDamageMax += randomIntInRange(6, 12);
                    break;
                case DamageTypes.cold:
                    customWeapon.name += " of legendary" + DamageTypes.cold;
                    customWeapon.coldDamageMin += randomIntInRange(4, 6);
                    customWeapon.coldDamageMax += randomIntInRange(6, 12);
                    break;
                case DamageTypes.fire:
                    customWeapon.name += " of legendary" + DamageTypes.fire;
                    customWeapon.fireDamageMin += randomIntInRange(4, 6);
                    customWeapon.fireDamageMax += randomIntInRange(6, 12);
                    break;
                case DamageTypes.necrotic:
                    customWeapon.name = "legendary " + DamageTypes.necrotic + " " + customWeapon.name;
                    customWeapon.necroticDamageMin += randomIntInRange(4, 6);
                    customWeapon.necroticDamageMax += randomIntInRange(6, 12);
                    break;
                case DamageTypes.force:
                    customWeapon.name += " of legendary " + DamageTypes.force;
                    customWeapon.forceDamageMin += randomIntInRange(4, 6);
                    customWeapon.forceDamageMax += randomIntInRange(6, 12);
                    break;
                case DamageTypes.lightning:
                    customWeapon.name += " of legendary " + DamageTypes.lightning;
                    customWeapon.lightningDamageMin += randomIntInRange(4, 6);
                    customWeapon.lightningDamageMax += randomIntInRange(6, 12);
                    break;
                case DamageTypes.piercing:
                    customWeapon.name += " of legendary " + DamageTypes.piercing;
                    customWeapon.piercingDamageMin += randomIntInRange(4, 6);
                    customWeapon.piercingDamageMax += randomIntInRange(6, 12);
                    break;
                case DamageTypes.poison:
                    customWeapon.name += " of legendary " + DamageTypes.poison;
                    customWeapon.poisonDamageMin += randomIntInRange(4, 6);
                    customWeapon.poisonDamageMax += randomIntInRange(6, 12);
                    break;
                case DamageTypes.psychic:
                    customWeapon.name = "legendary " + DamageTypes.psychic + " " + customWeapon.name;
                    customWeapon.psychicDamageMin += randomIntInRange(4, 6);
                    customWeapon.psychicDamageMax += randomIntInRange(6, 12);
                    break;
                case DamageTypes.radiant:
                    customWeapon.name = "legendary " + DamageTypes.radiant + " " + customWeapon.name;
                    customWeapon.radiantDamageMin += randomIntInRange(4, 6);
                    customWeapon.radiantDamageMax += randomIntInRange(6, 12);
                    break;
                case DamageTypes.slashing:
                    customWeapon.name += " of legendary " + DamageTypes.slashing;
                    customWeapon.slashingDamageMin += randomIntInRange(4, 6);
                    customWeapon.slashingDamageMax += randomIntInRange(6, 12);
                    break;
                case DamageTypes.thunder:
                    customWeapon.name += " of legendary " + DamageTypes.thunder;
                    customWeapon.thunderDamageMin += randomIntInRange(4, 6);
                    customWeapon.thunderDamageMax += randomIntInRange(6, 12);
                    break;
            }
        }
        customWeapon.abilities.add("Requires attunement.");
        //has 1-5 abilities
        customWeapon.abilities.add(getRandomAbilityTier4());
        if (randomIntInRange(1, 100) <= 25) {
            customWeapon.abilities.add(getRandomAbilityTier3());
        }
        if (randomIntInRange(1, 100) <= 50) {
            customWeapon.abilities.add(getRandomAbilityTier3());
        }
        if (randomIntInRange(1, 100) <= 75) {
            customWeapon.abilities.add(getRandomAbilityTier2());
        }
        if (randomIntInRange(1, 100) <= 90) {
            customWeapon.abilities.add(getRandomAbilityTier2());
        }
        return customWeapon;
    }

    public String getRandomAbilityTier2() {
        List<String> abilityList = new ArrayList<>(Arrays.asList(
                "For 1 bonus action and while equipped, may heal you for " + randomIntInRange(1, 10) + " hp, " + randomIntInRange(1, 3) + "times per long rest.",
                "Creatures hit must make a DC " + randomIntInRange(8, 14) + " CON save or are stunned for 1 round.",
                "+1 to critical hit range, +2 to critical fail range",
                "Critical hits do not deal extra damage, instead the target must make a DC " + randomIntInRange(14, 20) + " WIS save or be under a dominate person spell for " + randomIntInRange(1, 2) + " rounds, if applicable.",
                "You have resistance to " + getRandomDamageType() + " damage and weakness to " + getRandomDamageType() + " while wielding this weapon.",
                "You may teleport up to " + (randomIntInRange(1, 3) * 5) + "feet in any direction you can see after successfully hitting with this weapon",
                "+" + randomIntInRange(1, 2) + " to " + getRandomSecondarySkill() + " while holding this weapon.",
                "+" + randomIntInRange(1, 2) + " to " + getRandomPrimarySkill() + " saves while holding this weapon.",
                "+" + randomIntInRange(1, 2) + " to " + getRandomPrimarySkill() + " checks while holding this weapon.",
                randomIntInRange(1, 3) + " times per long rest, add " + randomIntInRange(1, 5) + " " + getRandomDamageType() + " damage when hitting an opponent.",
                "When damaging a creature, it loses " + randomIntInRange(1, 2) + " spell slots of its lowest available slots as if they were used.",
                "When scoring a critical hit against an opponent, regain " + randomIntInRange(1, 2) + " spend spell slots of your lowest tier which has a spend slot",
                "When scoring a critical hit you may, instead of dealing extra damage, heal for " + randomIntInRange(5, 10) + " hp once per long rest.",
                randomIntInRange(1, 3) + " times per long rest you may add " + randomIntInRange(1, 3) + "to a check or save while holding this weapon",
                randomIntInRange(1, 3) + " times per long rest you may prevent " + randomIntInRange(1, 6) + " damage dealt to you",
                "+" + randomIntInRange(1, 2) + " to hit against members of the " + getRandomRace() + "race",
                "+" + randomIntInRange(1, 2) + " " + getRandomDamageType() + " damage against members of the " + getRandomRace() + "race",
                "Glows " + getRandomColorName() + " when within " + (randomIntInRange(1,2) * 5) + " ft of a shapeshifter",
                "Glows " + getRandomColorName() + " when within " + (randomIntInRange(1, 2) * 5) + " ft of a mimic",
                "Becomes cold when " + " when within " + (randomIntInRange(1, 2) * 5) + " ft of a creature of " + getRandomAlignment() + " alignment",
                "The wielder gains advantage with attacks with this weapon while underwater",
                "The wielder gains advantage with attacks with this weapon while flying",
                "This weapon has an additional +1 to hit " + getRandomWeaponBonusCondition() + " and -1 to hit otherwise",
                "This weapon deals an additional +" + randomIntInRange(1,3) + " bludgeoning damage when striking an inanimate object",
                "+" + randomIntInRange(1,2) + " to hit a creature that has damaged the wielder in the last day"
        ));
        return abilityList.get(randomIntInRange(0, abilityList.size() - 1));
    }

    public String getRandomAbilityTier3() {
        List<String> abilityList = new ArrayList<>(Arrays.asList(
                "For 1 bonus action and while equipped, may heal you for " + randomIntInRange(5, 20) + " hp, " + randomIntInRange(1, 4) + "times per long rest.",
                "Creatures hit must make a DC " + randomIntInRange(10, 18) + " CON save or are stunned for 1 round.",
                "+1 to critical hit range, +1 to critical fail range",
                "Critical hits do not deal extra damage, instead the target must make a DC " + randomIntInRange(16, 24) + " WIS save or be under a dominate person spell for " + randomIntInRange(1, 4) + " rounds, if applicable.",
                "You have resistance to " + getRandomDamageType() + " damage and weakness to " + getRandomDamageType() + " while wielding this weapon.",
                "You may teleport up to " + (randomIntInRange(1, 4) * 5) + "feet in any direction you can see after successfully hitting with this weapon",
                "+" + randomIntInRange(2, 4) + " to " + getRandomSecondarySkill() + " while holding this weapon.",
                "+" + randomIntInRange(2, 4) + " to " + getRandomPrimarySkill() + " saves while holding this weapon.",
                "+" + randomIntInRange(2, 4) + " to " + getRandomPrimarySkill() + " checks while holding this weapon.",
                randomIntInRange(1, 3) + " times per long rest, add " + randomIntInRange(2, 8) + " " + getRandomDamageType() + " damage when hitting an opponent.",
                "When damaging a creature, it loses " + randomIntInRange(1, 4) + " spell slots of its lowest available slots as if they were used.",
                "When scoring a critical hit against an opponent, regain " + randomIntInRange(1, 4) + " spend spell slots of your lowest tier which has a spend slot",
                "When scoring a critical hit you may, instead of dealing extra damage, heal for " + randomIntInRange(10, 20) + " hp once per long rest.",
                randomIntInRange(1, 3) + " times per long rest you may add " + randomIntInRange(2, 5) + "to a check or save while holding this weapon",
                randomIntInRange(1, 3) + " times per long rest you may prevent " + randomIntInRange(3, 10) + " damage dealt to you",
                "+" + randomIntInRange(3, 4) + " to hit against members of the " + getRandomRace() + "race",
                "+" + randomIntInRange(3, 4) + " " + getRandomDamageType() + " damage against members of the " + getRandomRace() + "race",
                "Glows " + getRandomColorName() + " when within " + (randomIntInRange(3, 4) * 5) + " ft of a shapeshifter",
                "Glows " + getRandomColorName() + " when within " + (randomIntInRange(3, 4) * 5) + " ft of a mimic",
                "Becomes cold when " + " when within " + (randomIntInRange(3, 4) * 5) + " ft of a creature of " + getRandomAlignment() + " alignment",
                "When this weapon reduces an opponent to 0 hp, the wielder regains " + randomIntInRange(1,2) + "d4 temporary hp and may make 1 more attack with this weapon during the turn.",
                "The wielder gains advantage with attacks with this weapon while flying",
                "This weapon has an additional +2 to hit " + getRandomWeaponBonusCondition() + " and -1 to hit otherwise",
                "This weapon deals an additional +" + randomIntInRange(4, 8) + " bludgeoning damage when striking an inanimate object",
                "When damaging a humanoid, that creature must make a DC " + randomIntInRange(8, 14) + " WIS save or be affected by a " + getRandomWeaponSpellBonus() + " spell for 1 round.",
                "+" + randomIntInRange(3, 4) + " to hit a creature that has damaged the wielder in the last day"
        ));
        return abilityList.get(randomIntInRange(0, abilityList.size() - 1));
    }

    public String getRandomAbilityTier4() {
        List<String> abilityList = new ArrayList<>(Arrays.asList(
                "For 1 bonus action and while equipped, may heal you for " + randomIntInRange(12, 35) + " hp, " + randomIntInRange(2, 5) + "times per long rest.",
                "Creatures hit must make a DC " + randomIntInRange(14, 25) + " CON save or are stunned for 1 round.",
                "+1 to critical hit range.",
                "You have resistance to " + getRandomDamageType() + " damage while wielding this weapon.",
                "You may teleport up to " + (randomIntInRange(3, 6) * 5) + "feet in any direction you can see after successfully hitting with this weapon",
                "+" + randomIntInRange(3, 6) + " to " + getRandomSecondarySkill() + " while holding this weapon.",
                "+" + randomIntInRange(3, 6) + " to " + getRandomPrimarySkill() + " saves while holding this weapon.",
                "+" + randomIntInRange(3, 6) + " to " + getRandomPrimarySkill() + " checks while holding this weapon.",
                randomIntInRange(1, 3) + " times per long rest, add " + randomIntInRange(4, 15) + " " + getRandomDamageType() + " damage when hitting an opponent.",
                "When damaging a creature, it loses " + randomIntInRange(2, 6) + " spell slots of its lowest available slots as if they were used.",
                "When damaging a creature, it loses 1d2 spell slots of its highest available slots as if they were used.",
                "When scoring a critical hit against an opponent, regain " + randomIntInRange(2, 6) + " spend spell slots of your lowest tier which has a spend slot",
                "When scoring a critical hit you may, instead of dealing extra damage, heal for " + randomIntInRange(20, 30) + " hp once per long rest.",
                randomIntInRange(1, 3) + " times per long rest you may add " + randomIntInRange(3, 8) + "to a check or save while holding this weapon.",
                randomIntInRange(1, 3) + " times per long rest you may prevent " + randomIntInRange(5, 20) + " damage dealt to you.",
                "+" + randomIntInRange(5, 8) + " to hit against members of the " + getRandomRace() + "race",
                "+" + randomIntInRange(5, 8) + " " + getRandomDamageType() + " damage against members of the " + getRandomRace() + "race",
                "Glows " + getRandomColorName() + " when within " + (randomIntInRange(5, 8) * 5) + " ft of a shapeshifter",
                "Glows " + getRandomColorName() + " when within " + (randomIntInRange(5, 8) * 5) + " ft of a mimic",
                "Becomes cold when " + " when within " + (randomIntInRange(5, 8) * 5) + " ft of a creature of " + getRandomAlignment() + " alignment",
                "When this weapon reduces an opponent to 0 hp, the wielder regains " + randomIntInRange(3, 4) + "d4 temporary hp and may make 1 more attack with this weapon during the turn.",
                "This weapon has an additional +3 to hit " + getRandomWeaponBonusCondition() + " and -1 to hit otherwise",
                "This weapon deals an additional +" + randomIntInRange(9, 15) + " bludgeoning damage when striking an inanimate object",
                "When damaging a humanoid, that creature must make a DC " + randomIntInRange(15,22) + " WIS save or be affected by a " + getRandomWeaponSpellBonus() + " spell for 1 round.",
                randomIntInRange(2,5) + " times per long rest, the wielder may use a reaction to attack a creature whose melee attack against the wielder failed",
                "All wielders of this weapon do so as though they were proficient with it",
                "+" + randomIntInRange(5, 8) + " to hit a creature that has damaged the wielder in the last day",
                "When you hit a living creature with this weapon it must succeed on a DC 15 Wisdom saving throw or take an extra 5 hit points of psychic damage, as the death cries of the blade’s previous foes reverberate through the target’s very being. For every living creature with an Intelligence of 4 or above that you kill with this blade, add an additional 1 hit point to the psychic damage inflicted on a failed save."
        ));
        return abilityList.get(randomIntInRange(0, abilityList.size() - 1));
    }

    public String getRandomWeaponSpellBonus() {
        switch (randomIntInRange(1,12)) {
            case 1:
                return "Charm Person";
            case 2:
                return "Dominate Person";
            case 3:
                return "Hold Person";
            case 4:
                return "Confusion";
            case 5:
                return "Dispel Magic";
            case 6:
                return "Blindness Deafness";
            case 7:
                return "Gaseous Form";
            case 8:
                return "Hunter's Mark";
            case 9:
                return "Polymorph";
            case 10:
                return "Silence";
            case 11:
                return "Sleep";
            case 12:
                return "Zone of Truth (5 ft)";
            default:
                return "Prestidigitation";
        }
    }

    public String getRandomWeaponBonusCondition() {
        switch (randomIntInRange(1,29)) {
            case 1:
                return "while in direct sunlight";
            case 2:
                return "while underground";
            case 3:
                return "while above ground";
            case 4:
                return "while indoors";
            case 5:
                return "while outdoors";
            case 6:
                return "while standing in at least 1 inch of water";
            case 7:
                return "while standing on bare earth";
            case 8:
                return "from dusk to dawn (night)";
            case 9:
                return "from dawn to dusk (day)";
            case 10:
                return "while swimming";
            case 11:
                return "while flying";
            case 12:
                return "after having not moved (by using movement) for 2 rounds (does not stack)";
            case 13:
                return "during the wielder's turn following taking damage (does not stack)";
            case 14:
                return "during the turn following having dealt damage with this weapon (does not stack)";
            case 15:
                return "while standing on higher ground than the target";
            case 16:
                return "while lying prone";
            case 17:
                return "while undetected by all opponents in the area";
            case 18:
                return "while the wielder is within 5 ft of an ally";
            case 19:
                return "while only 1 opponent is within 10 ft";
            case 20:
                return "while the wielder is below 1/2 the wielder's maximum hp";
            case 22:
                return "while the wielder is at maximum hp or greater";
            case 23:
                return "while the wielder is a 15 or fewer hp";
            case 24:
                return "while within 5 ft of at least 2 opponents";
            case 25:
                return "while not wearing armor";
            case 26:
                return "when attacking a mimic";
            case 27:
                return "when attacking a shapeshifter";
            case 28:
                return "when attacking a creature with wings";
            case 29:
                return "when attacking a creature with hooves";
            default:
                return "When unconscious";
        }
    }

    public String getRandomPrimarySkill() {
        List<String> primarySkillList = new ArrayList<>(Arrays.asList(
            PrimarySkills.strength,
            PrimarySkills.dexterity,
            PrimarySkills.constitution,
            PrimarySkills.intelligence,
            PrimarySkills.wisdom,
            PrimarySkills.charisma
        ));
        return primarySkillList.get(randomIntInRange(0, primarySkillList.size() - 1));
    }

    public String getRandomSecondarySkill() {
        List<String> secondarySkillList = new ArrayList<>(Arrays.asList(
            SecondarySkills.athletics,
            SecondarySkills.acrobatics,
            SecondarySkills.sleightOfHand,
            SecondarySkills.stealth,
            SecondarySkills.arcana,
            SecondarySkills.history,
            SecondarySkills.investigation,
            SecondarySkills.nature,
            SecondarySkills.religion,
            SecondarySkills.animalHandling,
            SecondarySkills.insight,
            SecondarySkills.medicine,
            SecondarySkills.perception,
            SecondarySkills.survival,
            SecondarySkills.deception,
            SecondarySkills.intimidation,
            SecondarySkills.performance,
            SecondarySkills.persuasion
        ));
        return secondarySkillList.get(randomIntInRange(0, secondarySkillList.size() - 1));
    }

    public String getRandomDamageType() {
        List<String> damageTypeList = new ArrayList<>(Arrays.asList(
            DamageTypes.acid,
            DamageTypes.bludgeoning,
            DamageTypes.cold,
            DamageTypes.fire,
            DamageTypes.necrotic,
            DamageTypes.force,
            DamageTypes.lightning,
            DamageTypes.poison,
            DamageTypes.psychic,
            DamageTypes.radiant,
            DamageTypes.slashing,
            DamageTypes.piercing,
            DamageTypes.thunder
        ));
        return damageTypeList.get(randomIntInRange(0, damageTypeList.size() - 1));
    }

    public String getRandomColorName() {
        switch (randomIntInRange(1,12)) {
            case 1:
                return "red";
            case 2:
                return "blue";
            case 3:
                return "green";
            case 4:
                return "yellow";
            case 5:
                return "orange";
            case 6:
                return "purple";
            case 7:
                return "pink";
            case 8:
                return "teal";
            case 9:
                return "white";
            case 10:
                return "black";
            case 11:
                return "brown";
            case 12:
                return "grey";
            default:
                return "mud";
        }
    }

    public String getRandomAlignment() {
        switch (randomIntInRange(1, 9)) {
            case 1:
                return Alignments.lawfulGood;
            case 2:
                return Alignments.chaoticGood;
            case 3:
                return Alignments.neutralGood;
            case 4:
                return Alignments.lawfulNeutral;
            case 5:
                return Alignments.trueNeutral;
            case 6:
                return Alignments.chaoticNeutral;
            case 7:
                return Alignments.neutralEvil;
            case 8:
                return Alignments.chaoticEvil;
            case 9:
                return Alignments.lawfulEvil;
            default:
                return "mud";
        }
    }

    public String getRandomMood() {
        RandomCollectionWeighted<String> rc = new RandomCollectionWeighted<String>()
                .add(5,"angry")
                .add(5,"sad")
                .add(0.5,"suicidal")
                .add(10,"happy")
                .add(5,"antisocial")
                .add(5,"Looking for a fight")
                .add(5,"hangry")
                .add(10,"tired")
                .add(5,"excited")
                .add(10,"social")
                .add(10,"bored")
                .add(4.5,"overwhelmed")
                .add(2,"panicked")
                .add(3,"shy")
                .add(5, "sarcastic")//15 more
                .add(3,"worries")
                .add(2,"relaxed")
                .add(5,"stressed")
                .add(5,"boisterous");
        return rc.next();
    }

    /*public Spell getRandomSpellsByLevel(int spellLevel, List<Spell> masterSpellList) {
        //build a list of possible spells by level
        List<Spell> spellsOfLevel = new ArrayList<Spell>(Arrays.asList(masterSpellList.get(0)));
        for (Spell temp : masterSpellList) {
            if (temp.level == spellLevel) {
                spellsOfLevel.add(temp);
            }
        }
        //Get a random entry on that list
        return spellsOfLevel.get(randomIntInRange(0, (spellsOfLevel.size() - 1)));
    }*/

    public String getRandomBeggarQuirk() {
        List<String> quirkList = new ArrayList<>(Arrays.asList(
                "used to be wealthy and tells you all about it", "perfectly normal", "narrates everything they do", "has a disabled veteran sign", "has a disabled veteran sign", "has a disabled veteran sign", "has a disabled veteran sign", "has a disabled veteran sign", "has a disabled veteran sign", "has a disabled veteran sign", "has a will work for beer sign", "has a will work for beer sign", "has a will work for beer sign", "has a will work for beer sign", "has a will work for beer sign", "has a will work for food sign", "has a will work for food sign", "has a will work for food sign", "has a will work for food sign", "has a will work for food sign", "has a will work for food sign", "has a will work for food sign", "will interpretive dance for you", "has an overbite", "has no iris", "spits frequently", "has 26 kids", "blames their parents for everything wrong in life", "is really into fitness", "has a creepy fetish for halflings", "dreams of making the worlds biggest flan", "never speaks, only sings", "only makes left turns", "spent 2 days in bayorots cavern, constantly name drops", "will only speak in cat noises, but their best friend can translate", "has waking night terrors", "has no personal space", "flea ridden", "lice ridden", "has mice living in their hat", "believes they are actually a snail", "has a tick where they randomly punch people in the face", "has a phobia of the left shoe", "has 15 toes", "loves raw onions", "filthy", "has a bad mouth", "has no teeth", "is blind", "is deaf", "is mute", "limps", "cannot walk", "has no legs", "walks with a cane", "compulsively licks things", "has a lot of tattoos", "only somewhat speaks common", "speaks in slang", "has terrible grammar", "cleaner than expected", "horrible breath", "short", "emaciated", "is faking an injury", "attractive", "extremely ugly", "naked", "thin", "missing teeth", "missing an arm", "missing a leg", "missing an eye", "tall", "stooped", "limping", "bloodshot eyes", "scarred", "injured", "diseasd", "blood-stained", "urine-stained", "feces-stained", "has several thick blankets", "lazy eye", "crosseyed", "snaggle-tooth", "missing finger", "missing hand", "peg-leg", "smells horrible", "will not look at your face", "torn clothes", "really hates the government", "really hates one of the party members races", "mumbles a lot", "keeps looking over your shoulder", "really just needs a hug", "suicidal", "serious addict to healing potions", "serious alcoholic", "complete moron", "extremely gullible", "does not speak common", "looks like it got ran over by a caravan", "has a face like the flat end of a warhammer", "snorts a lot", "wheezes", "major seasonal allergies", "afraid of leaves", "has no arms", "has no legs", "does not remember its name", "has huge bruises", "has an imaginary friend who it thinks is real", "knows how to get to the black market", "thinks your skin looks delicious", "wants to marry one of the party members", "has no sense of personal space", "is wearing a jester hat", "is sleepwalking", "talks in third person", "ready to poop itself at any moment", "cries every time it hears the word: you", "believes that the sun is just a conspiracy", "cannot handle the truth", "thinks meeting the players is a good omen", "has narcolepsy and constanty falls asleep", "always wears a creepy smile", "total coward", "has delusions of grandeour", "believes its actually another race in the wrong body", "shy", "bold", "confident", "is certain the government is watching it"
        ));
        return quirkList.get(randomIntInRange(0, (quirkList.size() - 1)));
    }

    public String getRandomPoorQuirk() {
        List<String> quirkList = new ArrayList<>(Arrays.asList(
                "perfectly normal", "narrates everything they do", "awkwardly follows you", "poorly plays a loot for you for money", "has an overbite", "has no iris", "spits frequently", "has 26 kids", "blames their parents for everything wrong in life", "is really into fitness", "has a creepy fetish for halflings", "dreams of making the worlds biggest flan", "never speaks, only sings", "only makes left turns", "spent 2 days in bayorots cavern, constantly name drops", "has waking night terrors", "has no personal space", "flea ridden", "lice ridden", "has mice living in their hat", "super angsty", "has a tick where they randomly punch people in the face", "has 12 toes", "loves raw onions", "complains a lot", "speaks in slang", "meticulously clean", "has a lot of tattoos", "only somewhat speaks common", "completely ignores the players", "dreams of being an adventurer", "dreams of being a portal chaser", "wants to do a painting of the players", "wants to shine the players armor", "mistakes the players for their drug dealer", "hates being outdoors", "has a higher pitched voice than normal", "has a lisp", "has a strange bulge on its neck", "the darkest eyes you have ever seen", "reminds you of a pug", "reminds you of a vulture", "looks at your gear longingly", "will not stop twitching", "really wants to tell you about its plan to renovate the sewer system", "only wants to talk about itself", "long-winded", "wants to tell you about the good old days", "thinks everything is funny", "extremely awkward", "constantly looking over its shoulder", "works out a lot", "has scarred hands", "has not slept in 2 days", "needs a bath", "attractive", "extremely ugly", "stands an abnormal distance away when talking", "looks ready to run at any moment", "has different-colored eyes", "better dressed than expected", "", "filthy", "horrible breath", "short", "emaciated", "thin", "missing teeth", "is in a lot of debt", "missing an arm", "missing a leg", "missing an eye", "tall", "stooped", "limping", "bloodshot eyes", "scarred", "injured", "diseasd", "has several thick blankets", "lazy eye", "crosseyed", "snaggle-tooth", "missing finger", "missing hand", "peg-leg", "smells horrible", "will not look at your face", "torn clothes", "really hates the government", "really hates one of the party members races", "mumbles a lot", "keeps looking over your shoulder", "really just needs a hug", "serious addict to healing potions", "serious alcoholic", "shy", "bold", "confident", "complete moron", "extremely gullible", "does not speak common", "snorts a lot", "wheezes", "major seasonal allergies", "has no arms", "has no legs", "has huge bruises", "knows how to get to the black market", "cannot handle the truth", "has narcolepsy and constanty falls asleep", "always wears a creepy smile", "total coward", "has delusions of grandeour", "believes its actually another race in the wrong body", "is certain the government is watching it"
        ));
        return quirkList.get(randomIntInRange(0, (quirkList.size() - 1)));
    }

    public String getRandomMiddleClassQuirk() {
        List<String> quirkList = new ArrayList<>(Arrays.asList(
                "perfectly normal", "has a creeper stache", "has an overbite", "has no iris", "smokes and blows ring in your face", "only speaks in insults", "is wearing too much perfume", "has 26 kids", "blames their parents for everything wrong in life", "is really into fitness", "has a creepy fetish for halflings", "dreams of making the worlds biggest flan", "never speaks, only sings", "only makes left turns", "passionately wants to tell you about their spoon collection", "can never say no to a dare", "loves raw onions", "complains a lot", "meticulously clean", "completely ignores the players", "dreams of being an adventurer", "dreams of being a portal chaser", "wants to do a painting of the players", "mistakes the players for their drug dealer", "hates being outdoors", "has a higher pitched voice than normal", "has a lisp", "has a strange bulge on its neck", "the darkest eyes you have ever seen", "reminds you of a pug", "reminds you of a vulture", "looks at your gear longingly", "will not stop twitching", "really wants to tell you about its plan to renovate the sewer system", "only wants to talk about itself", "long-winded", "wants to tell you about the good old days", "thinks everything is funny", "extremely awkward", "constantly looking over its shoulder", "works out a lot", "has scarred hands", "has not slept in 2 days", "needs a bath", "attractive", "extremely ugly", "stands an abnormal distance away when talking", "looks ready to run at any moment", "has different-colored eyes", "better dressed than expected", "", "filthy", "horrible breath", "short", "emaciated", "thin", "missing teeth", "missing an arm", "missing a leg", "missing an eye", "tall", "stooped", "limping", "bloodshot eyes", "scarred", "injured", "diseasd", "has several thick blankets", "lazy eye", "crosseyed", "snaggle-tooth", "missing finger", "missing hand", "peg-leg", "smells horrible", "will not look at your face", "torn clothes", "really hates the government", "really hates one of the party members races", "mumbles a lot", "keeps looking over your shoulder", "really just needs a hug", "serious addict to healing potions", "serious alcoholic", "complete moron", "extremely gullible", "does not speak common", "shy", "bold", "confident", "snorts a lot", "wheezes", "major seasonal allergies", "has no arms", "has no legs", "has huge bruises", "knows how to get to the black market", "cannot handle the truth", "has narcolepsy and constanty falls asleep", "always wears a creepy smile", "total coward", "speaks slowly", "speaks quickly", "has delusions of grandeour", "believes its actually another race in the wrong body", "is certain the government is watching it", "overweight", "so fat it is a miracle it can stand up", "longer arms than normal", "underweight"
        ));
        return quirkList.get(randomIntInRange(0, (quirkList.size() - 1)));
    }

    public String getRandomWealthyQuirk() {
        List<String> quirkList = new ArrayList<>(Arrays.asList(
                "wears a monacle", "used to be a beggar and tells you all about it", "perfectly normal", "has a creeper stache", "is wearing shoes that are too big", "has an overbite", "has no iris", "smokes and blows ring in your face", "only speaks in insults", "is wearing too much perfume", "has 26 kids", "blames their parents for everything wrong in life", "is really into fitness", "has a creepy fetish for halflings", "dreams of making the worlds biggest flan", "never speaks, only sings", "can never say no to a dare", "loves raw onions", "complains a lot", "shy", "bold", "confident", "meticulously clean", "completely ignores the players", "dreams of being an adventurer", "dreams of being a portal chaser", "hates being outdoors", "has a lower voice than normal", "fat", "skinny", "extremely overweight", "likes to comment about the players weight", "very blunt", "thinks it is better than everyone else", "thinks it is a god among men", "expects all opposite genders to be swooning over it", "extremely self-absorbed", "much friendlier than expected", "very generous", "wants to help others", "thinks the party are beggars", "uses lots of big words", "tells you to get a job", "flaunts the fact that it is wealthy", "is very humble", "is allergic to a party members race", "has a strange accent", "has a huge nose", "has a smaller mouth than expected", "is extremely muscular", "looks like lifting a pen would count as a workout for it", "wants to improve the world", "is obsessed with rating others attractiveness", "talks way too much about the parties it has attended", "does not deem the players worthy of its attention", "envies the adventuring life", "wants to hear a good story", "tips those that help it", "has an alcohol problem", "has a gambling problem", "pretends, poorly, that it cannot speak the players languages", "rolls its eyes a lot", "has a really bad temper", "is very patient", "looks out for others", "does not want to be seen in the players company", "collects autographs", "wants to buy one of the players pieces of gear for more than it is worth", "is convinced it is going to run Grand Bastion some day", "thinks everyone wants to do it favors", "considers itself a blessing on everyone else", "inherited all its wealth and is very incompetent", "extremely shy", "very well dressed", "tells you to get a job", "tall", "short", "very alert", "smells nice", "wants to know who your stylist is", "judges everyone", "is very kind and gentle", "speaks very eloquently", "looks like they have had magic enhance their looks", "speaks condescendingly", "is an aspiring poet and wants to write one for you", "has a great singing voice", "thinks it sings well but it very much does not", "wears a stupid hat but is very proud of it", "looks like it is wearing a set of its grandmothers drapes but thinks it is the height of fashion", "is dressed in stripes and plaids", "refuses to talk to anyone not born in Grand Bastion", "is racist", "is very down-to-earth", "will pay to see a feat of magic", "handles itself with grace", "thinks that Grand Bastion needs a king, and that it should be the king", "treats everyone like they are idiots", "is well traveled", "loves a good drink", "easily pleased", "has a swollen cheek", "turned its skin a different color and loves it"
        ));
        return quirkList.get(randomIntInRange(0, (quirkList.size() - 1)));
    }

    private List<Spell> getSpellListByLevel(int level) {
        List<Spell> listToReturn = new ArrayList<Spell>(Arrays.asList());
        for (Spell temp : StandardSpells.masterSpellList) {
            if (temp.level == level) {
                listToReturn.add(temp);
            }
        }
        return listToReturn;
    }

    public Spell getRandomSpellByLevel(int level) {
        List<Spell> randomOptions = getSpellListByLevel(level);
        return randomOptions.get(randomIntInRange(0,(randomOptions.size() - 1)));
    }
}
