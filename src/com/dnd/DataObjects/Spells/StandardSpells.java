package com.dnd.DataObjects.Spells;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StandardSpells {
    //use the list here https://www.dndbeyond.com/spells?sort=level some you can't see details for but if you google that specific spell you'll find its details
    //TODO: fill out all 9 spell tiers. Doesn't need to be 100% of the spells (some are too much to give to an NPC

    //Cantrips (level 0)
    //public static final Spell spell = new Spell("", 0, "", "", 0, "", "", "", "");
    public static final Spell acidSplash = new Spell("Acid Splash",0,"","1 action",60,"v,s","instant","sorc, wiz","You hurl a bubble of acid. Choose one creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage.");
    public static final Spell bladeWard = new Spell("Blade Ward", 0, "", "1 action", 0, "", "1 round", "", "You extend your hand and trace a sigil of warding in the air. Until the end of your next turn, you have resistance against bludgeoning, piercing, and slashing damage dealt by weapon attacks.");
    public static final Spell boomingBlade = new Spell("Booming Blade", 0, "", "1 action", 5, "v,m (a weapon)", "1 round", "", "As part of the action used to cast this spell, you must make a melee attack with a weapon against one creature within the spell's range, otherwise the spell fails. On a hit, the target suffers the attack's normal effects, and it becomes sheathed in booming energy until the start of your next turn. If the target willingly moves be- fore then, it immediately takes 1d8 thunder damage, and the spell ends. At 5th level, the melee attack deals an extra 1d8 thunder damage to the target, and the damage the target takes for moving increases to 2d8. Both damage rolls increase by 1d8 at 11th level and 17th level.");
    public static final Spell chillTouch = new Spell("Chill Touch", 0, "", "1 action", 120, "", "1 round", "sorc, wiz, war", "You create a ghostly, skeletal hand in the space of a creature within range. Make a ranged spell attack against the creature to assail it with the chill of the grave. On a hit, the target takes 1d8 necrotic damage, and it can’t regain hit points until the start of your next turn. Until then, the hand clings to the target. If you hit an undead target, it also has disadvantage on attack rolls against you until the end of your next turn.");
    public static final Spell controlFlames = new Spell("Control Flames", 0, "", "1 action", 60, "s", "instant", "", "You choose nonmagical flame that you can see within range and that fits within a 5-foot cube. You affect it in one of the following ways: 1, You instantaneously expand the flame 5 feet in one direction, provided that wood or other fuel is present in the new location. 2, You instantaneously extinguish the flames within the cube. 3, You double or halve the area of bright light and dim light cast by the flame, change its color, or both. The change lasts for 1 hour. 4, You cause simple shapes—such as the vague form of a creature, an inanimate object, or a location—to appear within the flames and animate as you like. The shapes last for 1 hour. If you cast this spell multiple times, you can have up to three of its non-instantaneous effects active at a time, and you can dismiss such an effect as an action.");
    public static final Spell createBonfire = new Spell("Create Bonfire", 0, "", "1 action", 60, "v,s", "1 minute", "", "You create a bonfire on ground that you can see within range. Until the spell ends, the magic bonfire fills a 5-foot cube. Any creature in the bonfire’s space when you cast the spell must succeed on a Dexterity saving throw or take 1d8 fire damage. A creature must also make the saving throw when it moves into the bonfire’s space for the first time on a turn or ends its turn there. The bonfire ignites flammable objects in its area that aren’t being worn or carried. The spell’s damage increases by 1d8 when you reach 5th level (2d8), 11th level (3d8), and 17th level (4d8).");
    public static final Spell dancingLights = new Spell("Dancing Lights", 0, "", "1 action", 120, "v,s,m", "concentration, up to 1 min", "", "You create up to four torch-sized lights within range, making them appear as torches, lanterns, or glowing orbs that hover in the air for the duration. You can also combine the four lights into one glowing vaguely humanoid form of Medium size. Whichever form you choose, each light sheds dim light in a 10-foot radius. As a bonus action on your turn, you can move the lights up to 60 feet to a new spot within range. A light must be within 20 feet of another light created by this spell, and a light winks out if it exceeds the spell’s range");
    public static final Spell druidcraft = new Spell("Druidcraft", 0, "", "1 action", 30, "v,s", "instant", "", "Whispering to the spirits of nature, you create one of the following effects within range: You create a tiny, harmless sensory effect that predicts what the weather will be at your location for the next 24 hours. The effect might manifest as a golden orb for clear skies, a cloud for rain, falling snowflakes for snow, and so on. This effect persists for 1 round. You instantly make a flower blossom, a seed pod open, or a leaf bud bloom. You create an instantaneous, harmless sensory effect, such as falling leaves, a puff of wind, the sound of a small animal, or the faint odor of skunk. The effect must fit in a 5-foot cube. You instantly light or snuff out a candle, a torch, or a small campfire.");
    public static final Spell eldritchBlast = new Spell("Eldritch Blast", 0, "", "1 action", 120, "v,s", "instant", "", "A beam of crackling energy streaks toward a creature within range. Make a ranged spell attack against the target. On a hit, the target takes 1d10 force damage. The spell creates more than one beam when you reach higher levels: two beams at 5th level, three beams at 11th level, and four beams at 17th level. You can direct the beams at the same target or at different ones. Make a separate attack roll for each beam.");
    public static final Spell encodeThoughts = new Spell("Encode Thoughts", 0, "", "1 action", 0, "s", "8 hours", "", "You pull a memory, an idea, or a message from your mind and transform it into a tangible string of glowing energy called a thought strand, which persists for the duration or until you cast this spell again. The thought strand appears in an unoccupied space within 5 feet of you as a Tiny, weightless, semisolid object that can be held and carried like a ribbon. It is otherwise stationary. If you cast this spell while concentrating on a spell or an ability that allows you to read or manipulate the thoughts of others (such as Detect Thoughts or Modify Memory), you can transform the thoughts or memories you read, rather than your own, into a thought strand. Casting this spell while holding a thought strand allows you to instantly receive whatever memory, idea, or message the thought strand contains. (Casting Detect Thoughts on the strand has the same effect.)");
    public static final Spell fireBolt = new Spell("Fire Bolt", 0, "", "1 action", 0, "v,s", "instant", "", "You hurl a mote of fire at a creature or object within range. Make a ranged spell attack against the target. On a hit, the target takes 1d10 fire damage. A flammable object hit by this spell ignites if it isn’t being worn or carried.");
    public static final Spell friends = new Spell("Friends", 0, "", "1 action", 0, "S, M (a small amount of makeup applied to the face as this spell is cast)", "Concentration up to 1 min", "", "For the duration, you have advantage on all Charisma checks directed at one creature of your choice that isn’t hostile toward you. When the spell ends, the creature realizes that you used magic to influence its mood and becomes hostile toward you. A creature prone to violence might attack you. Another creature might seek retribution in other ways (at the DM’s discretion), depending on the nature of your interaction with it.");
    public static final Spell frostbite = new Spell("Frostbite", 0, "", "1 action", 60, "v,s", "instant", "", "You cause numbing frost to form on one creature that you can see within range. The target must make a Constitution saving throw. On a failed save, the target takes 1d6 cold damage, and it has disadvantage on the next weapon attack roll it makes before the end of its next turn. The spell’s damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).");
    public static final Spell greenFlameBlade = new Spell("Green-Flame Blade", 0, "", "1 action", 5, "V, M (a weapon)", "instant", "", "As part of the action used to cast this spell, you must make a melee attack with a weapon against one creature within the spell's range, otherwise the spell fails. On a hit, the target suffers the attack's normal effects, and green fire leaps from the target to a different creature of your choice that you can see within 5 feet of it. The second creature takes fire damage equal to your spellcasting ability modifier. This spell's damage increases when you reach higher levels. At 5th level, the melee attack deals an extra 1d8 fire damage to the target, and the fire damage to the second creature increases to 1d8 + your spellcasting ability modifier. Both damage rolls increase by 1d8 at 11th level and 17th level.");
    public static final Spell guidance = new Spell("Guidance", 0, "", "1 action", 0, "v,s", "conc, 1 min", "", "You touch one willing creature. Once before the spell ends, the target can roll a d4 and add the number rolled to one ability check of its choice. It can roll the die before or after making the ability check. The spell then ends.");
    public static final Spell gust = new Spell("Gust", 0, "", "1 action", 30, "v,s", "instant", "", "You seize the air and compel it to create one of the following effects at a point you can see within range: 1, One Medium or smaller creature that you choose must succeed on a Strength saving throw or be pushed up to 5 feet away from you. 2, You create a small blast of air capable of moving one object that is neither held nor carried and that weighs no more than 5 pounds. The object is pushed up to 10 feet away from you. It isn’t pushed with enough force to cause damage. 3, You create a harmless sensory effect using air, such as causing leaves to rustle, wind to slam shutters shut, or your clothing to ripple in a breeze.");
    public static final Spell infestation = new Spell("Infestation", 0, "", "1 action", 30, "v,s,m", "instant", "", "You cause a cloud of mites, fleas, and other parasites to appear momentarily on one creature you can see within range. The target must succeed on a Constitution saving throw, or it takes 1d6 poison damage and moves 5 feet in a random direction if it can move and its speed is at least 5 feet. Roll a d4 for the direction: 1., north; 2, south; 3, east; or 4, west. This movement doesn’t provoke opportunity attacks, and if the direction rolled is blocked, the target doesn't move. The spell’s damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).");
    public static final Spell light = new Spell("Light", 0, "", "1 action", 0, "v,m: firefly or phosphorescent moss", "1 hr", "", "You touch one object that is no larger than 10 feet in any dimension. Until the spell ends, the object sheds bright light in a 20-foot radius and dim light for an additional 20 feet. The light can be colored as you like. Completely covering the object with something opaque blocks the light. The spell ends if you cast it again or dismiss it as an action. If you target an object held or worn by a hostile creature, that creature must succeed on a Dexterity saving throw to avoid the spell.");
    public static final Spell lightningLure = new Spell("Lightning Lure", 0, "", "1 Action", 15, "v", "instant", "", "You create a lash of lightning energy that strikes at one creature of your choice that you can see within range. The target must succeed on a Strength saving throw or be pulled up to 10 feet in a straight line toward you and then take 1d8 lightning damage if it is within 5 feet of you. This spell's damage increases by 1d8 when you reach 5th level (2d8), 11th level (3d8), and 17th level (4d8).");
    public static final Spell mageHand = new Spell("Mage Hand", 0, "", "1 action", 30, "v,s", "1 min", "", "A spectral, floating hand appears at a point you choose within range. The hand lasts for the duration or until you dismiss it as an action. The hand vanishes if it is ever more than 30 feet away from you or if you cast this spell again. You can use your action to control the hand. You can use the hand to manipulate an object, open an unlocked door or container, stow or retrieve an item from an open container, or pour the contents out of a vial. You can move the hand up to 30 feet each time you use it. The hand can’t attack, activate magic items, or carry more than 10 pounds.");
    public static final Spell magicStone = new Spell("Magic Stone", 0, "", "1 bonus action", 0, "v,s", "1 min", "", "You touch one to three pebbles and imbue them with magic. You or someone else can make a ranged spell attack with one of the pebbles by throwing it or hurling it with a sling. If thrown, it has a range of 60 feet. If someone else attacks with the pebble, that attacker adds your spellcasting ability modifier, not the attacker’s, to the attack roll. On a hit, the target takes bludgeoning damage equal to 1d6 + your spellcasting ability modifier. Hit or miss, the spell then ends on the stone. If you cast this spell again, the spell ends early on any pebbles still affected by it.");
    public static final Spell mending = new Spell("Mending", 0, "", "1 minute (6 turns)", 0, "v,s,m", "instant", "", "This spell repairs a single break or tear in an object you touch, such as a broken chain link, two halves of a broken key, a torn cloak, or a leaking wineskin. As long as the break or tear is no larger than 1 foot in any dimension, you mend it, leaving no trace of the former damage. This spell can physically repair a magic item or construct, but the spell can’t restore magic to such an object.");
    public static final Spell message = new Spell("Message", 0, "", "1 action", 120, "v,s,m", "1 round", "", "You point your finger toward a creature within range and whisper a message. The target (and only the target) hears the message and can reply in a whisper that only you can hear. You can cast this spell through solid objects if you are familiar with the target and know it is beyond the barrier. Magical silence, 1 foot of stone, 1 inch of common metal, a thin sheet of lead, or 3 feet of wood blocks the spell. The spell doesn’t have to follow a straight line and can travel freely around corners or through openings.");
    public static final Spell mindSliver = new Spell("Mind Sliver", 0, "", "1 action", 60, "v", "1 round", "", "You drive a disorienting spike of psychic energy into the mind of one creature you can see within range. The target must make an Intelligence saving throw. Unless the saving throw is successful, the target takes 1d6 psychic damage, and the first time it makes a saving throw before the end of your next turn, it must roll a d4 and subtract the number rolled from the save. This spell’s damage increases by 1d6 when you reach certain levels: 5th level (2d6), 11th level (3d6), and 17th level (4d6).");
    public static final Spell minorIllusion = new Spell("Minor Illusion", 0, "", "1 action", 30, "s,m (a bit of fleece)", "1 min", "", "You create a sound or an image of an object within range that lasts for the duration. The illusion also ends if you dismiss it as an action or cast this spell again. If you create a sound, its volume can range from a whisper to a scream. It can be your voice, someone else’s voice, a lion’s roar, a beating of drums, or any other sound you choose. The sound continues unabated throughout the duration, or you can make discrete sounds at different times before the spell ends. If you create an image of an object—such as a chair, muddy footprints, or a small chest—it must be no larger than a 5-foot cube. The image can’t create sound, light, smell, or any other sensory effect. Physical interaction with the image reveals it to be an illusion, because things can pass through it. If a creature uses its action to examine the sound or image, the creature can determine that it is an illusion with a successful Intelligence (Investigation) check against your spell save DC. If a creature discerns the illusion for what it is, the illusion becomes faint to the creature.");
    public static final Spell moldEarth = new Spell("Mold Earth", 0, "", "1 action", 30, "s", "instant", "", "You choose a portion of dirt or stone that you can see within range and that fits within a 5-foot cube. You manipulate it in one of the following ways: 1, If you target an area of loose earth, you can instantaneously excavate it, move it along the ground, and deposit it up to 5 feet away. This movement doesn’t have enough force to cause damage. 2, You cause shapes, colors, or both to appear on the dirt or stone, spelling out words, creating images, or shaping patterns. The changes last for 1 hour. 3, If the dirt or stone you target is on the ground, you cause it to become difficult terrain. Alternatively, you can cause the ground to become normal terrain if it is already difficult terrain. This change lasts for 1 hour. If you cast this spell multiple times, you can have no more than two of its non-instantaneous effects active at a time, and you can dismiss such an effect as an action.");
    public static final Spell poisonSpray = new Spell("Poison Spray", 0, "", "1 action", 10, "v,s", "instant", "", "You extend your hand toward a creature you can see within range and project a puff of noxious gas from your palm. The creature must succeed on a Constitution saving throw or take 1d12 poison damage.");
    public static final Spell prestidigitation = new Spell("Prestidigitation", 0, "", "1 action", 10, "v,s", "up to 1 hr", "", "This spell is a minor magical trick that novice spellcasters use for practice. You create one of the following magical effects within range: 1, You create an instantaneous, harmless sensory effect, such as a shower of sparks, a puff of wind, faint musical notes, or an odd odor. 2, You instantaneously light or snuff out a candle, a torch, or a small campfire. 3, You instantaneously clean or soil an object no larger than 1 cubic foot. 4, You chill, warm, or flavor up to 1 cubic foot of nonliving material for 1 hour. 5, You make a color, a small mark, or a symbol appear on an object or a surface for 1 hour. 6, You create a nonmagical trinket or an illusory image that can fit in your hand and that lasts until the end of your next turn. If you cast this spell multiple times, you can have up to three of its non-instantaneous effects active at a time, and you can dismiss such an effect as an action.");
    public static final Spell primalSavagery = new Spell("Primal Savagery", 0, "", "1 action", 0, "s", "instant", "", "You channel primal magic to cause your teeth or fingernails to sharpen, ready to deliver a corrosive attack. Make a melee spell attack against one creature within 5 feet of you. On a hit, the target takes 1d10 acid damage. After you make the attack, your teeth or fingernails return to normal. The spell’s damage increases by 1d10 when you reach 5th level (2d10), 11th level (3d10), and 17th level (4d10).");
    public static final Spell produceFlame = new Spell("Produce Flame", 0, "", "1 action", 0, "v,s", "10 min", "", "A flickering flame appears in your hand. The flame remains there for the duration and harms neither you nor your equipment. The flame sheds bright light in a 10-foot radius and dim light for an additional 10 feet. The spell ends if you dismiss it as an action or if you cast it again. You can also attack with the flame, although doing so ends the spell. When you cast this spell, or as an action on a later turn, you can hurl the flame at a creature within 30 feet of you. Make a ranged spell attack. On a hit, the target takes 1d8 fire damage.");
    public static final Spell rayOfFrost = new Spell("Ray of Frost", 0, "", "1 action", 60, "v,s", "instant", "", "A frigid beam of blue-white light streaks toward a creature within range. Make a ranged spell attack against the target. On a hit, it takes 1d8 cold damage, and its speed is reduced by 10 feet until the start of your next turn.");
    public static final Spell resistance = new Spell("Resistance", 0, "", "1 action", 0, "v,s,m (a miniature cloak)", "Concentration, up to 1 min", "", "You touch one willing creature. Once before the spell ends, the target can roll a d4 and add the number rolled to one saving throw of its choice. It can roll the die before or after making the saving throw. The spell then ends.");
    public static final Spell sacredFlame = new Spell("Sacred Flame", 0, "", "1 action", 60, "v,s", "instant", "", "Flame-like radiance descends on a creature that you can see within range. The target must succeed on a Dexterity saving throw or take 1d8 radiant damage. The target gains no benefit from cover for this saving throw.");
    public static final Spell shapeWater = new Spell("Shape Water", 0, "", "1 action", 30, "s", "", "", "You choose an area of water that you can see within range and that fits within a 5-foot cube. You manipulate it in one of the following ways: 1, You instantaneously move or otherwise change the flow of the water as you direct, up to 5 feet in any direction. This movement doesn’t have enough force to cause damage. 2, You cause the water to form into simple shapes and animate at your direction. This change lasts for 1 hour. 3, You change the water’s color or opacity. The water must be changed in the same way throughout. This change lasts for 1 hour. 4, You freeze the water, provided that there are no creatures in it. The water unfreezes in 1 hour. If you cast this spell multiple times, you can have no more than two of its non-instantaneous effects active at a time, and you can dismiss such an effect as an action.");
    public static final Spell shillelagh = new Spell("Shillelagh", 0, "", "1 bonus action", 0, "v,s,m (Mistletoe, a shamrock leaf, and a club or quarterstaff)", "1 min", "", "The wood of a club or quarterstaff you are holding is imbued with nature’s power. For the duration, you can use your spellcasting ability instead of Strength for the attack and damage rolls of melee attacks using that weapon, and the weapon’s damage die becomes a d8. The weapon also becomes magical, if it isn’t already. The spell ends if you cast it again or if you let go of the weapon.");
    public static final Spell shockingGrasp = new Spell("Shocking Grasp", 0, "", "1 action", 0, "v,s", "instant", "", "Lightning springs from your hand to deliver a shock to a creature you try to touch. Make a melee spell attack against the target. You have advantage on the attack roll if the target is wearing armor made of metal. On a hit, the target takes 1d8 lightning damage, and it can’t take reactions until the start of its next turn.");
    public static final Spell spareTheDying = new Spell("Spare The Dying", 0, "", "1 action", 0, "v,s", "instant", "", "You touch a living creature that has 0 hit points. The creature becomes stable. This spell has no effect on undead or constructs.");
    public static final Spell thaumaturgy = new Spell("Thaumaturgy", 0, "", "", 30, "v", "up to 1 min", "", "You manifest a minor wonder, a sign of supernatural power, within range. You create one of the following magical effects within range: Your voice booms up to three times as loud as normal for 1 minute. You cause flames to flicker, brighten, dim, or change color for 1 minute. You cause harmless tremors in the ground for 1 minute. You create an instantaneous sound that originates from a point of your choice within range, such as a rumble of thunder, the cry of a raven, or ominous whispers. You instantaneously cause an unlocked door or window to fly open or slam shut. You alter the appearance of your eyes for 1 minute. If you cast this spell multiple times, you can have up to three of its 1-minute effects active at a time, and you can dismiss such an effect as an action.");
    public static final Spell thornWhip = new Spell("Thorn Whip", 0, "", "1 action", 20, "v,s,m (the stem of a thorned plant)", "instant", "", "You create a long, vine-like whip covered in thorns that lashes out at your command toward a creature in range. Make a melee spell attack against the target. If the attack hits, the creature takes 1d6 piercing damage, and if the creature is Large or smaller, you pull the creature up to 10 feet closer to you. This spell’s damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).");
    public static final Spell thunderclap = new Spell("Thunderclap", 0, "", "1 action", 5, "s", "instant", "", "You create a burst of thunderous sound that can be heard up to 100 feet away. Each creature within range, other than you, must succeed on a Constitution saving throw or take 1d6 thunder damage.");
    public static final Spell tollTheDead = new Spell("Toll the Dead", 0, "", "1 action", 60, "v,s", "instant", "", "You point at one creature you can see within range, and the sound of a dolorous bell fills the air around it for a moment. The target must succeed on a Wisdom saving throw or take 1d8 necrotic damage. If the target is missing any of its hit points, it instead takes 1d12 necrotic damage. The spell’s damage increases by one die when you reach 5th level (2d8 or 2d12), 11th level (3d8 or 3d12), and 17th level (4d8 or 4d12).");
    public static final Spell trueStrike = new Spell("True Strike", 0, "", "1 action", 30, "s", "concentration up to 1 round", "", "You extend your hand and point a finger at a target in range. Your magic grants you a brief insight into the target’s defenses. On your next turn, you gain advantage on your first attack roll against the target, provided that this spell hasn’t ended.");
    public static final Spell viciousMockery = new Spell("Vicious Mockery", 0, "", "1 action", 60, "v", "instant", "", "You unleash a string of insults laced with subtle enchantments at a creature you can see within range. If the target can hear you (though it need not understand you), it must succeed on a Wisdom saving throw or take 1d4 psychic damage and have disadvantage on the next attack roll it makes before the end of its next turn.");
    public static final Spell wordOfRadiance = new Spell("Word of Radiance", 0, "", "1 action", 0, "v,m (a holy symbol)", "instant", "", "You utter a divine word, and burning radiance erupts from you. Each creature of your choice that you can see within range must succeed on a Constitution saving throw or take 1d6 radiant damage.");

    //Level 1
    //public static final Spell spell = new Spell("", 1, "", "1 action", 0, "", "", "", "");
    public static final Spell alarm = new Spell("Alarm", 1, "", "1 minute", 30, "v,s,m (a tiny bell and a piece of fine silver wire)", "instant", "", "You set an alarm against unwanted intrusion. Choose a door, a window, or an area within range that is no larger than a 20-foot cube. Until the spell ends, an alarm alerts you whenever a Tiny or larger creature touches or enters the warded area. When you cast the spell, you can designate creatures that won't set off the alarm. You also choose whether the alarm is mental or audible. A mental alarm alerts you with a ping in your mind if you are within 1 mile of the warded area. This ping awakens you if you are sleeping. An audible alarm produces the sound of a hand bell for 10 seconds within 60 feet");
    public static final Spell absorbElements = new Spell("Absorb Elements", 1, "", "1 reaction", 0, "s", "1 round", "", "The spell captures some of the incoming energy, lessening its effect on you and storing it for your next melee attack. You have resistance to the triggering damage type until the start of your next turn. Also, the first time you hit with a melee attack on your next turn, the target takes an extra 1d6 damage of the triggering type, and the spell ends.  When you cast this spell using a spell slot of 2nd level or higher, the extra damage increases by 1d6 for each slot level above 1st.");
    public static final Spell animalFriendship = new Spell("Animal Friendship", 1, "", "1 action", 30, "v,s,m (a morsel of food)", "24 hours", "", "This spell lets you convince a beast that you mean it no harm. Choose a beast that you can see within range. It must see and hear you. If the beast's Intelligence is 4 or higher, the spell fails. Otherwise, the beast must succeed on a Wisdom saving throw or be charmed by you for the spell's duration. If you or one of your companions harms the target, the spell ends. When you cast this spell using a spell slot of 2nd level or higher, you can affect one additional beast for each slot level above 1st.");
    public static final Spell arcaneWeapon = new Spell("Arcane Weapon", 1, "", "1 bonus action", 0, "v,s", "1 hour", "", "You channel arcane energy into one simple or martial weapon you’re holding, and choose one damage type: acid, cold, fire, lightning, poison, or thunder. Until the spell ends, you deal an extra 1d6 damage of the chosen type to any target you hit with the weapon. If the weapon isn’t magical, it becomes a magic weapon for the spell’s duration. As a bonus action, you can change the damage type, choosing from the options above. When you cast this spell using a spell slot of 3rd level or higher, you can maintain your concentration on the spell for up to 8 hours.");
    //public static final Spell armorOfAgathys = new Spell("", 1, "", "1 action", 0, "", "", "", "");
    //public static final Spell armsOfHadar = new Spell("Arms of Hadar", 1, "", "1 action", 0, "", "", "", "");
    public static final Spell bane = new Spell("Bane", 1, "", "1 action", 30, "v,s,m (a drop of blood)", "1 min", "", "Up to three creatures of your choice that you can see within range must make Charisma saving throws. Whenever a target that fails this saving throw makes an attack roll or a saving throw before the spell ends, the target must roll a d4 and subtract the number rolled from the attack roll or saving throw. When you cast this spell using a spell slot of 2nd level or higher, you can target one additional creature for each slot level above 1st.");
    public static final Spell beastBond = new Spell("Beast Bond", 1, "", "1 action", 0, "v,s,m (a bit of fur wrapped in cloth)", "10 min", "", "You establish a telepathic link with one beast you touch that is friendly to you or charmed by you. The spell fails if the beast’s Intelligence is 4 or higher. Until the spell ends, the link is active while you and the beast are within line of sight of each other. Through the link, the beast can understand your telepathic messages to it, and it can telepathically communicate simple emotions and concepts back to you. While the link is active, the beast gains advantage on attack rolls against any creature within 5 feet of you that you can see.");
    public static final Spell bless = new Spell("Bless", 1, "", "1 action", 30, "v,s,m (a sprinkling of holy water)", "1 min", "", "You bless up to three creatures of your choice within range. Whenever a target makes an attack roll or a saving throw before the spell ends, the target can roll a d4 and add the number rolled to the attack roll or saving throw. When you cast this spell using a spell slot of 2nd level or higher, you can target one additional creature for each slot level above 1st.");
    public static final Spell burningHands = new Spell("Burning Hands", 1, "", "1 action", 15, "v,s", "instant", "", "As you hold your hands with thumbs touching and fingers spread, a thin sheet of flames shoots forth from your outstretched fingertips. Each creature in a 15-foot cone must make a Dexterity saving throw. A creature takes 3d6 fire damage on a failed save, or half as much damage on a successful one. The fire ignites any flammable objects in the area that aren't being worn or carried. When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d6 for each slot level above 1st.");
    public static final Spell catapult = new Spell("Catapult", 1, "", "1 action", 60, "s", "instant", "", "Choose one object weighing 1 to 5 pounds within range that isn’t being worn or carried. The object flies in a straight line up to 90 feet in a direction you choose before falling to the ground, stopping early if it impacts against a solid surface. If the object would strike a creature, that creature must make a Dexterity saving throw. On a failed save, the object strikes the target and stops moving. When the object strikes something, the object and what it strikes each take 3d8 bludgeoning damage. When you cast this spell using a spell slot of 2nd level or higher, the maximum weight of objects that you can target with this spell increases by 5 pounds, and the damage increases by 1d8, for each slot level above 1st.");
    //public static final Spell causeFear = new Spell("Cause Fear", 1, "", "1 action", 0, "", "", "", "");
    //public static final Spell ceremony = new Spell("Ceremony", 1, "", "1 action", 0, "", "", "", "");
    //public static final Spell chaosBolt = new Spell("Chaos Bolt", 1, "", "1 action", 0, "", "", "", "");
    public static final Spell charmPerson = new Spell("Charm Person", 1, "", "1 action", 30, "v,s", "1 hour", "", "You attempt to charm a humanoid you can see within range. It must make a Wisdom saving throw, and does so with advantage if you or your companions are fighting it. If it fails the saving throw, it is charmed by you until the spell ends or until you or your companions do anything harmful to it. The charmed creature regards you as a friendly acquaintance. When the spell ends, the creature knows it was charmed by you. When you cast this spell using a spell slot of 2nd level or higher, you can target one additional creature for each slot level above 1st. The creatures must be within 30 feet of each other when you target them.");
    //public static final Spell chromaticOrb = new Spell("Chromatic Orb", 1, "", "1 action", 0, "", "", "", "");
    public static final Spell colorSpray = new Spell("Color Spray", 1, "", "1 action", 15, "v,s,m (a pinch of powder or sand colored red, yellow, and blue)", "1 round", "", "A dazzling array of flashing, colored light springs from your hand. Roll 6d10; the total is how many hit points of creatures this spell can affect. Creatures in a 15-foot cone originating from you are affected in ascending order of their current hit points (ignoring unconscious creatures and creatures that can't see). Starting with the creature that has the lowest current hit points, each creature affected by this spell is blinded until the end of your next turn. Subtract each creature's hit points from the total before moving on to the creature with the next lowest hit points. A creature's hit points must be equal to or less than the remaining total for that creature to be affected. When you cast this spell using a spell slot of 2nd level or higher, roll an additional 2d10 for each slot level above 1st.");
    public static final Spell command = new Spell("Command", 1, "", "1 action", 60, "v", "1 round", "", "You speak a one-word command to a creature you can see within range. The target must succeed on a Wisdom saving throw or follow the command on its next turn. The spell has no effect if the target is undead, if it doesn't understand your language, or if your command is directly harmful to it. Some typical commands and their effects follow. You might issue a command other than one described here. If you do so, the GM determines how the target behaves. If the target can't follow your command, the spell ends. (approach, drop, flee, grovel, halt). When you cast this spell using a spell slot of 2nd level or higher, you can affect one additional creature for each slot level above 1st. The creatures must be within 30 feet of each other when you target them.");
    //public static final Spell compelledDuel = new Spell("Compelled Duel", 1, "", "1 action", 0, "", "", "", "");
    //TODO: finish out level 1 spells

    //Level 2
    //public static final Spell spell = new Spell("", 2, "", "1 action", 0, "", "", "", "");

    //Level 3
    //public static final Spell spell = new Spell("", 3, "", "1 action", 0, "", "", "", "");

    //Level 4
    //public static final Spell spell = new Spell("", 4, "", "1 action", 0, "", "", "", "");

    //Level 5
    //public static final Spell spell = new Spell("", 5, "", "1 action", 0, "", "", "", "");

    //Level 6
    //public static final Spell spell = new Spell("", 6, "", "1 action", 0, "", "", "", "");

    //Level 7
    //public static final Spell spell = new Spell("", 7, "", "1 action", 0, "", "", "", "");

    //Level 8
    //public static final Spell spell = new Spell("", 8, "", "1 action", 0, "", "", "", "");

    //Level 9
    //public static final Spell spell = new Spell("", 9, "", "1 action", 0, "", "", "", "");


    public static final List<Spell> masterSpellList = new ArrayList<Spell>(Arrays.asList(
            acidSplash,
            bladeWard,
            boomingBlade,
            chillTouch,
            controlFlames,
            createBonfire,
            dancingLights,
            druidcraft,
            eldritchBlast,
            encodeThoughts,
            fireBolt,
            friends,
            frostbite,
            greenFlameBlade,
            guidance,
            gust,
            infestation,
            light,
            lightningLure,
            mageHand,
            magicStone,
            mending,
            message,
            mindSliver,
            minorIllusion,
            moldEarth,
            poisonSpray,
            prestidigitation,
            primalSavagery,
            produceFlame,
            rayOfFrost,
            resistance,
            sacredFlame,
            shapeWater,
            shillelagh,
            shockingGrasp,
            spareTheDying,
            thaumaturgy,
            thornWhip,
            thunderclap,
            tollTheDead,
            trueStrike,
            viciousMockery,
            wordOfRadiance
    ));

    public static List<Spell> getSpellListByLevel(int level) {
        List<Spell> listToReturn = new ArrayList<Spell>(Arrays.asList());
        for (Spell temp : masterSpellList) {
            if (temp.level == level) {
                listToReturn.add(temp);
            }
        }
        return listToReturn;
    }
}