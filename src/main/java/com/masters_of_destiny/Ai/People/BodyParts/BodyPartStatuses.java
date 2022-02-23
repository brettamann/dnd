package com.masters_of_destiny.Ai.People.BodyParts;

public enum BodyPartStatuses {
    DISABLED, // cannot be used
    INJURED, //
    WEAKENED,
    BLEEDING,
    DISEASED,
    BROKEN,
    BURNED,
    CORRODED,
    AGED,
    PROTECTED,
    INVISIBLE,
    ETHEREAL,
    SKELETAL,
    GRIMY,
    BLOODY,
    MUDDY,
    AMPUTATED // means that is the LAST part in the chain. Forearm with "AMPUTATED" would not have a wrist-down
}
