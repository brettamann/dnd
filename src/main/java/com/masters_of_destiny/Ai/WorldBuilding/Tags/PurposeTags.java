package com.masters_of_destiny.Ai.WorldBuilding.Tags;

/**
 * These do NOT define an object's uses, but informs the AI what the intended purpose of the object
 * is, so you don't have NPCs trying to use cups for cooking when they should use a pot.
 * However, objects CAN be used outside their purposes, these just indicate what should be used first
 */
public enum PurposeTags {
    WEAPON,
    DRINKING, // cups, mugs
    EATING, // plates, untinsels
    SHIELD,
    ARMOR,
    SITTING,
    STORAGE, // anything meant to store other things
    CLOTHING,
    SLEEPING, // beds, bedrolls, stacks of hay, pillows, mats
    WARMTH, // stoves, campfires, fireplaces, coats, shelters
    COOLING,
    DESTRUCTION, // explosives, sledgehammers, fire,
    CONSTRUCTION, // hammer, nails, saws, things made for building projects
    CRAFTING, // tweezers, tacks, glue, things made for smaller projects like a table or arrow
    SMELTING, // melting elements and creating new things
    ALCHEMY, // bottles, evaporators, distillers
    SOCIALSTATUS,
    CONCEALMENT, //
    REFLECTION, // mirrors
    COOKING, // camp fires, stoves, things that actually cook a meal
    SOCIALIZING,
    FOODPREP, // knives, mixers, mashers, strainers, kitchen appliances
    FOODSTORAGE, // cellars, fridges, cold boxes
    EXERCISE,
    LEARNING, // Like a book
    PUBLICINFO, // Like a wanted sign, or "do not enter" or job posting or "wet floor", restaurant name
    ACCESSCONTROL, // anything locked where you control who accesses it. Doors, chests, windows, etc
    READING,
    ROMANCE,
    INTIMIDATION, // heads on pikes, danger signs
    PERSUASION, // advertisements, propaganda, letters of authority, badges, uniforms of a type
    MUSIC,
    ENTERTAINMENT, // games, instruments, shows
    DECORATION,
    INFORMATION,
    WRITTENCOMMS, // mostly letters, where it is a direct message to specific person(s)
    SONICCOMMS, // speaker, megaphone, voice amplifier (can be magic)
    MAGICCOMMS, // psychic communicator, callGlyph, where messages are sent AND received magically
    TRAVEL, // boats, mountable animals, trains, teleporters,
    RESTRAINT, // ropes, chains, handcuffs, jails
    ATTACHMENT, // overlaps with restraint, clamps, hooks, loops, glue
    INJURYTREATMENT, // bandages, salves, healing magic, surgery, splints, gauze
    CURE, // for disease, poison
    BREATHING, // air filters, underwater breathers, gas masks
    DIGGING, // shovels, excavators, drills
    MINING, // overlap with digging, picks
    WRITING, // pencils, quills, pens, chalk
}
