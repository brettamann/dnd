package com.masters_of_destiny.Ai.Actions;

/**
 * Generic descriptors of what an action does, what it does to the environment or provides.
 * This allows a quick definition of what a thing can do, and what it is susceptible to
 */
public enum ActionTags {
    BLUNTFORCE, // Shatters, cracks, compresses, smaller area of effect, 1-off
    PRESSUREFORCE, // Shatters, cracks, compresses, encompassing wide area of target, lasting
    PIERCINGFORCE, // Creates holes
    CUTTINGFORCE, // Separates things
    GENERICFORCE, // wind blast, gravity redirection, force-push kind of thing
// in the end this is all force applied to an object... maybe these should be combined

    CORROSION,
    HEAT,
    COOL,

    PHYSICALMOVEMENTSELF, // walking, flying, swimming, climbing, lifting, etc
    MAGICALMOVEMENTSELF, // teleportation, levitation, etc
    DIG,

    INTERACTION, // push, shove, pull, etc, can be magical

    ATTACH, // magnetic, tie, grab, clamp, etc, potentially temporary
    DETACH, // opposite of attach
    FILL, // put things in containers
    EMPTY, // opposite of fill
    COMBINE, // mix, stir, fuse, (permanent things), glue, nail, absorb
    SEPARATE, // opposite of combine
    MANIPULATE, // twist, bend, rotate, things that don't move overall object or resize it
    RESIZE, // stretch, squash, stretch, inflate/deflate, shrivel, swell
    HYDRATE, // moisturize, add water
    DEHYDRATE, // opposite of hydrate
    LOCK, // make some sort of object unable to be used for its purpose(s) without being unlocked
    UNLOCK, // opposite of unlock
    CONTAIN, // tie, imprison, put inside something else
    RELEASE, // opposite of contain

    MENTAL, // mind control, confusion, thoughts, dreams
    EMOTIONAL, // feelings, attitudes
    HEALTH, // diseases, homeostasis problems/resolution

    // Specific to bodies/people
    SENSE, // see, hear, feel, taste, smell, ESP, vestibular, magic
    BREATHE,
    EAT,
    DRINK,
    SLEEP,
    SOCIAL, // seduce, intimidate, persuade, friendship, barter, etc
    CAST, // spells








    // Things that change a character's location (self)
    WALK,
    LIMP,
    JOG,
    RUN,
    CRAWL,
    SWIM,
    FLY,
    SLITHER,
    CLIMB,
    JUMP,
    ROLL,
    LEVITATE,
    TELEPORT,
    BURROW,

    // Things that make OTHER objects change location
    PUSH, // Intended to move
    SHOVE, // Intended to harm
    PULL, // Intended to move
    YANK, //Intended to harm
    LIFT,
    CARRY,
    THROW, // Intended to harm
    TOSS, // Intended to be caught
    DROP,

    // Things that connect objects
    GRAB,
    ADHERE, // Glue
    HOLD, // Not sure how to differentiate from grab.

    // Attacks
    KICK,
    PUNCH,
    SCRATCH,
    SLAP,
    TACKLE,
    HEADBUTT,
    BITE,
    STAB,
    CUT,
    PUNCTURE,
    CRUSH,
    STRIKE, // As in with a knee, elbow, thing that doesn't have a specific name or result. Blunt force.
    GAUGE,
    WHIP,
    CORRODE,

    // Results of attacks that are sometimes actions.
    // "Shatter that vase" for instance implies physical trauma
    // So I may need to find a way to
    CRACK, // Weakens the thing, ruins air and water impermeability
    DENT, // Cosmetic damage
    SHATTER, // Into tons of pieces
    OBLITERATE, // Nothing left
    BLEED,
    LEAK,

    // Size changers
    GROW, // General size increase
    SWELL, // Local size increase, can be damaging or debilitating
    SHRINK, // General size decrease
    SHRIVEL, // Decrease in size due to loss of moisture

    // Actions that affect the shape of another thing without necessarily damaging it
    BEND,
    TWIST,
    SQUASH,
    STRETCH,
    INFLATE,
    DEFLATE,

}
