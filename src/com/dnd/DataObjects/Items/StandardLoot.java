package com.dnd.DataObjects.Items;

import java.util.ArrayList;
import java.util.Arrays;

public class StandardLoot {
    //TODO: fill out loot items
    //good to find loot descriptions https://www.dndbeyond.com/search?q=backpack
    //money is always a loot type but doesn't need to be explicitly stated here

    public static final Loot callGlyph = new Loot("Call Glyph Tablet", "A circular stone tablet ~1\" thick and 5\" in diameter with an etching of Grand Bastion's emblem, used to call emergency services.", ItemTypes.misc, new ArrayList<>(Arrays.asList("Call guards","Call Fire services","Call medical services")), 1, Rarities.common, 0, 0, 0, 0);

    //Basic items / beggar class
    public static final Loot barrel = new Loot("barrel","a 1x1 wooden barrel with a lid",ItemTypes.misc, new ArrayList<>(Arrays.asList("Stores items")), 1,Rarities.common,0,0,0,1);
    public static final Loot backpack = new Loot("backpack", "leather pack carried on the back, typically with straps to secure it", ItemTypes.misc, new ArrayList<>(Arrays.asList("can hold 1 cubic foot/ 30 pounds of gear. You can also strap items, such as a bedroll or a coil of rope, to the outside of a backpack")), 1, Rarities.common, 0, 0, 0, 2);
    public static final Loot ballBearings = new Loot("ball bearings", "A bag of 1000 tiny metal balls in a pouch", ItemTypes.misc, new ArrayList<>(Arrays.asList("As an action, you can spill these tiny metal balls from their pouch to cover a level, square area that is 10 feet on a side. A creature moving across the covered area must succeed on a DC 10 Dexterity saving throw or fall prone. A creature moving through the area at half speed doesn’t need to make the save.")), 1, Rarities.common, 0, 1, 0, 0);
    public static final Loot basket = new Loot("basket", "a 2x2 wicker basket with no lid", ItemTypes.misc, new ArrayList<>(Arrays.asList("Stores items")), 1, Rarities.common, 0, 0, 0, 1);
    public static final Loot bedroll = new Loot("bedroll", "bedding and a thing blanket small enough to roll up and tie.", ItemTypes.misc, new ArrayList<>(Arrays.asList("You never know where you’re going to sleep, and a bedroll helps you get better sleep in a hayloft or on the cold ground. A bedroll consists of bedding and a blanket thin enough to be rolled up and tied. In an emergency, it can double as a stretcher.")), 1, Rarities.common, 0, 1, 0, 0);;
    public static final Loot arrow1 = new Loot("1 arrow", "1 standard arrow", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 0);
    public static final Loot arrows5 = new Loot("5 arrows", "5 standard arrows", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 0);
    public static final Loot bagofBallBearings1000 = new Loot("Bag of 1000 ball bearings", "As an action, you can spill these tiny metal balls from their pouch to cover a level, square area that is 10 feet on a side. A creature moving across the covered area must succeed on a DC 10 Dexterity saving throw or fall prone. A creature moving through the area at half speed doesn't need to make the save.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 1, 0, 0);
    public static final Loot bell = new Loot("Bell", "A standard bell that rings, typically used for signaling.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 1, 0, 0);
    public static final Loot blanket = new Loot("Blanket", "A thick, quilted, blanket made to keep you warm in cold weather.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 5, 0);
    public static final Loot blowgunNeedles1 = new Loot("Blowgun Needle", "Ammunition for a blowgun", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 0);
    public static final Loot blowgunNeedles5 = new Loot("Blowgun Needle", "Ammunition for a blowgun", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 5, Rarities.common, 0, 0, 0, 0);
    public static final Loot burglarsBackpack = new Loot("Burglar's Pack", "The following set of items: Backpack,ball bearing (100),string,candle (5),crowbar,hammer,piton (5),hooded lantern,flask of oil (2),rations (5),tinderbox,waterskin,hempen rope", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 1);
    public static final Loot caltropsBag = new Loot("Bag of Caltrops", "As an action, you can spread a single bag of caltrops to cover a 5-foot-square area. Any creature that enters the area must succeed on a DC 15 Dexterity saving throw or stop moving and take 1 piercing damage. Until the creature regains at least 1 hit point, its walking speed is reduced by 10 feet. A creature moving through the area at half speed doesn't need to make the saving throw.", ItemTypes.misc, new ArrayList<>(Arrays.asList("abilities")), 1, Rarities.common, 0, 0, 50, 0);
    public static final Loot candle1 = new Loot("Candle", "For 1 hour, a candle sheds bright light in a 5-foot radius and dim light for an additional 5 feet.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 1);
    public static final Loot candle5 = new Loot("Candle", "For 1 hour, a candle sheds bright light in a 5-foot radius and dim light for an additional 5 feet.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 5, Rarities.common, 0, 0, 0, 1);
    public static final Loot chalk1 = new Loot("Chalk", "A small piece of chalk, often used in some magic rituals. Or writing on the ground.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 1);
    public static final Loot chalk5 = new Loot("Chalk", "A small piece of chalk, often used in some magic rituals. Or writing on the ground.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 5, Rarities.common, 0, 0, 0, 1);
    public static final Loot commonClothes = new Loot("Common Clothes", "A set of basic unadorned clothing used by lower classes made of non-protective material.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 5, 0);
    public static final Loot componentPouch = new Loot("Component Pouch", "A component pouch is a small, watertight leather belt pouch that has compartments to hold all the material Components and other Special items you need to cast your Spells, except for those Components that have a specific cost (as indicated in a spell's description).", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 25, 0, 0);
    public static final Loot cooksUtinsels = new Loot("Cooking Utinsels", "A basic knife, fork, and spoon. Not much good as weapons.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 1);
    public static final Loot diceSet = new Loot("Pair of Dice", "A pair 6-sided die used in many different games", ItemTypes.misc, new ArrayList<>(Arrays.asList("If you are proficient with a gaming set, you can add your proficiency bonus to ability checks you make to play a game with that set.")), 1, Rarities.common, 0, 0, 1, 0);
    public static final Loot flask = new Loot("Flask", "A leather flask for holding liquid, often alcohol.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 2);
    public static final Loot flute = new Loot("Flute", "A carved wooden musical instrument", ItemTypes.misc, new ArrayList<>(Arrays.asList("If you have proficiency with a given musical instrument, you can add your proficiency bonus to any ability checks you make to play music with the instrument. A bard can use a musical instrument as a spellcasting focus.")), 1, Rarities.common, 0, 2, 0, 0);
    public static final Loot glassBottle = new Loot("Glass Bottle", "A bottle can hold 1 1/2 pints of liquid.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 2, 0, 0);
    public static final Loot hammer = new Loot("Hammer", "This one-handed hammer with an iron head is useful for pounding pitons into a wall.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 1, 0, 0);
    public static final Loot healersKit = new Loot("Healer's Kit", "This kit is a leather pouch containing bandages, salves, and splints.", ItemTypes.misc, new ArrayList<>(Arrays.asList("The kit has ten uses. As an action, you can expend one use of the kit to stabilize a creature that has 0 hit points, without needing to make a Wisdom (Medicine) check.")), 1, Rarities.common, 0, 5, 0, 0);
    public static final Loot hempenRope25ft = new Loot("Hempen Rope (25 ft)", "Has 2 hit points and can be burst with a DC 17 Strength check.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 1, 0, 0);
    public static final Loot herbalismKit = new Loot("Herbalism Kit", "This kit contains a variety of instruments such as clippers, mortar and pestle, and pouches and vials used by herbalists to create remedies and potions.", ItemTypes.misc, new ArrayList<>(Arrays.asList("Proficiency with this kit lets you add your proficiency bonus to any ability checks you make to identify or apply herbs. Also, proficiency with this kit is required to create antitoxin and any potion of healing.")), 1, Rarities.common, 0, 5, 0, 0);
    public static final Loot holySymbol = new Loot("Holy Symbol", "A holy symbol is a representation of a god or pantheon. A cleric or paladin can use a holy symbol as a spellcasting focus, as described in the Spellcasting section. To use the symbol in this way, the caster must hold it in hand, wear it visibly, or bear it on a shield.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 2, 0, 0);
    public static final Loot hoodedLantern = new Loot("Hooded Lantern", "A handheld lantern that can be dimmed.", ItemTypes.misc, new ArrayList<>(Arrays.asList("A hooded lantern casts bright light in a 30-foot radius and dim light for an additional 30 feet. Once lit, it burns for 6 hours on a flask (1 pint) of oil. As an action, you can lower the hood, reducing the light to dim light in a 5-foot radius.")), 1, Rarities.common, 0, 5, 0, 0);
    public static final Loot hornInstrument = new Loot("Horn (Instrument)", "A small horn used for music", ItemTypes.misc, new ArrayList<>(Arrays.asList("If you have proficiency with a given musical instrument, you can add your proficiency bonus to any ability checks you make to play music with the instrument. A bard can use a musical instrument as a spellcasting focus.")), 1, Rarities.common, 0, 3, 0, 0);
    public static final Loot ink1ozBottle = new Loot("Ink Bottle, 1 oz", "Ink is typically used with an ink pen to write.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 10, 0, 0);
    public static final Loot inkPen = new Loot("Ink Pen", "An ink pen is a wooden stick with a special tip on the end. The tip draws ink in when dipped in a vial and leaves an ink trail when drawn across a surface.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 2);
    public static final Loot ironPot = new Loot("Iron Pot", "An iron pot can hold 1 gallon of liquid.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 2, 0, 0);
    public static final Loot ironSpikes1 = new Loot("Iron Spike", "Standard iron spikes typically used with a hammer.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 10, 0);
    public static final Loot ironSpikes5 = new Loot("Iron Spike", "Standard iron spikes typically used with a hammer.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 5, Rarities.common, 0, 0, 10, 0);
    public static final Loot jug = new Loot("Jug", "A jug or pitcher can hold 1 gallon of liquid.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 2);
    public static final Loot lamp = new Loot("Lamp", "A small handheld device for lighting", ItemTypes.misc, new ArrayList<>(Arrays.asList("A lamp casts bright light in a 15-foot radius and dim light for an additional 30 feet. Once lit, it burns for 6 hours on a flask (1 pint) of oil.")), 1, Rarities.common, 0, 0, 5, 0);
    public static final Loot lock = new Loot("Lock", "Without the key, a creature proficient with thieves' tools can pick this lock with a successful DC 15 Dexterity check.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 10, 0, 0);
    public static final Loot lute = new Loot("Lute (Instrument)", "A stringed instrument, like a guitar with a broken neck", ItemTypes.misc, new ArrayList<>(Arrays.asList("If you have proficiency with a given musical instrument, you can add your proficiency bonus to any ability checks you make to play music with the instrument. A bard can use a musical instrument as a spellcasting focus.")), 1, Rarities.common, 0, 35, 0, 0);
    public static final Loot lyre = new Loot("Lyre (Instrument)", "Could be considered a handheld harp", ItemTypes.misc, new ArrayList<>(Arrays.asList("If you have proficiency with a given musical instrument, you can add your proficiency bonus to any ability checks you make to play music with the instrument. A bard can use a musical instrument as a spellcasting focus.")), 1, Rarities.common, 0, 30, 0, 0);
    public static final Loot manacles = new Loot("Manacles", "Metal restraints", ItemTypes.misc, new ArrayList<>(Arrays.asList("These metal restraints can bind a Small or Medium creature. Escaping the manacles requires a successful DC 20 Dexterity check. Breaking them requires a successful DC 20 Strength check. Each set of manacles comes with one key. Without the key, a creature proficient with thieves' tools can pick the manacles' lock with a successful DC 15 Dexterity check. Manacles have 15 hit points.")), 1, Rarities.common, 0, 2, 0, 0);
    public static final Loot mapScrollCase = new Loot("Map or Scroll Case", "This cylindrical leather case can hold up to ten rolled-up sheets of paper or five rolled-up sheets of parchment.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 1, 0, 0);
    public static final Loot messKit = new Loot("Mess Kit", "This tin box contains a cup and simple cutlery. The box clamps together, and one side can be used as a cooking pan and the other as a plate or shallow bowl.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 2, 0);
    public static final Loot minersPick = new Loot("Miner's Pick", "A miner's pick is designed to concentrate the force of its blow on a small area.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 2, 0, 0);
    public static final Loot mossAgateGem = new Loot("Moss Agate", "A translucent gemstone with pink or yellow-white with mossy gray or green markings", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 10, 0, 0);
    public static final Loot oilFlask = new Loot("Oil Flask", "Oil usually comes in a clay flask that holds 1 pint.", ItemTypes.misc, new ArrayList<>(Arrays.asList("As an action, you can splash the oil in this flask onto a creature within 5 feet of you or throw it up to 20 feet, shattering it on impact. Make a ranged attack against a target creature or object, treating the oil as an improvised weapon. On a hit, the target is covered in oil. If the target takes any fire damage before the oil dries (after 1 minute), the target takes an additional 5 fire damage from the burning oil. You can also pour a flask of oil on the ground to cover a 5-foot-square area, provided that the surface is level. If lit, the oil burns for 2 rounds and deals 5 fire damage to any creature that enters the area or ends its turn in the area. A creature can take this damage only once per turn.")), 1, Rarities.common, 0, 0, 1, 0);
    public static final Loot pairEngravedBoneDice = new Loot("Bone Dice", "A pair of engraved, carved dice made of some sort of bone", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 10, 0);
    public static final Loot panFlute = new Loot("Pan Flute (Instrument)", "A flute made of many small rods in a line", ItemTypes.misc, new ArrayList<>(Arrays.asList("If you have proficiency with a given musical instrument, you can add your proficiency bonus to any ability checks you make to play music with the instrument. A bard can use a musical instrument as a spellcasting focus.")), 1, Rarities.common, 0, 12, 0, 0);
    public static final Loot paperSheet1 = new Loot("Paper", "A sheet of standard paper is made from cloth fibers.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 2, 0);
    public static final Loot paperSheet5 = new Loot("Paper", "A sheet of standard paper is made from cloth fibers.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 5, Rarities.common, 0, 0, 2, 0);
    public static final Loot playingCardSet = new Loot("Playing Card Set", "If you are proficient with a gaming set, you can add your proficiency bonus to ability checks you make to play a game with that set.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 5, 0);
    public static final Loot pouch = new Loot("Pouch", "A cloth or leather pouch can hold 1/5 cubic foot/ 6 pounds of gear - or up to 20 sling bullets or 50 blowgun needles, among other things. A compartmentalized pouch for holding spell components is called a component pouch.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 5, 0);
    public static final Loot quiver = new Loot("Quiver", "A quiver can hold up to 20 arrows.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 1, 0, 0);
    public static final Loot dayRations1 = new Loot("Rations (1 day)", "Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 5, 0);
    public static final Loot dayRations2 = new Loot("Rations (1 day)", "Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 2, Rarities.common, 0, 0, 5, 0);
    public static final Loot dayRations3 = new Loot("Rations (1 day)", "Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 3, Rarities.common, 0, 0, 5, 0);
    public static final Loot dayRations4 = new Loot("Rations (1 day)", "Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 4, Rarities.common, 0, 0, 5, 0);
    public static final Loot dayRations5 = new Loot("Rations (1 day)", "Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 5, Rarities.common, 0, 0, 5, 0);
    public static final Loot dayRations6 = new Loot("Rations (1 day)", "Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 6, Rarities.common, 0, 0, 5, 0);
    public static final Loot dayRations7 = new Loot("Rations (1 day)", "Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 7, Rarities.common, 0, 0, 5, 0);
    public static final Loot robes = new Loot("Robes", "A standard set of robes.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 1, 0, 1);
    public static final Loot sack = new Loot("Sack", "A sack can hold 1 cubic foot/ 30 pounds of gear.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 0);
    public static final Loot shovel = new Loot("Shovel", "A standard shovel used for digging.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 2, 0, 0);
    public static final Loot signalWhistle = new Loot("Signel Whistle", "A small whistle used for signaling.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 5);
    public static final Loot signetRing = new Loot("Signet Ring", "Each signet ring has a distinctive design carved into it. When you press this ring into warm sealing wax, you leave an identifying mark.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 5, 0, 0);
    public static final Loot slingBullet1 = new Loot("Sling Bullet", "Small shaped stone used for a sling", ItemTypes.misc, new ArrayList<>(Arrays.asList("Each time you attack with the weapon, you expend one piece of ammunition. Drawing the ammunition from a quiver, case, or other container is part of the attack (you need a free hand to load a one-handed weapon). At the end of the battle, you can recover half your expended ammunition by taking a minute to search the battlefield.")), 1, Rarities.common, 0, 0, 0, 4);
    public static final Loot slingBullet5 = new Loot("Sling Bullet", "Small shaped stone used for a sling", ItemTypes.misc, new ArrayList<>(Arrays.asList("Each time you attack with the weapon, you expend one piece of ammunition. Drawing the ammunition from a quiver, case, or other container is part of the attack (you need a free hand to load a one-handed weapon). At the end of the battle, you can recover half your expended ammunition by taking a minute to search the battlefield.")), 5, Rarities.common, 0, 0, 0, 4);
    public static final Loot slingBullet10 = new Loot("Sling Bullet", "Small shaped stone used for a sling", ItemTypes.misc, new ArrayList<>(Arrays.asList("Each time you attack with the weapon, you expend one piece of ammunition. Drawing the ammunition from a quiver, case, or other container is part of the attack (you need a free hand to load a one-handed weapon). At the end of the battle, you can recover half your expended ammunition by taking a minute to search the battlefield.")), 10, Rarities.common, 0, 0, 0, 4);
    public static final Loot soap = new Loot("Soap", "A commodity used for bathing.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 2);
    public static final Loot sprigOfMistletoe = new Loot("Sprig of Mistletoe", "A druid can use a Sprig of Mistletoe (or holly) as a spellcasting focus, as described in the Spellcasting section.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 1, 0, 0);
    public static final Loot steelMirror = new Loot("Steel Mirror", "A steel mirror is handy when you want to look around corners, signal friends with reflected sunlight, keep an eye on a medusa, make sure that you look good enough to present yourself to the queen, or examine wounds that you’ve received on hard-to-see parts of your body.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 5, 0, 0);
    public static final Loot tankard = new Loot("A flask or tankard can hold 1 pint of liquid.", "desc", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 2);
    public static final Loot thievesTools = new Loot("Thieves' Tools", "This set of tools includes a small file, a set of lock picks, a small mirror mounted on a metal handle, a set of narrow-bladed scissors, and a pair of pliers. Proficiency with these tools lets you add your proficiency bonus to any ability checks you make to disarm traps or open locks.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 25, 0, 0);
    public static final Loot tigersEyeGem = new Loot("Tiger's Eye (gem)", "A yellow, brown, and black gem", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 10, 0, 0);
    public static final Loot tinderbox = new Loot("Tinderbox", "This small container holds flint, fire steel, and tinder (usually dry cloth soaked in light oil) used to kindle a fire. Using it to light a torch -- or anything else with abundant, exposed fuel -- takes an action. Lighting any other fire takes 1 minute.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 5, 0);
    public static final Loot bundleOfSticks = new Loot("Bundle of Sticks", "desc", ItemTypes.misc, new ArrayList<>(Arrays.asList("A bundle of thin sticks, useful for starting fires but not keeping them going")), 1, Rarities.common, 0, 0, 0, 0);
    public static final Loot torch = new Loot("Torch", "A torch burns for 1 hour, providing bright light in a 20-foot radius and dim light for an additional 20 feet. If you make a melee attack with a burning torch and hit, it deals 1 fire damage.", ItemTypes.misc, new ArrayList<>(Arrays.asList("abilities")), 1, Rarities.common, 0, 0, 0, 1);
    public static final Loot travelersClothes = new Loot("Traveler's Clothes", "A set of warm clothing meant to withstand the wear and tear of extensive travel", ItemTypes.misc, new ArrayList<>(Arrays.asList("abilities")), 1, Rarities.common, 0, 0, 30, 0);
    public static final Loot trinket = new Loot("Trinket", "A small item of mysterious purpose but no clear value. See https://www.dndbeyond.com/sources/basic-rules/equipment#Trinkets", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 0);
    public static final Loot twoPersonTent = new Loot("Two-Person Tent", "A simple and portable canvas shelter, a tent sleeps two.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 2, 0, 0);
    public static final Loot vial = new Loot("Vial", "A vial can hold 4 ounces of liquid.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 1, 0, 0);
    public static final Loot violInstrument = new Loot("Viol (Instrument)", "Similar to a violin", ItemTypes.misc, new ArrayList<>(Arrays.asList("If you have proficiency with a given musical instrument, you can add your proficiency bonus to any ability checks you make to play music with the instrument. A bard can use a musical instrument as a spellcasting focus.")), 1, Rarities.common, 0, 30, 0, 0);
    public static final Loot wand = new Loot("Wand", "An arcane focus is a special item designed to channel the power of arcane spells. A sorcerer, warlock, or wizard can use such an item as a spellcasting focus, as described in the Spellcasting section.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 10, 0, 0);
    public static final Loot waterskin = new Loot("Waterskin", "A waterskin can hold 4 pints of liquid.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 2, 0);
    public static final Loot whetstone = new Loot("Whetstone", "A standard whetstone used to sharpen blades.", ItemTypes.misc, new ArrayList<>(Arrays.asList("abilities")), 1, Rarities.common, 0, 0, 0, 1);
    public static final Loot walkingStick = new Loot("Walking Stick", "A roughly carved stick with a leather wrapping for a grip. Not intended as a weapon.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 1);
    public static final Loot grungyGlasses = new Loot("Grungy Glasses", "A pair of dirty glasses in poor shape, meant to improve bad eyesight.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 1);
    public static final Loot wornShoes = new Loot("Worn Shoes", "These boots have clearly seen much walking.", ItemTypes.misc, new ArrayList<>(Arrays.asList("")), 1, Rarities.common, 0, 0, 0, 1);
    public static final Loot haversack = new Loot("Haversack", "Similar to a backpack but with more pockets and better suited for travel", ItemTypes.misc, new ArrayList<>(Arrays.asList("abilities")), 1, Rarities.common, 0, 0, 0, 20);


    /*
    need to add these to support the poor item tiers
acid_vial
arrows_x10
block_and_tackle_for_lifting
blowgun_needles_x10
blue_quartz_10gp
brewers_supplies
bucket
bullseye_lantern
burglars_pack
carpenters_tools
cartographers_tools
carved_bone_statuette_x1_25gp
chalcedony_gem_50gp
climbers_kit
cobblers_tools
costume_clothes
crossbow_bolt_case
crossbow_bolts_x1
crossbow_bolts_x5
crossbow_bolts_x10
crowbar
crystal_10_gp
disguise_kit
dragon_chess_set
drum
entertainers_pack
eye_agate_10gp
fishing_tackle
forgery_kit
glassblowers_tools
hematite_10gp
hempen_rope_50_ft
holy_symbol_amulet
holy_symbol_emblem
holy_symbol_reliquary
hourglass
hunting_trap
jasper_gem_50gp
jewelers_tools
lapis_lazuli_10gp
leatherworkers_tools
malachite_10gp
masons_tools
merchants_scale
moss_agate_10gp
parchment_x1_sheet
parchment_x5_sheet
poisoners_kit
potion_of_climbing
potion_of_healing
potters_tools
priests_pack
rhodochosite_10_gp
rod
sealing_wax
sickle
sledge_hammer
sling_bullets_x10
smiths_tools
staff
totem
turquise_10gp
yew_wand
     */


     /*
     Need to add these to support middle-class
abacus_x1
alchemists_supplies
amber_gem_100gp
antitoxin
arrows_+1_x1
arrows_+1_x5
arrows_x15
azurite_gem_10gp
bagpipes
banded_agate_gem_10gp
basic_poison_vial
bead_of_nourishment
bead_of_refreshment
bloodstone_gem_50gp
blowgun_needles_x15
blue_quartz_10gp
book_25_gp
boots_of_false_tracks
carnelian_gem_50gp
carved_ivory_statuette_250_gp
chain_5_ft
chain_10_ft
cloak_of_billowing
cloth_of_gold_vestments_25gp
clothes_of_mending
crossbow_bolts_+1_x1
crossbow_bolts_+1_x5
crossbow_bolts_x15
crystal_10_gp
disguise_kit
embroidered_silk_handkerchief_25_gp
enduring_spellbook
explorers_pack
eye_agate_10gp
fine_clothes_15gp
fishing_tackle
glaive
gloves_of_thievery
goggles_of_night
grappling_hook_x1
healers_kit
hematite_10gp
holy_water_flask_25gp
hourglass_25gp
hunting_trap
instrument_of_illusions
instrument_of_scribing
jade_gem_100gp
jasper_gem_50gp
jewelers_tools
lock_of_trickery
malachite_10gp
masons_tools
merchants_scale
monster_hunters_pack
moonstone_gem_50gp
moss_agate_10gp
mystery_key
obsidian_10gp
oil_of_slipperiness_x1
onyx_gem_50gp
orb_of_direction
painters_supplies
paper_bird_magical
perfume_vial_5gp
potion_of_acid_resistance_x1
potion_of_climbing
potion_of_cold_resistance
potion_of_fire_breath
potion_of_fire_resistance
potion_of_force_resistance
potion_of_greater_healing
potion_of_healing
potion_of_hill_giant_strength
potion_of_invisibility
potion_of_lightning_resistance
potion_of_necrotic_resistance
potion_of_poison
potion_of_poison_resistance
potion_of_psychic_resistance
potion_of_radiant_resistance
potion_of_thunder_resistance
potters_tools
quartz_gem_50gp
ring_of_feather_falling
ring_of_force_resistance
ring_of_swimming
ring_of_truth_telling
rope_of_mending
sardonyx_gem_50gp
scholars_pack_40gp
sealing_wax
silk_rope_50ft
silver_ewer_25gp
sledge_hammer
sling_bullets_+1_x1
sling_bullets_+1_x5
sling_bullets_x15
small_gold_bracelet_25gp
small_mirror_set_in_a_painted_wooden_frame_25gp
smiths_tools
smokepowder
spell_scroll_cantrip
spell_scroll_lvl_1
spell_scroll_lvl_2
spell_scroll_lvl_3
spell_scroll_lvl_4
spell_scroll_lvl_5
spell_scroll_lvl_6
spell_scroll_lvl_7
spellbook_50gp
staff
staff_of_adornment
staff_of_birdcalls
staff_of_flowers
staff_of_the_adder
star_rose_quarts_50gp
tankard_of_sobriety
tinkers_tools
truth_serum_150_gp
unbreakable_arrow_x1
walloping_arrow_x1
walloping_blowgun_needle_x1
walloping_crossbow_bolt_x1
walloping_sling_bullet_x1
wand_of_conductiong
wand_of_entangle
wand_of_magic_missiles
wand_of_scowls
wand_of_smiles
weavers_tools
woodcarvers_tools
wooden_staff
yew_wand
zircon_gem_50gp
      */


      /*
      These need to be added to support the wealthy loot classes
alchemists_fire_flask
amber_gem_100gp
amethyst_gem_100gp
amulet_of_health
antitoxin
arrows_+1_x10
arrows_+2_x5
arrows_x20
arrows_x40
azurite_gem_10gp
bag_of_holding
bead_of_nourishment
bead_of_refreshment
belt_of_dwarvenking
belt_of_stone_giant_strength
blowgun_needles_+1_x10
blowgun_needles_+2_x5
blowgun_needles_x20
blowgun_needles_x40
blue_quartz_10gp
book_25_gp
boots_of_elvenkind
boots_of_false_tracks
bottled_breath
box_of_turquise_animal_figurines_250gp
bracers_of_archery
bracers_of_defense
brass_mug_with_jade_inlay_250gp
breastplate_of_gleaming
brooch_of_shielding
candle_of_the_deep
candle_x10
cap_of_water_breathing
carnelian_gem_50gp
carved_ivory_statuette
chain_shirt_of_gleaming
chalcedony_gem_50gp
chrysoberyl_gem_100gp
chrysoprase_gem_50gp
circlet_of_blasting
citrine_gem_50gp
cloak_of_billowing
cloak_of_elvenkind
cloak_of_many_fashions
clockwork_amulet
cloth_of_gold_vestments_25gp
clothes_of_mending
component_pouch
crossbow_bolt_case
crossbow_bolts_+1_x10
crossbow_bolts_+2_x5
crossbow_bolts_x20
crossbow_bolts_x40
crystal_10_gp
dart_+1_x10
dart_+1_x20
dart_+2_x5
dart_+2_x10
dart_x20
dart_x40
diplomats_pack
disguise_kit
dragon_chess_set
dread_helm
dungeoneers_pack
dust_of_disappearance
dust_of_dryness
dust_of_sneezing_and_choking
electrum_ring_580gp
elemental_gem_blue_sapphire
elemental_gem_emerald
elemental_gem_red_corundum
elemental_gem_yellow_diamond
elixer_of_health
embroidered_silk_handkerchief_25gp
explorers_pack
eye_agate_10gp
fine_clothes_15gp
fine_gold_chain_set_with_a_fire_opal_2500gp
fine_wine_bottle_5gp
fine_wine_bottle_10gp
fine_wine_bottle_12gp
fine_wine_bottle_15gp
fine_wine_bottle_25gp
fine_wine_bottle_30gp
fine_wine_bottle_40gp
fine_wine_bottle_60gp
fine_wine_bottle_80gp
fine_wine_bottle_100gp
garnet_gem_100gp
gauntlets_of_ogre_power
goggles_of_night
gold_dragon_comb_set_with_red_garnets_as_eyes_750gp
gold_locket_with_a_painted_portrait_inside_25gp
gold_ring_set_with_bloodstones_250gp
hat_of_disguise
hat_of_vermin
hat_of_wizardry
hide_armor_of_gleaming
holy_symbol_amulet
holy_symbol_emblem
holy_symbol_reliquary
holy_water_flask_25gp
horn_of_silent_alarm
hourglass
immovable_rod
jade_gem_100gp
jasper_gem_50gp
jet_gem_100gp
large_gold_bracelet_250gp
magnifying_glass_100gp
malachite_10gp
map_of_Grand_Bastion_2gp
map_or_scroll_case
mask_of_the_beast
merchants_scale
mess_kit
monster_hunters_pack
moon-touched_rapier
moon-touched_scimitar
moon-touched_shortsword
moonstone_gem_50gp
mystery_key
naviagtion_orb
navigators_tools
necklace_string_of_small_pink_pearls_2500gp
oil_of_slipperiness_x1
orb_of_direction
orb_of_time
painters_supplies
painting_10gp
painting_25gp
pair_of_engraved_bone_dice
paper_bird_magical_x5
paper_x10_sheet
paper_x20_sheet
parchment_x10_sheet
parchment_x20_sheet
pearl_100gp
perfume_of_bewitching
perfume_vial_5gp
periapt_of_health
pipe-of_smoke_monsters
poetry_book_15_gp
potion_of_acid_resistance_x1
potion_of_animal_friendship
potion_of_cold_resistance
potion_of_fire_breath
potion_of_fire_resistance
potion_of_force_resistance
potion_of_greater_healing
potion_of_growth
potion_of_healing
potion_of_invisibility
potion_of_lightning_resistance
potion_of_necrotic_resistance
potion_of_poison
potion_of_poison_resistance
potion_of_psychic_resistance
potion_of_radiant_resistance
potion_of_speed
potion_of_water_breathing
priests_pack
rhodochosite_10_gp
ring_of_evasion
ring_of_mind_shielding
ring_of_necrotic_resistance
ring_of_poison_resistance
ring_of_protection
ring_of_psychic_resistance
ring_of_radiant_resistance
ring_of_regeneration
ring_of_thunder_resistance
ring_of_truth_telling
robe-of_scintillating_colors
rod_of_the_pact_keeper
sardonyx_gem_50gp
scholars_pack_40gp
scroll_of_protection
shield_of_expressions
silk_bedclothes_30gp
silk_blanket_60gp
silk_robe_with_gold_embroidery_250gp
silver_and_gold_broach_750gp
silver_ewer_25gp
silver_necklace_with_a_gemstone_pendant_250gp
sling_bullets_+1_x10
sling_bullets_+2_x5
sling_bullets_x20
sling_bullets_x40
small_gold_bracelet_25gp
small_gold_idol_750gp
small_mirror_set_in_a_painted_wooden_frame_25gp
spellbook_50gp
staff
staff_of_adornment
staff_of_birdcalls
staff_of_flowers
staff_of_healing
staff_of_the_adder
staff_of_the_python
star_rose_quarts_50gp
steel_mirror
stone_of_good_luck
stone_of_ill_luck
tankard_of_sobriety
unbreakable_arrow_x5
wand_of_conducting
wand_of_enemy_detection
wand_of_magic_detection
wand_of_magic_missiles
wand_of_pyrotechnics
wand_of_secrets
wind_fan
       */

    //public static final Loot thing = new Loot("name","desc",ItemTypes.misc, new ArrayList<>(Arrays.asList("abilities")),1,Rarities.common,0,0,0,0);

    //blowgun
    //club
}
