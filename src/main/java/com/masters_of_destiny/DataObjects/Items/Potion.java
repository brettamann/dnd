package com.masters_of_destiny.DataObjects.Items;

import com.masters_of_destiny.Utilities.RandomGenerator;
import com.masters_of_destiny.Utilities.Screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Potion {
    private String name;
    private String title;
    private String container;
    private String mainEffect;
    private String sideEffect;
    private String mainEffectPotency;
    private String sideEffectPotency;
    private String sideEffectLength;
    private String mainEffectLength;
    private String liquidMainAppearance;
    private String liquidSecondaryAppearance;
    private String appearance;
    private String smell;
    private String taste;
    private String label;
    private String texture;
    public String textToDisplay;
    public String dmTextToDisplay;

    private static final String insignificant = "1 turn";
    private static final String slight = "5 turns";
    private static final String minor = "10 turns";
    private static final String small = "10 minutes";
    private static final String moderate = "1 hour";
    private static final String medium = "6 hours";
    private static final String regular = "12 hours";
    private static final String significant = "18 hours";
    private static final String large = "1 day";
    private static final String major = "1 week";
    private static final String huge = "1 month";
    private static final String permanent = "forever or remove curse";

    private static final String basicallyWater = "Basically Nonexistant";
    private static final String extremelyDiluted = "Extremely Diluted";
    private static final String diluted = "Diluted";
    private static final String slightlyDiluted = "Slightly Diluted";
    private static final String regularStrength = "Regular";
    private static final String concentrated = "Concentrated";
    private static final String highlyConcentrated = "Highly Concentrated";
    private static final String extremelyConcentrated = "Extremely Concentrated";
    private static final String toxicallyConcentrated = "Toxically Concentrated";
    private static final String toxic = "Toxic";

    public void display() {
        Screen.println(textToDisplay);
    }

    public void createAndDisplayNoDm() {
        createRandomPotion();
        display();
    }

    public void createAndDisplayWithDM() {
        createRandomPotion();
        display();
        Screen.println("\nREAD:");
        displayDmText();
    }

    public void displayDmText() {
        Screen.println("Examining the potion, it's " + container + " labeled with " + label + ".\nInside is a " + texture + " " + liquidMainAppearance + " " + title + " with " + liquidSecondaryAppearance + ". It smells like " + smell + ".");
    }

    public Potion createRandomPotion() {
        title = getRandomTitle();
        container = getRandomContainer();
        label = getRandomLabel();
        texture = getRandomTexture();
        liquidMainAppearance = getRandomMainAppearance();
        liquidSecondaryAppearance = getRandomSecondaryAppearance();
        smell = getRandomFlavor();
        taste = getRandomFlavor();
        appearance = "Container label: " + label + ". Fluid looks like " + texture + " " + liquidMainAppearance + " with " + liquidSecondaryAppearance + ". Smells like " + smell + " and tastes like " + taste;

        mainEffect = getRandomMainEffect();
        sideEffect = getRandomSideEffect();
        mainEffectPotency = getRandomPotency();
        sideEffectPotency = getRandomPotency();
        mainEffectLength = getRandomEffectLength();
        sideEffectLength = getRandomSideEffectLength();

        //mainEffect = "Main Effect: " + getRandomPotency() + " for " + getRandomEffectLength() + ", " + getMainEffect();

        textToDisplay = getKeyWordFromPotency(mainEffectPotency) + "" + title + " of " + getKeyWordFromEffect(mainEffect).replace(".", "") + ", in " + container +  "\n"
        + appearance + "\n"
        + "Main Effect: " + mainEffectPotency + ". For " + mainEffectLength + ", " + mainEffect + "\n"
        + "Side Effect: " + sideEffectPotency + ". For " + sideEffectLength + ", " + sideEffect
        ;
        return this;
    }


    private String getKeyWordFromEffect(String effect) {
        Pattern pattern = Pattern.compile("^.*?\\.");
        Matcher matcher = pattern.matcher(effect);
        if (matcher.find()) {
            return matcher.group(0);
        }
        else return "ERROR: could not find main effect key word in: " + effect;
    }

    private String getPotencyNumber(String potency) {
        switch (potency) {
            case basicallyWater:
                return "1";
            case extremelyDiluted:
                return "" + RandomGenerator.randomIntInRange(1, 2);
            case diluted:
                return "" + RandomGenerator.randomIntInRange(2, 3);
            case slightlyDiluted:
                return "" + RandomGenerator.randomIntInRange(3, 4);
            case regularStrength:
                return "" + RandomGenerator.randomIntInRange(4, 6);
            case concentrated:
                return "" + RandomGenerator.randomIntInRange(5, 8);
            case highlyConcentrated:
                return "" + RandomGenerator.randomIntInRange(8, 12);
            case extremelyConcentrated:
                return "" + RandomGenerator.randomIntInRange(10, 14);
            case toxicallyConcentrated:
                return RandomGenerator.randomIntInRange(12, 20) + " & " + RandomGenerator.randomIntInRange(15,50) + " poison damage";
            case toxic:
                return RandomGenerator.randomIntInRange(15, 50) + " poison damage, corrupts main effect";
        }
        return "ERROR: no effect";
    }

    private String getRandomEffectLength() {
        return RandomGenerator.getRandomFromStringList(new ArrayList<>(Arrays.asList(
                insignificant,
                slight,
                minor,
                small,
                moderate,
                medium,
                regular,
                significant,
                large,
                major,
                huge,
                permanent
        )));
    }

    private String getRandomSideEffectLength() {
        return RandomGenerator.getRandomFromStringList(new ArrayList<>(Arrays.asList(
                insignificant,
                insignificant,
                slight,
                slight,
                slight,
                minor,
                minor,
                minor,
                minor,
                small,
                small,
                small,
                small,
                small,
                moderate,
                moderate,
                moderate,
                moderate,
                medium,
                medium,
                medium,
                regular,
                regular,
                significant,
                large,
                major,
                huge,
                permanent
        )));
    }

    private String getRandomPotency() {
        String potency = RandomGenerator.getRandomFromStringList(new ArrayList<>(Arrays.asList(
                //this creates a bell curve. optionCount/22 % chance
                basicallyWater,
                extremelyDiluted,
                diluted,
                diluted,
                slightlyDiluted,
                slightlyDiluted,
                slightlyDiluted,
                regularStrength,
                regularStrength,
                regularStrength,
                regularStrength,
                regularStrength,
                regularStrength,
                regularStrength,
                concentrated,
                concentrated,
                concentrated,
                highlyConcentrated,
                highlyConcentrated,
                extremelyConcentrated,
                toxicallyConcentrated,
                toxic
        )));
        return potency + " (mod = " + getPotencyNumber(potency) + ")";
    }

    private String getKeyWordFromPotency(String potency) {
        Pattern pattern = Pattern.compile("^[A-Za-z ]+");
        Matcher matcher = pattern.matcher(potency);
        if (matcher.find()) {
            return matcher.group(0);
        } else return "ERROR: could not find main potency key word in: " + potency;
    }

    private String getRandomTitle() {
        return RandomGenerator.getRandomFromStringList(new ArrayList<>(Arrays.asList(
                "Potion",
                "Elixir",
                "Draught",
                "Vial",
                "Philter",
                "Tonic",
                "Brew",
                "Ichor",
                "Juice",
                "Concoction",
                "Serum",
                "Mixture"
        )));
    }

    private String getRandomMainEffect() {
        return RandomGenerator.getRandomFromStringList(new ArrayList<>(Arrays.asList(
                "Healing. It instantly regenerates {mod*2} health when drank.",
                "Luck. +mod advantage when playing any gambling game",
                "Elemental Infusion. The caster becomes an elemental of air, earth, fire, or water, with the type's accompanying stats with the exception of still only speaking the drinker's native languages and retaining memories. During this time all gear worn and carried is morphed into the person. Roll a d4 to determine which elemental.",
                "Vigor. Gives {mod*2} temporary health when drank.",
                "Hairiness. Drinker grows {mod} feet of hair from their head and or chin.",
                "Smurf. Shrinks the user down to Tiny size, and turns their skin blue. -4 to Str and Con, +2 to Dex and Cha. Lasts for 1 hour, or until the user consumes a mushroom.",
                "Pointless Ear Hair. Does exactly what it says on the tin until the player sunbathers for two hours",
                "Reversed Invigorance. You swap HP with the nearest entity. If the new HP are more than your HP maximum, the excess HP are lost. The potion has no effect if the entity's HP maximum is more than twice your own HP max.",
                "Devious Duo. An opposite twin of yourself appears in the nearest empty space. The twin has the same stats as you, and is under the control of the DM. DMs are advised to play the twin as polar opposite of the character as possible.",
                "Hot Hands. Makes the user's hands hot enough to burn for 5 minutes (does not harm the user('s hands), can light a fire if holding onto a wooden object for 1 round)",
                "Bushwalking. The user grows leaves and flowers all over their skin, which remain for 24 hours. The user's eyes can just barely be seen through the brush.",
                "Flaming Head. User's hair turns red, and they can cast firebolt for the duration",
                "Embarassing clumsiness. User is clumsy for the duration, dropping or knocking something on a roll of 1 on 1d4 when attempting to take an action.",
                "Forced Truth. User and everyone within 5ft are under the effects of Zone of Truth for the duration. Anyone entering the zone makes the usual CHR saving throw against a DC 15.",
                "Dragon Skin. The user sprouts red scales and can use a fire breath attack once. The effect dispels upon use of the breath attack.",
                "Vitality. It slowly regenerates {mod} health during the next short rest.",
                "Might. It gives a {mod} bonus to to-hit attack rolls after drinking.",
                "Courage. Gives immunity to fear and some temporary inspiration.",
                "Giant Strength. +{mod} to STR.",
                "Flame Resistance. It gives resistance to fire damage.",
                "Cold Resistance. It gives resistance to cold damage.",
                "Necro Resistance. Gives resistance to necrotic damage.",
                "Radiant Resistance. Gives resistance to radiant damage.",
                "Stoneskin. Gives resistance to martial damage.",
                "Acid Resistance. Gives resistance to acid.",
                "Lightning Resistance. Gives resistance to lightning damage.",
                "Succubus Charm. Makes the drinker irresistible to nearby people. +{mod} to social-related rolls",
                "Shielding. Gives the user a magical shield of energy that absorbs {mod*2} non-physical damage before expiring.",
                "Flame Breath. Gives the user {mod} uses of fire breath for a short time as if it were a dragonborn.",
                "Growth. Makes the user double in size.",
                "Shrinking. Makes the user half in size.",
                "Comprehension. Lets the user understand all languages.",
                "Fertility. Makes the user very fertile, almost certain to make a baby under its effects!",
                "Intimidation. Gives the user a huge booming voice that terrifies those around. +{mod} to intimidation",
                "Luck. It gives the user a temporary boost to luck. +{mod} to all rolls",
                "Mana. Gives the user more magical power to cast with. +{mod} spell slots of choice (lvl 5 would take 5 \"mod\" points",
                "Arcane. Gives the user more powerful spells. +{mod} to spell to-hit rolls, spell DC, and spell damage",
                "Animal form. Makes the user turn into a random animal.",
                "Dreams. Makes the user get lost in a hallucinary dream world of their perfect dream. Asleep for the duration, gain {mod} temp hp if not disturbed/harmed during the time period",
                "Nightmares. Makes the user get lost in a hallucinary dream world of their worst nightmares. Takes {2*mod} psychic damage if disturbed/harmed during the sleep",
                "Stamina. Gives the user more stamina and constitution. +{mod} to CON-related rolls, and +5 speed",
                "Fleet foot. Makes the user have +{mod*2, rounded to nearest 5, minimum 5} speed.",
                "Knowledge. Increases the users intelligence by {mod}.",
                "The Bard. +{mod} to charisma.",
                "Disguise. Changes the users form to a disguised form of any race and appearance.",
                "Feast. Removes all hunger and thirst from the target.",
                "Youth. Makes the user grow {mod} years younger.",
                "Age. Makes the user grow {mod} years older.",
                "Furnace. Makes the user radiate with a damaging aura of {mod} damage per turn within {mod, rounded to nearest 5, minimum 5} ft",
                "Eagle Sight. Gives the user strong vision and a +{mod} bonus to perception.",
                "Health. Cures all diseases and illnesses, and heals {mod} hp",
                "Invulnerability. Freezes the user in stasis that makes them immune to damage but they cannot move or act. Cannot move during the first turn out of stasis but can take actions",
                "Riddle me gone. Gives the user the answer to a single riddle.",
                "Horrifying appearance. Makes the user look more ugly for a time. -{mod} to all social skills if their body is visible",
                "Beautiful appearance. Makes the user appear more attractive for a time. +{mod} to social rolls if body is visible",
                "Swordsmanship. Makes the user more effective and versatile with a blade. +{mod} damage and +{1/2 mod} to hit with a bladed weapon",
                "Bowmanship. Makes the user more effective with a bow or ranged weapon. +{mod} damage and +{1/2 mod} to hit with ranged weapons",
                "Nymph Breath. Gives water breathing.",
                "Midas. Makes the user turn the next {mod} objects they touch to gold. Equipped gear is immune to this effect and 'touch' is transmitted through equipped gear.",
                "Berserker. Makes the user rage with great strength. +{mod*2} melee-weapon damage",
                "Utter Hatred. Makes the user have bonuses against a particular type of enemy.",
                "Oracle. The user may ask a question about the future, and is granted a vision to answer their question, but is limited to {mod} days in the future.",
                "Demonic Leech. All damage dealt heals for 1/4 the amount dealt. +{1/2 mod} to damage rolls .",
                "Fey Nature. Lets the user become one with animals and nature around them. +{mod} for nature-related skills",
                "Tracelessness. Makes the user very hard to follow. +{mod} to survival",
                "Gracefulness. Makes the user have a better acrobatics skill. +{mod} to acrobatics",
                "Goblin Climb. Gives the user a bonus to climbing. +{mod rounded to nearest 5, minimum 5} climb speed",
                "Dead Ringer. Makes the user appear completely dead to all magic. Spells that cannot affect living creatures cannot affect you, and spells that only affect the dead affect you",
                "One Leafed Clover. Gives the user worst luck. -{2*mod} to all rolls",
                "Possession. Lets the user gain control of a nearby creature within {mod*5} ft that they can see, their body is unconscious while they do.",
                "Owls Wake. The user does not need to sleep during a rest.",
                "Hawks Flight. Lets the user fly at 1/2 their movement speed. and walk at half their normal movement speed.",
                "Peace. Makes the user very calm and unable to harm others. DC {mod * 3} WIS save to overcome",
                "Rejuvenation. Heals {1/4 mod hp, minimum 1} every round, or if user is missing a body part that heals.",
                "Sphinxes Truth. Makes the user tell the truth. DC (mod * 3} WIS check to overcome",
                "Serpent Tongue. Makes the user only able to lie. DC {mod * 3} WIS check to overcome",
                "Navigation. User is able to find any place they have been to previously.",
                "Hook Horror. The users hands become sharp weaponised blades. +{mod} to unarmed damage",
                "Schaffensfreude. 50% of damage dealt to the user is also dealt to the source. Does not reduce damage dealt to the user.",
                "Invisibility. Makes the user invisible.",
                "Wild magic. Taps into wild magic making an absolutely random thing happen.",
                "Fame. Makes the user more famous. Others may roll a recognition check of +{mod}, DC 20 to recognize the person",
                "Goats Trek. Makes the user immune to the toils of long travels and bad weather.",
                "Gargoyle Toughness. Increases the users constitution by {1/2 mod, minimum 1}.",
                "Atomic Clock. Lets the user know the exact tme and date.",
                "Transmutation. Lets the user have the ability to change somethings properties.",
                "Iron Skin. Turns the users skin to metal giving them resistance to all physical damage.",
                "Sex Change. Changes the users gender.",
                "Race Change. Changes the users race.",
                "Musical Breath. Makes the user say everything in song, and fey music follows them in the air.",
                "Greater Understanding. Grants the user knowledge about a specific weapon. Permanent +1 to-hit with that one chosen weapon (not weapon type or category).",
                "Split Form. The user turns into two or three tiny versions of themselves and controls them all. All gear is duplicated for each instance but NO posessions on any of the entities can be taken or given away. If such a thing happens, the duplicates are destroyed and the spell ends.",
                "Flavour. Makes anything and everything taste amazing!",
                "Glimmer. Makes the user and its gear instantly clean and as good looking as possible.",
                "Love. Makes the user and someone else fall in love.",
                "Poison. Poisons the user, weakening them. -{1/2 mod, minimum 1} CON",
                "Rebirth. Resurrects the user if they die soon after drinking.",
                "Elemental form. Turns the user to an elemental form relevant to their personality.",
                "True form. Turns the user into a familiar like creature similar to their personality.",
                "Gods Touch. Gives the user a holy connection to their god or fiendish deity through which they may ask for a favor. +{mod} to the roll that they ask",
                "Antidepressant. Does what it says on the tin. Cannot be made to feel sad through magical means",
                "Ghostly Form. Makes the user intangible and able to phase through objects, can move in any direction, but at 5 speed only. Cannot interact with anything or cast spells during this time but can still see and hear normally.",
                "Artisans Skill. Gives the user +{mod} skill in a particular art temporarily - calligraphy, painting, drawing, sculpting, etc.",
                "Godly form. Improves all stats by 1.",
                "Bless Weapon. Makes the users weapons do {mod} more damage.",
                "Euphoria. Makes the user feel amazing. -{mod} to WIS rolls but +{mod} to CON rolls.",
                "Bodyguard. Creates a spectral bodyguard for a short time who obeys orders. bodyguard cannot be harmed and has {10+mod} to hit and deals {mod} damage with its weapon. Cannot speak.",
                "Babelfish. Lets the user speak any language but not understand it.",
                "Preservation. Stops whatever its poured on from rotting or degrading for the duration.",
                "Fear. Makes the user terrified and flee from all living things. {mod*3} WIS save per turn to resist.",
                "Night Vision. Gives the user darkvision up to {mod*10} ft",
                "Tracking. Grants +{mod} to survival rolls to track a creature",
                "Cure-all. Cures any status effects. Prevents sleep, fear, charm, petrification, stun, and confusion for the duration.",
                "Messy Transformation. -4 to a random primary skill and +4 to a different random primary skill",
                "Identification. The drinker can identify magical objects at-will for the duration.",
                "Skill Swap. The drinker's best primary stat switches with their worst for the duration.",
                "Soul Exchange. Your spirit and that of a random party member switch bodies for the duration. (swap control of characters)"
        )));
    }

    private String getRandomSideEffect() {
        return RandomGenerator.getRandomFromStringList(new ArrayList<>(Arrays.asList(
                "Nothing bad at all happens!",
                "Puts the user to sleep for the duration. Dispel magic or remove curse to counter.",
                "Rapid hair growth all over the body. -{mod} to all social rolls.",
                "Bleeding from the eyes. -{mod} to all sight-related rolls, social-related rolls, and -{mod} max hp",
                "Vivid hallucinations. -{mod} to all sight or hearing related rolls.",
                "Visions of your own eventual demise. Can't be sure if they're real or not.",
                "The skin to crack and appear distorted. -{mod} to all social rolls if skin is visible.",
                "Spots to grow on the skin. -{mod} to all social rolls if skin is visible.",
                "Diarrhoea. -{5*mod} to all movement and -{mod} to dex rolls. -{mod} to AC",
                "Vomiting. -{5*mod} to all movement and -{mod} to dex and str rolls. -{mod} to AC",
                "Blurred Vision. -{mod} to all sight-related rolls",
                "Blindness. Automatically fail all checks relating to sight.",
                "Deafness. Cannot hear for the duration.",
                "Mutism. Cannot speak for the duration.",
                "Forgetfulness. Lose all spell slots as if they had been used.",
                "Health loss via rapid bleeding. -{mod} HP per turn",
                "A sudden horrific accent. -{mod} to all speech-related rolls",
                "The irresistible urge to dance. -{2*mod} to all rolls while dancing.",
                "The hearing of demons. +{mod} to hearing-related checks",
                "Loss of balance. -{mod} to all DEX-related rolls",
                "Everything tasting like dirt for some time. Fail all taste checks.",
                "Excessive drooling. -{mod} to all checks related to speech",
                "intelligence reduced by {mod} for the duraction.",
                "strength reduced by {mod} for the duraction.",
                "speed reduced by {mod, rounded to nearest 5} for the duration.",
                "charisma reduced by {mod} for the duraction.",
                "Genuine happiness. You are very happy for the duration and gain +{mod / 3, min 1} charisma",
                "Hunger.",
                "Thirst.",
                "Trouble breathing. -{mod} to all attack rolls and rolls related to speech",
                "Sudden Moustache. a fantastic moustache grows on your face for the duration",
                "Poisoning. -{mod} hp per turn for the duration",
                "Petrification. Con save DC is {2*mod} or be petrified for the duration unless counteracted.",
                "Stunning. Con save DC is {2*mod} or be stunned for the duration",
                "Immobilisation. Cannot in any way move.",
                "Increased libido. -{mod / 4, min 1} to WIS",
                "Fidgeting. -{mod / 4, min 1} to DEX",
                "Itchiness. -{mod} to social rolls",
                "Rashes. -{mod / 4, min 1} to CON saves",
                "Attracts bears, wolves, and snakes within {mod} miles.",
                "Magically covers you in dirt. -{mod} to social rolls",
                "Horrifying stench. -{2*mod} to social rolls",
                "Baldness.",
                "Swelling. Up to {mod*5} % of the body becomes swollen",
                "Loss of a random item for the duration of the potion.",
                "Curses.",
                "Take {mod} untyped Damage.",
                "Weakness to a magical damage type.",
                "Weakness to physical damage.",
                "Feelings of Guilt",
                "Feelings of Anxiety. -{mod} to saves against fear",
                "Feelings of Shame. -{mod} to saves against charm",
                "Sneezing. -{2*mod} on all smell-related rolls. -{mod} to dex rolls. When casting a spell, make a DC 10+{mod} CON save or the spell fails to cast",
                "Uncontrollable crying. {-mod} to sight-related rolls. When casting a spell, roll a DC 10+{mod} CON save or the spell fails to cast",
                "Need to sing heroic music.",
                "Urge to hug.",
                "Kleptomania. DC {mod*2} to resist pickpocketing or theft rather than other actions",
                "Burping.",
                "Loss of smell. Smell-related rolls fail.",
                "Insomnia. Cannot gain effects from rest.",
                "Paranoia. {-2*mod} to saves against fear.",
                "Bad luck. -{mod} to all rolls",
                "Summons {mod} imps that want to kill you.",
                "Summons {3*mod} angry bees.",
                "Fear of something.",
                "Temporary madness. Each round roll d4 and take the corresponding action7. 1: you attack the nearest person at random. 2: you run from all living things. 3: you attack yourself (-4 penalty to hit). 4: you babble incoherently.",
                "Relaxation. Resting effects you twice as much.",
                "Appreciation of colours and sound.",
                "Go on a bad trip. -{mod} to all social skills, and -{2*mod} to all checks and saves.",
                "Painful lust.",
                "Light headedness. -{mod} to perception",
                "Increased confidence. +{mod} against fear-related saves",
                "Recklessness. WIS DC {2*mod} to not do something reckless",
                "Rage. +{mod} damage to attack rolls and +{mod} to intimidation, -{2*mod} to other social rolls",
                "Sadness.",
                "Dizziness. -{mod} to DEX related rolls",
                "Pain. When damaged, make CON DC {mod*2} save or go prone in pain",
                "Slight possession. DC {mod*2} WIS save every turn or a spirit takes over movement",
                "Allergic reaction to your favourite food.",
                "Strong belief you’re someone else.",
                "Severe debt. lose {mod*500} gp. If the full amount isn't paid, a lvl {mod} demon appears and attacks",
                "Grumpiness.",
                "Muscle spasms. -{mod} to damage rolls and -{mod} to dex rolls",
                "A bloated feeling.",
                "A cold. -{mod} to CON saves and smell-related rolls",
                "A fever. -{mod} to CON saves",
                "Become strangely light. -{10*mod} lbs",
                "Weakness. -{mod} STR",
                "The urge to fight. DC {mod*2} WIS to resist urge to fight anyone you see",
                "The need to make friends. DC {mod*2} WIS to resist urge to try to befriend anyone you see",
                "Nausea. -{mod} to CON saves, -5 speed",
                "Mood swings.",
                "Addiction.",
                "Need for booze.",
                "Drunkeness. -{mod} to all rolls",
                "Coughing. -{mod} to social skills",
                "Uncontrollable babbling. all speech-related rolls fail",
                "Slight aches.",
                "A bad taste for some time. Taste-related rolls fail.",
                "Giddiness. -{mod} wisdom, +{1/4 mod} chr",
                "Laughter. -{mod} to DEX, STR, and speed.",
                "Limited Luck. Rather than rolling dice during combat, you may make only 1 \"roll\" per round and that \"roll\" is always a base of 15. You fail all other rolls (saves, checks, etc). Rolls against your AC gain +4"
        )));
    }

    private String getRandomContainer() {
        return RandomGenerator.getRandomFromStringList(new ArrayList<>(Arrays.asList(
                "a conical smooth glass bottle",
                "a square glass bottle",
                "a not quite watertight leather waterskin",
                "a stone flask",
                "a metal thermos",
                "a glass syringe",
                "a small medical vial",
                "a small shot sized bottle",
                "a large metal bottle",
                "a capped horn",
                "an ornate very decorated glass bottle",
                "a geometric diamond shaped bottle",
                "a translucent long wine bottle",
                "a translucent beer bottle",
                "a leather pouch",
                "an inhaler-like spray bottle",
                "a colored bottle",
                "a bone flask",
                "a small metal vial",
                "a large bottle that can be swigged several times.",
                "an egg-shaped membrane with a small valve for an opening",
                "a watertight wooden flask",
                "a spherical orb with a nozzle",
                "a lidded cup",
                "a standard potion bottle",
                "a mug",
                "a hollowed fruit with a straw",
                "a perfume bottle",
                "a small wicker bottle that somehow doesn't leak",
                "a bottle made of thick leaves and sap",
                "a skull-shaped clay bottle",
                "a cement vial",
                "a magical sphere of force acting as a vial",
                "a hollowed-out amber vial",
                "a bottle of molded beeswax",
                "a thick egg with a cork plug",
                "a mysterious leathery organ stitched to contain liquid"
        )));
    }

    private String getRandomMainAppearance() {
        return RandomGenerator.getRandomFromStringList(new ArrayList<>(Arrays.asList(
                "Clear",
                "Blue",
                "Turquoise",
                "Green",
                "Red",
                "Pale Green",
                "Pink",
                "Light Blue",
                "White",
                "Black",
                "Dark Grey",
                "Charcoal",
                "Light grey",
                "Yellow",
                "Orange",
                "Burnt Orange",
                "Gold",
                "Orange",
                "Bronze",
                "Metallic",
                "Purple",
                "Violet",
                "Sage",
                "Tan",
                "Hot Pink",
                "Salmon-colored",
                "Brown",
                "Blood Red",
                "Dark Red"
        )));
    }

    private String getRandomSecondaryAppearance() {
        return RandomGenerator.getRandomFromStringList(new ArrayList<>(Arrays.asList(
               "Flecks of colour",
               "Swirls of colour",
               "Fizzing bubbles",
               "Bubbles suspended in it",
               "Some kind of bone floating in it",
               "Leaves and flowers in it",
               "Two separating liquid",
               "a Bright glow",
               "a Soft glow",
               "Stripes of colour",
               "Translucency",
               "a Cloudy murkiness",
               "Blood within it",
               "Dirt floating in it",
               "Chunks of metal in it",
               "Some type of gore from a slain creature",
               "Steam coming from it",
               "a Face in the liquid",
               "Constantly moving and shifting liquid",
               "a Constant heat",
               "Small sparks shooting on the top",
               "Small bits of meat swirling in it",
               "A finger floating at the bottom",
               "Thick sludge at the bottom",
               "Soft cream floating on top",
               "Small flames on the surface of the liquid",
               "a reflective sheen",
               "Small sweets mixed in",
               "Pebbles in it",
               "A tiny frog swimming in it",
               "Illusory fairies floating inside",
               "A magical spoon constantly stirring it",
               "A constant cold emanating from it",
               "Chunks of ice in it",
               "Marbles on the bottom",
               "Glowing sand mixed in",
               "Black flecks you can't identify",
               "A corroded nail at the bottom",
               "A small pastry floating on the top",
               "Frosting floating on the top",
               "Teeth from some monster mixed in",
               "Plant matter mixed in",
               "Leaves mixed in",
               "Twigs and grass mixed in",
               "Chopped up fungus",
               "Potato bits mixed in",
               "Fish scales mixed in",
               "A glass ball rolling around inside",
               "A lot more weight than it should have",
               "A lot less weight than it should have",
               "A faint humming sound emanating from it",
               "A hissing noise emanating from it",
               "A layer of separated fatty substance",
               "thick foam",
               "chopped vegetables floating in it",
               "a gold coin in it",
               "a silver coin in it",
               "a copper coin in it",
               "a platinum coin in it",
               "a twig in it",
               "a single large bubble that never pops",
               "three glowing bubbles floating around in it",
               "a thin blade in it",
               "a whole egg too large to pour out in it",
               "a layer of black beans floating in the middle",
               "a pile of coal on the bottom",
               "a series of ribbons twirling on their own through the fluid",
               "a spider web near the mouth of the bottle as if it were a filter"
        )));
    }

    private String getRandomTexture() {
        return RandomGenerator.getRandomFromStringList(new ArrayList<>(Arrays.asList(
                "a thick and sludgy",
                "a thin and watery",
                "an airy and bubbly",
                "a slimey",
                "an almost solid",
                "an oily",
                "a chunky",
                "a gritty",
                "a creamy",
                "an almost gaseous"
        )));
    }

    private String getRandomFlavor() {
        String flavorToReturn = "";
        List modifierOptionsList = new ArrayList<>(Arrays.asList(
                "baked",
                "fried",
                "cooked",
                "dried",
                "pickled",
                "melted",
                "boiled",
                "crushed",
                "minced",
                "rotting",
                "spoiled",
                "seared",
                "poached",
                "wet",
                "spicy",
                "juiced",
                "moldy",
                "fresh",
                "sour",
                "warm",
                "burned"
        ));
        if (RandomGenerator.randomIntInRange(1, 100) <= 50) {
            flavorToReturn = RandomGenerator.getRandomFromStringList(modifierOptionsList);
            flavorToReturn = flavorToReturn + " ";
        }
        List optionsList = new ArrayList<>(Arrays.asList(
                "Nothing at all",
                "Sulphur",
                "summer breeze",
                "winter wind",
                "cookies",
                "Flowers",
                "meat",
                "eggs",
                "Fresh bread",
                "Blood",
                "Vomit",
                "Garlic",
                "Fruit",
                "Chocolate",
                "Beer",
                "Smoke",
                "Wood",
                "Death",
                "Orc",
                "dog",
                "goblin",
                "expensive Perfume",
                "Cheap perfume",
                "Musk",
                "Garbage",
                "Sand",
                "woodlands",
                "Nuts",
                "Acid",
                "Hot spices",
                "Mint",
                "strong chemicals",
                "Dirt",
                "oil",
                "Alcohol",
                "Sugar",
                "earth",
                "Rain",
                "Bitter herbs",
                "Bacon",
                "Coffee",
                "Cut grass",
                "Vanilla",
                "ocean spray",
                "Roasted meat",
                "festival",
                "Lavender",
                "Lilac and Gooseberries",
                "fresh baby smell",
                "Citris",
                "Leather",
                "Metal",
                "forge smell",
                "Fresh Cake",
                "Paint",
                "Wine",
                "Polish",
                "Cheese",
                "Fish",
                "Compost",
                "Apples",
                "Holy oils",
                "Massage oil",
                "brothel smells",
                "Old fruit",
                "Roses",
                "Gingerbread",
                "Cinnamon",
                "Candy",
                "acrid Fumes",
                "tree Bark",
                "Chicken",
                "Beef",
                "Human Flesh",
                "Gunpowder",
                "rain-storm smell",
                "snow-storm smell",
                "Success",
                "Gold",
                "Mayonnaise",
                "Barbeque",
                "Salt",
                "Pepper",
                "Aromatic spices",
                "Fruit punch",
                "Water",
                "Fresh water",
                "Stagnant water",
                "Mud",
                "sweaty ogre smell",
                "Music",
                "armagedden",
                "olives",
                "burnt chicken",
                "undercooked beef",
                "beef stew",
                "chicken broth",
                "shrimp",
                "buttered fish",
                "pickled vegetables",
                "smoked pork",
                "burning wood",
                "fresh rain",
                "fall leaves",
                "new furniture smell",
                "freshly baked pastries",
                "jerky",
                "cut flowers",
                "dragon's breath",
                "goblin sweat",
                "bad human body odor",
                "thyme",
                "oregano",
                "hot peppers",
                "milk",
                "hair",
                "scales",
                "ham",
                "rocks",
                "sewage",
                "mushrooms",
                "moth balls",
                "old bones",
                "corpses",
                "meatloaf",
                "pizza"
        ));
        flavorToReturn = flavorToReturn + RandomGenerator.getRandomFromStringList(optionsList);
        if (RandomGenerator.randomIntInRange(1,100) <= 40) {
            flavorToReturn = flavorToReturn + " mixed with ";
            if (RandomGenerator.randomIntInRange(1, 100) <= 40) {
                flavorToReturn = RandomGenerator.getRandomFromStringList(modifierOptionsList);
                flavorToReturn = flavorToReturn + " ";
            }
            flavorToReturn = flavorToReturn + RandomGenerator.getRandomFromStringList(optionsList);
        }
        return flavorToReturn;
    }

    private String getRandomLabel() {
        return RandomGenerator.getRandomFromStringList(new ArrayList<>(Arrays.asList(
                "its name and title in bold letters",
                "its description in ornate elvish",
                "its description in elvish with a relevant mythic story",
                "its description on dwarven",
                "Dwarven runes",
                "its description in gnomish",
                "Gnomish diagrams for its use",
                "The words USE ONLY IN EMERGENCIES scrawled on it",
                "a mass-produced label claiming the company has no fault for any side effects",
                "a mass-produced label saying \"New and improved flavor!\"",
                "very tiny print describing how the potion was made in great detail, around 1000 words",
                "its name in Bold words in Giant",
                "a scrawled-off note",
                "a note that is faded beyond reading",
                "nothing - Doesn’t seem to have one",
                "its description and a random fact",
                "its description and a small compliment to make your day better",
                "its description and a joke",
                "its description in infernal",
                "its description in some ancient language",
                "unrecognizable symbols",
                "some kind of raised symbols for the blind to read",
                "its description in elemental languages",
                "its name and flavour",
                "its name with a warning about side effects",
                "its name and its recommended buying price",
                "nothing - but bloody prints are all over it",
                "its name engraved into the container",
                "its name glowing with minor magic",
                "a cartoony mascot",
                "a warning of an ancient curse",
                "(ROLL PERCEPTION DC 20) its name and description in invisible ink",
                "its description in draconic",
                "several different names and descriptions plastered over each other",
                "a name of a completely different potion to what it does",
                "a title describing {{the exact opposite of what the potion does}}",
                "a money back guarantee",
                "a coupon for a free potion",
                "a living face looking around (can't speak)",
                "its name and recipe for other alchemists. It's long-winded and hard to follow.",
                "a heartfelt love letter for someone",
                "a heartfelt hate letter for someone",
                "a persons name and a warning that the potion wont work unless asked by its name to do so",
                "a strange rambling prophecy",
                "a small doodle",
                "a red note saying DO NOT DRINK",
                "a passive aggressive note about other people drinking potions that don’t belong to them",
                "brightly glowing letters",
                "nothing - but the bottle plays a very quiet lullabye (till the bottle is empty)",
                "ornate and beautiful designs",
                "strange arcane designs",
                "holy symbols",
                "unholy symbols",
                "fey symbols and sylvan writing",
                "a riddle (the liquid does not work or pour out of the bottle until the riddle is solved)",
                "a note saying its designed for babies",
                "a note saying that it shouldn’t be drunk by anyone under 18",
                "a note saying it's illegal contraband being confiscated",
                "a note saying the alchemist thinks it is its greatest work",
                "a note saying the alchemist is sorry for ever creating it",
                "a note saying that it \"never should have been made\" and copious blood stains over the bottle",
                "a note that says you’re being watched. When you double check the label it instead says \"Just Kidding\"",
                "its description in Druidic",
                "its description in Orcish",
                "its description in Goblin",
                "its description in Halfling",
                "its description in Celestial",
                "its description in Undercommon",
                "its description in Deep speech",
                "its description in strange arcane symbols",
                "a map of where the potion was made. You don't recognize the location",
                "a small puzzle for kids",
                "a list of ingredients in their chemical forms. (DC 20 Medicine or Arcana to identify the potion's use)",
                "a long list of possible side effects stretching across the entire bottle",
                "a red X",
                "a sad face",
                "an angry face",
                "a happy face",
                "a healing symbol",
                "a cheesy pun potion name",
                "nothing - but the bottle is growing with vines",
                "nothing - but the bottle is growing with flowers",
                "nothing - but the bottle is growing with crystals",
                "nothing - but the bottle is growing with rock",
                "shamanistic symbols and shavings",
                "no words, just a single colour",
                "a barely legible water-damaged note with the name and description",
                "a bow as if it was some kind of present",
                "a note showing how many calories it is",
                "a warning about potion abuse and to only take in moderation",
                "its description but the warnings and side effects all scribbled out",
                "a note that only shows the side effects",
                "a mysterious number",
                "a code name",
                "a few unrelated letters",
                "the name of one of the party members",
                "the name \"Bayorot\"",
                "nothing - but the bottle is crawling with bugs",
                "nothing - but the bottle is covered in creepy drawings that shift every time you look at them",
                "nothing - but the bottle is covered in glitter. It gets everywhere",
                "a note saying \"I'm sorry mom\"",
                "a note saying \"To my husband\"",
                "a note saying \"With love\"",
                "a fancy wax seal",
                "an inhuman fingerprint",
                "nothing - but the bottle is covered with barnacles",
                "nothing - but the bottle is scarred with claw marks",
                "a suicide note",
                "a flower symbol",
                "a hammer a shield symbol",
                "the words \"ha ha ha\",",
                "\"drink this\"",
                "\"drink in case of sudden family visit\"",
                "\"for those rough nights\"",
                "\"for the in-laws\"",
                "\"pre-fight elixir\""
        )));
    }
}
