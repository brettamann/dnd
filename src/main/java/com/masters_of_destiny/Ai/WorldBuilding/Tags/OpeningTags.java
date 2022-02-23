package com.masters_of_destiny.Ai.WorldBuilding.Tags;

public enum OpeningTags {
    SEALABLE, // Can become sealed
    SEALED, // Cannot be opened except by breaking container
    CLOSEABLE, // Contents can be prevented from falling out
    CLOSED, // Contents won't fall out
    LOCKABLE,
    LOCKED,
    HIDEABLE, // Can be disguised or hidden
    HIDDEN
}
